import java.util.HashSet;

/**
 * Meetup Saturday 2017/01/28
 * @author triet
 * 
 * A. Permutation
 * nPr = n! (n - r)!
 * |c| | | r = 3, n = 6
 * r = 2; n = 5
 * 
 * "ab" + dc (loop and concatenation. Terminate when r = 0?)
 * 
 * b. With duplicates:
 * |a|b|F|a|c|b|
 * Sort is better but ok without sorting
 * 
 * B. Combination
 * nCr = n! / ((n - r) * r!) ?
 * a. No duplicate
 * b. With duplicate
 * 		"abcd"
 * =>	"aaaa"
 * 		"aaab"
 * 
 * What if given "abbde"
 * 	=> Take the string and eliminate duplicate => "abde"
 * 
 */
public class Permutation {
	public HashSet<String> permutation(String text, int r) {
		HashSet<String> permutationSet = new HashSet<String>();
		if (text == null || text.length() == 0 || text.length() < r) {
			return permutationSet;
		}
		
		if (text.length() == r) {
			permutationSet.add(text);
		}
		
		return permutationSet;
	}
	
	/* C.
	 * Given x, y
	 * => x ^ y using recursion in (log y) time
	 * Func(x, y) = x * Func(x, y - 1)
	 * 
	 * y = 0 => return 1
	 * 
	 * To follow-up: (?)
	 * if (even) {
	 * 		return Pxy2 * Pxy2;
	 * } else { // odd
	 * 		return x * Pxy2 * Pxy2;
	 * }
	 */
	// double power()
	
	/*
	 * Problem: Tower of Hanoi (https://en.m.wikipedia.org/wiki/Tower_of_Hanoi# )
	 * Print the step to move n disks, 64 disks, from pole A to pole B via pole C
	 * 
	 * n 	Source (S) - D (Destination) - Target (T)
	 * 
	 * if (n == 0)
	 * 		return;
	 * move(n -1, S, T, D);
	 * print mth disks "S" -> "D"
	 * move(n - 1, T, D, S);
	 * 
	 */
	public void towerOfHanoi(int numOfDisks) {
		
	}
	
	private void towerOfHanoi() {
		
	}
	
	
	/*
	 * D. n queen problem
	 * n x n chess board
	 * Place 4 queen on the check board such that no queen can attack each other.
	 * Increase the number of queen to 5, 6, etc.
	 * 
	 * Problem statement: Write a program to place n queen on a n x n chess board
	 * 
	 * Notes:
	 * 		- No solution when n = 2, 3
	 * 		- Solution exists for n = 1 (trivial) and n >= 4
	 */
	public void placeQueensOnCheckBoard(int numberOfQueens) {
		if (numberOfQueens <= 0) {
			System.out.println("No solut");
		}
	}
	
	/* E. Quine (computing) - Don't search online
	 * https://en.wikipedia.org/wiki/Quine_%28computing%29
	 * 
	 * F. Write two programs that generate each other
	 * 
	 * Two ways:
	 * a. See the photo in my phone
	 * b. Read disassembly
	 */
	
	/*
	 * F. 
	 * Given a array of number in [0, 100]
	 * Look at the list to find out those folks who are younger than me but have more seniority
	 * In the other words, find the mismatches. Example
	 * I am younger than you but you are more senior than me == You are younger than me but you have more seniority than me (1 mismatch)
	 * 
	 * Example:
	 * 		Array: | 1 | 2 | 3 | 4 | 9 | 3 |
	 * ==> two pair of dis-order: A[3] vs. A[5] and
	 *		A[4] vs. A[5]
	 * 
	 * Solutions:
	 * a. Always has n^2 solution
	 * b. Better than n^2 solution: N log N  with merge sort
	 * 
	 * 
	 */
}
