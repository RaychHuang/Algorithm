# Design Pattern

- ### Singleton Pattern

  + ##### （DCL，Double-Checked Locking）
  ```java
  public class Singleton {
    
    private volatile static Singleton singleton;
    
    private Singleton (){}
      
    public static Singleton getSingleton() {  
      if (singleton == null) {  
        synchronized (Singleton.class) {  
        if (singleton == null) {  
            singleton = new Singleton();  
        }  
      }  
    }  
    return singleton;  
    }  
  }
  ```
  
  + ##### Enum
  ```java
  public enum Singleton {
    
    INSTANCE;
    
    public void whateverMethod() {  
    }  
  }
  ```
  
  
