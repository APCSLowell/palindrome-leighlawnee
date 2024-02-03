import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class PalindromeChecker {
public void tester()
{
  //String lines[] = loadStrings("palindromes.txt");
  String[] lines = new String[6]; 
    try{
        File myFile = new File("palindromes.txt");
        Scanner myReader = new Scanner(myFile);
        int counter = 0;
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            lines[counter] = data;
            counter++;
        }
        myReader.close();
    }
    catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
    }
  System.out.println("there are " + lines.length + " lines");
  for (int i=0; i < lines.length; i++) 
  {
    if(palindrome(lines[i])==true)
    {
      System.out.println(lines[i] + " IS a palindrome.");
    }
    else
    {
      System.out.println(lines[i] + " is NOT a palindrome.");
    }
  }
}
public boolean palindrome(String word)
{
  String ton= onlyChars(noSpaces(word.toLowerCase()));
  return (ton.equals(reverseW(ton)));
}
public String onlyChars(String str3) {
  String str = new String();
  for (int i = 0; i<str3.length(); i++) {
    if (Character.isLetter(str3.charAt(i)))
      str = str + str3.substring(i,i+1);
  }
  return str;
}

public String noSpaces(String str2){
String str = "";

  for (int i = 0; i < str2.length(); i++) {
    if (!str2.substring(i, i + 1).equals(" ")) {
      str = str + str2.substring(i, i + 1);
    }
  }
  return str;
}



public String reverseW(String str) {
  String sNew = new String();
  for (int i = str.length(); i > 0; i--) {
    sNew += str.substring(i-1,i);
  }
  return sNew;
}
}
