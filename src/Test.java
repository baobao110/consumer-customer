
public class Test {
	public static void main(String[] args) {
		customer a=new customer();
		new Thread(new productor(), "生产者").start();
		new Thread(a,"消费者1").start();
		new Thread(a,"消费者2").start();
	}
}
