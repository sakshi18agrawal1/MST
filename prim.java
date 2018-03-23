class prim 								//class to implement prim's algorithm	
{
	public int primcost=0;							//total cost of MST calculated using prim's algorithm
	public graph getPrim(graph G)						//method to get MST using prim algorithm
	{
		int a[][]= new int[G.v+1][G.v+1]; 				//adjacency matrix for MST
		graph G2= new graph(G.v, a);					//graph instance of MST
		int lowcost[]= new int[G.v+1];					//array storing lowest cost of any vertex to any other vertex
		int closest[]= new int[G.v+1];					//array to store closest vertex from any given vertex
		int min,i,j,k;
		for(i=2; i<=G.v; i++)						//initialising lowcost and closest of all vertices to 1st node
		{
			lowcost[i]= G.adj[1][i];
			closest[i]= 1;
		}
		for(i=2; i<=G.v; i++)						//iterating on remaining nodes to find low cost nodes
		{
			min= lowcost[2];							
			k=2;
			for(j=3; j<=G.v; j++)					//finding the vertex having minimum cost from U to V
			{
				if(lowcost[j]<min)				//if there is any edge having cost less than the current minimum then update the minimum
				{
					min= lowcost[j];
					k=j;
				}
			}	
			G2.addEdge(G2, k, closest[k], lowcost[k]);		//add the minimum edge to the MST
			primcost+= lowcost[k];					//calculating the total cost by adding currently added edge to the MST
			lowcost[k]= 99999;					//replacing lowest cost by large value so that it is not added to MST again
			for(j=2; j<= G.v; j++)					//after adding nay node to MST updating the lowcost and closest array with respect to newly added node
			{
				if(G.adj[k][j]<lowcost[j] && lowcost[j]<99999)
				{
					lowcost[j]= G.adj[k][j];		//if the cost is less than previous cost then update it
					closest[j]=k;
				}
			}
		}
		return G2;							//returning the MST calculated using prim's algorihtm
	}
}
