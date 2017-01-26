/*
 * Written By: Ervin Mamutov | G00311015
 * Written For: Data Centric RAD Semester 2 Year 2
 */
package garage;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
	
@ManagedBean
@SessionScoped
public class SearchController {
	private String symbol;
	private double price;
	private String color;
	private String fuel;
	private String query;
	private ArrayList<Vehicle> vehicles;
	private DAO dao;
	
	public SearchController() {
		try {
			dao = new DAO();
		} catch (Exception e) {
			System.out.println("Error: " + e + "\nCould not connect to DAO");
		}
	}
	
	public ArrayList<Vehicle> getVehicles() {
		System.out.println("GET");
		return vehicles;
	}
	
	public String search() throws Exception{
		switch(getSymbol()){
		case "Less Than":
			setSymbol("<");
			break;
		case "Greater Than":
			setSymbol(">");
			break;
		default:
			setSymbol("=");
			break;
		}
		
		if(getColor() == ""){
			System.out.println("NULL");
			setColor("%");
		}
		
		if(getFuel() == null){
			setFuel("%");
		}
		
		setQuery("select * from vehicle where price " + getSymbol() + " " + getPrice() + " and colour like '" + getColor() + "' and fuel like '" + getFuel() + "';");
		
		vehicles = dao.getSearchVehicle(getQuery());
		
		System.out.println(vehicles.size());
		if(vehicles.size() == 0){
			return "noResult";
		}else{
			return "searchOutput";
		}
	}
	
	public void loadVehicles() throws Exception {
		System.out.println("LOAD");
		vehicles = dao.getSearchVehicle(getQuery());
	}
	
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getFuel() {
		return fuel;
	}
	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}
	
	
}
