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
public class VehicleController {
	private ArrayList<Vehicle> vehicles;
	private DAO dao;
	
	public VehicleController() {
		try {
			dao = new DAO();
		} catch (Exception e) {
			System.out.println("Error: " + e + "\nCould not connect to DAO");
		}
	}
	
	public ArrayList<Vehicle> getVehicles() {
		return vehicles;
	}
	
	public void loadVehicles() throws Exception {
		vehicles = dao.getVehicleDetails();
	}
	
	public String addVehicle(Vehicle v) throws SQLException, Exception {
		try {
			dao.addVehicle(v);
			return "vehicleOutput";
		} catch (SQLException e) {
			FacesMessage message = new FacesMessage("Error: " + e);
			FacesContext.getCurrentInstance().addMessage(null, message);
			
			return "Error: " + e;
		} catch(Exception e){
			return "Error: " + e;
		}
	}
}
