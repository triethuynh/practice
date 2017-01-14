/**
 * @author Triet Huynh
 *
 */
public class Conversion {
	/*
	 * colorDecimalToHexadecimal(int colorValue) - Convert an R (Red), G (Green), or B (Blue) into the corresponding Hexadecimal value. 
	 * Ref. for testing purpose: http://www.bing.com/search?q=decimal+to+hexadecimal&qs=LS&pq=
	 * 		(http://www.bing.com/search?q="decimal to hexadecimal")
	 * 
	 * Assumption: colorValue is between 0 and 255, inclusively
	 * Throw an exception when the parameter is not valid
	 */
	public String colorDecimalToHexadecimal(int colorValue) throws Exception {
		if (colorValue < 0 || colorValue > 255) {
			throw new Exception("Color value (colorValue) must be between 0 and 255, inclusively");
		}
		
		final int SIZE = 2;
		final char invalidHexDigit = 'Z';
		char[] hexCharArray = {invalidHexDigit, '0'};
		final char[] hexCharMap = {'A', 'B', 'C', 'D', 'E', 'F'};

		for (int i = SIZE - 1; i >= 0 && colorValue != 0; i--) {
			char hexChar;
			int remainder = colorValue % 16;
			if (remainder >= 10) {
				hexChar = hexCharMap[remainder % 10];
			} else {
				hexChar = (char) ('0' + remainder);
			}
			hexCharArray[i] = hexChar;
			colorValue = colorValue >> 4;
		}
		
		assert(colorValue == 0);
		String hex = "";
		for (char c : hexCharArray)
		{
			if (c != invalidHexDigit) {
				hex += c;
			}
		}
		return hex;
	}
}
