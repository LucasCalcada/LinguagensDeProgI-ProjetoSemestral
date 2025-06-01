package org.example.Utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class ResourceLoader {
  public static String readResourceAsString(String path) {
    InputStream fileStream = ResourceLoader.class.getResourceAsStream(path);
    BufferedReader reader = new BufferedReader(new InputStreamReader(fileStream));
    return reader.lines().collect(Collectors.joining("\n"));
  }
}
