package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeSet;

public class main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader reader = null;
		try {
			reader= new BufferedReader(new FileReader("/home/christian/eclipse-workspace/Code Challenge 2020/src/main/a_solar.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File Not Found 404");
			System.exit(-1);
		}
		
		//Floor section
		String[] Map_value=reader.readLine().split(" ");
		int w = Integer.parseInt(Map_value[0]);
		int h = Integer.parseInt(Map_value[1]);
		ArrayList<String> Floors= new ArrayList<>();
		for(int i=0;i<h;i++)
			Floors.add(reader.readLine());
		Floor Piano=new Floor(w,h,Floors);
		Piano.print();
		
		//Developer section
		ArrayList<Developer>Developers=new ArrayList<>();
		int n=Integer.parseInt(reader.readLine());
		for(int i=0;i<n;i++) {
			String linea[] = reader.readLine().split(" ");
			TreeSet<String>skill=new TreeSet<>();
			for(int c =0; c<Integer.parseInt(linea[2]);c++)
				skill.add(linea[c+3]);
			Developers.add(new Developer(linea[0],Integer.parseInt(linea[1]),skill));
			//Developers.get(i).print();
		}
		
		
		//Project Manager Section
		ArrayList<ProjectManager>Managers=new ArrayList<>();
		int n1=Integer.parseInt(reader.readLine());
		for(int i=0;i<n1;i++) {
			String linea[] = reader.readLine().split(" ");
			Managers.add(new ProjectManager(linea[0],Integer.parseInt(linea[1])));
			//Managers.get(i).print();
		}
		
		//Disposizioni
		
		Disposition prova = new Disposition(Developers,Managers,Piano);
		prova.Do();
		
			
}
}
