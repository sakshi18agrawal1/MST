class mfset							//class mfset to implement mfset
{
	int c[];							//array of mfset that stores the set in which the particular element belongs
	public mfset()							//constructor for mfset class							
	 {
		 c= new int[100];
	 }
	public void merge(mfset m, int a, int b)			//method to merger two sets together
	{
		for(int i=1; i<100; i++)				//iterating over the array of mfset
		{
			if(m.c[i]==b)
				m.c[i]=a;				//replacing all occurrences of 2nd set by 1st set  
		}
	}
	public int find(mfset m,int x)					//method to find out the set of any element
	{
		return m.c[x];						//returning the set of given element 'x'
	}
	public void initial(mfset m, int a, int x)			//method to add a particular element 'x' in the set 'a'
	{
		m.c[x]=a;						//adding element x in set a
	}
	public void display(mfset m)					//method to display the mfset
	{
		System.out.println();
		for(int i=1; i<=c.length; i++)				//iterating over the the array of mfset
			System.out.print(m.c[i]+ "  ");			//printing the set of mfset
	}
}
