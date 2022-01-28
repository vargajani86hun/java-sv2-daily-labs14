package day05.daily;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StreetViewTest {

    @Test
    void testStreetView() {
        StreetView sv = new StreetView();

        sv.readSoldOrderFromFile("src/test/resources/streets.txt");

        System.out.println(sv.getSoldBuildings());
    }

}