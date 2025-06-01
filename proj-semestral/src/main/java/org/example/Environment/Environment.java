package org.example.Environment;

public class Environment {
  public static Environment Instance;

  public final String dbName;
  public final String dbAddress;
  public final String dbPort;
  public final String dbUser;
  public final String dbPasswd;

  private Environment() {
    this.dbName = System.getenv("DB_NAME");
    this.dbAddress = System.getenv("DB_ADDRESS");
    this.dbPort = System.getenv("DB_PORT");
    this.dbUser = System.getenv("DB_USER");
    this.dbPasswd = System.getenv("DB_PASSWORD");
  }

  public static Environment getInstance() {
    if (Instance == null) {
      Instance = new Environment();
    }
    return Instance;
  }
}
