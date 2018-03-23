class graph 								//class to implement graph ADT
{
	int v;									//number of vertices in the graph
	int adj[][];								//adjacency matrix of the graph
	public graph(int n, int[][]a)						//constructor for graph 
	{
		v=n;								//initialising number of vertices of graph
		adj=a;								//initialising adjacency matrix of graph
		for(int i=1; i<=v; i++)
		{
			for(int j= 1; j<= v; j++)
			{
				if(adj[i][j]==-1)				//if there is no edge between any node then replace with some large value
					adj[i][j]=9999;
			}
		}
	}
	public void addEdge(graph G, int src, int des, int w)			//method to add new edge in the graph
	{
		G.adj[src][des]= w;						//adding cost of the edge in the matrix
		G.adj[des][src]= w;
	}
	public void display(graph G)						//method to dispaly the graph
	{
		for(int i=1; i<= G.v; i++)					//searching the adjacency matrix for existing edges 
		{
			for(int j=i+1; j<= G.v; j++)
			{
				if(G.adj[i][j]!=0 &&G.adj[i][j]!=9999 )
				System.out.println("("+i+","+j+")");		//printing the source and destination of existing edge
			}
		}
	}
}
