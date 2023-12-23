package code;

import java.util.HashSet;

import java.util.*;
public class Question12 {

  public static void main(String[] args) {
    System.out.println(calculateScore("GoodProductButScrapAfterWash", List.of("crap", "odpro")));
  }

  //leetcode 2781
  public static int calculateScore(String word, List<String> forbidden) {
    Set<String> set = new HashSet<>();
    String newWord = word.toLowerCase();
    int max = 0;
    for(String s : forbidden){
      max = Math.max(max , s.length());
      set.add(s.toLowerCase());
    }
    int ans = 0;
    StringBuilder sb = new StringBuilder();
    for(int i = 0 ; i < newWord.length() ; i++){
      char ch = newWord.charAt(i);
      sb.append(ch +"");
      int len = sb.length();
      for(int j = len - 1 ; j >= Math.max(0 , len - max); j--){
        String s = sb.substring(j);
        if(set.contains(s)){
          sb.delete(0 , j + 1);
          break;

        }
      }
      ans = Math.max(sb.length() , ans);
    }
    return ans;
  }

}
