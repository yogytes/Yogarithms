package HE;


public class Parent {
	{
		System.out.println("Parent block");
	}
	static {
		System.out.println("Parent static");
	}

	Parent() {
		System.out.println("Parent constructor");
	}
	
	public static void main(String[] args) {
		Child child = new Child();
	}
	
}

class Child extends Parent {
			
	{
	
		System.out.println("Child block");
	}
	static {
		System.out.println("Child static");
	}

	Child() {
		System.out.println("Child constructor");
	}
	
	
}