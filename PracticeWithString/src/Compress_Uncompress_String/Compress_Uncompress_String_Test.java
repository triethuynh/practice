package Compress_Uncompress_String;

import java.util.Arrays;

/**
 * 
 * @author Triet Huynh
 *
 * Test cases for methods: compress(char[] charArray) and uncompressed(char[] charArray)
 */
public class Compress_Uncompress_String_Test {
	private final String PASS = "Pass";
	private final String FAIL = "Fail";

	/**
	 * Main
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		Compress_Uncompress_String_Test T = new Compress_Uncompress_String_Test();
		T.compressTest();
		T.unCompressTest();

		System.out.println("Tests completed");
	}

	/**
	 * compressTest() - test cases for method compress(char[] charArray)
	 * @throws Exception
	 */
	public void compressTest() throws Exception {
		char[] givenCharArray = {};
		char[] expected = {};
		int testNumber = 0;
		boolean overallTestResult = true;

		System.out.println("** Test cases for the compress method **");

		// Test #1: null => null
		overallTestResult = overallTestResult && this.compressTestOutput(givenCharArray, expected, ++testNumber);

		// Test #2: {a} => {a}
		givenCharArray = "a".toCharArray();
		overallTestResult = overallTestResult && this.compressTestOutput(givenCharArray, givenCharArray, ++testNumber);

		// Test #3: {ab} => {ab}
		givenCharArray = "ab".toCharArray();
		overallTestResult = overallTestResult && this.compressTestOutput(givenCharArray, givenCharArray, ++testNumber);

		// Test #4: [aaa] => [3a]
		givenCharArray = "aaa".toCharArray();
		expected = "3a0".toCharArray();
		overallTestResult = overallTestResult && this.compressTestOutput(givenCharArray, expected, ++testNumber);
		
		// Test #5: [aaaab] => [4ab00]
		givenCharArray = "aaaab".toCharArray();
		expected = "4ab00".toCharArray();
		overallTestResult = overallTestResult && this.compressTestOutput(givenCharArray, expected, ++testNumber);

		// Test #6: [aaaaaaaaaaaaabbbcczooaa] => [13a3b2cz2o2a]
		givenCharArray = "aaaaaaaaaaaaabbbcczooaa".toCharArray();
		expected = "13a3b2cz2o2a00000000000".toCharArray();
		overallTestResult = overallTestResult && this.compressTestOutput(givenCharArray, expected, ++testNumber);

		// Test #7: [abcdefghizklmnopqrstuvwxyz] => [abcdefghizklmnopqrstuvwxyz]
		givenCharArray = "abcdefghizklmnopqrstuvwxyz".toCharArray();
		overallTestResult = overallTestResult && this.compressTestOutput(givenCharArray, givenCharArray, ++testNumber);
		
		// Test #8
		final int SIZE = 562;
		char[] charArray = new char[SIZE];
		int i = 0;
		for (; i < SIZE - 31; i++) {
			charArray[i] = 'a';
		}
		charArray[i++] = 'b';
		for (; i < SIZE; i++) {
			charArray[i] = 't';
		}
		char[] expectedCharArray = new char[SIZE];
		i = 0;
		expectedCharArray[i++] = '5'; expectedCharArray[i++] = '3'; expectedCharArray[i++] = '1'; expectedCharArray[i++] = 'a';
		expectedCharArray[i++] = 'b';
		expectedCharArray[i++] = '3'; expectedCharArray[i++] = '0'; expectedCharArray[i++] = 't';
		while (i < SIZE) {
			expectedCharArray[i++] = '0';
		}
		overallTestResult = overallTestResult && this.compressTestOutput(charArray, expectedCharArray, ++testNumber);
		
		System.out.println("** Overall test result: " + (overallTestResult ? PASS : FAIL));
		
		System.out.println("");
	}

	private boolean compressTestOutput(char[] charArray, char[] expected, int testNumber) throws Exception {
		if (testNumber <= 0) {
			throw new Exception("Unexpected negative or zero value for test number");
		}

		System.out.println(testNumber + ". Test #" + testNumber);
		System.out.print("   Given character array: ");
		this.printToConsoleCharArray(charArray);

		CompressUncompress P = new CompressUncompress();
		P.compress(charArray);

		System.out.print("   Actual result  : ");
		this.printToConsoleCharArray(charArray);
		boolean result = Arrays.equals(charArray, expected);
		System.out.println("   Result: " + (result ? PASS : FAIL));

		if (!result) {
			System.out.print("   Expected result: ");
			this.printToConsoleCharArray(expected);
		}
		System.out.println();

		return result;
	}

	/**
	 * Test cases for method unCompress(char[] charArray)
	 * @throws Exception
	 */
	public void unCompressTest() throws Exception {
		char[] givenCharArray = {};
		char[] expected = {};
		int testNumber = 0;
		boolean overallTestResult = true;

		System.out.println("** Test cases for the unCompress method **");

		 // Test #1: null => null
		 overallTestResult = overallTestResult &&
		 this.unCompressTestOutput(givenCharArray, expected, ++testNumber);
		
		 // Test #2: {a} => {a}
		 givenCharArray = "a".toCharArray();
		 overallTestResult = overallTestResult &&
		 this.unCompressTestOutput(givenCharArray, givenCharArray,
		 ++testNumber);
		
		 // Test #3: {ab} => {ab}
		 givenCharArray = "ab".toCharArray();
		 overallTestResult = overallTestResult &&
		 this.unCompressTestOutput(givenCharArray, givenCharArray,
		 ++testNumber);

		// Test #4: [2a] => [aa]
		givenCharArray = "2a".toCharArray();
		expected = "aa".toCharArray();
		overallTestResult = overallTestResult && this.unCompressTestOutput(givenCharArray, expected, ++testNumber);

		// Test #5: [2ab] => [aab]
		givenCharArray = "2ab".toCharArray();
		expected = "aab".toCharArray();
		overallTestResult = overallTestResult && this.unCompressTestOutput(givenCharArray, expected, ++testNumber);
		
		// Test #6: [3ab0] => [aaab]
		givenCharArray = "3ab0".toCharArray();
		expected = "aaab".toCharArray();
		overallTestResult = overallTestResult && this.unCompressTestOutput(givenCharArray, expected, ++testNumber);
		
		// Test #7: [4ab00] => [aaaab]
		givenCharArray = "4ab00".toCharArray();
		expected = "aaaab".toCharArray();
		overallTestResult = overallTestResult && this.unCompressTestOutput(givenCharArray, expected, ++testNumber);

		// Test #8: [13a3b2cz2o2a] => [aaaaaaaaaaaaabbbcczooaa]
		givenCharArray = "13a3b2cz2o2a00000000000".toCharArray();
		expected = "aaaaaaaaaaaaabbbcczooaa".toCharArray();
		overallTestResult = overallTestResult && this.unCompressTestOutput(givenCharArray, expected, ++testNumber);

		// Test #9: [abcdefghizklmnopqrstuvwxyz] => [abcdefghizklmnopqrstuvwxyz]
		givenCharArray = "abcdefghizklmnopqrstuvwxyz".toCharArray();
		overallTestResult = overallTestResult && this.compressTestOutput(givenCharArray, givenCharArray, ++testNumber);

		// Test #10
		final int SIZE = 562;
		char[] expectedCharArray = new char[SIZE];
		int i = 0;
		for (; i < SIZE - 31; i++) {
			expectedCharArray[i] = 'a';
		}
		expectedCharArray[i++] = 'b';
		for (; i < SIZE; i++) {
			expectedCharArray[i] = 't';
		}
		char[] charArray = new char[SIZE];
		i = 0;
		charArray[i++] = '5'; charArray[i++] = '3'; charArray[i++] = '1'; charArray[i++] = 'a';
		charArray[i++] = 'b';
		charArray[i++] = '3'; charArray[i++] = '0'; charArray[i++] = 't';
		while (i < SIZE) {
			charArray[i++] = '0';
		}
		overallTestResult = overallTestResult && this.unCompressTestOutput(charArray, expectedCharArray, ++testNumber);
		
		System.out.println("** Overall test result: " + (overallTestResult ? PASS : FAIL));
		System.out.println();
	}

	private boolean unCompressTestOutput(char[] charArray, char[] expected, int testNumber) throws Exception {
		if (testNumber <= 0) {
			throw new Exception("Unexpected negative or zero value for test number");
		}

		System.out.println(testNumber + ". Test #" + testNumber);
		System.out.print("   Given the compressed character array: ");
		this.printToConsoleCharArray(charArray);

		CompressUncompress P = new CompressUncompress();
		P.unCompress(charArray);

		System.out.print("   Actual result: ");
		this.printToConsoleCharArray(charArray);
		boolean result = Arrays.equals(charArray, expected);
		System.out.println("   Result: " + (result ? PASS : FAIL));

		if (!result) {
			System.out.print("   Expected result: ");
			this.printToConsoleCharArray(expected);
		}
		System.out.println();

		return result;
	}

	/**
	 * Output the array of characters onto the console
	 * @param charArray
	 */
	private void printToConsoleCharArray(char[] charArray) {
		if (charArray == null) {
			System.out.println("null");
			return;
		}

		if (charArray.length == 0) {
			System.out.println("[]");
			return;
		}

		System.out.print("[");
		boolean isFirstChar = true;
		for (char c : charArray) {
			if (isFirstChar) {
				isFirstChar = false;
				System.out.print(c);
			} else {
				System.out.print(", " + c);
			}
		}

		System.out.println("]");
	}
}
