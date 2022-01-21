package me.adamcraftmaster;

import org.junit.jupiter.api.Test;

import me.adamcraftmaster.WeatherAPIService;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {
    @Test void someLibraryMethodReturnsTrue() {
        WeatherAPIService classUnderTest = new WeatherAPIService();
        assertTrue(classUnderTest.someLibraryMethod(), "someLibraryMethod should return 'true'");
    }
}
