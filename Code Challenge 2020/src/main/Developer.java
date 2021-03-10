package main;

import java.util.TreeSet;

public class Developer {
	public String Company;
	public int Bonus;
	public TreeSet<String> Skills=new TreeSet<>();
	
	public Developer(String company, int bonus, TreeSet<String> skills) {
		super();
		Company = company;
		Bonus = bonus;
		Skills.addAll(skills);
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

	public TreeSet<String> getSkills() {
		return Skills;
	}

	public void setSkills(TreeSet<String> skills) {
		Skills = skills;
	}
	
	public void print() {
		System.out.println(this.Company+" "+this.Bonus+" ");
		Skills.stream().forEach(e->System.out.println("\t"+e));
		System.out.println("\n");

	}
	
}
