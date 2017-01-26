/*
 * Written By: Ervin Mamutov | G00311015
 * Written For: Data Centric RAD Semester 2 Year 2
 */
package garage;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Model {
	private String mCode;
	private String code;
	private String name;
	private String desc;
	
	public Model(){
		
	}
	
	public Model(String mCode, String code, String name, String desc){
		this.mCode = mCode;
		this.code = code;
		this.name = name;
		this.desc = desc;
	}
	
	public String getmCode() {
		return mCode;
	}
	public void setmCode(String mCode) {
		this.mCode = mCode;
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
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
}
