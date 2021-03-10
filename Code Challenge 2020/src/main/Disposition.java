package main;

import java.util.ArrayList;

public class Disposition {
    ArrayList<Developer>Developers=new ArrayList<>();
	ArrayList<Integer>mark_developers=new ArrayList<>();
	
	ArrayList<ProjectManager>Managers=new ArrayList<>();
	ArrayList<Integer>mark_managers=new ArrayList<>();
	
	Floor piano,Soluzione;
	ArrayList<Integer>piano_solution=new ArrayList<>();

	int n_posti;
	
	int n_availableposti;
	
	public Disposition(ArrayList<Developer> developers, ArrayList<ProjectManager> managers,Floor piano) {
		super();
		this.Developers.addAll(developers);
		for(int i=0;i<developers.size();i++)
			this.mark_developers.add(0);
		
		this.Managers.addAll(managers);
		for(int i=0;i<managers.size();i++)
			this.mark_managers.add(0);
		
		this.piano=piano;
		this.n_availableposti=piano.numeberofAvailable();
		for(int i=0;i<this.n_availableposti;i++)
			this.piano_solution.add(-1);
		
		this.n_posti =piano.h*piano.w;
		
		this.Soluzione=new Floor(piano.w,piano.h);
		
		//this.n_availableposti=piano.numeberofAvailable();
	}
	
	private void Do(int pos,int i_d,int i_m) {
		int i;
		if(pos>=this.n_posti) {
			this.printSolution();
			return;
		}
		//System.out.println("prova"+pos);

		//for(i=0;i<this.n_posti;i++)
		if(piano.isAvaliable(pos)) {
			//int i_d=i%this.mark_developers.size();
			
			//Disponi Developer
			if(piano.isDeveloper(pos))
				for(i=0;i<i_d;i++)
					if(this.mark_developers.get(i)==0) {
						this.mark_developers.set(i, 1);
						//piano_solution.set(pos, i_d);
						Soluzione.setITgoTONext(i);
						this.Do(pos+1,i_d,i_m);
						this.mark_developers.set(i, 0);
					}
			
			//int i_m=i%this.mark_managers.size();
			//Disponi Manager
			if(piano.isManager(pos))
				for(i=0;i<i_m;i++)
					if(this.mark_managers.get(i)==0) {
						this.mark_managers.set(i, 1);
						//piano_solution.set(pos, i_m);
						Soluzione.setITgoTONext(i);
						this.Do(pos+1,i_d,i_m);
						this.mark_managers.set(i, 0);
					}	
			}
		
		else {
			Soluzione.setITgoTONext(-1);
			this.Do(pos+1,i_d,i_m);
		}
		
		//return;
				
	}
	
	public void Do() {
		System.out.println("Inizio Disposizione");
		System.out.println("N posti "+ this.n_posti);
		System.out.println("Mark Manager "+ this.mark_managers+" size: " + this.mark_managers.size());
		System.out.println("Mark Developers "+ this.mark_developers+" size: " + this.mark_developers.size());




		this.Do(0,this.mark_developers.size(),this.mark_managers.size());
	}
	
	public void printSolution() {
		System.out.println("\n");
		
		for(int c=0;c<this.piano.h;c++) {
			String s=new String();
			for(int j=0;j<this.piano.w;j++) {
				if(this.piano.isDeveloper(c, j))
					s+=(" D"+Soluzione.Matrix.get(c).get(j));
				else if(this.piano.isManager(c, j))
					s+=(" M"+Soluzione.Matrix.get(c).get(j));
				else
					s+=" N ";
			}
			System.out.println(s);
		}
		
	}
	
}
