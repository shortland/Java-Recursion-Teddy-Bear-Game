/*
	Instructions:

	You start with a given number of teddy bears. 
	Each step of the game you have the choice to do one of the following options:
		1.) Receive "X" increment bears.
		2.) Get rid of "X" increment of your bears.
		3.) If you have an even amount of bears, you can get rid of exactly half of yours bears.
		4.) If you have an even number of bears, you can get an additional number of bears equal to half your current number of bears (* 1.5) 

		*If you fail to obtain the goal within 10 steps, the method returns -1.
		* Otherwise, return the total amount of steps required to get the desired amount of bears.
*/

public class TeddyBears {

	public static void main(String[] args) {
		System.out.println("The Famous Teddy Bear Game");
		System.out.println();
		System.out.println("teddy(10,4,2) = " + teddy(10,4,2)); // returns 2
		System.out.println("teddy(9,5,3) = " + teddy(9,5,3)); // returns -1
		System.out.println("teddy(15,4,2) = " + teddy(15,4,2)); // returns -1
		System.out.println("teddy(20,3,5) = " + teddy(20,3,5)); // returns -1
		System.out.println("teddy(40,5,6) = " + teddy(40,5,6)); // returns 3
		System.out.println("teddy(30,56,5) = " + teddy(30,56,5)); // returns -1
		System.out.println("teddy(30,55,4) = " + teddy(30,55,4)); // returns 3
	}

	public static int teddy(int initial, int goal, int increment) {
		int n = 10;
		int retVal = -1;

		for(int i = 0; i <= n; i++) {
			if(teddy(initial, goal, increment, i)) {
				retVal = i;
				break;
			}
		}
		return retVal;
	}

	public static boolean teddy(int initial, int goal, int increment, int n) {
		if (initial == goal)
			return true;
		else if (n == 0)
			return false;
		else if (teddy(initial+increment, goal, increment, n-1))
			return true;
		else if (teddy(initial-increment, goal, increment, n-1))
			return true;
		else if ((initial % 2 == 0) && teddy(initial/2, goal, increment, n-1))
			return true;
		else if ((initial % 2 == 0) && teddy(initial + (initial/2), goal, increment, n-1))
			return true;
		else
			return false;
	}

}