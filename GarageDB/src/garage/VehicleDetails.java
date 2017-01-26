/*
 * Written By: Ervin Mamutov | G00311015
 * Written For: Data Centric RAD Semester 2 Year 2
 */
package garage;

public class VehicleDetails {
	private String reg;
	private String mCode;
	private String mName;
	private String mDetails;
	private String moCode;
	private String moName;
	private String moDesc;
	private int mileage;
	private double price;
	private String color;
	private String fuel;
	
	public VehicleDetails(){
		
	}
	
	public VehicleDetails(String reg, String mCode, String mName, String mDetails, String moCode, String moName,
			String moDesc, int mileage, double price, String color, String fuel) {
		super();
		this.reg = reg;
		this.mCode = mCode;
		this.mName = mName;
		this.mDetails = mDetails;
		this.moCode = moCode;
		this.moName = moName;
		this.moDesc = moDesc;
		this.mileage = mileage;
		this.price = price;
		this.color = color;
		this.fuel = fuel;
	}

	public String getReg() {
		return reg;
	}
	public void setReg(String reg) {
		this.reg = reg;
	}
	public String getmCode() {
		return mCode;
	}
	public void setmCode(String mCode) {
		this.mCode = mCode;
	}
	public String getMoCode() {
		return moCode;
	}
	public void setMoCode(String moCode) {
		this.moCode = moCode;
	}
	public int getMileage() {
		return mileage;
	}
	public void setMileage(int mileage) {
		this.mileage = mileage;
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



	public String getmName() {
		return mName;
	}



	public void setmName(String mName) {
		this.mName = mName;
	}



	public String getmDetails() {
		return mDetails;
	}



	public void setmDetails(String mDetails) {
		this.mDetails = mDetails;
	}



	public String getMoName() {
		return moName;
	}



	public void setMoName(String moName) {
		this.moName = moName;
	}



	public String getMoDesc() {
		return moDesc;
	}



	public void setMoDesc(String moDesc) {
		this.moDesc = moDesc;
	}
	
}
