public class Question1 {

  public static void main(String[] args) {
    System.out.println(countNumWays("ababa", 2));
  }
  public static int countNumWays(String s, int k){
    if(s == null || s.length() == 0){
      return 0;
    }
    int count = 0;
    for(int i = 0; i <= s.length() - k; i++){
      int left = i, right = i + k - 1;
      while(left < right){
        if(s.charAt(left) != s.charAt(right)){
          if(s.charAt(left) > s.charAt(right)){
            count++;
          }
          break;
        }else {
          left++;
          right--;
        }
      }
    }
    return count;
  }
}
