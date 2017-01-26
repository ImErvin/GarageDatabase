/*
 * Written By: Ervin Mamutov | G00311015
 * Written For: Data Centric RAD Semester 2 Year 2
 */
package garage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.naming.*;
import javax.sql.DataSource;

public class DAO {

	private DataSource mysqlDS;

	public DAO() throws Exception {
		Context context = new InitialContext();
		String jndiName = "java:comp/env/jdbc/garage";
		mysqlDS = (DataSource) context.lookup(jndiName);
	}
	
	// MODEL METHODS ===============================================================================
	public void addModel(Model mo) throws SQLException{
		Connection conn = mysqlDS.getConnection();
		PreparedStatement myStmt = conn.prepareStatement("INSERT INTO model values(?, ?, ?, ?);");

		myStmt.setString(1, mo.getmCode());
		myStmt.setString(2, mo.getCode());
		myStmt.setString(3, mo.getName());
		myStmt.setString(4, mo.getDesc());
		
		myStmt.executeUpdate();
	}
	
	public ArrayList<Model> getModelDetails() throws Exception{
		ArrayList<Model> models = new ArrayList<>();

		Connection conn = mysqlDS.getConnection();
		PreparedStatement myStmt = conn.prepareStatement("select * from model");

		ResultSet rs = myStmt.executeQuery();

		while (rs.next()) {
			
			String mCode = rs.getString("manu_code");
			String code = rs.getString("model_code");
			String name = rs.getString("model_name");
			String desc = rs.getString("model_desc");
			models.add(new Model(mCode, code, name, desc));
		}

		return models;
	}
	// END OF MODEL METHODS =======================================================================
	
	// MANUFACTURER METHODS =======================================================================
	public void addManufacturer(Manufacturer m) throws SQLException{
		Connection conn = mysqlDS.getConnection();
		PreparedStatement myStmt = conn.prepareStatement("INSERT INTO manufacturer values(?, ?, ?);");

		myStmt.setString(1, m.getCode());
		myStmt.setString(2, m.getName());
		myStmt.setString(3, m.getDetails());
		
		myStmt.executeUpdate();
	}
	
	public void deleteManufacturer(Manufacturer m) throws SQLException{
		Connection conn = mysqlDS.getConnection();
		PreparedStatement myStmt = conn.prepareStatement("DELETE FROM manufacturer WHERE "
														+ "manu_code = ?;");
		System.out.println("DELETING MANU_CODE:" + m.getCode());
		myStmt.setString(1, m.getCode());

		myStmt.executeUpdate();		
	}
	
	public void updateManufacturer(Manufacturer m) throws SQLException{
		Connection conn = mysqlDS.getConnection(); 
		PreparedStatement myStmt = conn.prepareStatement("UPDATE manufacturer SET "
														+ "manu_name = ?,"
														+ "manu_details = ? WHERE "
														+ "manu_code = ?;");
		 
		myStmt.setString(1, m.getName());
		myStmt.setString(2, m.getDetails());
		myStmt.setString(3, m.getCode());
		
		myStmt.executeUpdate(); 
	}
	
	public ArrayList<Manufacturer> getManufacturerDetails() throws Exception {

		ArrayList<Manufacturer> manufacturers = new ArrayList<>();

		Connection conn = mysqlDS.getConnection();
		PreparedStatement myStmt = conn.prepareStatement("select * from manufacturer");

		ResultSet rs = myStmt.executeQuery();

		while (rs.next()) {

			String code = rs.getString("manu_code");
			String name = rs.getString("manu_name");
			String details = rs.getString("manu_details");
			manufacturers.add(new Manufacturer(code, name, details));
		}

		return manufacturers;
	}
	// END OF MANUFACTURER METHODS ================================================================
	
	// VEHICLE METHODS ============================================================================	
	public void addVehicle(Vehicle v) throws SQLException{
		Connection conn = mysqlDS.getConnection();
		PreparedStatement myStmt = conn.prepareStatement("INSERT INTO vehicle values(?, ?, ?, ?, ?, ?, ?);");
		
		myStmt.setString(1, v.getReg());
		myStmt.setString(2, v.getmCode());
		myStmt.setString(3, v.getMoCode());
		myStmt.setInt(4, v.getMileage());
		myStmt.setDouble(5, v.getPrice());
		myStmt.setString(6, v.getColor());
		myStmt.setString(7, v.getFuel());
		
		myStmt.executeUpdate();
	}
	
	public ArrayList<Vehicle> getVehicleDetails() throws Exception{
		ArrayList<Vehicle> vehicles = new ArrayList<>();

		Connection conn = mysqlDS.getConnection();
		PreparedStatement myStmt = conn.prepareStatement("select * from vehicle");

		ResultSet rs = myStmt.executeQuery();

		while (rs.next()) {
			
			String reg = rs.getString("reg");
			String mCode = rs.getString("manu_code");
			String moCode = rs.getString("model_code");
			int mileage = rs.getInt("mileage");
			double price = rs.getDouble("price");
			String color = rs.getString("colour");
			String fuel = rs.getString("fuel");

			vehicles.add(new Vehicle(reg, mCode, moCode, mileage, price, color, fuel));
		}

		return vehicles;
	}
	// END OF VEHICLE METHODS ====================================================================
	public VehicleDetails getVehicleDeets(Vehicle v) throws Exception{
		Connection conn = mysqlDS.getConnection();
		PreparedStatement myStmt = conn.prepareStatement("select distinct v.*, m.manu_name, m.manu_details, mo.model_name, mo.model_desc "
														+ "from vehicle v inner join manufacturer m inner join model mo "
														+ "where v.reg like ? "
														+ "and m.manu_code like ? "
														+ "and mo.model_code like ?");
		
		myStmt.setString(1, v.getReg());
		myStmt.setString(2, v.getmCode());
		myStmt.setString(3, v.getMoCode());
		
		ResultSet rs = myStmt.executeQuery();
		rs.next();
		
		String reg = rs.getString("reg");
		String mCode = rs.getString("manu_code");
		String mName = rs.getString("manu_name");
		String mDetails = rs.getString("manu_details");
		String moCode = rs.getString("model_code");
		String moName = rs.getString("model_name");
		String moDesc = rs.getString("model_desc");
		int mileage = rs.getInt("mileage");
		double price = rs.getDouble("price");
		String color = rs.getString("colour");
		String fuel = rs.getString("fuel");
		
		VehicleDetails vDeets = new VehicleDetails(reg,mCode,mName,mDetails,moCode,moName,moDesc,mileage,price,color,fuel);
		
		return vDeets;
	}
	// END OF VEHICLE METHODS ==================================================================
	// SEARCH METHODS ==========================================================================
	public ArrayList<Vehicle> getSearchVehicle(String query) throws Exception{
		ArrayList<Vehicle> vehicles = new ArrayList<>();

		Connection conn = mysqlDS.getConnection();
		PreparedStatement myStmt = conn.prepareStatement(query);
		
		ResultSet rs = myStmt.executeQuery();

		while (rs.next()) {
			
			String reg = rs.getString("reg");
			String mCode = rs.getString("manu_code");
			String moCode = rs.getString("model_code");
			int mileage = rs.getInt("mileage");
			double price = rs.getDouble("price");
			String color = rs.getString("colour");
			String fuel = rs.getString("fuel");

			vehicles.add(new Vehicle(reg, mCode, moCode, mileage, price, color, fuel));
		}
		
		return vehicles;
	}
	// END OF SEARCH METHODS ================================================================
	
}
