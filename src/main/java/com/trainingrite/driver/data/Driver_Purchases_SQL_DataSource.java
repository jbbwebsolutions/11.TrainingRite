package com.trainingrite.driver.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp.BasicDataSource;

import com.trainingrite.model.Purchases;

public class Driver_Purchases_SQL_DataSource {

	public static void main(String[] args) {

		BasicDataSource ds = new BasicDataSource();

		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUsername("root");
		ds.setPassword("");
		ds.setUrl("jdbc:mysql://localhost:3306/purchasedb");

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Purchases> list = new ArrayList<>();
		try {
			con = ds.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from purchases");
			while (rs.next()) {
				System.out.println("ID=" + rs.getString("customerId") + ", price=" + rs.getDouble("totalprice"));
				Purchases p  = new Purchases( rs.getString("customerId"), rs.getDouble("totalprice"), rs.getInt("totalItems"));				
				list .add(p);
			}
		} catch (SQLException e) {
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
