package ru.stqa.soap;

import net.webservicex.GeoIP;
import net.webservicex.GeoIPService;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by User on 16.04.2017.
 */
public class GeoIpServiceTests {

    @Test
    public void testMyIp() {
        GeoIP geoIP = new GeoIPService().getGeoIPServiceSoap12().getGeoIP("109.172.15.13");
        assertEquals(geoIP.getCountryCode(), "RUS");
    }

    @Test
    public void testInvalidIp() {
        GeoIP geoIP = new GeoIPService().getGeoIPServiceSoap12().getGeoIP("109.172.15.xx");
        assertEquals(geoIP.getCountryCode(), "RUS");
    }
}
