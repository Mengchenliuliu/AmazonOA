package AS;

import java.util.Arrays;

public class Knapsack {

  public static void main(String[] args) {
    System.out.println(maxSubjectsNumber(new int[]{24,27,0}, new int[]{51,52,100}, 100));
  }

  public static int maxSubjectsNumber(int[] answered, int[] needed, int q){
    if(answered == null || answered.length == 0 || needed == null || needed.length == 0){
      return 0;
    }
    int n = answered.length;
    int[] difArray = new int[n];
    for(int i = 0; i < n; i++){
      difArray[i] = Math.max(0, needed[i] - answered[i]);
    }
    Arrays.sort(difArray);
    int index = 0;
    while(q >= 0 && index < n){
      if(q >= difArray[index]){
        q -= difArray[index];
        index++;
      }else {
        break;
      }
    }
    return index;
  }

}
