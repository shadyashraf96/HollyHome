package resources;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class TableDuplicator {
	/**
	 * Duplicates a table's structure and content from a source database to a target
	 * SQLite database.
	 * 
	 * @param sourceConnection The connection to the source database.
	 * @param targetConnection The connection to the SQLite database.
	 * @param tableName        The name of the table to duplicate.
	 */
	public static void duplicateTable(Connection sourceConnection, Connection targetConnection, String tableName) {
		try {
			// Retrieve metadata about the table from the source database
			DatabaseMetaData metaData = sourceConnection.getMetaData();
			ResultSet columns = metaData.getColumns(null, null, tableName, null);

			StringBuilder createTableSQL = new StringBuilder("CREATE TABLE " + tableName + " (");

			while (columns.next()) {
				String name = columns.getString("COLUMN_NAME");
				String type = columns.getString("TYPE_NAME");
				// Mapping to SQLite types might be necessary here
				createTableSQL.append(name).append(" ").append(type).append(", ");
			}
			// Remove trailing comma and space
			createTableSQL.setLength(createTableSQL.length() - 2);
			createTableSQL.append(");");

			// Execute CREATE TABLE statement in SQLite
			Statement targetStatement = targetConnection.createStatement();
			targetStatement.execute("DROP TABLE IF EXISTS " + tableName + ";");
			targetStatement.execute(createTableSQL.toString());

			// Fetch and copy data
			Statement sourceStatement = sourceConnection.createStatement();
			ResultSet rs = sourceStatement.executeQuery("SELECT * FROM " + tableName);
			ResultSetMetaData rsMetaData = rs.getMetaData();
			int columnCount = rsMetaData.getColumnCount();

			StringBuilder insertSQL = new StringBuilder("INSERT INTO " + tableName + " (");
			for (int i = 1; i <= columnCount; i++) {
				insertSQL.append(rsMetaData.getColumnName(i));
				if (i < columnCount)
					insertSQL.append(", ");
			}
			insertSQL.append(") VALUES (");
			for (int i = 1; i <= columnCount; i++) {
				insertSQL.append("?");
				if (i < columnCount)
					insertSQL.append(", ");
			}
			insertSQL.append(");");

			PreparedStatement insertStatement = targetConnection.prepareStatement(insertSQL.toString());

			while (rs.next()) {
				for (int i = 1; i <= columnCount; i++) {
					insertStatement.setObject(i, rs.getObject(i));
				}
				insertStatement.addBatch();
			}

			insertStatement.executeBatch();
			System.out.println("Table " + tableName + " duplicated successfully.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
