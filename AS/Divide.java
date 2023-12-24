package AS;
import java.util.*;
public class Divide {

  public static void main(String[] args) {
    System.out.println(pthFactor(20,3));
    System.out.println(pthFactor(25,3));
    System.out.println(pthFactor(10, 3));
    System.out.println(pthFactor(10, 5));
  }
  //时间复杂度为logn
  public static long pthFactor(long n, int p){
    if(n < p){
      return 0;
    }
    List<Integer> list1 = new ArrayList<>();
    List<Long> list2 = new ArrayList<>();

    for(int i = 1; i <= (int)(Math.sqrt(n)); i++){
      if(n % i == 0){
        if(i * i != n){
          list2.add(n/i);
        }
        list1.add(i);
      }
      if(list1.size() == p){
        return list1.get(list1.size() - 1);
      }
    }

    if(list1.size() + list2.size() < p){
      return 0;
    }
    return list2.get(list2.size() + list1.size() - p);
  }

}
