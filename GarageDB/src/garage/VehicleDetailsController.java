/*
 * Written By: Ervin Mamutov | G00311015
 * Written For: Data Centric RAD Semester 2 Year 2
 */
package garage;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
	
@ManagedBean
@SessionScoped
public class VehicleDetailsController {
	VehicleDetails vDeets = new VehicleDetails();
	private DAO dao;
	
	public VehicleDetailsController() {
		try {
			dao = new DAO();
		} catch (Exception e) {
			System.out.println("Error: " + e + "\nCould not connect to DAO");
		}
	}
		
	public String getVehicleDeets(Vehicle v) throws Exception{
		setvDeets(dao.getVehicleDeets(v));
		
		return "vehicleDetails";
	}
	
	
	public VehicleDetails getvDeets() {
		return vDeets;
	}

	public void setvDeets(VehicleDetails vDeets) {
		this.vDeets = vDeets;
	}
	
}
