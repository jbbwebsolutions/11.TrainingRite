package com.trainingrite.driver.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.trainingrite.model.Purchases;

public class Driver_Purchases_SQL_JDBC {

	public static void main(String[] args) {

		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		final String DB_URL = "jdbc:mysql://localhost:3306/purchasedb";
		final String USER = "root";
		final String PASS = "";

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Purchases> list = new ArrayList<>();
		try {

			// STEP 2: Register JDBC driver
			Class.forName(JDBC_DRIVER);

			// STEP 3: Open a connection
			System.out.println("Connecting to a selected database...");
			con = DriverManager.getConnection(DB_URL, USER, PASS);

			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from purchases");
			while (rs.next()) {
				System.out.println("ID=" + rs.getString("customerId") + ", price=" + rs.getDouble("totalprice"));
				Purchases p = new Purchases(rs.getString("customerId"), rs.getDouble("totalprice"),
						rs.getInt("totalItems"));
				list.add(p);
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		for (Purchases purchases : list) {
			System.out.println(purchases);
		}

	}

}
