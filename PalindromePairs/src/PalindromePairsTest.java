import java.util.ArrayList;
import java.util.List;

/**
 * @author Triet Huynh
 * 
 Input:
["bb","bababab","baab","abaabaa","aaba","","bbaa","aba","baa","b"]
Output:
[[0,9],[4,3],[4,8],[5,7],[7,5],[6,0],[7,4],[7,5],[8,2],[8,9],[9,0]]
Expected:
[[0,5],[0,9],[9,0],[5,0],[1,5],[5,1],[2,5],[8,2],[5,2],[4,3],[7,4],[4,8],[6,0],[7,5],[5,7],[8,9],[9,5],[5,9]]
 *
 */
public class PalindromePairsTest {
	private static final String PASS = "Pass";
	private static final String FAIL = "Fail";
	
	private static final String YES = "Yes";
	private static final String NO = "No";
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		PalindromePairsTest T = new PalindromePairsTest();
		
		//T.isPalindromeTest();
		System.out.println();
		T.palindromePairsTest();

	}
	
	/**
	 * Test cases for method palindromePairs()
	 */
	public void palindromePairsTest() throws Exception {
		boolean overallTestResult = true;
		int testNumber = 0;
		List<Integer> list;
		
		System.out.println("** Test cases for palindromePairs(String[] words) **");
		
		String[] words = null;
		List<List<Integer>> expected = new ArrayList<List<Integer>>();
		overallTestResult = this.palindromePairsTestOutput(words, expected, ++testNumber) && overallTestResult;
		
		words = new String[] {};
		expected = new ArrayList<List<Integer>>();
		overallTestResult = this.palindromePairsTestOutput(words, expected, ++testNumber) && overallTestResult;
		
		words = new String[] {"Hello"};
		expected = new ArrayList<List<Integer>>();
		overallTestResult = this.palindromePairsTestOutput(words, expected, ++testNumber) && overallTestResult;
		
		words = new String[] {"a", ""};
		expected = new ArrayList<List<Integer>>();
		list = new ArrayList<Integer>(); list.add(0); list.add(1); expected.add(list);
		list = new ArrayList<Integer>(); list.add(1); list.add(0); expected.add(list);
		overallTestResult = this.palindromePairsTestOutput(words, expected, ++testNumber) && overallTestResult;
		
		words = new String[] {"mo", "m"};
		expected = new ArrayList<List<Integer>>();
		list = new ArrayList<Integer>(); list.add(0); list.add(1); expected.add(list);
		overallTestResult = this.palindromePairsTestOutput(words, expected, ++testNumber) && overallTestResult;
		
		words = new String[] {"mo", "gym", "m", "my"};
		expected = new ArrayList<List<Integer>>();
		list = new ArrayList<Integer>(); list.add(0); list.add(2); expected.add(list);
		list = new ArrayList<Integer>(); list.add(3); list.add(1); expected.add(list);
		list = new ArrayList<Integer>(); list.add(3); list.add(2); expected.add(list);
		overallTestResult = this.palindromePairsTestOutput(words, expected, ++testNumber) && overallTestResult;
		
		words = new String[] {"bat", "tab", "cat"};
		expected = new ArrayList<List<Integer>>();
		list = new ArrayList<Integer>(); list.add(0); list.add(1); expected.add(list);
		list = new ArrayList<Integer>(); list.add(1); list.add(0); expected.add(list);
		overallTestResult = this.palindromePairsTestOutput(words, expected, ++testNumber) && overallTestResult;

		words = new String[] {"abcd", "dcba", "lls", "s", "sssll"};
		expected = new ArrayList<List<Integer>>();
		list = new ArrayList<Integer>(); list.add(0); list.add(1); expected.add(list);
		list = new ArrayList<Integer>(); list.add(1); list.add(0); expected.add(list);
		list = new ArrayList<Integer>(); list.add(3); list.add(2); expected.add(list);
		list = new ArrayList<Integer>(); list.add(2); list.add(4); expected.add(list);
		overallTestResult = this.palindromePairsTestOutput(words, expected, ++testNumber) && overallTestResult;
		
    	// leedcode.com test case: ["abcd","dcba","lls","s","sssll",""]
    	// expected: [[0,1],[1,0],[3,2],[3,5],[5,3],[2,4]]
		words = new String[] {"abcd", "dcba", "lls", "s", "sssll", ""};
		expected = new ArrayList<List<Integer>>();
		list = new ArrayList<Integer>(); list.add(0); list.add(1); expected.add(list);
		list = new ArrayList<Integer>(); list.add(1); list.add(0); expected.add(list);
		list = new ArrayList<Integer>(); list.add(3); list.add(2); expected.add(list);
		list = new ArrayList<Integer>(); list.add(2); list.add(4); expected.add(list);
		list = new ArrayList<Integer>(); list.add(3); list.add(5); expected.add(list);
		list = new ArrayList<Integer>(); list.add(5); list.add(3); expected.add(list);
		overallTestResult = this.palindromePairsTestOutput(words, expected, ++testNumber) && overallTestResult;
		
		words = new String[] {"abcd", "dcba", "slls", "s", ""};
		expected = new ArrayList<List<Integer>>();
		list = new ArrayList<Integer>(); list.add(0); list.add(1); expected.add(list);
		list = new ArrayList<Integer>(); list.add(1); list.add(0); expected.add(list);
		list = new ArrayList<Integer>(); list.add(3); list.add(4); expected.add(list);
		list = new ArrayList<Integer>(); list.add(4); list.add(3); expected.add(list);
		list = new ArrayList<Integer>(); list.add(2); list.add(4); expected.add(list);
		list = new ArrayList<Integer>(); list.add(4); list.add(2); expected.add(list);
		overallTestResult = this.palindromePairsTestOutput(words, expected, ++testNumber) && overallTestResult;
		
		// Input: ["aaba", "baa"]
		// Expected: [[0, 1]]
		words = new String[] {"aaba", "baa"};
		expected = new ArrayList<List<Integer>>();
		list = new ArrayList<Integer>(); list.add(0); list.add(1); expected.add(list);
		
		overallTestResult = this.palindromePairsTestOutput(words, expected, ++testNumber) && overallTestResult;
		// Input: ["bb","bababab","baab","abaabaa","aaba","","bbaa","aba","baa","b"]
		// Expected: [[0,5],[0,9],[9,0],[5,0],[1,5],[5,1],[2,5],[8,2],[5,2],[4,3],[7,4],[4,8],[6,0],[7,5],[5,7],[8,9],[9,5],[5,9]]
		words = new String[] {"bb","bababab","baab","abaabaa","aaba","","bbaa","aba","baa","b"};
		expected = new ArrayList<List<Integer>>();
		list = new ArrayList<Integer>(); list.add(0); list.add(5); expected.add(list);
		list = new ArrayList<Integer>(); list.add(0); list.add(9); expected.add(list);
		list = new ArrayList<Integer>(); list.add(9); list.add(0); expected.add(list);
		list = new ArrayList<Integer>(); list.add(5); list.add(0); expected.add(list);
		list = new ArrayList<Integer>(); list.add(1); list.add(5); expected.add(list);
		list = new ArrayList<Integer>(); list.add(5); list.add(1); expected.add(list);
		list = new ArrayList<Integer>(); list.add(2); list.add(5); expected.add(list);
		list = new ArrayList<Integer>(); list.add(8); list.add(2); expected.add(list);
		list = new ArrayList<Integer>(); list.add(5); list.add(2); expected.add(list);
		list = new ArrayList<Integer>(); list.add(4); list.add(3); expected.add(list);
		list = new ArrayList<Integer>(); list.add(7); list.add(4); expected.add(list);
		list = new ArrayList<Integer>(); list.add(4); list.add(8); expected.add(list);
		list = new ArrayList<Integer>(); list.add(6); list.add(0); expected.add(list);
		list = new ArrayList<Integer>(); list.add(7); list.add(5); expected.add(list);
		list = new ArrayList<Integer>(); list.add(5); list.add(7); expected.add(list);
		list = new ArrayList<Integer>(); list.add(8); list.add(9); expected.add(list);
		list = new ArrayList<Integer>(); list.add(9); list.add(5); expected.add(list);
		list = new ArrayList<Integer>(); list.add(5); list.add(9); expected.add(list);
		overallTestResult = this.palindromePairsTestOutput(words, expected, ++testNumber) && overallTestResult;
		
		System.out.println();
		System.out.println("Overall test result: " + (overallTestResult? PASS: FAIL));
	}
	
	private boolean palindromePairsTestOutput(String[] words, List<List<Integer>> expected, int testNumber) throws Exception {
		boolean result = true;
		if (testNumber <= 0) {
			throw new Exception("Test number is zero or negative");
		}
		
		System.out.println(testNumber + ". Given words[] = " + (words == null? null : this.toString(words)));
		
		PalindromePairs p = new PalindromePairs();
		// long startTime = System.currentTimeMillis();
		List<List<Integer>> pairOfIndexes = p.palindromePairs(words);
		// long runTime = System.currentTimeMillis() - startTime;
		
		if (expected.isEmpty()) {
			result = pairOfIndexes.isEmpty();
		} else {
			if (pairOfIndexes.size() != expected.size()) {
				result = false;
			} else {
				for (List<Integer> list : pairOfIndexes) {
					if (!expected.contains(list)) {
						result = false;
						break;
					}
				}
			}
		}
		
		System.out.println("   Actual pairs of palindromes:   " + pairOfIndexes);
		System.out.println("   Expected pairs of palindromes: " + expected);
		
		System.out.println("   Result: " + (result? PASS : FAIL));
		// System.out.println("   Run-time: " + runTime + " ms");
		System.out.println();
		
		return result;
	}

    /**
     * toString(String[] words) - convert words into the String representation
     * @param words - the given words
     * @return - the String representation of the given words String array
     */
    public String toString(String[] words) {
    	if (words == null) {
    		return null;
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	sb.append("[");
    	boolean isFirstWord = true;
    	for (String word : words) {
    		if (isFirstWord) {
    			isFirstWord = false;
    			sb.append(word);
    		} else {
    			sb.append(", " + word);
    		}
    	}
    	
    	sb.append("]");
    	
    	return sb.toString();
    }
    
    /**
     * isPalindromeTest() - Test cases for method isPalindrome(String word1, String word2)
     * @throws Exception 
     * Ref. http://www.palindromelist.net/
     */
    public void isPalindromeTest() throws Exception {
    	int testNumber = 0;
    	String word1 = "";
    	String word2 = "";
    	boolean expected = false;
    	boolean overallTestResult = true;
    	
    	overallTestResult = this.isPalindromeTestOutput(word1, word2, expected, ++testNumber) && overallTestResult;
    	
    	word1 = "a";
    	word2 = "";
    	expected = true;
    	overallTestResult = this.isPalindromeTestOutput(word1, word2, expected, ++testNumber) && overallTestResult;
    	
    	word1 = "";
    	word2 = "a";
    	expected = true;
    	overallTestResult = this.isPalindromeTestOutput(word1, word2, expected, ++testNumber) && overallTestResult;
    	
    	word1 = "";
    	word2 = "mom";
    	expected = true;
    	overallTestResult = this.isPalindromeTestOutput(word1, word2, expected, ++testNumber) && overallTestResult;
    	
    	word1 = "dad";
    	word2 = "";
    	expected = true;
    	overallTestResult = this.isPalindromeTestOutput(word1, word2, expected, ++testNumber) && overallTestResult;
    	
    	word1 = "dad";
    	word2 = "mom";
    	expected = false;
    	overallTestResult = this.isPalindromeTestOutput(word1, word2, expected, ++testNumber) && overallTestResult;
    	
    	word1 = "bat";
    	word2 = "tab";
    	expected = true;
    	overallTestResult = this.isPalindromeTestOutput(word1, word2, expected, ++testNumber) && overallTestResult;
    	
    	word1 = "live";
    	word2 = "evil";
    	expected = true;
    	overallTestResult = this.isPalindromeTestOutput(word1, word2, expected, ++testNumber) && overallTestResult;
    	
    	word1 = "race";
    	word2 = "car";
    	expected = true;
    	overallTestResult = this.isPalindromeTestOutput(word1, word2, expected, ++testNumber) && overallTestResult;

    	word1 = "dr";
    	word2 = "awkward";
    	expected = true;
    	overallTestResult = this.isPalindromeTestOutput(word1, word2, expected, ++testNumber) && overallTestResult;
    	
    	System.out.println("Overall test result: " + (overallTestResult? PASS : FAIL));
    }
    
    /**
     * Helper method for isPalindromeTestOutput()
     * @param word1 - 1st word
     * @param word2 - 2nd word
     * @param expected - true when we expect a palindrome formed; false, otherwise
     * @param testNumber - the test case number
     * @return - true if word1 concatenating word2 forms a palindrome; false, otherwise
     * @throws Exception - when one of the parameter is invalid
     */
    private boolean isPalindromeTestOutput(String word1, String word2, boolean expected, int testNumber) throws Exception {
    	if (word1 == null || word2 == null || testNumber <= 0) {
    		throw new Exception("Invalid parameter(s)");
    	}
    	
    	PalindromePairs p = new PalindromePairs();
    	boolean isPalindrome = p.isPalindrome(word1, word2);
    	boolean result = isPalindrome == expected;
    	
    	System.out.println(testNumber + ". Given two words: " + "\"" + word1 + "\" and \"" + word2 + "\"");
    	System.out.println("   Word concatenation: \"" + word1 + word2 + "\" is " + (isPalindrome? "" : "not ") + "a palindrome.");
    	System.out.println("   Test result: " + (result? PASS : FAIL));
    	System.out.println();
    	
    	return result;
    }
}
