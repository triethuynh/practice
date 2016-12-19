package Compress_Uncompress_String;

import java.util.Stack;

/**
 * @author Triet Huynh
 * Problem statement from "Seattle Tech Interview" Meetup (https://www.meetup.com/techinterviews/) on Saturday 12/10/2016
 * 		- compress in place
 * 		- uncompress - suggested practice
 */
public class CompressUncompress {

	/**
	 * compress method - compress in-place the given array of characters.
	 * 
	 * Problem statement: Given an array of characters, compress in-place the array of characters with their character counts
	 * and fill out the remainder spaces with zero ('0').
	 * Assuming the array contains only lower-case English alphabet.
	 * Examples:
	 * null	=> null
	 * []	=>	[]
	 * [a]	=> {a}
	 * [a, b}	=> [a, b]
	 * [a, a, a, a, b}	=> [4, a, b, 0, 0]
	 * [a, a, a, a, a, a, a, a, a, a, a, a, a, b, b, b, c, c, z, o, o, a, a} => {1, 3, a, 3, b, 2, c, z, 2, o, 2, a, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
	 * [a, b, c, d, e, f, g, h, i, z, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z} => {a, b, c, d, e, f, g, h, i, z, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z]
	 * Expected time: 30 minutes	
	 * 
	 * @param charArray - the character array to be compressed
	 * @return the compressed character array
	 */
	public void compress(char[] charArray) {
		if (charArray == null || charArray.length == 1) {
			return;
		}

		int position = 0;
		for (int i = 0; i < charArray.length; i++) {
			char currentChar = charArray[i];
			int count = 1;
			while (i + 1 < charArray.length && currentChar == charArray[i + 1]) {
				count++; i++;
			}

			if (count == 1) {
				charArray[position++] = currentChar;
			} else {
				if (count > 9) {
					Stack<Integer> stack = new Stack<Integer>();
					while (count != 0) {
						stack.push(count % 10);
						count /= 10;
					}

					while (!stack.empty()) {
						charArray[position++] = (char) (stack.pop() + '0');
					}
				} else {
					charArray[position++] = (char) (count + '0');
				}
				charArray[position++] = currentChar;
			}
		}
		while (position < charArray.length ) {
			charArray[position++] = '0';
		}
	}
	
	/**
	 * unCompress - Reverse of method compress
	 * @param charArray: the compressed character array
	 * @throws Exception - when falling into the unexpected code path
	 */
	public void unCompress(char[] charArray) throws Exception {
		if (charArray == null || charArray.length == 1) {
			return;
		}
		
		int position = charArray.length - 1;
		for (int i = position; i >= 0;) {
			char currentChar = charArray[i];
			
			if (currentChar >= 'a' && currentChar <= 'z') {
				int count = 1; int numOfChars = 0;
				i--;
				while (i >= 0 && (charArray[i] >= '0' && charArray[i] <= '9')) {
					numOfChars += Math.pow(10, count - 1) * ((int) (charArray[i] - '0'));
					count++; i--;
				}
				
				if (count == 1) {
					charArray[position--] = currentChar;
				} else {
					while (numOfChars > 0) {
						charArray[position--] = currentChar;
						numOfChars--;
					}
				}
			} else {
				if (charArray[i] == '0') {
					i--;
				} else {
					throw new Exception("Logic exception. Investigate");
				}
			}
		}
	}
}
