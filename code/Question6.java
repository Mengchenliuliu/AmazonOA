package code;

public class Question6 {

  public static void main(String[] args) {
    System.out.println(dropRequest(new int[]{1,1,1,1,2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7}));
    System.out.println(dropRequest(new int[]{1,1,1,1,2}));
  }

  public static int dropRequest(int[] requests){
    int drop = 0;
    for(int i = 0; i < requests.length; i++){
      int time = requests[i];
      if(i >= 3 && requests[i-3] == time){
        drop++;
        continue;
      }
      if(i >= 20 && requests[i - 20] + 10 > time){
        drop++;
        continue;
      }
      if(i >= 60 && requests[i - 60] + 60 > time){
        drop++;
        continue;
      }
    }
    return drop;
  }

}
