package resources;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DBConnection {
	private static ComboPooledDataSource cpds = new ComboPooledDataSource();
	static {
		try {
			cpds.setDriverClass("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			cpds.setJdbcUrl("jdbc:sqlserver://masryatech.database.windows.net:1433;database=MasryaTech");
			cpds.setUser("shady");
			cpds.setPassword("Masryatech12");
			cpds.setMaxIdleTime(60 * 10);
			cpds.setAcquireRetryDelay(2000);
			cpds.setAcquireRetryAttempts(3);
			cpds.setUnreturnedConnectionTimeout(100);
			cpds.setPrivilegeSpawnedThreads(true);
			cpds.setDebugUnreturnedConnectionStackTraces(true);
			cpds.setContextClassLoaderSource("library");
			cpds.setMaxConnectionAge(20);
			cpds.setInitialPoolSize(6);
			cpds.setMaxPoolSize(30);
			cpds.setMaxStatements(30);
			cpds.setIdentityToken("MasterDB");
			cpds.setStatementCacheNumDeferredCloseThreads(2);
			cpds.setNumHelperThreads(5);
			// cpds.setTestConnectionOnCheckin(true);
			cpds.setContextClassLoaderSource("library");
		} catch (PropertyVetoException e) {
			// System.out.println("Refresh");
			// cpds.close();
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {
		return cpds.getConnection();
	}

	public static void DestroyConnection() throws SQLException {
		cpds.close();
		cpds.resetPoolManager();
	}

	private DBConnection() {
	}
}
