package thread;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceDemo {
  
  public static class TestThread extends Thread {
    
    public void run() {  
      System.out.println("Child" + this.getName() + " starts.");  
      try {  
        // ���߳���������  
        Thread.sleep(new Random().nextInt(13) * 100);  
      }  
      catch (InterruptedException e) {  
        e.printStackTrace();  
      }
      
      System.out.println("Child" + this.getName() + " ends.");
    }
  }

  public static void main(String[] args) {
    long start = System.currentTimeMillis();
    
    // ����һ��ͬʱ���������̲߳���ִ�е��̳߳�
    ExecutorService executor = Executors.newFixedThreadPool(2);
    for(int i = 0; i < 5; i++) {
        Thread thread = new TestThread();
        executor.execute(thread);
    }
    executor.shutdown();
    
    try {
        // awaitTermination����false����ʱ�����ѭ��������true���̳߳��е��߳�ִ��������߳�����ѭ������ִ�У�ÿ��10��ѭ��һ��
        while (!executor.awaitTermination(10, TimeUnit.SECONDS));
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    
    long end = System.currentTimeMillis();
    System.out.println("MainTread spent��" + (end - start));
  }

}
