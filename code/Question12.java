package code;

import java.util.HashSet;

import java.util.*;
public class Question12 {

  public static void main(String[] args) {
    System.out.println(calculateScore("GoodProductButScrapAfterWash", new String[]{"crap", "odpro"}));
  }

  public static int calculateScore(String review, String[] prohibitedWords) {
    String fixReview = review.toLowerCase();
    int minLen = Integer.MAX_VALUE, maxLen = 0;
    int n = review.length();
    Set<String> set = new HashSet<>();
    for(String word : prohibitedWords){
      set.add(word.toLowerCase());
      minLen = Math.min(minLen, word.length());
      maxLen = Math.max(maxLen, word.length());
    }
    int res = 0;
    int preIndex = 0;
    for(int i = 0; i <= n - minLen; i++){
      for(int j = i + minLen; j <= i + maxLen && j < n; j++){
        if(set.contains(fixReview.substring(i, j))){
          res = Math.max(res, j - preIndex - 1);
          preIndex = i + 1;
          break;
        }
      }
    }
    return res;


  }

}
