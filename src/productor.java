
public class productor implements Runnable {
	public void run(){
		try {
			for(int i=0;i<10;i++){
				Action("xxx"+i);
				Thread.sleep(500);//���������Ϊ�ķ��������߲�ѯ
			}
		} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	}
	public void Action(String msg) throws InterruptedException {
		synchronized (Container.object) {
			while(Container.size()>0){
				System.out.println("�����ߵȴ�");
				Container.object.wait();
				/*
				�������̵߳��ô˶���� notify() ������ notifyAll() ����ǰ�����µ�ǰ�̵߳ȴ�����ʵ������֮����ʹ��wait()�ķ�����Ϊ��ʼ�ն���object���ڵĴ������в���
				������Ҫע�����synchhronized()��wait()�����Ķ��������ͬһ������
				*/
			}
			Container.add(msg);
			System.out.println(Thread.currentThread().getName());
			Container.object.notifyAll();
		}
	}
}
