
/**
 * @author Triet Huynh
 *
 */
public class Search2DMatrixTest {
	private static final String PASS = "Pass";
	private static final String FAIL = "Fail";
	
	private static final String YES = "Yes";
	private static final String NO = "No";
	
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		Search2DMatrixTest T = new Search2DMatrixTest();
		
		T.isInMatrixTest();
		
		System.out.println("Test completed");
	}

	/**
	 * @throws Exception 
	 * 
	 */
	public void isInMatrixTest() throws Exception {
		int[][] matrix1 = {
				{1, 60},
				{45, 62},
				{48, 100}
		};
		boolean overallResult = true;
		
		Search2DMatrix matrixI = new Search2DMatrix(matrix1);
		System.out.println("** Given matrix: ");
		System.out.println(matrixI.toString());
		
		int testNumber = 0;
		int targetNumber = 1;
		boolean expected = true;
		overallResult = this.isMatrixTestOutput(targetNumber, matrixI, expected, ++testNumber) && overallResult;
		
		targetNumber = 60; expected = true;
		overallResult = this.isMatrixTestOutput(targetNumber, matrixI, expected, ++testNumber) && overallResult;
		
		targetNumber = 45; expected = true;
		overallResult = this.isMatrixTestOutput(targetNumber, matrixI, expected, ++testNumber) && overallResult;

		targetNumber = 62; expected = true;
		overallResult = this.isMatrixTestOutput(targetNumber, matrixI, expected, ++testNumber) && overallResult;
		
		targetNumber = 48; expected = true;
		overallResult = this.isMatrixTestOutput(targetNumber, matrixI, expected, ++testNumber) && overallResult;
		
		targetNumber = 100; expected = true;
		overallResult = this.isMatrixTestOutput(targetNumber, matrixI, expected, ++testNumber) && overallResult;

		targetNumber = 0; expected = false;
		overallResult = this.isMatrixTestOutput(targetNumber, matrixI, expected, ++testNumber) && overallResult;

		targetNumber = 2; expected = false;
		overallResult = this.isMatrixTestOutput(targetNumber, matrixI, expected, ++testNumber) && overallResult;
		
		targetNumber = 50; expected = false;
		overallResult = this.isMatrixTestOutput(targetNumber, matrixI, expected, ++testNumber) && overallResult;

		targetNumber = 47; expected = false;
		overallResult = this.isMatrixTestOutput(targetNumber, matrixI, expected, ++testNumber) && overallResult;
		
		targetNumber = 101; expected = false;
		overallResult = this.isMatrixTestOutput(targetNumber, matrixI, expected, ++testNumber) && overallResult;

		
		System.out.println("\n** Given matrix: ");
		int[][] matrix2 = {{1}};
		matrixI = new Search2DMatrix(matrix2);
		System.out.println(matrixI.toString());
		
		targetNumber = 1; expected = true;
		overallResult = this.isMatrixTestOutput(targetNumber, matrixI, expected, ++testNumber) && overallResult;
		
		targetNumber = 2; expected = false;
		overallResult = this.isMatrixTestOutput(targetNumber, matrixI, expected, ++testNumber) && overallResult;
		
		
		System.out.println("\n** Given matrix: ");
		int[][] matrix3 = {{-1}, {1002}};
		
		matrixI = new Search2DMatrix(matrix3);
		System.out.println(matrixI.toString());
		
		targetNumber = -1; expected = true;
		overallResult = this.isMatrixTestOutput(targetNumber, matrixI, expected, ++testNumber) && overallResult;
		
		targetNumber = 1002; expected = true;
		overallResult = this.isMatrixTestOutput(targetNumber, matrixI, expected, ++testNumber) && overallResult;
		
		targetNumber = -2; expected = false;
		overallResult = this.isMatrixTestOutput(targetNumber, matrixI, expected, ++testNumber) && overallResult;
		
		targetNumber = 1; expected = false;
		overallResult = this.isMatrixTestOutput(targetNumber, matrixI, expected, ++testNumber) && overallResult;
		
		targetNumber = 1003; expected = false;
		overallResult = this.isMatrixTestOutput(targetNumber, matrixI, expected, ++testNumber) && overallResult;
		
		
		System.out.println("\n** Given matrix: ");
		int[][] matrix4 = {{-1}, {1002}, {1006}, {2000}, {2500}};
		
		matrixI = new Search2DMatrix(matrix4);
		System.out.println(matrixI.toString());
		
		targetNumber = -1; expected = true;
		overallResult = this.isMatrixTestOutput(targetNumber, matrixI, expected, ++testNumber) && overallResult;
		
		targetNumber = 2500; expected = true;
		overallResult = this.isMatrixTestOutput(targetNumber, matrixI, expected, ++testNumber) && overallResult;
		
		targetNumber = 2000; expected = true;
		overallResult = this.isMatrixTestOutput(targetNumber, matrixI, expected, ++testNumber) && overallResult;
		
		targetNumber = 0; expected = false;
		overallResult = this.isMatrixTestOutput(targetNumber, matrixI, expected, ++testNumber) && overallResult;
		
		targetNumber = 2501; expected = false;
		overallResult = this.isMatrixTestOutput(targetNumber, matrixI, expected, ++testNumber) && overallResult;
		
		targetNumber = 1001; expected = false;
		overallResult = this.isMatrixTestOutput(targetNumber, matrixI, expected, ++testNumber) && overallResult;
		
		
		System.out.println("\n** Given matrix: ");
		int[][] matrix5 = {{-1, 10, 100, 200, 301}};
		
		matrixI = new Search2DMatrix(matrix5);
		System.out.println(matrixI.toString());
		
		targetNumber = -1; expected = true;
		overallResult = this.isMatrixTestOutput(targetNumber, matrixI, expected, ++testNumber) && overallResult;
		
		targetNumber = 301; expected = true;
		overallResult = this.isMatrixTestOutput(targetNumber, matrixI, expected, ++testNumber) && overallResult;
		
		targetNumber = 100; expected = true;
		overallResult = this.isMatrixTestOutput(targetNumber, matrixI, expected, ++testNumber) && overallResult;
		
		targetNumber = 300; expected = false;
		overallResult = this.isMatrixTestOutput(targetNumber, matrixI, expected, ++testNumber) && overallResult;
		
		targetNumber = 302; expected = false;
		overallResult = this.isMatrixTestOutput(targetNumber, matrixI, expected, ++testNumber) && overallResult;
		
		
		System.out.println("\n** Given matrix: ");
		int[][] matrix6 = {
				{1, 4, 7, 11, 15, 16, 20, 25},
				{2, 5, 8, 12, 19, 100, 101, 105},
				{3, 6, 9, 16, 22, 203, 210, 223},
				{10, 13, 14, 17, 27, 310, 311, 315},
				{18, 21, 23, 26, 30, 405, 450, 500}};
		
		matrixI = new Search2DMatrix(matrix6);
		System.out.println(matrixI.toString());
		
		targetNumber = 1; expected = true;
		overallResult = this.isMatrixTestOutput(targetNumber, matrixI, expected, ++testNumber) && overallResult;
		
		targetNumber = 25; expected = true;
		overallResult = this.isMatrixTestOutput(targetNumber, matrixI, expected, ++testNumber) && overallResult;
		
		targetNumber = 10; expected = true;
		overallResult = this.isMatrixTestOutput(targetNumber, matrixI, expected, ++testNumber) && overallResult;
		
		targetNumber = 500; expected = true;
		overallResult = this.isMatrixTestOutput(targetNumber, matrixI, expected, ++testNumber) && overallResult;
		
		targetNumber = 6; expected = true;
		overallResult = this.isMatrixTestOutput(targetNumber, matrixI, expected, ++testNumber) && overallResult;
		
		targetNumber = 22; expected = true;
		overallResult = this.isMatrixTestOutput(targetNumber, matrixI, expected, ++testNumber) && overallResult;
		
		targetNumber = 18; expected = true;
		overallResult = this.isMatrixTestOutput(targetNumber, matrixI, expected, ++testNumber) && overallResult;
		
		targetNumber = 450; expected = true;
		overallResult = this.isMatrixTestOutput(targetNumber, matrixI, expected, ++testNumber) && overallResult;
		
		targetNumber = 0; expected = false;
		overallResult = this.isMatrixTestOutput(targetNumber, matrixI, expected, ++testNumber) && overallResult;
		
		targetNumber = 501; expected = false;
		overallResult = this.isMatrixTestOutput(targetNumber, matrixI, expected, ++testNumber) && overallResult;
		
		targetNumber = 24; expected = false;
		overallResult = this.isMatrixTestOutput(targetNumber, matrixI, expected, ++testNumber) && overallResult;
		
		targetNumber = 312; expected = false;
		overallResult = this.isMatrixTestOutput(targetNumber, matrixI, expected, ++testNumber) && overallResult;
		
		targetNumber = 205; expected = false;
		overallResult = this.isMatrixTestOutput(targetNumber, matrixI, expected, ++testNumber) && overallResult;
		
		
		// [[1,4,5],[3,7,12],[5,7,16],[7,10,17],[10,11,20],[11,14,22]]
		System.out.println("\n** Given matrix: ");
		int[][] matrix7 = {
				{1, 4, 5},
				{3, 7, 12},
				{5, 7, 16},
				{7, 10, 17},
				{10, 11, 20},
				{11, 14, 22}};
		
		matrixI = new Search2DMatrix(matrix7);
		System.out.println(matrixI.toString());
		
		targetNumber = 10; expected = true;
		overallResult = this.isMatrixTestOutput(targetNumber, matrixI, expected, ++testNumber) && overallResult;
		
		targetNumber = 11; expected = true;
		overallResult = this.isMatrixTestOutput(targetNumber, matrixI, expected, ++testNumber) && overallResult;
		
		targetNumber = 7; expected = true;
		overallResult = this.isMatrixTestOutput(targetNumber, matrixI, expected, ++testNumber) && overallResult;
		
		targetNumber = 8; expected = false;
		overallResult = this.isMatrixTestOutput(targetNumber, matrixI, expected, ++testNumber) && overallResult;
		
		targetNumber = 13; expected = false;
		overallResult = this.isMatrixTestOutput(targetNumber, matrixI, expected, ++testNumber) && overallResult;
		
		targetNumber = 23; expected = false;
		overallResult = this.isMatrixTestOutput(targetNumber, matrixI, expected, ++testNumber) && overallResult;

		
		System.out.println("\n** Given 1 X 0 matrix: ");
		int[][] matrix8 = {{}};
		matrixI = new Search2DMatrix(matrix8);
		System.out.println(matrixI.toString());
		
		targetNumber = 1; expected = false;
		overallResult = this.isMatrixTestOutput(targetNumber, matrixI, expected, ++testNumber) && overallResult;

		// {{}, {}}
		System.out.println("\n** Given 2 X 0 matrix: ");
		int[][] matrix9 = {{}, {}};
		matrixI = new Search2DMatrix(matrix9);
		System.out.println(matrixI.toString());
		
		targetNumber = 1; expected = false;
		overallResult = this.isMatrixTestOutput(targetNumber, matrixI, expected, ++testNumber) && overallResult;
		
		System.out.println();
		System.out.println(">> Overal test result: " + (overallResult? PASS: FAIL));
		System.out.println();
	}
	
	private boolean isMatrixTestOutput(int targetNumber, Search2DMatrix search2DMatrix, boolean expected, int testNumber) throws Exception {
		if (testNumber <= 0) {
			throw new Exception("Negative or zero test number is unexpected.");
		}
		
		boolean isFound = search2DMatrix.isInMatrix(targetNumber);
		boolean result = isFound == expected;
		
		System.out.println(testNumber + ". " + (result? PASS : FAIL) + ": Search2DMatrix(" + targetNumber + ") - Found? " + (isFound? YES : NO));
		
		return result;
	}
}
