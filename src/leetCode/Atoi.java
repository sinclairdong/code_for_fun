package leetCode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Atoi {
    public int myAtoiOld(String str) {

	if (str.length() == 0) {
	    return 0;
	}

	int counter = 0;
	char charAtCounter = str.charAt(counter);
	while (counter < str.length() && ((charAtCounter = str.charAt(counter)) == ' ') && charAtCounter != '-') {
	    counter++;
	}
	StringBuilder result = new StringBuilder();
	// check the first digit
	boolean negtiveFlag = charAtCounter == '-';
	if (counter < str.length() - 1 && negtiveFlag) {
	    charAtCounter = str.charAt(++counter);
	}

	while (counter < str.length() && Character.isDigit(charAtCounter = str.charAt(counter))) {
	    result.append(charAtCounter);
	    counter++;
	}

	int resultInt;

	try {
	    resultInt = Integer.parseInt(result.toString());
	} catch (NumberFormatException e) {
	    resultInt = negtiveFlag ? Integer.MIN_VALUE : Integer.MAX_VALUE;
	}

	return negtiveFlag ? -1 * resultInt : resultInt;
    }

    public int myAtoi(String str) {

	Pattern p = Pattern.compile("\\s*([+-]{0,1}[0-9]+).*");
	Matcher m = p.matcher(str);

	if (m.find() && m.matches()) {
	    String result = m.group(1);

	    int resultInt;
	    try {
		resultInt = Integer.parseInt(result.toString());
	    } catch (NumberFormatException e) {
		resultInt = result.charAt(0) == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
	    }
	    return resultInt;
	} else {
	    return 0;
	}
    }

    public static void main(String[] args) {
	System.out.println(new Atoi().myAtoi("+"));
    }
}
