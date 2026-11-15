


import java.util.*;
public class mainTest{

   public static String systemPin;

   static Scanner user=new Scanner(System.in);

   public static void keynumber(int n,Key other){//method to assign original and code parts of the key based on the user choice.
      String o,c;
      user.nextLine();
      System.out.printf("Enter the original part of the key: ");
      o=user.nextLine();
      System.out.printf("Enter the code part of the key, (make sure original and code have the same length): ");
      System.out.println();
      c=user.nextLine();
      other.setKey(o,c);
      System.out.println("Valid Key");//inform user that his key is valid
   }
   
   public static Key keychoice(int n,Key key1,Key key2,Key key3){//method to return Key based on the user chose and assign it to KeyUsed attribute of the sentence.
      if (n==1)
         return key1;
      else if (n==2)
         return key2;
      else if (n==3)
         return key3;
      return key1 ;
   }
   

   public static void setPin(){//setpin method. checks conditions of the pin and save the valid entry as systempin
      String pin;
      boolean validPin;
      char ch;
      do {
         System.out.println("Enter a 4-digit PIN: ");
         pin=user.next();
         validPin=true;
         if (pin.length()!=4){ //case 1: if the length !=4
            System.out.printf("Error, PIN must be composed of 4 digits,%n");
            validPin=false;
            continue;
         }
         if (pin.substring(0,1).equals("0")){ //case2: if the first digit is 0
            System.out.printf("Error, PIN can't start with zero,%n");
            validPin=false;
            continue;
         }
         for (int i=0;i<pin.length();i++){ //case3: if the pin contains characters not digits.
            ch = pin.charAt(i);
            if (ch<'0'||ch>'9'){
               System.out.printf("Error, PIN must be composed of digits only,%n");
               validPin=false;
               break;
            }
         }
      }while (!validPin);
      if (validPin)
         systemPin=pin;
   }
      
   public static boolean pinMatches(int pin){//methid to check pin for other parts in the program
      if (pin==Integer.parseInt(systemPin))
         return true;
      else
         return false;}   
    
   public static int menu(){
      int selection;
      System.out.printf("What you would like to do? %n");
      System.out.println();
      System.out.printf("1-Set\\change the key: choose '1'%n");
      System.out.printf("2-Display all keys: choose '2'%n");
      System.out.printf("3-Select SecureSentence object: choose'3'%n");
      System.out.printf("4-Enter a sentence:choose '4' %n");
      System.out.printf("5-Display sentence: choose '5' %n");
      System.out.printf("6-Encrypt sentence and display it: choose '6' %n");
      System.out.printf("7-Decrypt sentence and display it:choose '7' %n");
      System.out.printf("8-Display all SecureSentence Objects:choose '8' %n");
      System.out.printf("9-Exit the system:choose '9' %n");
      System.out.println();
      System.out.println("Enter your choice");
      selection=user.nextInt();
      return selection;}

   public static void main(String[]atgs){
   //decleration of objects of class key
      Key key1=new Key();
      Key key2=new Key();
      Key key3=new Key();
      //decleration of objects of class securesentence
      SecureSentence sentence1= new SecureSentence();
      SecureSentence sentence2= new SecureSentence();
      SecureSentence current= new SecureSentence();
      
      boolean currentIsSet=false;
      boolean sentenceIsSet=false;
      
      int choice;
      setPin();
      do {//do-while loop to get menu choice.
         choice=menu();
         if (choice==9){
            System.out.println("Good Bye, have a nice day");//(farewall message)
            break;}
         switch (choice){
            case 1://Set\\change the key
               int checkpin;
               int keynumber;
               System.out.println("Enter your PIN");
               checkpin=user.nextInt();
               if (pinMatches(checkpin)){
                  System.out.println("Which key of the 3 possible ones you want to work on?");
                  keynumber=user.nextInt();
                  if (keynumber==1)
                     keynumber(keynumber,key1);
                    
                  else if (keynumber==2)
                     keynumber(keynumber,key2);
                     
                  else if (keynumber==3)
                     keynumber(keynumber,key3);
                    
                  else 
                     System.out.println("invalid Key number,try again");
               }
               
               else 
                  System.out.println("your PIN is not correct");
               break;
         
            case 2:  //Display all keys
              
               System.out.println("Enter your PIN");
               checkpin=user.nextInt();
               if (pinMatches(checkpin)){
                  System.out.println("Number of keys is: "+Key.numKeys);
                  key1.displayMe();
                  key2.displayMe();
                  key3.displayMe();
               }
               else 
                  System.out.println("your PIN is not correct");
               break;
            case 3: //Select SecureSentence object
               int senNum;
               System.out.print("Enter the number of the Sentence(1-2): ");
               senNum=user.nextInt();
               
               if (senNum==1){
                  current=sentence1;
                  currentIsSet=true;
                  System.out.println("Current Sentence is set.");
               }
               else if (senNum==2){
                  current=sentence2;
                  currentIsSet=true;
                  System.out.println("Current Sentence is set.");}
               else
                  System.out.print("Only 2 Sentences are available ");//out of bound error
               break;
            case 4://Enter a sentence
               String sen,answer;
               int keyid;
               if(currentIsSet){
                  System.out.print("Enter the Sentece: ");
                  user.nextLine();
                  sen=user.nextLine();
                  current.setSentence(sen);
               
                  System.out.print("Is the sentence already encrypted(yes-no): ");
                  answer=user.next();
               
                  if (answer.equalsIgnoreCase("yes")){
                     System.out.print("what is the ID of the key that is used for encryption(1-3): ");
                     keyid=user.nextInt();
                     if (keyid==1){
                         if(key1.getIsSet()){
                        current.setSentence(sen,key1);
                        System.out.print("Sentence is set successfully.\n\n ");}
                        else
                        System.out.println("Key 1 is not set,please set the key and try again.\n");}
                     else if(keyid==2){
                     if(key2.getIsSet()){
                        current.setSentence(sen,key2);
                        System.out.print("Sentence is set successfully.\n\n ");}
                        else
                        System.out.println("Key 2 is not set,,please set the key and try again.\n");}
                     else if(keyid==3){
                        if(key3.getIsSet()){
                         current.setSentence(sen,key3);
                         System.out.print("Sentence is set successfully.\n\n ");}
                        else
                        System.out.println("Key 3 is not set,,please set the key and try again.\n");}

                               
                                       }
                  sentenceIsSet=true;
               }
               else 
                  System.out.println("You didn't select a securesentence yet");
            
               break;
            
            case 5://Display sentence
               if(currentIsSet)
                  System.out.println(current.getsentence());
               else
                  System.out.println("You didn't select a securesentence yet");
            
               break;
            case 6: //Encrypt sentence and display it
               if (currentIsSet&&!current.isEncrypted()){
                  int userkey;
                  System.out.print("Enter the number of the key: ");
                  userkey=user.nextInt();
                  if (userkey>=1&&userkey<=3){
                     current.setkeyUsed(keychoice(userkey,key1,key2,key3));
                     current.encrypt(current.getkeyUsed());
                     System.out.println(current.getsentence());}
                  else//out of bound error
                     System.out.println("Key number doesn't exist");}
               
               else 
               
                  System.out.println("Sentence is not set or is already encrypted");
               
               break;     
            case 7: //Decrypt sentence and display it
               if (currentIsSet){
                  current.decrypt();
                  System.out.println(current.getsentence());
               }
               else
                  System.out.println("You didn't select a securesentence yet");
            
               break;
         
            case 8://Display all SecureSentence Objects
               System.out.println("Sentence1: ");
               sentence1.displayMe();
            
               System.out.println();
            
               System.out.println("Sentence2: ");
               sentence2.displayMe();
               System.out.println("The current sentence is: "+((current==sentence1)?"Sentence1":(current==sentence2)?"Sentence2":"current hasn't been set yet"));
               System.out.println();
               break;
            default:
               System.out.println("invalid selection, choose from the menu: ");
               continue;
         }
      
      }while(choice!=9);//Exit the system
   
   
   
   }
}