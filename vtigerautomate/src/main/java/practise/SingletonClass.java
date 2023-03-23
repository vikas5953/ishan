package practise;

public class SingletonClass {
	public static SingletonClass isobj=null;
	public static SingletonClass isobj1=null;

	
	private SingletonClass(){
		
	}
    public static SingletonClass  getobj() {
    	if(isobj==null) {
    		isobj=new SingletonClass();
    	}else if(isobj1==null) {
    		isobj1= new SingletonClass();
    	}
    	return isobj;
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
 class abc{
	 public static void main(String[] args) {
		System.out.println(SingletonClass.getobj());
		System.out.println(SingletonClass.getobj());
		System.out.println(SingletonClass.getobj());


	}
	 
 }
	
