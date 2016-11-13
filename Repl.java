import java.util.regex.Pattern;

public class Repl {
  static boolean pchum = false;
  public static void main(String[] args)
  {
    Pattern others = Pattern.compile("^.+?:\\ ");
    Pattern irilib = Pattern.compile("^Erelye:\\ ");
    Pattern irilia = irilib;

    if(pchum){
      others = Pattern.compile("^.+?:\\ ");
      irilia = Pattern.compile("^.AO:\\ ");
      irilib = Pattern.compile("^.AT:\\ ");
    }

    String out = "";
    for(String i : args){
      i = i.replaceAll("\n", "").replaceAll("\r", "");
      i = i.replaceAll("→", " ");
      if(irilib.matcher(i).find()){
        i = irilib.matcher(i).replaceAll("[OUTPUT: ");
        i = i + "]";
      }
      else if(irilia.matcher(i).find()){
        i = irilia.matcher(i).replaceAll("[OUTPUT: ");
        i = i + "]";
      }
      else{
        i = others.matcher(i).replaceAll("");
      }
      i = i.replaceAll("\\[OUTPUT: \\[\\*\\*", "\\[OUTPUT: ").replaceAll("\\*\\*\\]\\]", "\\]").replaceAll("\\[OUTPUT: \\[\\*", "\\[OUTPUT: \\*").replaceAll("\\]\\]", "\\]");
      out = out + "\n" + i;
    }
    System.out.println(out);
  }
}
