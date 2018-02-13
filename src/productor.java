
public class productor implements Runnable {
	public void run(){
		try {
			for(int i=0;i<10;i++){
				Action("xxx"+i);
				Thread.sleep(500);//这里的休眠为的方便消费者查询
			}
		} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	}
	public void Action(String msg) throws InterruptedException {
		synchronized (Container.object) {
			while(Container.size()>0){
				System.out.println("生产者等待");
				Container.object.wait();
				/*
				在其他线程调用此对象的 notify() 方法或 notifyAll() 方法前，导致当前线程等待。其实在这里之所以使用wait()的方法是为了始终对于object所在的代码块进行操作
				这里需要注意的是synchhronized()和wait()方法的对象必须是同一个对象
				*/
			}
			Container.add(msg);
			System.out.println(Thread.currentThread().getName());
			Container.object.notifyAll();
		}
	}
}
