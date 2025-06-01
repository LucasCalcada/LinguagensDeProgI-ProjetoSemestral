package org.example.Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.example.Utils.ResourceLoader;

public class DatabaseInit {
  public static void InitializeDatabase() throws SQLException {
    // Pega referência para a conexão ao banco
    Connection conn = DbConnector.getInstance().dbConnection;
    Statement stm = conn.createStatement();
    stm.execute("USE proj_semestral");

    // Carrega o script de inicialização do banco
    String initScript = ResourceLoader.readResourceAsString("/database/initDb.sql");

    String[] commands = initScript.split(";");
    for (String command : commands) {
      command = command.trim();
      stm.execute(command);
    }
  }
}
