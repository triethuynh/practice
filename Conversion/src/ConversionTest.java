/**
 * @author Triet Huynh
 *
 */
public class ConversionTest {
	final String PASS = "Pass";
	final String FAIL = "Fail";
	
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		ConversionTest T = new ConversionTest();
		
		T.colorDecimalToHexadecimalTest();

	}

	/**
	 * Test cases for method String colorDecimalToHexadecimal(int colorValue)
	 * @throws Exception 
	 */
	public void colorDecimalToHexadecimalTest() throws Exception {
		System.out.println("** Test cases for method String colorDecimalToHexadecimal(int colorValue) **");
		
		int testNumber = 0;
		int colorValue = 0;
		boolean overallTestResult = true;		
		String expectedValue = "0";
		overallTestResult = this.colorDecimalToHexadecimalTest(colorValue, expectedValue, ++testNumber) && overallTestResult;
		
		colorValue = 1; expectedValue = "1";
		overallTestResult = this.colorDecimalToHexadecimalTest(colorValue, expectedValue, ++testNumber) && overallTestResult;
		
		colorValue = 2; expectedValue = "2";
		overallTestResult = this.colorDecimalToHexadecimalTest(colorValue, expectedValue, ++testNumber) && overallTestResult;
		
		colorValue = 9; expectedValue = "9";
		overallTestResult = this.colorDecimalToHexadecimalTest(colorValue, expectedValue, ++testNumber) && overallTestResult;
		
		colorValue = 10; expectedValue = "A";
		overallTestResult = this.colorDecimalToHexadecimalTest(colorValue, expectedValue, ++testNumber) && overallTestResult;
		
		colorValue = 11; expectedValue = "B";
		overallTestResult = this.colorDecimalToHexadecimalTest(colorValue, expectedValue, ++testNumber) && overallTestResult;
		
		colorValue = 12; expectedValue = "C";
		overallTestResult = this.colorDecimalToHexadecimalTest(colorValue, expectedValue, ++testNumber) && overallTestResult;
		
		colorValue = 13; expectedValue = "D";
		overallTestResult = this.colorDecimalToHexadecimalTest(colorValue, expectedValue, ++testNumber) && overallTestResult;
		
		colorValue = 14; expectedValue = "E";
		overallTestResult = this.colorDecimalToHexadecimalTest(colorValue, expectedValue, ++testNumber) && overallTestResult;
		
		colorValue = 16; expectedValue = "10";
		overallTestResult = this.colorDecimalToHexadecimalTest(colorValue, expectedValue, ++testNumber) && overallTestResult;
		
		colorValue = 20; expectedValue = "14";
		overallTestResult = this.colorDecimalToHexadecimalTest(colorValue, expectedValue, ++testNumber) && overallTestResult;
		
		colorValue = 32; expectedValue = "20";
		overallTestResult = this.colorDecimalToHexadecimalTest(colorValue, expectedValue, ++testNumber) && overallTestResult;
		
		colorValue = 186; expectedValue = "BA";
		overallTestResult = this.colorDecimalToHexadecimalTest(colorValue, expectedValue, ++testNumber) && overallTestResult;
		
		colorValue = 205; expectedValue = "CD";
		overallTestResult = this.colorDecimalToHexadecimalTest(colorValue, expectedValue, ++testNumber) && overallTestResult;
		
		colorValue = 240; expectedValue = "F0";
		overallTestResult = this.colorDecimalToHexadecimalTest(colorValue, expectedValue, ++testNumber) && overallTestResult;
		
		colorValue = 254; expectedValue = "FE";
		overallTestResult = this.colorDecimalToHexadecimalTest(colorValue, expectedValue, ++testNumber) && overallTestResult;
		
		colorValue = 255; expectedValue = "FF";
		overallTestResult = this.colorDecimalToHexadecimalTest(colorValue, expectedValue, ++testNumber) && overallTestResult;
		
		colorValue = 255; expectedValue = "FF";
		overallTestResult = this.colorDecimalToHexadecimalTest(colorValue, expectedValue, ++testNumber) && overallTestResult;
		
		System.out.println("Overal test result: " + (overallTestResult? PASS : FAIL));
		System.out.println();
	}
	
	/**
	 * private method colorDecimalToHexadecimalTest()
	 * @param colorValue - color value in [0, 255]
	 * @param expectedHexValue - expected color Hexadecimal value
	 * @param testNumber - test number
	 * @return true if the test pass; false, otherwise
	 * @throws Exception when any parameter is invalid
	 */
	private boolean colorDecimalToHexadecimalTest(int colorValue, String expectedHexValue, int testNumber) throws Exception {
		if (colorValue < 0 || colorValue > 255 || testNumber < 1) {
			throw new Exception("Unexpected parameter value(s)");
		}
		Conversion C = new Conversion();
		
		String actualValue = C.colorDecimalToHexadecimal(colorValue);
		boolean testResult = actualValue.equals(expectedHexValue);
		System.out.println(testNumber + ". colorDecimalToHexadecimalTest(" + colorValue + ") = " + actualValue);
		System.out.println("  - Test result: " + (testResult? PASS: FAIL));
		if (!testResult) {
			System.out.println("  - Actual value: " + actualValue + " vs. expected value: " + expectedHexValue);
		}
		
		System.out.println();
		
		return testResult;
	}
}
