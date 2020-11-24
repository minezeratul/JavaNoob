

import java.util.*;
import java.io.*;

public class CountKeywords {
  public static void main(String[] args){
    if (args.length != 1) {
      System.out.println("Usage: java CountKeywords fullfilename");
      System.exit(1);
    }

    String[] keywordString = {"abstract", "assert", "boolean",
        "break", "byte", "case", "catch", "char", "class", "const",
        "continue", "default", "do", "double", "else", "enum",
        "extends", "for", "final", "finally", "float", "goto",
        "if", "implements", "import", "instanceof", "int",
        "interface", "long", "native", "new", "package", "private",
        "protected", "public", "return", "short", "static",
        "strictfp", "super", "switch", "synchronized", "this",
        "throw", "throws", "transient", "try", "void", "volatile",
        "while", "true", "false", "null"};

    Set<String> keywordSet = new HashSet<>(Arrays.asList(keywordString));
    int count = 0;

  try {
    Scanner input = new Scanner(new File(args[0]));

    String text = "" ;

    while (input.hasNext()) {
      String line = input.nextLine();
      line = stripLineComments(line);
      line = stripLineStringLiterals(line);
      text += line + " " ;
    }

    text = stripParagraghComments(text);

    String[] tokens = text.split("[ \\[,()\\]]");
    for (String token: tokens) {
      if (keywordSet.contains(token))
        count++;
    }

    System.out.println("The number of keywords in the program is " + count);
  }
    catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  private static String stripLineComments(String line) {
    int index = line.indexOf("//");

    if (index < 0)
      return line;
    else
      return line.substring(0, index);
  }

  /* Strip string literals */
  private static String stripLineStringLiterals(String line) {
    int start = line.indexOf("\"");
    int end = line.indexOf("\"", start + 1);

    while (start > 0 && end > 0) {
      line = line.substring(0, start) + line.substring(end + 1);
      start = line.indexOf("\"");
      end = line.indexOf("\"");
    }

    return line;
  }

  /* Strip paragraph comments */
  private static String stripParagraghComments(String text) {
    int start = text.indexOf("/*");
    int end = text.indexOf("*/");

    while (start > 0 && end > 0) {
      text = text.substring(0, start) + text.substring(end + 2);
      start = text.indexOf("/*");
      end = text.indexOf("*/");
    }

    return text;
  }
}
