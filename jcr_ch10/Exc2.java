class Exc2{
	public static void main(String args[]){
		int d, a;

		try{//monitor a block of code.
			d = 0;
			a = 42/d;
			System.out.println("This will not be printed.");
		}
		catch(ArithmeticException e){
			System.out.println("Division by zero lol.");
		}
		System.out.println("After catch statement.");
	}
}