package PTPudding_Database.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	
	public Connection connect;
	public Statement statement;
	public PreparedStatement preparedStatement;
	public ResultSet resultSet;

	public DBConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/ptpuddingdb";
			String username = "root";
			String password = "";
			
			connect = DriverManager.getConnection(url, username, password);

			statement = connect.createStatement();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//select all
		public ResultSet getAllData() {
			try {
				preparedStatement = connect.prepareStatement("SELECT * FROM table_user");
				resultSet = preparedStatement.executeQuery();
			} catch (SQLException e) {}
			return resultSet;
		}
		
		//insert
		public void insertUser(String name, String price, String stock) {
			try {
				preparedStatement = connect.prepareStatement("INSERT INTO table_user (Name, Price, Stock) VALUES (?, ?, ?)");
				preparedStatement.setString(1, name);
				preparedStatement.setString(2, price);
				preparedStatement.setString(3, stock);

				preparedStatement.execute();
			} catch (SQLException e) {}
		}

		//update
		public void updateUser(Integer id, String name, String price, String stock) {
			try {
				preparedStatement = connect.prepareStatement("UPDATE table_user SET Name = ?, Price = ?, Stock = ? WHERE ID = ?");
				preparedStatement.setString(1, name);
				preparedStatement.setString(2, price);
				preparedStatement.setString(3, stock);
				preparedStatement.setInt(4, id);

				preparedStatement.execute();
			} catch (SQLException e) {}
		}

		//delete
		public void deleteUser(Integer id) {
			try {
				preparedStatement = connect.prepareStatement("DELETE FROM table_user WHERE ID = ?");
				preparedStatement.setInt(1, id);

				preparedStatement.execute();
			} catch (SQLException e) {}
		}

}
