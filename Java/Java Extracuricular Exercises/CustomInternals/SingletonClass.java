package CustomInternals;

public class SingletonClass{
	private static SingletonClass instance;

	private SingletonClass(){} // private constructor

	public static SingletonClass getInstance(){
		if (instance == null)
			synchronized (SingletonClass.class){
				if (instance == null)
					instance = new SingletonClass();
			}
		return instance;
	}
}