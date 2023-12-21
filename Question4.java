import java.util.Arrays;

public class Question4 {

  public static void main(String[] args) {
    System.out.println(getScoreDifference(new Integer[]{1,3,3}));
  }

  public static int getScoreDifference(Integer[] points){
    Arrays.sort(points, (a,b) -> b - a);
    int dif = 0;
    for(int i = 0; i < points.length; i++){
      if(i % 2 == 0){
        dif += points[i];
      }else {
        dif -= points[i];
      }
    }
    return Math.abs(dif);
  }


}
