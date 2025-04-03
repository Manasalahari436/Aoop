package task_12;

import java.sql.Connection;
import java.sql.DriverManager;

class DBConnection {
	static final String URL = "jdbc:postgresql://localhost:5432/studentdb";

    static final String USER = "sathvikchoudary61";
    static final String PASSWORD = "@Madhavi2006";

    public static Connection getConnection() throws Exception {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}