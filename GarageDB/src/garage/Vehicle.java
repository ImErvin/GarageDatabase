/*
 * Written By: Ervin Mamutov | G00311015
 * Written For: Data Centric RAD Semester 2 Year 2
 */
package garage;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class Vehicle {
	private String reg;
	private String mCode;
	private String moCode;
	private int mileage;
	private double price;
	private String color;
	private String fuel;
	
	public Vehicle(){
		
	}
	
	public Vehicle(String reg, String mCode, String moCode, int mileage, double price, String color, String fuel) {
		this.reg = reg;
		this.mCode = mCode;
		this.moCode = moCode;
		this.mileage = mileage;
		this.price = price;
		this.color = color;
		this.fuel = fuel;
	}
	public String getReg() {
		System.out.println("GET REG");
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
}
