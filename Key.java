




public class Key {////the class contain a methods to set and display the tow parts of the Keys.
   public static int numKeys;
   private int ID;
   private String original;
   private String code;
   private boolean isSet;

   public Key (){////defulte constructure.
      ID=++numKeys;
      original = "";
      code = "";
      isSet = false;
   } 
////get/set methods:
   public boolean getIsSet(){
      return isSet;}
   public String getOriginal(){
      return original;}

   public String getCode(){
      return code;}
   public int getID(){
      return ID;}

   public boolean setKey(String o, String c){
      original =o;
      code = c;
      if (validKey(o, c)) {
         isSet = true;
         return true;
      } else {
         original = "";
         code = "";
         isSet = false;
         return false;
      }
   }
   private boolean validKey(String o, String c) {
    // case 1: mismatch in length
      if (o.length() != c.length()) {
         System.out.printf("Invalid key, both parts should have the same length.%n");
         return false;
      }
   
    // case 2: missing characters in the codeKey
      for (int i = 0; i < o.length(); i++) {
         if (c.indexOf(o.charAt(i)) == -1) {
            System.out.println("Invalid key: characters must be in the original and code parts.");
            System.out.println();
            return false;
         }
      }
      return true;
   }
   public void displayMe(){////to display the Keys and their parts
      System.out.println("+-------+");
      System.out.printf("| Key#%d |\n",ID);
      if(isSet){
         System.out.println("|set    |");
         System.out.println("|---+---|");}
      else{
         System.out.println("|not set|");
         System.out.println("+-------+");}
      if (isSet) {
         System.out.println("| O | C |");
         System.out.println("|---+---|");
         for (int i = 0; i < original.length(); i++) {
            System.out.printf("| %c | %c |%n", original.charAt(i), code.charAt(i));
         }
         System.out.println("+-------+");
         System.out.println();
      }
   }
}

