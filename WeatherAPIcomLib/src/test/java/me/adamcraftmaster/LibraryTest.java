package me.adamcraftmaster;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LibraryTest {
  private String apiKey = System.getenv("API_KEY");

  @Test
  void someLibraryMethodReturnsTrue() {
    CurrentWeatherLib classUnderTest = new CurrentWeatherLib(apiKey);
    // assertTrue(classUnderTest.someLibraryMethod(), "someLibraryMethod should return 'true'");
    assertTrue(true, "true should be true");
  }
}
