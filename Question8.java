import java.util.Stack;

public class Question8 {

  public static void main(String[] args) {
    System.out.println(erasePairs("CBCAAXA"));
    System.out.println(erasePairs("ZYXZYZY"));
    System.out.println(erasePairs("ABCBACDDAA"));
  }
  public static String erasePairs(String s) {
    if(s == null || s.length() == 0){
      return "";
    }
    int[] lastIndex = new int[256];
    int[] counts = new int[256];
    for(int i = 0; i < s.length(); i++){
      lastIndex[s.charAt(i)] = i;
      counts[s.charAt(i)]++;
    }
    Stack<Integer> stack = new Stack<>();
    boolean[] visited = new boolean[256];

    for(int i = 0; i < s.length(); i++){
      int c = s.charAt(i);
      if(counts[c] % 2 == 0 || visited[c]){
        continue;
      }
      while (!stack.isEmpty() && stack.peek() > c && lastIndex[stack.peek()] > i){
        visited[stack.pop()] = false;
      }
      stack.push(c);
      visited[c] = true;
    }
    StringBuilder sb = new StringBuilder();
    while(!stack.isEmpty()){
      sb.append((char)(stack.pop().intValue()));
    }
    return sb.reverse().toString();


  }
}
