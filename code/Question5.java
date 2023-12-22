package code;

import java.util.*;
public class Question5 {

  public static void main(String[] args) {
    List<String> list = List.of("code", "doce", "ecod", "framer", "frame");
    List<String> res = removeAnagram(list);
    for(String str : res){
      System.out.println(str);
    }

  }

  public static List<String> removeAnagram(List<String> products){
    List<String> res = new ArrayList<>();
    if(products == null || products.size() == 0){
      return  res;
    }
    Set<String> set = new HashSet<>();
    for(String str : products){
      char[] chars = str.toCharArray();
      Arrays.sort(chars);
      String newOne = new String(chars);
      if(!set.contains(newOne)){
        res.add(str);
        set.add(newOne);
      }
    }
    Collections.sort(res);
    return res;
  }

}
