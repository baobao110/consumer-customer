
public class customer implements Runnable  {
	public void run() {
			try {
				while(true){
					Action();//������ֻ��Ҫ����һֱ�Ĳ�ѯ
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	public void Action() throws InterruptedException {
		synchronized (Container.object) {
			while(Container.size()<=0){
				System.out.println("�����ߵȴ�");
				Container.object.wait();
			}
			System.out.println(Thread.currentThread().getName()+Container.get());
			Container.object.notifyAll();
		}
	}
}
