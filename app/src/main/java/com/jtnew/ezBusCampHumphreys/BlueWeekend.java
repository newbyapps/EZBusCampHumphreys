package com.jtnew.ezBusCampHumphreys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import java.text.DateFormat;

public class BlueWeekend  extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<String> adapter, adapter2;
    private String[] strings, result;
    // Blue weekdays
    private String[] a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, aa, bb, cc, dd, ee, ff, gg, hh, ii, jj, kk, ll;


    private int value, day;
    private Switch timeSwitch;
    private boolean isSwitchChecked;
    private DateFormat format;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        setContentView(R.layout.activity_blue_weekday);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        value = getIntent().getExtras().getInt("passed");
        day = getIntent().getExtras().getInt("number");
        System.out.println("day: " + day);
        System.out.println("value: " + value);
        System.out.println("day: " + day);
        String titlePassed = getIntent().getExtras().getString("selection");
        setTitle(titlePassed + " - Blue");

        // Blue weekdays - 8/21/2016
        a = new String[]{"0745", "0815", "0845", "0915", "0945", "1015", "1045", "1115", "1145", "1215", "1245", "1315", "1345", "1415", "1445", "1515", "1545", "1615", "1645", "1715", "1745", "1815", "1845", "1915", "1945", "2015", "2045", "2115", "2145", "2215", "2245", "2315", "2345", "0015 Saturday Nights", "0045 Saturday Nights"};
        b = new String[]{"0746", "0816", "0846", "0916", "0946", "1016", "1046", "1116", "1146", "1216", "1246", "1316", "1346", "1416", "1446", "1516", "1546", "1616", "1646", "1716", "1746", "1816", "1846", "1916", "1946", "2016", "2046", "2116", "2146", "2216", "2246", "2316", "2346", "0016 Saturday Nights", "0046 Saturday Nights"};
        c = new String[]{"0748", "0818", "0848", "0918", "0948", "1018", "1048", "1118", "1148", "1218", "1248", "1318", "1348", "1418", "1448", "1518", "1548", "1618", "1648", "1718", "1748", "1818", "1848", "1918", "1948", "2018", "2048", "2118", "2148", "2218", "2248", "2318", "2348", "0018 Saturday Nights", "0048 Saturday Nights"};
        d = new String[]{"0751", "0821", "0851", "0921", "0951", "1021", "1051", "1121", "1151", "1221", "1251", "1321", "1351", "1421", "1451", "1521", "1551", "1621", "1651", "1721", "1751", "1821", "1851", "1921", "1951", "2021", "2051", "2121", "2151", "2221", "2251", "2321", "2351", "0021 Saturday Nights", "0051 Saturday Nights"};
        e = new String[]{"0753", "0823", "0853", "0923", "0953", "1023", "1053", "1123", "1153", "1223", "1253", "1323", "1353", "1423", "1453", "1523", "1553", "1623", "1653", "1723", "1753", "1823", "1853", "1923", "1953", "2023", "2053", "2123", "2153", "2223", "2253", "2323", "2353", "0023 Saturday Nights", "0053 Saturday Nights"};
        f = new String[]{"0755", "0825", "0855", "0925", "0955", "1025", "1055", "1125", "1155", "1225", "1255", "1325", "1355", "1425", "1455", "1525", "1555", "1625", "1655", "1725", "1755", "1825", "1855", "1925", "1955", "2025", "2055", "2125", "2155", "2225", "2255", "2325", "2355", "0025 Saturday Nights", "0055 Saturday Nights"};
        g = new String[]{"0759", "0829", "0859", "0929", "0959", "1029", "1059", "1129", "1159", "1229", "1259", "1329", "1359", "1429", "1459", "1529", "1559", "1629", "1659", "1729", "1759", "1829", "1859", "1929", "1959", "2029", "2059", "2129", "2159", "2229", "2259", "2329", "2359", "0029 Saturday Nights", "0059 Saturday Nights"};
        h = new String[]{"0801", "0831", "0901", "0931", "1001", "1031", "1101", "1131", "1201", "1231", "1301", "1331", "1401", "1431", "1501", "1531", "1601", "1631", "1701", "1731", "1801", "1831", "1901", "1931", "2001", "2031", "2101", "2131", "2201", "2231", "2301", "2331", "0001", "0031 Saturday Nights", "0101 Saturday Nights"};
        i = new String[]{"0802", "0832", "0902", "0932", "1002", "1032", "1102", "1132", "1202", "1232", "1302", "1332", "1402", "1432", "1502", "1532", "1602", "1632", "1702", "1732", "1802", "1832", "1902", "1932", "2002", "2032", "2102", "2132", "2202", "2232", "2302", "2332", "0002", "0032 Saturday Nights", "0102 Saturday Nights"};
        j = new String[]{"0803", "0833", "0903", "0933", "1003", "1033", "1103", "1133", "1203", "1233", "1303", "1333", "1403", "1433", "1503", "1533", "1603", "1633", "1703", "1733", "1803", "1833", "1903", "1933", "2003", "2033", "2103", "2133", "2203", "2233", "2303", "2333", "0003", "0033 Saturday Nights", "0103 Saturday Nights"};
        k = new String[]{"0805", "0835", "0905", "0935", "1005", "1035", "1105", "1135", "1205", "1235", "1305", "1335", "1405", "1435", "1505", "1535", "1605", "1635", "1705", "1735", "1805", "1835", "1905", "1935", "2005", "2035", "2105", "2135", "2205", "2235", "2305", "2335", "0005", "0035 Saturday Nights", "0105 Saturday Nights"};
        l = new String[]{"0806", "0836", "0906", "0936", "1006", "1036", "1106", "1136", "1206", "1236", "1306", "1336", "1406", "1436", "1506", "1536", "1606", "1636", "1706", "1736", "1806", "1836", "1906", "1936", "2006", "2036", "2106", "2136", "2206", "2236", "2306", "2336", "0006", "0036 Saturday Nights", "0106 Saturday Nights"};
        m = new String[]{"0808", "0838", "0908", "0938", "1008", "1038", "1108", "1138", "1208", "1238", "1308", "1338", "1408", "1438", "1508", "1538", "1608", "1638", "1708", "1738", "1808", "1838", "1908", "1938", "2008", "2038", "2108", "2138", "2208", "2238", "2308", "2338", "0008", "0038 Saturday Nights", "0108 Saturday Nights"};
        n = new String[]{"0811", "0841", "0911", "0941", "1011", "1041", "1111", "1141", "1211", "1241", "1311", "1341", "1411", "1441", "1511", "1541", "1611", "1641", "1711", "1741", "1811", "1841", "1911", "1941", "2011", "2041", "2111", "2141", "2211", "2241", "2311", "2341", "0011", "0041 Saturday Nights", "0111 Saturday Nights"};
        o = new String[]{"0812", "0842", "0912", "0942", "1012", "1042", "1112", "1142", "1212", "1242", "1312", "1342", "1412", "1442", "1512", "1542", "1612", "1642", "1712", "1742", "1812", "1842", "1912", "1942", "2012", "2042", "2112", "2142", "2212", "2242", "2312", "2342", "0012", "0042 Saturday Nights", "0112 Saturday Nights"};
        p = new String[]{"0813", "0843", "0913", "0943", "1013", "1043", "1113", "1143", "1213", "1243", "1313", "1343", "1413", "1443", "1513", "1543", "1613", "1643", "1713", "1743", "1813", "1843", "1913", "1943", "2013", "2043", "2113", "2143", "2213", "2243", "2313", "2343", "0013", "0043 Saturday Nights", "0113 Saturday Nights"};
        q = new String[]{"0816", "0846", "0916", "0946", "1016", "1046", "1116", "1146", "1216", "1246", "1316", "1346", "1416", "1446", "1516", "1546", "1616", "1646", "1716", "1746", "1816", "1846", "1916", "1946", "2016", "2046", "2116", "2146", "2216", "2246", "2316", "2346", "0016", "0046 Saturday Nights", "0116 Saturday Nights"};
        r = new String[]{"0818", "0848", "0918", "0948", "1018", "1048", "1118", "1148", "1218", "1248", "1318", "1348", "1418", "1448", "1518", "1548", "1618", "1648", "1718", "1748", "1818", "1848", "1918", "1948", "2018", "2048", "2118", "2148", "2218", "2248", "2318", "2348", "0018", "0048 Saturday Nights", "0118 Saturday Nights"};
        s = new String[]{"0820", "0850", "0920", "0950", "1020", "1050", "1120", "1150", "1220", "1250", "1320", "1350", "1420", "1450", "1520", "1550", "1620", "1650", "1720", "1750", "1820", "1850", "1920", "1950", "2020", "2050", "2120", "2150", "2220", "2250", "2320", "2350", "0020", "0050 Saturday Nights", "0120 Saturday Nights"};
        t = new String[]{"0821", "0851", "0921", "0951", "1021", "1051", "1121", "1151", "1221", "1251", "1321", "1351", "1421", "1451", "1521", "1551", "1621", "1651", "1721", "1751", "1821", "1851", "1921", "1951", "2021", "2051", "2121", "2151", "2221", "2251", "2321", "2351", "0021", "0051 Saturday Nights", "0121 Saturday Nights"};
        u = new String[]{"0825", "0855", "0925", "0955", "1025", "1055", "1125", "1155", "1225", "1255", "1325", "1355", "1425", "1455", "1525", "1555", "1625", "1655", "1725", "1755", "1825", "1855", "1925", "1955", "2025", "2055", "2125", "2155", "2225", "2255", "2325", "2355", "0025", "0055 Saturday Nights", "0125 Saturday Nights"};
        v = new String[]{"0827", "0857", "0927", "0957", "1027", "1057", "1127", "1157", "1227", "1257", "1327", "1357", "1427", "1457", "1527", "1557", "1627", "1657", "1727", "1757", "1827", "1857", "1927", "1957", "2027", "2057", "2127", "2157", "2227", "2257", "2327", "2357", "0027", "0057 Saturday Nights", "0127 Saturday Nights"};
        w = new String[]{"0830", "0900", "0930", "1000", "1030", "1100", "1130", "1200", "1230", "1300", "1330", "1400", "1430", "1500", "1530", "1600", "1630", "1700", "1730", "1800", "1830", "1900", "1930", "2000", "2030", "2100", "2130", "2200", "2230", "2300", "2330", "2400", "0030", "0100 Saturday Nights", "0130 Saturday Nights"};
        x = new String[]{"0833", "0903", "0933", "1003", "1033", "1103", "1133", "1203", "1233", "1303", "1333", "1403", "1433", "1503", "1533", "1603", "1633", "1703", "1733", "1803", "1833", "1903", "1933", "2003", "2033", "2103", "2133", "2203", "2233", "2303", "2333", "0003", "0033", "0103 Saturday Nights", "0133 Saturday Nights"};
        y = new String[]{"0836", "0906", "0936", "1006", "1036", "1106", "1136", "1206", "1236", "1306", "1336", "1406", "1436", "1506", "1536", "1606", "1636", "1706", "1736", "1806", "1836", "1906", "1936", "2006", "2036", "2106", "2136", "2206", "2236", "2306", "2336", "0006", "0036", "0106 Saturday Nights", "0136 Saturday Nights"};
        z = new String[]{"0837", "0907", "0937", "1007", "1037", "1107", "1137", "1207", "1237", "1307", "1337", "1407", "1437", "1507", "1537", "1607", "1637", "1707", "1737", "1807", "1837", "1907", "1937", "2007", "2037", "2107", "2137", "2207", "2237", "2307", "2337", "0007", "0037", "0107 Saturday Nights", "0137 Saturday Nights"};
        aa = new String[]{"0839", "0909", "0939", "1009", "1039", "1109", "1139", "1209", "1239", "1309", "1339", "1409", "1439", "1509", "1539", "1609", "1639", "1709", "1739", "1809", "1839", "1909", "1939", "2009", "2039", "2109", "2139", "2209", "2239", "2309", "2339", "0009", "0039", "0109 Saturday Nights", "0139 Saturday Nights"};
        bb = new String[]{"0840", "0910", "0940", "1010", "1040", "1110", "1140", "1210", "1240", "1310", "1340", "1410", "1440", "1510", "1540", "1610", "1640", "1710", "1740", "1810", "1840", "1910", "1940", "2010", "2040", "2110", "2140", "2210", "2240", "2310", "2340", "0010", "0040", "0110 Saturday Nights", "0140 Saturday Nights"};
        cc = new String[]{"0841", "0911", "0941", "1011", "1041", "1111", "1141", "1211", "1241", "1311", "1341", "1411", "1441", "1511", "1541", "1611", "1641", "1711", "1741", "1811", "1841", "1911", "1941", "2011", "2041", "2111", "2141", "2211", "2241", "2311", "2341", "0011", "0041", "0111 Saturday Nights", "0141 Saturday Nights"};
        dd = new String[]{"0842", "0912", "0942", "1012", "1042", "1112", "1142", "1212", "1242", "1312", "1342", "1412", "1442", "1512", "1542", "1612", "1642", "1712", "1742", "1812", "1842", "1912", "1942", "2012", "2042", "2112", "2142", "2212", "2242", "2312", "2342", "0012", "0042", "0112 Saturday Nights", "0142 Saturday Nights"};
        ee = new String[]{"0843", "0913", "0943", "1013", "1043", "1113", "1143", "1213", "1243", "1313", "1343", "1413", "1443", "1513", "1543", "1613", "1643", "1713", "1743", "1813", "1843", "1913", "1943", "2013", "2043", "2113", "2143", "2213", "2243", "2313", "2343", "0013", "0043", "0113 Saturday Nights", "0143 Saturday Nights"};
        ff = new String[]{"0849", "0919", "0949", "1019", "1049", "1119", "1149", "1219", "1249", "1319", "1349", "1419", "1449", "1519", "1549", "1619", "1649", "1719", "1749", "1819", "1849", "1919", "1949", "2019", "2049", "2119", "2149", "2219", "2249", "2319", "2349", "0019", "0049", "0119 Saturday Nights", "0149 Saturday Nights"};
        gg = new String[]{"0851", "0921", "0951", "1021", "1051", "1121", "1151", "1221", "1251", "1321", "1351", "1421", "1451", "1521", "1551", "1621", "1651", "1721", "1751", "1821", "1851", "1921", "1951", "2021", "2051", "2121", "2151", "2221", "2251", "2321", "2351", "0021", "0051", "0121 Saturday Nights", "0151 Saturday Nights"};
        hh = new String[]{"0854", "0924", "0954", "1024", "1054", "1124", "1154", "1224", "1254", "1324", "1354", "1424", "1454", "1524", "1554", "1624", "1654", "1724", "1754", "1824", "1854", "1924", "1954", "2024", "2054", "2124", "2154", "2224", "2254", "2324", "2354", "0024", "0054", "0124 Saturday Nights", "0154 Saturday Nights"};
        ii = new String[]{"0855", "0925", "0955", "1025", "1055", "1125", "1155", "1225", "1255", "1325", "1355", "1425", "1455", "1525", "1555", "1625", "1655", "1725", "1755", "1825", "1855", "1925", "1955", "2025", "2055", "2125", "2155", "2225", "2255", "2325", "2355", "0025", "0055", "0125 Saturday Nights", "0155 Saturday Nights"};
        jj = new String[]{"0858", "0928", "0958", "1028", "1058", "1128", "1158", "1228", "1258", "1328", "1358", "1428", "1458", "1528", "1558", "1628", "1658", "1728", "1758", "1828", "1858", "1928", "1958", "2028", "2058", "2128", "2158", "2228", "2258", "2328", "2358", "0028", "0058", "0128 Saturday Nights", "0158 Saturday Nights"};
        kk = new String[]{"0900", "0930", "1000", "1030", "1100", "1130", "1200", "1230", "1300", "1330", "1400", "1430", "1500", "1530", "1600", "1630", "1700", "1730", "1800", "1830", "1900", "1930", "2000", "2030", "2100", "2130", "2200", "2230", "2300", "2330", "2400", "0030", "0100", "0130 Saturday Nights", "0200 Saturday Nights"};
        ll = new String[]{"0904", "0934", "1004", "1034", "1104", "1134", "1204", "1234", "1304", "1334", "1404", "1434", "1504", "1534", "1604", "1634", "1704", "1734", "1804", "1834", "1904", "1934", "2004", "2034", "2104", "2134", "2204", "2234", "2304", "2334", "0004", "0034", "0104", "0134 Saturday Nights", "0204 Saturday Nights"};

        // Done with Blue Weekdays


        switch (value) {

            case 0:
                adapter = new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1, android.R.id.text1, a);
                break;
            case 1:
                adapter = new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1, android.R.id.text1, b);
                break;
            case 2:
                adapter = new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1, android.R.id.text1, c);
                break;
            case 3:
                adapter = new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1, android.R.id.text1, d);
                break;
            case 4:
                adapter = new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1, android.R.id.text1, e);
                break;
            case 5:
                adapter = new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1, android.R.id.text1, f);
                break;
            case 6:
                adapter = new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1, android.R.id.text1, g);
                break;
            case 7:
                adapter = new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1, android.R.id.text1, h);
                break;
            case 8:
                adapter = new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1, android.R.id.text1, i);
                break;
            case 9:
                adapter = new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1, android.R.id.text1, j);
                break;
            case 10:
                adapter = new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1, android.R.id.text1, k);
                break;
            case 11:
                adapter = new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1, android.R.id.text1, l);
                break;
            case 12:
                adapter = new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1, android.R.id.text1, m);
                break;
            case 13:
                adapter = new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1, android.R.id.text1, n);
                break;
            case 14:
                adapter = new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1, android.R.id.text1, o);
                break;
            case 15:
                adapter = new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1, android.R.id.text1, p);
                break;
            case 16:
                adapter = new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1, android.R.id.text1, q);
                break;
            case 17:
                adapter = new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1, android.R.id.text1, r);
                break;
            case 18:
                adapter = new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1, android.R.id.text1, s);
                break;
            case 19:
                adapter = new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1, android.R.id.text1, t);
                break;
            case 20:
                adapter = new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1, android.R.id.text1, u);
                break;
            case 21:
                adapter = new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1, android.R.id.text1, v);
                break;
            case 22:
                adapter = new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1, android.R.id.text1, w);
                break;
            case 23:
                adapter = new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1, android.R.id.text1, x);
                break;
            case 25:
                adapter = new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1, android.R.id.text1, y);
                break;
            case 26:
                adapter = new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1, android.R.id.text1, z);
                break;
            case 27:
                adapter = new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1, android.R.id.text1, aa);
                break;
            case 28:
                adapter = new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1, android.R.id.text1, bb);
                break;
            case 29:
                adapter = new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1, android.R.id.text1, cc);
                break;
            case 30:
                adapter = new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1, android.R.id.text1, dd);
                break;
            case 31:
                adapter = new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1, android.R.id.text1, ee);
                break;
            case 32:
                adapter = new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1, android.R.id.text1, ff);
                break;
            case 33:
                adapter = new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1, android.R.id.text1, gg);
                break;
            case 34:
                adapter = new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1, android.R.id.text1, hh);
                break;
            case 35:
                adapter = new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1, android.R.id.text1, ii);
                break;
            case 36:
                adapter = new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1, android.R.id.text1, jj);
                break;
            case 37:
                adapter = new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1, android.R.id.text1, kk);
                break;
            case 38:
                adapter = new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1, android.R.id.text1, ll);
                break;
            default:
                Toast.makeText(getApplicationContext(),
                        "This is the default" + value
                        , Toast.LENGTH_LONG)
                        .show();

        }


        listView = (ListView) findViewById(R.id.blueListView);
        listView.setAdapter(adapter);

//        // 24-Hour time format
//
//
//        strings = new String[adapter.getCount()];
//        result = new String[strings.length];
//        adapter2 = new ArrayAdapter<>(this,
//                android.R.layout.simple_list_item_1, android.R.id.text1, result);
//        format = new SimpleDateFormat("hh:mm a");
//
//        if (timeSwitch.isChecked()) {
//            for (int i = 0; i < adapter.getCount(); i++) {
//                strings[i] = adapter.getItem(i);
//            }
//            try {
//
//                for (int i = 0; i < strings.length; i++) {
//                    if (strings[i].contains("-")) {
//                        StringBuilder a = new StringBuilder();
//                        int count = 0;
//                        String[] test = strings[i].split(" - ");
//                        for (String j : test) {
//                            Date date = format.parse(j);
//                            Time time = new Time(date.getTime());
//                            StringBuilder b = new StringBuilder(String.valueOf(time));
//                            b.delete(5, 8);
//                            a.append(String.valueOf(b));
//                            if (count == 0)
//                                a.append(" - ");
//                            count++;
//                        }
//                        result[i] = String.valueOf(a);
//                    } else {
//                        Date date = format.parse(strings[i]);
//                        Time time = new Time(date.getTime());
//                        StringBuilder c = new StringBuilder(String.valueOf(time));
//                        c.delete(5, 8);
//                        result[i] = String.valueOf(c);
//                    }
//                }
//
//                listView.setAdapter(adapter2);
//            } catch (Exception e) {
//                System.out.println("OH no");
//            }
//
//        } else {
//            listView.setAdapter(adapter);
//        }
//
//
//
//        timeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                Globals.setSelected(isChecked);
//                if (timeSwitch.isChecked()) {
//                    for (int i = 0; i < adapter.getCount(); i++) {
//                        strings[i] = adapter.getItem(i);
//                    }
//                    try {
//
//                        for (int i = 0; i < strings.length; i++) {
//                            if (strings[i].contains("-")) {
//                                StringBuilder a = new StringBuilder();
//                                int count = 0;
//                                String[] test = strings[i].split(" - ");
//                                for (String j : test) {
//                                    Date date = format.parse(j);
//                                    Time time = new Time(date.getTime());
//                                    StringBuilder b = new StringBuilder(String.valueOf(time));
//                                    b.delete(5, 8);
//                                    a.append(String.valueOf(b));
//                                    if (count == 0)
//                                        a.append(" - ");
//                                    count++;
//                                }
//                                result[i] = String.valueOf(a);
//                            } else {
//                                Date date = format.parse(strings[i]);
//                                Time time = new Time(date.getTime());
//                                StringBuilder c = new StringBuilder(String.valueOf(time));
//                                c.delete(5, 8);
//                                result[i] = String.valueOf(c);
//                            }
//                        }
//                        int index = listView.getFirstVisiblePosition();
//                        View view = listView.getChildAt(0);
//                        int top = (view == null) ? 0 : view.getTop();
//
//                        listView.setAdapter(adapter2);
//                        listView.setSelectionFromTop(index, top);
//                    } catch (Exception e) {
//                        System.out.println("OH no");
//                    }
//
//                } else {
//                    int index = listView.getFirstVisiblePosition();
//                    View view = listView.getChildAt(0);
//                    int top = (view == null) ? 0 : view.getTop();
//
//                    listView.setAdapter(adapter);
//                    listView.setSelectionFromTop(index, top);
//                }
//            }
//
//        });
    }
}
