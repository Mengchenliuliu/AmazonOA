import java.util.Arrays;

public class Question16 {

  public static void main(String[] args) {
    System.out.println(countMaxNumTeams(new int[]{3, 4, 3, 1, 6, 5}, 3, 2));
  }
  public static int countMaxNumTeams(int[] skill, int teamSize, int maxDiff) {
    if(skill == null || skill.length == 0){
      return 0;
    }
    Arrays.sort(skill);
    int count = 0, index = 0;
    while(index + teamSize - 1 < skill.length){
      if(skill[index + teamSize - 1] - skill[index] <= maxDiff){
        count++;
        index += teamSize;
      }else {
        index++;
      }
    }
    return count;
  }

}
