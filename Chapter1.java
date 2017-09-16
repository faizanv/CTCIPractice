import java.util.*;

public class Chapter1 {

  public static void main(String[] args) {
    int[][] input = {
      {1,2,3,4},
      {5,6,0,8},
      {9,1,2,3}
    };
    zeroMatrix(input);
  }

  // 1.8
  public static void zeroMatrix(int[][] matrix) {
    boolean[] rows = new boolean[matrix.length];
    boolean[] cols = new boolean[matrix[0].length];

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if (matrix[i][j] == 0) {
          rows[i] = true;
          cols[j] = true;
        } 
      }
    }

    for (int b = 0; b < rows.length; b++) {
      if (rows[b]) {
        for (int i = 0; i < matrix[0].length; i++) {
          matrix[b][i] = 0;
        }
      }
    }

    for (int b = 0; b < cols.length; b++) {
      if (cols[b]) {
        for (int i = 0; i < matrix.length; i++) {
          matrix[i][b] = 0;
        }
      }
    }

    for(int i=0; i<matrix.length; i++){
      for(int j=0; j< matrix[0].length; j++){
          System.out.print(matrix[i][j] + " ");
      }
      System.out.println("");
    }
  }

  // 1.6
  public static String compress(String str) {
    StringBuilder compressed = new StringBuilder();
    int consecCount = 0;
    for (int i = 0; i < str.length(); i++) {
      consecCount++;
      if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
        compressed.append(str.charAt(i));
        compressed.append(consecCount);
        consecCount = 0;
      }
    }
    return compressed.length() < str.length() ? compressed.toString() : str;
  }
  
  // 1.5
  public static boolean isOneAway(String s1, String s2) {
    if (Math.abs(s1.length() - s2.length()) > 1 || s1.equals(s2)) {
      return false;
    }
    
    if (s1.length() == s2.length()) {
      boolean foundDiff = false;
      for (int i = 0; i < s1.length(); i++) {
        if (s1.charAt(i) != s2.charAt(i)) {
          if (foundDiff) {
            return false;
          }
          foundDiff = true;
        }
      }
      return true;
    } else if (s1.length() + 1 == s2.length()) {
      return isOneInsertionOrDeletionAway(s1, s2);
    } else {
      return isOneInsertionOrDeletionAway(s2, s1);
    }
  }

  // 1.5 helper
  private static boolean isOneInsertionOrDeletionAway(String s1, String s2) {
    int index1 = 0;
    int index2 = 0;
    while (index1 < s1.length() && index2 < s2.length()) {
      if (s1.charAt(index1) != s2.charAt(index2)) {
        if (index1 != index2) {
          return false;
        } else {
          index2++;
        }
      } else {
        index1++;
        index2++;
      }
    }
    return true;
  }

  // 1.4
  public static boolean isPalindromePermutation(char[] str) {
    Map<Character, Integer> charMap = new HashMap<>();
    for (char c : str) {
      int count = charMap.containsKey(c) ? charMap.get(c) : 0;
      charMap.put(c, count + 1);
    }
    int numOdds = 0;
    for (Integer i : charMap.values()) {
      if (i % 2 != 0) numOdds++;
      if (numOdds > 1) return false;
    }
    return true;
  }
  
  // 1.3
  public static String replaceSpace(char[] str, int trueLength) {
    int numSpaces = 0;
    for (int i = 0; i < trueLength; i++) {
      if (str[i] == ' ') {
        numSpaces++;
      }
    }

    int index = trueLength + (numSpaces * 2) - 1;
    for (int i = trueLength - 1; i >= 0; i--) {
      if (str[i] == ' ') {
        str[index] = '0';
        str[index - 1] = '2';
        str[index - 2] = '%';
        index -= 3;
      } else {
        str[index] = str[i];
        index--;
      }
    }
    return String.valueOf(str);
  }
  
  // 1.2
  public static boolean isPermutation(String s1, String s2) {
    if (s1.length() != s2.length()) {
      return false;
    }
    Set<Character> charSet = new HashSet<>();
    for (char c : s1.toCharArray()) {
      charSet.add(c);
    }
    for (char c : s2.toCharArray()) {
      if (!charSet.contains(c)) {
        return false;
      }
    }
    return true;
  }
  
  // 1.1
  public static boolean isUnique(String input) {
    char[] arr = input.toCharArray();
    Set<Character> charSet = new HashSet<>();
    for (Character c : arr) {
      if (!charSet.contains(c)) {
        charSet.add(c);
      } else {
        return false;
      }
    }
    return true;
  }
}