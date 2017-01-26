/*
 * Written By: Ervin Mamutov | G00311015
 * Written For: Data Centric RAD Semester 2 Year 2
 */
package garage;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Manufacturer {
	private String code;
	private String name;
	private String details;
	
	public Manufacturer(){
		
	}
	
	public Manufacturer(String code, String name, String details){
		this.code = code;
		this.name = name;
		this.details = details;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
	
	public String getUpdateCode() {
		return details;
	}

	public void setUpdateCode(String details) {
		this.details = details;
	}
	
	
	
}
