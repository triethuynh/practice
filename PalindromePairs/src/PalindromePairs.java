import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Triet Huynh
 *
 */
public class PalindromePairs {
	/**
	 * Problem statement: https://leetcode.com/problems/palindrome-pairs/ 
	 * Given a list of unique words, find all pairs of distinct indices (i, j) in the
	 * given list, so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.
	 * 
	 * @param words - the given words of unique words
	 * @return - the pair of distinct indexes (i, j)
	 * 
	 * Result: Pass all 134 leetcode tests and ran in 282 ms
	 * 
	 * Example:
	 * Given words[] = [abcd, dcba, lls, s, sssll, ]
	 * Expected pairs of palindromes: [[0, 1], [1, 0], [2, 4], [3, 2], [2, 5], [5, 2], [5, 3], [3, 5]]
	 * 		{"abcddcba", "dcbaabcd", "llssssll", "slls", "dcba", "dcba", "s", "s"}
	 */
	public List<List<Integer>> palindromePairs(String[] words) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (words == null) {
			return result;
		}

		// Zero or one word: No palindrome pair
		if (words.length < 2) {
			return result;
		}

		// Hash map of the word's ending characters and the word's index in the
		// given array of words.
		HashMap<Character, List<Integer>> map = new HashMap<Character, List<Integer>>();
		final int INVALID = -1;
		
		// Since words contains unique words, the number of empty words in the given list of words is either zero or one.
		// indexOfEmptyWord keep track of the index of the empty word, if any.
		int indexOfEmptyWord = INVALID;

		// Go through the array of words to generate the said hash map
		for (int i = 0; i < words.length; i++) {
			if (words[i].length() != 0) {
				char endingChar = words[i].charAt(words[i].length() - 1);
				if (map.containsKey(endingChar)) {
					map.get(endingChar).add(i);
				} else {
					List<Integer> list = new ArrayList<Integer>();
					list.add(i);
					map.put(endingChar, list);
				}
			} else {
				indexOfEmptyWord = i;
			}
		}

		// Go through the list of given words and use the created hash map to detect the concatenating words, 
		// if any, which form palindrome.
		for (int i = 0; i < words.length; i++) {
			if (words[i].length() != 0) {
				char startCharOfWord1 = words[i].charAt(0);
				if (map.containsKey(startCharOfWord1)) {
					List<Integer> list = map.get(startCharOfWord1);
					for (int n : list) {
						// Requirement: distinct indexes => i and n are different
						List<Integer> pairOfIndexes;
						if (i != n && isPalindrome(words[i], words[n])) {
							pairOfIndexes = new ArrayList<Integer>(2);
							pairOfIndexes.add(i);
							pairOfIndexes.add(n);
							result.add(pairOfIndexes);
						}
					}
				}
				
				// If there exists an empty word in the given list of word and the current word is a palindrome, 
				// we have two pairs of indexes by prefix and suffix the empty word with the palindrome word.
				if (indexOfEmptyWord != INVALID && this.isPalindrome(words[i], "")) {
					List<Integer> pairOfIndexes = new ArrayList<Integer>(2);
					pairOfIndexes.add(i); pairOfIndexes.add(indexOfEmptyWord);
					result.add(pairOfIndexes);
					
					pairOfIndexes = new ArrayList<Integer>(2);
					pairOfIndexes.add(indexOfEmptyWord); pairOfIndexes.add(i);
					result.add(pairOfIndexes);
				}
			}
		}

		return result;
	}

	/**
	 * isPalindrome(String word1, String word2) - determine if word1
	 * concatenating word2 is a palindrome
	 * 
	 * @param word1 - the first word
	 * @param word2 - the second word
	 * Assumption: 
	 * 	- Empty string concatenating a palindrome is valid characters are English alphabet
	 * @return - true if word1 concatenating word2 is a palindrome; false, otherwise.
	 */
	public boolean isPalindrome(String word1, String word2) {
		if (word1 == null || word2 == null || (word1.length() == 0 && word2.length() == 0)) {
			return false;
		}

		int i = 0, j = word2.length() - 1;
		for (; i < word1.length() && j >= 0; i++, j--) {
			if (word1.charAt(i) != word2.charAt(j)) {
				return false;
			}
		}

		if (i < word1.length() || j >= 0) {
			if (j >= 0) {
				i = 0;
				while (i < j) {
					if (word2.charAt(i) != word2.charAt(j)) {
						return false;
					}
					i++;
					j--;
				}
			} else { // i < word1.length()
				j = word1.length() - 1;
				while (i < j) {
					if (word1.charAt(i) != word1.charAt(j)) {
						return false;
					}
					i++;
					j--;
				}
			}
		}

		return true;
	}
}
