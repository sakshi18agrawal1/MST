
import java.io.BufferedReader;									//importing required libraries
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

class find 										//top-level program to take input and generate MST using both algorithms
{
	public static void main(String args[])throws IOException				//main method
	{											//creating instance of the input txt file
		File file= new File("C:\\Users\\sakshi agrawal\\Desktop\\2017EET2291(assign)\\SFCT_A3\\input_graph2.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String s=br.readLine();								//reading one line from the input file
		int v;
		String str[]= s.split(" ");							//splitting the line in individual costs 
		v= str.length;									//number of vertices is equal to number of cost in one line
		int a[][]= new int[v+1][v+1];							//creating adjacency matrix for the input graph
		for(int i=1; i<=v ; i++)
		{
			str= s.split(" ");							//reading entire file and storing individual cost in the matrxix
			for(int j= 1; j<=v ;j++)
			a[i][j]= Integer.parseInt(str[j-1]);
			s= br.readLine();
		}
		
		//int v=6;
		//int a[][]= {{0,0,0,0,0,0,0},{0,0,6,1,5,-1,-1},{0,6,0,5,-1,3,-1},{0,1,5,0,5,6,4},{0,5,-1,5,0,-1,2},{0,-1,3,6,-1,0,6},{0,-1,-1,4,2,6,0}};
		//int v;=5;
		//int a[][]= {{0,0,0,0,0,0},{0,0,3,5,1,-1},{0,3,0,-1,-1,2},{0,5,-1,0,3,7},{0,1,-1,3,0,6},{0,-1,4,7,6,0}};
		
		prim pobj= new prim();								//creating object of prim class
		graph G= new graph(v, a);							//instance of input graph
		
		double starttime= System.nanoTime();						//start time of prim's algorithm
		graph G2= pobj.getPrim(G);							//calling prim's algorithm on input graph
		double duration= System.nanoTime()- starttime;					//calculating execution time of prim's algorithm
		
		System.out.println("Prim's algorithm MST (total cost: "+ pobj.primcost+"; runtime: "+ duration+"ns)");
		
		G2.display(G2);									//displaying MST calculated using prim's algorithm 
		
		kruskal kobj= new kruskal();							//creating object of kruskal class
		starttime= System.currentTimeMillis();						//start time of kruskal's algorithm
		G2= kobj.getKruskal(G);								//calling kruskal's algorithm on input graph
		duration= System.currentTimeMillis()- starttime;				//calculating execution time of kruskal's algorithm
		
		System.out.println("\n\nKruskal's algorithm MST (total cost: "+ kobj.kruscost+"; runtime: "+ duration+"ms)");
		
		G2.display(G2);									//displaying MST calculated using kruskal's algorithm
		br.close();									//closing input file								
	}
}
