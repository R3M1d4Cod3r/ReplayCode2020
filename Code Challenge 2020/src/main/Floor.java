package main;

import java.util.ArrayList;

public class Floor {
	public int w;
	public int h;
	public ArrayList<ArrayList<Integer>> Matrix;
	public PuntoMatrice p;
	
	public Floor(int w, int h, ArrayList<String>map) {
		super();
		this.w = w;
		this.h = h;
		p=new PuntoMatrice(w,h);
		ArrayList<ArrayList<Integer>>Matrice=new ArrayList<>();
		ArrayList<Integer>Riga;
		for(int i=0;i<h;i++) {
			String linea=map.get(i);
			Riga=new ArrayList<>();
			for(int c=0;c<w;c++) {
				if(linea.toCharArray()[c]=='#')
					Riga.add(-1);
				if(linea.toCharArray()[c]=='_')
					Riga.add(1);
				if(linea.toCharArray()[c]=='M')
					Riga.add(2);
			}
			Matrice.add(Riga);
		}
		Matrix=Matrice;
	}
	
	public Floor(int w,int h) {
		super();
		this.w = w;
		this.h = h;
		p=new PuntoMatrice(w,h);
		ArrayList<ArrayList<Integer>>Matrice=new ArrayList<>();
		ArrayList<Integer>Riga;
		for(int i=0;i<h;i++) {
			Riga=new ArrayList<>();
			for(int c=0;c<w;c++)
				Riga.add(0);
			Matrice.add(Riga);
		}
		Matrix=Matrice;
		
	}
	
	public ArrayList<ArrayList<Integer>> getMatrix() {
		return Matrix;
	}
	
	public int getW() {
		return w;
	}
	public int getH() {
		return h;
	}
	public int get(int riga,int colonna) {
		return Matrix.get(riga).get(colonna);
	}
	
	public void print() {
		System.out.println("\n");
		for(int i=0;i<h;i++)
			System.out.println(this.Matrix.get(i));
		System.out.println("\n");
	}
	public boolean isAvaliable(int riga, int colonna) {
		if (this.get(riga, colonna)!=-1)
			return true;
		return false;
	}
	public boolean isDeveloper(int riga, int colonna) {
		if (this.get(riga, colonna)==1)
			return true;
		return false;
	}
	public boolean isManager(int riga, int colonna) {
		if (this.get(riga, colonna)==2)
			return true;
		return false;
	}
	public boolean isAvaliable(int index) {
		if(index>=this.w*this.h)
			return false;
		int riga=index/this.w;
		int colonna=index - riga*this.w;
		return this.isAvaliable(riga, colonna);
	}
	public boolean isDeveloper(int index) {
		if(index>=this.w*this.h)
			return false;
		int riga=index/this.w;
		int colonna=index - riga*this.w;
		return this.isDeveloper(riga, colonna);
	}
	public boolean isManager(int index) {
		if(index>=this.w*this.h)
			return false;
		int riga=index/this.w;
		int colonna=index - riga*this.w;
		return this.isManager(riga, colonna);
	}
	
	public int numeberofAvailable() {
		int ris=0;
		for(int i =0;i<this.h;i++)
			for(int j=0;j<this.w;j++)
				if(this.isAvaliable(i, j))
					ris+=1;
		return ris;
	}
	
	public class PuntoMatrice{
		int x,y,w,h,index;
		public PuntoMatrice(int w,int h) {
			super();
			x=0;
			y=0;
			index=0;
			this.w=w;
			this.h=h;			
		}
		
		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
			this.refreshindex();
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
			this.refreshindex();
		}

		public int getIndex() {
			return index;
		}

		public void setIndex(int index) {
			this.index = index;
			this.refreshXY();
		}

		public int getW() {
			return w;
		}

		public int getH() {
			return h;
		}

		public int convertToIndex(int x,int y) {
			return y*w + x;
		}
		public int[] convertToXY(int index) {
			int riga=index/this.w;
			int colonna=index - riga*this.w;
			int[] ris= new int[2];
			ris[0]=riga;
			ris[1]=colonna;
			return ris;
		}
		private void refreshindex() {
			this.index=this.y*this.w + this.x;
		}
		private void refreshXY() {
			this.y=this.index/this.w;
			this.x=this.index-this.y*this.w;
		}
		public void goToNext() {
			if(this.index==this.w*this.h-1) {
				this.index =-1;
				this.x=-1;
				this.y=-1;
				return;
			}
			if(this.x<this.w-1)
				this.x++;
			else {
				this.y++;
				this.x=0;
			}
			this.index++;
		}

	}
	
	public int getIT() {
		return this.Matrix.get(p.getY()).get(p.getX());
	}
	public void setIT(int set) {
		if(p.getIndex()<w*h-1)
			this.Matrix.get(p.getY()).set(p.getX(), set);
	}

	public void setITgoTONext(int set) {
		this.setIT(set);
		this.p.goToNext();
	}

}
