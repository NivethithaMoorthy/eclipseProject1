package transactions;

public class Test 
{
	public static void add()
	{
		System.out.println("Hi inside class");
	}

	public static void main(String[] args) 
	{
		add(); //method calling
		System.out.println("Hello inside main");
		add();
	}
}
