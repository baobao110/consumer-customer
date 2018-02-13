import java.util.LinkedList;


public class Container {
	private static final LinkedList<String> a=new LinkedList<String>();
	public  static final Object object=new Object();
	public static void add(String msg){
		a.addLast(msg);
	}
	public static String get(){
		return a.removeFirst();
	}
	public static int size(){
		return a.size();
	}
}
