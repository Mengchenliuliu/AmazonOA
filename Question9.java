import java.util.Arrays;
import java.util.Comparator;

public class Question9 {

  public static void main(String[] args) {
    System.out.println(getMaxRewardPoints(new int[]{5,2,2,3,1}));
    System.out.println(getMaxRewardPoints(new int[]{5,5,5}));

  }
  public static long getMaxRewardPoints(int[] reward) {
    long res = 0;
    int count = 0;
    if(reward == null || reward.length == 0){
      return res;
    }
    Arrays.sort(reward);
    int n = reward.length;
    for(int i = n - 1; i >= 0; i--){
      if(reward[i] - count <= 0){
        break;
      }
      res += reward[i] - count;
      count++;
    }
    return res;

  }
}
