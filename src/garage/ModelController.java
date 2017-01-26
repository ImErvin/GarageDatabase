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
public class ModelController {
	private ArrayList<Model> models;
	private DAO dao;
	
	public ModelController() {
		try {
			dao = new DAO();
		} catch (Exception e) {
			System.out.println("Error: " + e + "\nCould not connect to DAO");
		}
	}
	
	public ArrayList<Model> getModels() {
		return models;
	}
	
	public void loadModels() throws Exception {
		models = dao.getModelDetails();
	}
	
	public String addModel(Model mo) throws SQLException, Exception {
		try {
			dao.addModel(mo);
			return "modelOutput";
		} catch (SQLException e) {
			FacesMessage message = new FacesMessage("Error: " + e);
			FacesContext.getCurrentInstance().addMessage(null, message);
			
			return "Error: " + e;
		} catch(Exception e){
			return "Error: " + e;
		}
	}
}
