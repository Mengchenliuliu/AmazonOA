package AS;

import java.util.Arrays;

public class AS3 {

  public static void main(String[] args) {
    System.out.println(maximumFinal(new int[]{1,3,2,2}));
    System.out.println(maximumFinal(new int[]{3,2,3,5}));
    System.out.println(maximumFinal(new int[]{3,1,3,4}));
  }
  public static int maximumFinal(int[] arr){
    if(arr == null || arr.length == 0){
      return 0;
    }
    Arrays.sort(arr);
    arr[0] = 1;
    for(int i = 1; i < arr.length; i++){
      if(arr[i] >= arr[i-1] + 1){
        arr[i] = arr[i-1] + 1;
      }
    }
    return arr[arr.length - 1];
  }

}
