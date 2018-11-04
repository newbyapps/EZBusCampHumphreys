package com.jtnew.ezBusCampHumphreys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.google.firebase.analytics.FirebaseAnalytics;

public class MainActivity extends AppCompatActivity {

    private ListView listView ;
    private String[] redLocations, blueLocations, greenLocations;
    private RadioGroup rGroup, rGroup2;
    private RadioButton redButton, blueButton, weekDay, weekEnd, greenButton;
    private ArrayAdapter<String> adapter, adapter2, adapter3;
    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        listView = (ListView) findViewById(R.id.locationListView);

        // Buttons
        redButton = (RadioButton) findViewById(R.id.redButton);
        blueButton = (RadioButton) findViewById(R.id.blueButton);
        weekDay = (RadioButton) findViewById(R.id.weekdayButton);
        weekEnd = (RadioButton) findViewById(R.id.weekendButton);
        greenButton = (RadioButton) findViewById(R.id.greenButton);

        // Blue and red buttons
        rGroup = (RadioGroup) findViewById(R.id.radioGroup);

        // Weekday, Weekend, Midnight buttons
        rGroup2 = (RadioGroup) findViewById(R.id.radioGroup2);

        // Red bus-stop locations
        redLocations = new String[]{"PED/walkthru gate", "AV/CPX Gate", "1-17 CAV, P-860", "4-2 ARB S-869", "New Dental Clinic", "AV/CPX Gate", "Bus Terminal", "Lodging S-121", "USO S-375", "Quarry Gate", "2nd CAB/CDC", "Medical/Dental Clinic", "Super Gym", "School", "Vet Clinic P2260", "New Commissary", "New PX", "One Stop Bldg", "Tomahawk DFAC ", "VMF S-7412", "VMF S-7515", "HQs P-7621", "VMF S-7515", "VMF S-7412", "Tomahawk DFAC", "Spartan DFAC S-6321", "Bldg # P-6315", "Chapel P-6360", "New Barracks. Bldg P-6001", "Talon DFAC S-2097", "3rd MI Bn", "TMP P-7010", "ROKA HQs", "8th Army HQs", "S-12114", "Provider Grill DFAC S-1291", "Zoeckler station S-1210", "PED/walkthru gate"};
        // Blue bus-stop locations
        blueLocations = new String[]{"PED/walkthru gate", "Zoeckler station S-1210", "Provider Grill DFAC S-1291", "S-12114", "8th Army HQs", "ROKA HQs", "TMP P-7010", "3rd MI Bn", "Talon DFAC S-2097", "New Barracks. Bldg P-6001", "Chapel P-6360", "Bldg # P-6315", "Spartan DFAC S-6321", "Tomahawk DFAC", "VMF S-7412", "VMF S-7515", "HQs P-7621", "VMF S-7515", "VMF S-7412", "Tomahawk DFAC ", "One Stop Bldg", "New PX", "New Commissary", "Vet Clinic P2260", "School", "Super Gym", "Quarry Gate", "2nd CAB/CDC", "Medical/Dental Clinic", "USO S-375", "Lodging S-121", "Bus Terminal", "AV/CPX Gate", "1-17 CAV, P-860", "4-2 ARB S-869", "New Dental Clinic", "AV/CPX Gate", "PED/walkthru gate"};        // Midnight locations
        // Green bus-stop locations
        greenLocations = new String[]{"New PX", "Spartan S-6321", "Bldg P- 6315", "Chapel P-6360", "New Barracks P-6003", "3rd MI", "Talon DFAC P-2097", "School", "Super Gym", "Ed Center/Commissary", "Medical Clinic", "Bus Terminal", "CPX", "Walkthru Gate", "Zoekler station S-1210", "Provider Grill S-1291", "Zoekler station S-1210", "Walkthru Gate", "CPX", "Bus Terminal", "Medical Clinic", "Ed Center/Commissary", "Super Gym", "School", "Talon DFAC P-2097", "3rd MI", "New Barracks P-6001", "Bldg P- 6315", "Chapel P-6360", "Spartan S-6321", "New PX"};

        // Red locations in a scrollpane
        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, redLocations);

        // App begins with red locations shown
        listView.setAdapter(adapter);

        // Blue locations in a scrollpane
        adapter2 = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, blueLocations);

        // Midnight locations in a scrollpane
        adapter3 = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, greenLocations);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // ListView Clicked item index
                int itemPosition     = position;

                // ListView Clicked item value
                String  itemValue    = (String) listView.getItemAtPosition(position);
                Intent redIntent = new Intent(MainActivity.this, RedWeekday.class);
                redIntent.putExtra("selection", itemValue);
                redIntent.putExtra("passed", itemPosition);
                startActivity(redIntent);
            }
        });


        rGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            public void onCheckedChanged(RadioGroup group, final int checkedId) {
                if (redButton.isChecked()) {
                    if (weekDay.isChecked()) {
                        int index = listView.getFirstVisiblePosition();
                        View view = listView.getChildAt(0);
                        int top = (view == null) ? 0 : view.getTop();

                        listView.setAdapter(adapter);
                        listView.setSelectionFromTop(index, top);

                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view,
                                                    int position, long id) {
                                // ListView Clicked item index
                                int itemPosition = position;
                                // ListView Clicked item value
                                String itemValue = (String) listView.getItemAtPosition(position);
                                Intent redIntent = new Intent(MainActivity.this, RedWeekday.class);
                                redIntent.putExtra("selection", itemValue);
                                redIntent.putExtra("passed", itemPosition);
                                startActivity(redIntent);
                            }
                        });
                    } else {
                        int index = listView.getFirstVisiblePosition();
                        View view = listView.getChildAt(0);
                        int top = (view == null) ? 0 : view.getTop();

                        listView.setAdapter(adapter);
                        listView.setSelectionFromTop(index, top);

                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view,
                                                    int position, long id) {
                                // ListView Clicked item index
                                int itemPosition = position;
                                // ListView Clicked item value
                                String itemValue = (String) listView.getItemAtPosition(position);
                                Intent redIntent = new Intent(MainActivity.this, RedWeekend.class);
                                redIntent.putExtra("selection", itemValue);
                                redIntent.putExtra("passed", itemPosition);
                                startActivity(redIntent);
                            }


                        });
                    }
                } else if (blueButton.isChecked()) {
                    if (weekDay.isChecked()) {
                        int index = listView.getFirstVisiblePosition();
                        View view = listView.getChildAt(0);
                        int top = (view == null) ? 0 : view.getTop();

                        listView.setAdapter(adapter2);
                        listView.setSelectionFromTop(index, top);

                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // ListView Clicked item index
                                int itemPosition = position;
                                // ListView Clicked item value
                                String itemValue = (String) listView.getItemAtPosition(position);
                                Intent blueIntent = new Intent(MainActivity.this, BlueWeekday.class);
                                blueIntent.putExtra("passed", itemPosition);
                                blueIntent.putExtra("selection", itemValue);
                                startActivity(blueIntent);
                            }
                        });
                    } else {
                        int index = listView.getFirstVisiblePosition();
                        View view = listView.getChildAt(0);
                        int top = (view == null) ? 0 : view.getTop();

                        listView.setAdapter(adapter2);
                        listView.setSelectionFromTop(index, top);

                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // ListView Clicked item index
                                int itemPosition = position;
                                // ListView Clicked item value
                                String itemValue = (String) listView.getItemAtPosition(position);
                                Intent blueIntent = new Intent(MainActivity.this, BlueWeekend.class);
                                blueIntent.putExtra("passed", itemPosition);
                                blueIntent.putExtra("selection", itemValue);
                                startActivity(blueIntent);
                            }
                        });
                    }
                } else if (greenButton.isChecked()) {
                    if (weekDay.isChecked()) {
                        int index = listView.getFirstVisiblePosition();
                        View view = listView.getChildAt(0);
                        int top = (view == null) ? 0 : view.getTop();

                        listView.setAdapter(adapter3);
                        listView.setSelectionFromTop(index, top);

                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // ListView Clicked item index
                                int itemPosition = position;
                                // ListView Clicked item value
                                String itemValue = (String) listView.getItemAtPosition(position);
                                Intent greenIntent = new Intent(MainActivity.this, GreenWeekday.class);
                                greenIntent.putExtra("passed", itemPosition);
                                greenIntent.putExtra("selection", itemValue);
                                startActivity(greenIntent);
                            }
                        });
                    } else {
                        int index = listView.getFirstVisiblePosition();
                        View view = listView.getChildAt(0);
                        int top = (view == null) ? 0 : view.getTop();

                        listView.setAdapter(adapter3);
                        listView.setSelectionFromTop(index, top);

                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // ListView Clicked item index
                                int itemPosition = position;
                                // ListView Clicked item value
                                String itemValue = (String) listView.getItemAtPosition(position);
                                Intent greenIntent = new Intent(MainActivity.this, GreenWeekend.class);
                                greenIntent.putExtra("passed", itemPosition);
                                greenIntent.putExtra("selection", itemValue);
                                startActivity(greenIntent);
                            }
                        });
                    }
                }
            }
        });


        rGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (weekDay.isChecked() && redButton.isChecked()) {
                    int index = listView.getFirstVisiblePosition();
                    View view = listView.getChildAt(0);
                    int top = (view == null) ? 0 : view.getTop();

                    listView.setAdapter(adapter);
                    listView.setSelectionFromTop(index, top);
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                                // ListView Clicked item index
                                int itemPosition = position;
                                // ListView Clicked item value
                                String itemValue = (String) listView.getItemAtPosition(position);

                                Intent redIntent = new Intent(MainActivity.this, RedWeekday.class);
                                redIntent.putExtra("passed", itemPosition);
                                redIntent.putExtra("selection", itemValue);
                                startActivity(redIntent);
                            }
                        });
                    }
                else if (weekDay.isChecked() && blueButton.isChecked()) {
                    int index = listView.getFirstVisiblePosition();
                    View view = listView.getChildAt(0);
                    int top = (view == null) ? 0 : view.getTop();

                        listView.setAdapter(adapter2);
                    listView.setSelectionFromTop(index, top);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // ListView Clicked item index
                                int itemPosition = position;
                                // ListView Clicked item value
                                String itemValue = (String) listView.getItemAtPosition(position);
                                Intent blueIntent = new Intent(MainActivity.this, BlueWeekday.class);
                                blueIntent.putExtra("passed", itemPosition);
                                blueIntent.putExtra("selection", itemValue);
                                startActivity(blueIntent);
                            }
                        });
                    }
                else if (weekDay.isChecked() && greenButton.isChecked()) {
                    int index = listView.getFirstVisiblePosition();
                    View view = listView.getChildAt(0);
                    int top = (view == null) ? 0 : view.getTop();

                    listView.setAdapter(adapter3);
                    listView.setSelectionFromTop(index, top);
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            // ListView Clicked item index
                            int itemPosition = position;
                            // ListView Clicked item value
                            String itemValue = (String) listView.getItemAtPosition(position);
                            Intent greenIntent = new Intent(MainActivity.this, GreenWeekday.class);
                            greenIntent.putExtra("passed", itemPosition);
                            greenIntent.putExtra("selection", itemValue);
                            startActivity(greenIntent);
                        }
                    });
                }

            else if (weekEnd.isChecked() && redButton.isChecked()) {
                    int index = listView.getFirstVisiblePosition();
                    View view = listView.getChildAt(0);
                    int top = (view == null) ? 0 : view.getTop();

                    listView.setAdapter(adapter);
                    listView.setSelectionFromTop(index, top);
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                                // ListView Clicked item index
                                int itemPosition = position;
                                // ListView Clicked item value
                                String itemValue = (String) listView.getItemAtPosition(position);

                                Intent redIntent = new Intent(MainActivity.this, RedWeekend.class);
                                redIntent.putExtra("passed", itemPosition);
                                redIntent.putExtra("selection", itemValue);
                                startActivity(redIntent);
                            }
                        });
                    }
                else if (weekEnd.isChecked() && blueButton.isChecked()) {
                    int index = listView.getFirstVisiblePosition();
                    View view = listView.getChildAt(0);
                    int top = (view == null) ? 0 : view.getTop();

                        listView.setAdapter(adapter2);
                    listView.setSelectionFromTop(index, top);
                    System.out.println("Weekend and blue");
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // ListView Clicked item index
                                int itemPosition = position;
                                // ListView Clicked item value
                                String itemValue = (String) listView.getItemAtPosition(position);
                                Intent blueIntent = new Intent(MainActivity.this, BlueWeekend.class);
                                blueIntent.putExtra("passed", itemPosition);
                                blueIntent.putExtra("selection", itemValue);
                                startActivity(blueIntent);
                            }
                        });
                    }
                else if (weekEnd.isChecked() && greenButton.isChecked()) {
                    int index = listView.getFirstVisiblePosition();
                    View view = listView.getChildAt(0);
                    int top = (view == null) ? 0 : view.getTop();

                    listView.setAdapter(adapter3);
                    listView.setSelectionFromTop(index, top);
                    System.out.println("Weekend and blue");
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            // ListView Clicked item index
                            int itemPosition = position;
                            // ListView Clicked item value
                            String itemValue = (String) listView.getItemAtPosition(position);
                            Intent greenIntent = new Intent(MainActivity.this, GreenWeekend.class);
                            greenIntent.putExtra("passed", itemPosition);
                            greenIntent.putExtra("selection", itemValue);
                            startActivity(greenIntent);
                        }
                    });
                }
                }
            });


        }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
