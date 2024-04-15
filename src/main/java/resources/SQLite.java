package resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.sqlite.SQLiteConfig;
import org.sqlite.SQLiteConfig.SynchronousMode;

public class SQLite {
	static Connection con;
	static boolean Writing = false;

	public void WaitUntilAvailable() {
		while (Writing) {
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	static public Connection GetSqlite() throws ClassNotFoundException, SQLException {
		Class.forName("org.sqlite.JDBC");
		String url = "jdbc:sqlite:RentalsDB.sql";
		SQLiteConfig config = new SQLiteConfig();
		config.setSynchronous(SynchronousMode.OFF);
		con = DriverManager.getConnection(url, config.toProperties());
		return con;
	}

	static public void CloseSqlite() throws ClassNotFoundException, SQLException {
		Writing = false;
		if (con != null)
			con.close();
	}
}
