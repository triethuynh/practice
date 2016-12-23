import java.util.Arrays;

/**
 * @author Triet Huynh
 * 
 */
public class Search2DMatrix {
	private int[][] matrix;
	private final int INVALID = -1;
	
	/**
	 * Default constructor - Initialize an empty matrix
	 */
	Search2DMatrix() {
		this.matrix = null;
	}
	
	/**
	 * Constructor
	 * @param matrix - the given matrix
	 */
	Search2DMatrix(int[][] matrix) {
		if (matrix == null) {
			this.matrix = matrix;
			return;
		}
		
		this.matrix = new int[matrix.length][];
		for (int i = 0; i < matrix.length; i++) {
			this.matrix[i] = Arrays.copyOf(matrix[i], matrix[i].length);
		}
	}
	
	/**
	 * isInMatrix(int number) - tell if the given number is found in the matrix.
	 * 
	 * Problem statement from leedcode.com (https://leetcode.com/problems/search-a-2d-matrix-ii/):
	 * Problem 240. Search a 2D Matrix II
	 * Searches for a value in an m x n matrix where rows and columns are sorted in ascending order 
	 * from left to right and top to bottom, respectively.
	 * 
	 * Example: (from leedcode.com)
	 * [
  	 * 		[1,   4,  7, 11, 15],
  	 * 		[2,   5,  8, 12, 19],
  	 * 		[3,   6,  9, 16, 22],
  	 * 		[10, 13, 14, 17, 24],
  	 * 		[18, 21, 23, 26, 30]
	 * ]
	 * Given target = 5, return true.
	 * Given target = 20, return false.
	 * 
	 * @param number - the number to search for
	 * @return	- true is the number is in the matrix; false, otherwise
	 */
	public boolean isInMatrix(int number) {
		if (this.matrix == null) {
			return false;
		}
		
		int n = matrix.length;
		int m = matrix[0].length;
		
		// 1. m == 0: the horizontal dimension has no element. For example: n = 1; m = 0: {{}}; n = 2, m = 0: {{}, {}}
		// 2. Observing that the top left corner element is the smallest and the bottom right corner element is the largest
		// We, therefore, can use this property to quickly tell if the number is "out-of-range".
		if (m == 0 || number < this.matrix[0][0] || number > this.matrix[n - 1][m - 1]) {
			return false;
		}

		return this.isInMatrix(number, 0, n - 1, 0, m - 1);
	}
	
	/**
	 * isInMatrix - recursive helper method for isInMatrix(int number)
	 * @param number - the number to search
	 * @param iStart - Start index in the horizontal direction
	 * @param iEnd - End index in the horizontal direction
	 * @param jStart - Start index in the vertical direction
	 * @param jEnd - End index in the vertical direction
	 * @return true if the number is in the matrix area; false, otherwise.
	 */
	private boolean isInMatrix(int number, int iStart, int iEnd, int jStart, int jEnd) {
		if (number < this.matrix[iStart][jStart] || this.matrix[iEnd][jEnd] < number) {
			return false;
		}
		
		int delta_i = iEnd - iStart;
		int delta_j = jEnd - jStart;
		// 2 x 2 matrix area
		if (delta_i == 1 && delta_j == 1) {
			return (this.matrix[iStart][jStart] == number || this.matrix[iEnd][jEnd] == number
					|| this.matrix[iStart][jEnd] == number || this.matrix[iEnd][jStart] == number);
		} else if (delta_i == 0 && delta_j == 0) { // 1 x 1 matrix area
			return this.matrix[iStart][jStart] == number;
		} else if (delta_i == 0 && delta_j == 1) { // 1 x 2 matrix area
			return this.matrix[iStart][jStart] == number || this.matrix[iEnd][jEnd] == number;
		} else if (delta_j == 0 && delta_i == 1) { // 2 x 1 matrix area
			return this.matrix[iStart][jStart] == number || this.matrix[iEnd][jStart] == number;
		}
		
		boolean result_topLeft = this.isInMatrix(number, iStart, iStart + delta_i / 2, jStart, jStart + delta_j / 2);
		if (result_topLeft) {
			return true;
		}
		
		boolean result_topRight = this.isInMatrix(number, iStart, iStart + delta_i / 2, Math.min(jEnd, jStart + delta_j / 2 + 1), jEnd);
		if (result_topRight) {
			return true;
		}
		
		boolean result_bottomLeft = this.isInMatrix(number, Math.min(iEnd, iStart + delta_i / 2 + 1), iEnd, jStart, jStart + delta_j / 2);
		if (result_bottomLeft) {
			return true;
		}
		
		// Bottom right
		return this.isInMatrix(number, Math.min(iEnd, iStart + delta_i / 2 + 1), iEnd, Math.min(jEnd, jStart + delta_j / 2 + 1), jEnd);
	}
	
	/**
	 * searchMatrix(int number, int[][] matrix) - tell if the given number is found in the matrix.
	 * Note: Same logic as isInMatrix(int number)
	 * To try on leedcode site.
	 * Result on leed code: https://leetcode.com/submissions/detail/86525946/
	 * 		. 127/127 test cases passed.
	 * 		. Runtime: 15 ms (runtime beats 34.76% of java submission)
	 * 
	 * @param number - the number to search for
	 * @matrix - the given matrix upon which the search is performed
	 * @return	- true is the number is in the matrix; false, otherwise
	 */
    public boolean searchMatrix(int[][] matrix, int number) {
		if (matrix == null) {
			return false;
		}

		int n = matrix.length;
		int m = matrix[0].length;

		// 1. m == 0: the horizontal dimension has no element. For example: n = 1; m = 0: {{}}; n = 2, m = 0: {{}, {}}
		// 2. Observing that the top left corner element is the smallest and the bottom right corner element is the largest
		// We, therefore, can use this property to quickly tell if the number is "out-of-range".
		if (m == 0 || number < matrix[0][0] || number > matrix[n - 1][m - 1]) {
			return false;
		}
		
		return isInMatrix(number, 0, n - 1, 0, m - 1, matrix);
	}
	
	/**
	 * isInMatrix - recursive helper method for isInMatrix(int number, int[][] matrix)
	 * @param number - the number to search
	 * @param iStart - Start index in the horizontal direction
	 * @param iEnd - End index in the horizontal direction
	 * @param jStart - Start index in the vertical direction
	 * @param jEnd - End index in the vertical direction
	 * @return true if the number is in the matrix area; false, otherwise.
	 */
	private boolean isInMatrix(int number, int iStart, int iEnd, int jStart, int jEnd, int[][] matrix) {
		if (number < matrix[iStart][jStart] || matrix[iEnd][jEnd] < number) {
			return false;
		}
		
		int delta_i = iEnd - iStart;
		int delta_j = jEnd - jStart;
		// 2 x 2 matrix area
		if (delta_i == 1 && delta_j == 1) {
			return (matrix[iStart][jStart] == number || matrix[iEnd][jEnd] == number
					|| matrix[iStart][jEnd] == number || matrix[iEnd][jStart] == number);
		} else if (delta_i == 0 && delta_j == 0) { // 1 x 1 matrix area
			return matrix[iStart][jStart] == number;
		} else if (delta_i == 0 && delta_j == 1) { // 1 x 2 matrix area
			return matrix[iStart][jStart] == number || matrix[iEnd][jEnd] == number;
		} else if (delta_j == 0 && delta_i == 1) { // 2 x 1 matrix area
			return matrix[iStart][jStart] == number || matrix[iEnd][jStart] == number;
		}
		
		boolean result_topLeft = isInMatrix(number, iStart, iStart + delta_i / 2, jStart, jStart + delta_j / 2, matrix);
		if (result_topLeft) {
			return true;
		}
		
		boolean result_topRight = isInMatrix(number, iStart, iStart + delta_i / 2, Math.min(jEnd, jStart + delta_j / 2 + 1), jEnd, matrix);
		if (result_topRight) {
			return true;
		}
		
		boolean result_bottomLeft = isInMatrix(number, Math.min(iEnd, iStart + delta_i / 2 + 1), iEnd, jStart, jStart + delta_j / 2, matrix);
		if (result_bottomLeft) {
			return true;
		}
		
		// Bottom right
		return isInMatrix(number, Math.min(iEnd, iStart + delta_i / 2 + 1), iEnd, Math.min(jEnd, jStart + delta_j / 2 + 1), jEnd, matrix);
	}
	
	/**
	 * toString() - The string representation of the 2-D matrix
	 */
	public String toString() {
		if (this.matrix == null) { 
			return "null";
		}
		
		String matrixStr = "[\n";
		boolean isFirstRow = true;
		for (int i = 0; i < this.matrix.length; i++) {
			
			if (isFirstRow) {
				matrixStr += "  [";
				isFirstRow = false;
			} else {
				matrixStr += ",\n  [";
			}
			
			boolean isFirstElementOfRow = true;
			for (int j = 0; j < this.matrix[i].length; j++) {
				if (isFirstElementOfRow) {
					isFirstElementOfRow = false;
				} else {
					matrixStr += ", ";
				}
				
				matrixStr += this.matrix[i][j];
			}
			matrixStr += "]";
		}
		
		matrixStr += "\n]";
		
		return matrixStr;
	}
}
