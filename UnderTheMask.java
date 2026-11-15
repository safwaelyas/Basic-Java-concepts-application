

import java.util.*;
public class UnderTheMask
{
   public static void main(String[]args)
   {
      Scanner user= new Scanner(System.in); //use scanner for the input.
   //declaration section:
      String pin="";//new section added(intialize the variables outside the case1.
      String originalKey="";
      String codeKey="";
      String checkPin="";
      String sentence="";
      String tempSentence="";
      char ch,ch3;
      char selection;
      boolean validPin=false;//new section added(new booleans)
      boolean keyExist=false;
      boolean validKey=true;
      boolean pinMatch=false;
      boolean sentenceExist=false;
      int len1,len2;
   // do-while loop to validate the user pin according to the restrictions.
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
   
      do {
         System.out.printf("What you would like to do?, choose one of the below choices: %n");
         System.out.println();
         System.out.printf("1-Set\\change the key: choose '1'%n");
         System.out.printf("2-Display The key: choose '2'%n");
         System.out.printf("3-Enter a sentence: choose'3'%n");
         System.out.printf("4-Display the current sentence:choose '4' %n");
         System.out.printf("5-Encrypt the sentence and display it: choose '5' %n");
         System.out.printf("6-Decrypt the sentence and display it: choose '6' %n");
         System.out.printf("7-Exit the system:choose 'x' %n");
         System.out.println();
         selection=user.next().charAt(0);
         if (selection =='x'||selection=='X'){
            System.out.println("Good Bye, have a nice day");//(farewall message)
            break;}
         switch(selection)
         {
            case '1':
               do{
                  System.out.print("Enter your PIN: ");//(check the pin)
                  checkPin=user.next();
                  user.nextLine();
                  pinMatch=true;
                  if (!(checkPin.equals(pin))){
                     System.out.println("PIN doesn't match, please try Again: ");
                     pinMatch=false;
                     break;}
                  if(pinMatch){
                     System.out.println("Correct pin");
                  }
               }while(!pinMatch);
               if (!pinMatch)
                  break;
               else{
                  do{ // do-while loop to validate the key entered by the user, if invalid control goes back to the menu.
                    validKey=true; 
                     System.out.printf("Enter the original part of the key: ");
                     originalKey=user.nextLine();
                     len1=originalKey.length();
                        
                     System.out.printf("Enter the code part of the key, (make sure original and code have the same length): ");
                     System.out.println();
                     codeKey=user.nextLine();
                     len2=codeKey.length();
                     
                  
                     if (len1!=len2){ //case 1: missmtched length
                        System.out.printf("invalid key, the should be the same length.%n");
                        validKey=false;
                        break;}
                   for (int i = 0; i < len1; i++) { //case 3: missing characters in the codeKey
                        if (codeKey.indexOf(originalKey.charAt(i)) == -1) {
                           System.out.println("Invalid key: characters must match in different order.");
                           System.out.println();
                           validKey = false;
                           break;  
                        }
                     }
                     if (!validKey) //for any invalid entry control goes back to the menu
                        break;
                     if (validKey){ //this to ensure that keyExists after validating the user input,and for the other switches to be accessible.
                        System.out.println("Valid Key");
                        System.out.println();
                        keyExist=true;
                        break;}
                  }while (!validKey);
                  break;}
            case '2':// display the two parts of the key after checking the correct pin
               if (keyExist){
                     System.out.print("Enter your PIN: ");
                     checkPin=user.next();
                     pinMatch=true;
                     if (!(checkPin.equals(pin))){
                        System.out.println("PIN doesn't match, please try Again: ");
                        pinMatch=false;}
                     else
                        System.out.printf("The original part of your key: %s%nThe code part of your key: %s%n%n",originalKey,codeKey);
                     } 
               else 
                  System.out.println("Sorry, You haven't set a key yet");
               break;
            case '3': //sentence to be entered by the user,(no restrictions).
               System.out.println("Enter the sentence below: ");
               user.nextLine();
               sentence=user.nextLine();
               sentenceExist=true;
               break;
            case '4'://display the value assigned with variable sentence could changed by the user
               if(sentenceExist)
                  System.out.println(sentence);
               else
                  System.out.println("you have not entered a sentence yet");
               break;
            case '5'://increpting the sentence by the code key if it exist
               if(keyExist && sentenceExist){
                  tempSentence="";
                  len1=sentence.length();
                  for(int i=0;i<len1;i++){
                     ch3=sentence.charAt(i);
                     int place =originalKey.indexOf(ch3);
                     if (place>-1)
                        tempSentence +=codeKey.charAt(place);
                     else
                        tempSentence +=ch3;
                  }
                  sentence = tempSentence;
                  System.out.println(sentence);
                  break;                        
               }
               else{
                  System.out.println("You haven't set a key or a sentence yet");
                  break;}
            
            case '6'://decrepting the sentence by the original key if it exist
               if(keyExist && sentenceExist){
                  tempSentence="";
                  len1=sentence.length();
                  for(int i=0;i<len1;i++){
                     ch3=sentence.charAt(i);
                     int place =codeKey.indexOf(ch3);
                     if (place>-1)
                        tempSentence +=originalKey.charAt(place);
                           
                     else{
                        tempSentence +=ch3;
                     }
                  }
                  sentence = tempSentence;
                  System.out.println(sentence);
                  break;
               }
               else{
                  System.out.println("Sorry, You haven't set a key or a sentence yet");
                  break;}
            default://a massege will come of if the user entered other value
               System.out.println("invalid selection, choose from the menu: ");
               continue;
         }
      }while (selection!='x' && selection!='X' );
   
   }
}


