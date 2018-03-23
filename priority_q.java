class priority_q 
{
	 static class node					//each node of priority queue
	 {
		 int key;	
		 int u;
		 int v;
	 }
	 node q[];						//defining the priority queue
	 int heapsize;						//indicates size of the heap
	 public priority_q()					//constructor to initialize members of class
	 {
		 heapsize=0;								
		 q= new node[500];
		 for(int i=0 ; i<500; i++)
			 q[i]= null;				//initially all elements of queue is null
	 }
	 public int[] delete_min(priority_q Q)			//method to delete minimum value from the heap
	 {
		 node min= Q.q[1];				//minimum value is stored at index 1
		 Q.q[1]= Q.q[heapsize];				//replace index 1 by last element of heap
		 //Q.q[heapsize]= null;
		 Q.heapsize--;					//reducing heap size by 1
		 Q.heapify(Q, 1);				//calling heapify at index 1 as replacing must have violated heap property
		 int arr[]= new int[3];
		 arr[0]= min.key;
		 arr[1]= min.u;
		 arr[2]= min.v;
		 return arr;					//returning minimum value of the heap
	 }
	 public void heapify(priority_q Q, int i)		//method to restore heap property at particular index i
	 {
		 node left= Q.q[2*i];				//value of left child of current node
		 node right= Q.q[(2*i)+1];			//value of right child of current node
		 node d= Q.q[i];
		 if(2*i<= Q.heapsize && ((2*i)+1)<= Q.heapsize)	//if the node has both children
		 {
			 if(left.key<= d.key && left.key<= right.key)	//if left child is smallest
			 {
				 Q.q[2*i]= d;			//replacing left child with current node
				 Q.q[i]= left;
				 Q.heapify(Q, 2*i);		//calling heapify on left child
			 }
		 	else if(right.key<= d.key && right.key<= left.key)//if right child is smallest
			 {
				 Q.q[(2*i)+1]= d;		//replacing right child with current node
				 Q.q[i]= right;
				 Q.heapify(Q, (2*i)+1);		//calling heapify on right child
			 }
		 }
		 if(2*i<= Q.heapsize && ((2*i)+1)> Q.heapsize)//if the node has only left child
		 {
			 if(left.key<= d.key)			//if key of left child is less than the parent key 
			 {
				 Q.q[2*i]= d;			//replacing left child with current node
				 Q.q[i]= left;
				 Q.heapify(Q, 2*i);		//calling heapify on left child
			 }
		}
	 }
	 public void insert(priority_q Q, int key, int i, int j)//method to insert new node in heap
	 {
		 Q.heapsize++;					//increasing size of heap
		 q[Q.heapsize]= new node();			//creating new node
		 q[Q.heapsize].key= 9999;			//assigning a large value to new node
		 q[Q.heapsize].u= i;				//initialising the source and destination of the node 
		 q[Q.heapsize].v= j;
		 Q.decrease_key(Q, heapsize, key);		//decreasing the value of new node to the required node to be added
	 }
	 public void decrease_key(priority_q Q, int i, int key)//method to decrease the key of 'i'th node with the new key
	 {									
		 if(key>= Q.q[i].key)				//if new key is greater no action has to be done
			 return;
		 Q.q[i].key= key; 				//replacing the old key with new key
		 while(i>1 && Q.q[i/2].key>Q.q[i].key)		//moving up the parent node until property of heap is violated
		 {
			 int p= i/2;				//calculating parent index
			 node temp= Q.q[p];			//exchanging parent with child 
			 Q.q[p]= Q.q[i];
			 Q.q[i]= temp;
			 i=p;					//checking the haep property for parent
		 }
	 }
	 public void display(priority_q Q)			//method to display the priority queue
	 {
		 System.out.println();
		 for(int i= 1; i<= Q.heapsize; i++)		//iterating over all nodes
			 System.out.print(Q.q[i].key+ "  ");	//printing key of the node
		 System.out.println();
	 }
}
