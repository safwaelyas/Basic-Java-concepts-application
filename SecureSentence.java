



public class SecureSentence////the class contain the methods for seting a sentence and its Key and encrept/decrebt of the sentenses
{
////attributes
   private String sentence;
   private Key keyUsed;
   private boolean encrypted;

   public SecureSentence(){////defult constructer
      sentence="";
      keyUsed=null;
      encrypted=false;}
     
   public void setSentence(String s){
      sentence=s;
      keyUsed=null;
      encrypted=false;}
   public void setSentence(String s, Key key){//before calling this method I should verify that a key has been set.
      sentence=s;
      keyUsed=key;
      encrypted=true;} 
      ////get/set methods
  public String getsentence(){
 return sentence;
 }
 public void setkeyUsed(Key key){
 keyUsed=key;}
 public Key getkeyUsed(){
 return keyUsed;}
 
 
 
   public void encrypt(Key key){
      if (!encrypted && key.getIsSet()) //encryption of a sentence.
      { String tempSentence=""; 
         int len=sentence.length();
         for(int i=0;i<len;i++){
            char ch3=sentence.charAt(i);
            int place =key.getOriginal().indexOf(ch3);
            if (place>-1)
               tempSentence +=key.getCode().charAt(place);
            else
               tempSentence +=ch3;}
         sentence=tempSentence;
         encrypted=true;}                 
      else if (encrypted)//display a massege if the sentence is  Encrypted alraedy or did not set the key yet.
         System.out.println("The Sentence is already Encrypted");
      else
         System.out.println("The key you choose hasn't been set it current yet");
   }
  
   public void decrypt(){//decrypting the sentence if it encrypted first
      if (encrypted){
         String tempSentence=""; 
         int len=sentence.length();
         for(int i=0;i<len;i++){
            char ch3=sentence.charAt(i);
            int place =this.getkeyUsed().getCode().indexOf(ch3);
            if (place>-1)
               tempSentence +=this.getkeyUsed().getOriginal().charAt(place);
            else
               tempSentence +=ch3;
         }
         sentence = tempSentence;
         encrypted=false;
      }
      else
         System.out.println("The Sentence is Not encrypted yet or you haven't set it yet");}
  
  
   public void displayMe(){///a method to display objects and the current sentence.
      System.out.println("Your sentence: "+sentence);
      if (keyUsed==null)
      System.out.println("Key used: null");
      else
      System.out.println("Key Used: number "+keyUsed.getID());
      System.out.println("Status: "+((encrypted)?"encrypted":"not encrypted"));}
  
   public boolean isEncrypted(){
      if (encrypted)
         return true;
      else
         return false;}
}