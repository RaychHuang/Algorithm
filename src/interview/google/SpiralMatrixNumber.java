package interview.google;

public class SpiralMatrixNumber {
  
  /**
   *  ��һ�������߳�2^N �η��Ķ�ά���� ÿ�����������и� ˳������
   *  1   2
   *  0   3
   *  
   *  Ȼ����ÿ��С���� �ٴ��и�
   *  ����NΪ2���߳�Ϊ2^2�ľ��� �ͻ᳤����
   *  5   6    9  10
   *  4   7    8  11
   *  1   2   13  14
   *  0   3   12  15
   *  �ٸ���һ��(x, y)���� �������Ǹ���������Ƕ��٣�
   *  ������2^2���� (3, 3) = 15 (3, 0) = 0. 
   *  
   *  ��߳�Ϊ2^N�Ķ�λ���������Ϊ(x, y)�ĵ�����Ϊ���٣�
   *  
   *  1 <= N <= 16
   *  0 <= x <= 2^N - 1
   *  0 <= y <= 2^N - 1
   */
  
  public long calNumber(int N, int x, int y) {
    if (N == 1) {
      return getIndex(x, y, 1);
    }
    int half = 1 << (N - 1);
    int index = getIndex(x, y, half);
    return (1 << N) * index + calNumber(N - 1, x % half, y % half); 
  }
  
  private int getIndex(int x, int y, int half) {
    return x >= half ? (y >= half ? 3 : 0) : (y >= half ? 2 : 1);
  }
  

  public static void main(String[] args) {
    int N = 2;
    int x = 3;
    int y = 3;
    SpiralMatrixNumber one = new SpiralMatrixNumber();
    System.out.println(one.calNumber(N, x, y));
  }

}
