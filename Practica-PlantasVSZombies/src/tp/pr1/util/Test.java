package tp.pr1.util;

import java.util.Random;

public class Test {

	public static void main(String[] args) {
	
	
//       Random s = new Random(1);
//       System.out.println(s.nextInt(10));
//       for(int i = 0;i<30;i++) System.out.println(s.nextInt(10));
//        
//        Random rgen = new Random();  // Random number generator
//        int[] cards = new int[52];  
//
//        //--- Initialize the array to the ints 0-51
//        for (int i=0; i<cards.length; i++) {
//            cards[i] = i;
//        }
//
//        //--- Shuffle by exchanging each element randomly
//        for (int i=0; i<cards.length; i++) {
//            int randomPosition = rgen.nextInt(cards.length);
//            int temp = cards[i];
//            cards[i] = cards[randomPosition];
//            cards[randomPosition] = temp;
//        }
        
					String str = new String("ads S 3 2");
			String q[];
			q = str.split(" ");
			int x;
			int y;
			x = Integer.parseInt(q[2]);
			y = Integer.parseInt(q[3]);
			
			System.out.println(q[0]);
			System.out.println(q[1]);
			System.out.println(x);
			System.out.println(y);
			String s = q[1].toUpperCase();
			
			switch(q[1]) {
			case "P": System.out.println("lolo"); break;
			
			case "S": System.out.println("lele"); break;
					
			
			}
			
			
			
//			switch(q[0].toUpperCase()) {
//			
//			case "ADD":
//			case "A":
//			{
//				System.out.println("pepe");
//			}break;
//			case "NONE": break;
//			case "N": break;
//			case "LIST": break;
//			case "L": break;
//			case "EXIT": break;
//			case "E": break;
//			case "HELP": break;
//			case "H": break;
//
//			
//			}

        
	}

}