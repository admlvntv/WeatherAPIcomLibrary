/*
   Copyright 2022 Adam Nativ

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/

package me.adamcraftmaster;

import static org.junit.jupiter.api.Assertions.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;

class LibraryTest {
  private String apiKey = System.getenv("API_KEY");

  @Test
  /** test that zip code 10025 return tz id America/New_York */
  void testTzIdNewYork() {
    LocationInfoLib classUnderTest = new LocationInfoLib(apiKey);
    try {
      String tzId = classUnderTest.getTzDatabaseId("10025");
      assertEquals("America/New_York", tzId, "tzId should be America/New_York");
    } catch (JsonProcessingException e) {
      fail("JsonProcessingException should not be thrown"); 
    }
  }

}
