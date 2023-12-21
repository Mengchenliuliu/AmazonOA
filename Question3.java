import java.util.Arrays;

public class Question3 {

  public static void main(String[] args) {
    int[] res = findSuccessValue(new Integer[]{7,5,6}, new Integer[]{1,2,3});
    for(int num : res){
      System.out.println(num);
    }

  }
  public static int[] findSuccessValue(Integer[] num_viewers, Integer[] queries){
    if(num_viewers == null || num_viewers.length == 0 || queries == null || queries.length == 0){
      return new int[0];
    }
    int m = num_viewers.length, n = queries.length;
    Arrays.sort(num_viewers, (a, b) -> b - a);
    int[] prefixSum = new int[m + 1];
    for(int i = 0; i < m; i++){
      prefixSum[i+1] = prefixSum[i] + num_viewers[i];
    }

    int[] res = new int[n];
    for(int i = 0; i < n; i++){
      res[i] = prefixSum[queries[i]];
    }
    return res;

  }

}
