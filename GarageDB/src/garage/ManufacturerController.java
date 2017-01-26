/*
 * Written By: Ervin Mamutov | G00311015
 * Written For: Data Centric RAD Semester 2 Year 2
 */
package garage;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
	
@ManagedBean
@SessionScoped
public class ManufacturerController {
	private ArrayList<Manufacturer> manufacturers;
	private DAO dao;
    Manufacturer m = new Manufacturer();
	
	public ManufacturerController() {
		try {
			dao = new DAO();
		} catch (Exception e) {
			System.out.println("Error: " + e + "\nCould not connect to DAO");
		}
	}
	
	public ArrayList<Manufacturer> getManufacturers() {
		return manufacturers;
	}
	
	public void loadManufacturers() throws Exception {
		manufacturers = dao.getManufacturerDetails();
	}

	public String addManufacturer(Manufacturer m) throws SQLException, Exception{
		try {
			dao.addManufacturer(m);
			return "manufacturerOutput";
		} catch (SQLException e) {
			FacesMessage message = new FacesMessage("Error: " + e);
			FacesContext.getCurrentInstance().addMessage(null, message);
			
			return "Error: " + e;
		} catch(Exception e){
			return "Error: " + e;
		}
	}

	public void deleteManufacturer(Manufacturer m) throws SQLException,Exception{
		try{
			dao.deleteManufacturer(m);
		}catch (SQLException e) {
			FacesMessage message = new FacesMessage("Error: " + e);
			FacesContext.getCurrentInstance().addMessage(null, message);

		} catch(Exception e){
			System.out.println(e);
		}
	}
	
	public String updateManufacturerClick() throws Exception{
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		
		Map<String,Object> object = externalContext.getRequestMap();
		object.put("object", m);
        
		return "manufacturerUpdate";
	}
	
	public String updateManufacturer() throws SQLException,Exception{
		try{
			dao.updateManufacturer(m);
			return "manufacturerOutput";
		} catch (SQLException e) {
			FacesMessage message = new FacesMessage("Error: " + e);
			FacesContext.getCurrentInstance().addMessage(null, message);
			
			return "Error: " + e;
		} catch(Exception e){
			return "Error: " + e;
		}
	}
	
	public Manufacturer getM(){
		return m;
	}
	
	public void setM(Manufacturer m){
		this.m = m;
	}
}
