package main;

public class ProjectManager {
	public String Company;
	public int Bonus;
	public ProjectManager(String company, int bonus) {
		super();
		Company = company;
		Bonus = bonus;
	}
	public String getCompany() {
		return Company;
	}
	public void setCompany(String company) {
		Company = company;
	}
	public int getBonus() {
		return Bonus;
	}
	public void setBonus(int bonus) {
		Bonus = bonus;
	}
	
	public void print() {
		System.out.println(this.Company+" "+this.Bonus+" ");

	}

}
