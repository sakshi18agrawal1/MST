class kruskal									//class to implement kruskal's algorithm
{
	public int kruscost=0;								//total cost of MST calculated using kruskal's algorithm
	public graph getKruskal(graph G)						//method to get MST using kruskal algorithm
	{
		int a[][]= new int[G.v+1][G.v+1]; 					//adjacency matrix for MST
		graph G2= new graph(G.v, a);						//graph instance of MST
		priority_q Q= new priority_q();						//instance of priority queue
		mfset m= new mfset();							//instance of mfset
		int next=0;							
		for(int i=1; i<=G.v; i++)						//iterating over all vertices
		{
			next= next+1;									
			m.initial(m, next, i);						//adding all vertices to mfset with unique set value
		}
		for(int i=1; i<= G.v; i++)						//iterating over all edges
		{
			for(int j=i+1; j<= G.v; j++)			
			{
				if(G.adj[i][j]!=0 && G.adj[i][j]!= 999)			//if there exists an edge then add the edge to the queue
				Q.insert(Q, G.adj[i][j],i,j);
			}
		}
		int n=G.v;
		while(n>1)								//repeat till all vertices are added to MST
		{
			int e[]= Q.delete_min(Q);					//delete minimum edge from queue
			
			int uc= m.find(m, e[1]);					//get set value for source vertex
			int vc= m.find(m, e[2]);					//get set value for destination vertex
			if(uc!= vc)							//if source and destination are in different set
			{
				m.merge(m, uc, vc);					//then merge the two sets
				G2.addEdge(G2, e[1], e[2], e[0]);			//add the above edge in MST
				n= n-1;
				kruscost+=e[0];						//adding cost of the newly added edge to get total cost of kruskal's algorithm
			}
		}
		return G2;								//returning MST calculated using kruskal's algorithm
	}
}
