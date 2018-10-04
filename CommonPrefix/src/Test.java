public class Test {
    public static void main(String []args) {
      String []strings = new String[3];
      strings[0] = "dsdssafas";
      strings[1] = "daffffsafsa";
      strings[2] = "dssfdasdsadsaddsa";

      StringBuffer s = new StringBuffer();
      int i = 0;
      while(i < strings[0].length() && i < strings[1].length() && i < strings[2].length()) {
          if(strings[0].charAt(i) == strings[1].charAt(i) && strings[0].charAt(i) == strings[2].charAt(i)) {
              s.append(strings[0].charAt(i));
              i++;
          } else {
              break;
          }
      }
      System.out.print(s);
    }
}
