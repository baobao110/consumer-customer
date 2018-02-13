
public class customer implements Runnable  {
	public void run() {
			try {
				while(true){
					Action();//消费者只需要负责一直的查询
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	public void Action() throws InterruptedException {
		synchronized (Container.object) {
			while(Container.size()<=0){
				System.out.println("消费者等待");
				Container.object.wait();
			}
			System.out.println(Thread.currentThread().getName()+Container.get());
			Container.object.notifyAll();
		}
	}
}
