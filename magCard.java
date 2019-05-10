import java.util.Arrays;
import java.util.Scanner;

public class magCard
{
    /**
     * @param args the command line arguments
     */
  public static int[] deal(int[] array) {
     int[] newarray = new int[array.length];

     // Deal one by one to three piles.
     int k = 0;
     // First pile is every 3 ( see the notepad.txt)
     for (int i=0; i < array.length; i += 3) { // top
       newarray[k] = array[i];
       k++;
     }

     // Deal second pile
       for (int i=1; i < array.length; i += 3) { // mid
       newarray[k] = array[i];
       k++;
     }

     // Deal third pile
       for (int i=2; i < array.length; i += 3) { // bot
       newarray[k] = array[i];
       k++;
     }

     return newarray;
 }

 public static int[] build(int[]array, int position) {
     if (position == 1) {
       // Put 1st pile in middle
       int [] newarray = new int[array.length];
       int k = 0;
       for (int i=7; i < 14; i += 1) { //top
         newarray[k] = array[i];
          k++;
       }

       for (int i=0; i < 7; i += 1) { //middle
         newarray[k] = array[i];
          k++;
       }

       for (int i=14; i < 21; i += 1) { // bottom
         newarray[k] = array[i];
          k++;
       }


       return newarray;
     }

     if (position == 2)  // put 2nd pile in middle
       return array; // don't need to do anything b/C 2ND IS ALREADY zhong

     if (position == 3) {
       // move
       int [] newarray = new int[array.length];
       int k = 0;

       for (int i=0; i < 7; i += 1) { // shang
         newarray[k] = array[i];
          k++;
       }
        for (int i=14; i < 21; i += 1) { // zhong
         newarray[k] = array[i];
          k++;
       }

         for (int i=7; i < 14; i += 1) { // xia
         newarray[k] = array[i];
          k++;
       }
       return newarray;
     }
    
     return new int[10]; // compiler complains if you don't return
 }

 public static void get11(int[] arr) { // get the 11th card. which is 10 because we count at ling
     System.out.println("Your card is the number: " + arr[10] + " !!!!!!");
 }

 public static void print3piles(int[] arr) {
     // print the 3 piles
     for (int row=0; row < 3; row++) {
       for (int i = 0; i < 7; i++) {

         System.out.print(arr[row*7 + i] + " ");
       }
       System.out.println();
       System.out.println("------------------------------");
     }

 }


 public static void main(String[] args)
 {
         int[] cards = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21};

         Scanner input = new Scanner(System.in);

         // Do the card trick thre times
         for (int i = 0; i < 3; i++) {

           print3piles(cards);
          
           int pile_number = 1;
           do {
             System.out.println("Which pile 1/2/3");
             pile_number = input.nextInt();
             input.nextLine();
           } while (pile_number != 1 && pile_number != 2 && pile_number != 3);

           // Build the card again, and then deal it
           cards = build(cards, pile_number);
           cards = deal(cards);

         }
         // Guess their card
         get11(cards);
 }
   
  

   
}


