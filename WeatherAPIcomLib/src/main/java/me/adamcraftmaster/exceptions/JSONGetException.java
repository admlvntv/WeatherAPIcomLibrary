package me.adamcraftmaster.exceptions;

import java.io.IOException;

/**
 * A class that handles exceptions to do with getting the JSON from a URL
 *
 * <p>sub-class of {@link java.io.IOException}
 */
public class JSONGetException extends IOException {
  public JSONGetException(String errorMessage) {
    super(errorMessage);
  }
}
