package thread;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
  
  public static class TestThread extends Thread {
    
    private CountDownLatch countDownLatch;  
    
    public TestThread(CountDownLatch countDownLatch) {  
      this.countDownLatch = countDownLatch;  
    }  
    
    public void run() {  
      System.out.println("Child" + this.getName() + " starts.");  
      try {  
        // ���߳���������  
        Thread.sleep(new Random().nextInt(13) * 100);  
      }  
      catch (InterruptedException e) {  
        e.printStackTrace();  
      } finally {
        //!!!!!!!!!!!!!!!!!!!!!!!! in finally!      
      // ��������1
        countDownLatch.countDown();
      }
      
      System.out.println("Child" + this.getName() + " ends.");

    }
  }

  public static void main(String[] args) {
    System.out.println("MainThread starts at: " + System.currentTimeMillis());
    
    // ����һ����ʼֵΪ5�ĵ���������
    CountDownLatch countDownLatch = new CountDownLatch(5);
    for(int i = 0; i < 5; i++) {
      Thread thread = new TestThread(countDownLatch);
      thread.start();
    }
    
    try {
      // ������ǰ�̣߳�ֱ������������������0
      countDownLatch.await();
    }
    catch (InterruptedException e) {
      e.printStackTrace();
    }
    
    System.out.println("MainThread ends at: " + System.currentTimeMillis());
  }

}
