
public class Test {
	public static void main(String[] args) {
		customer a=new customer();
		new Thread(new productor(), "������").start();
		new Thread(a,"������1").start();
		new Thread(a,"������2").start();
	}
}
