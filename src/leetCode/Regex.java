package leetCode;

public class Regex {
    public boolean isMatch(String text, String pattern) {
	if (pattern.isEmpty())
	    return text.isEmpty();
	boolean first_match = (!text.isEmpty() && (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

	if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
	    return (isMatch(text, pattern.substring(2)) || (first_match && isMatch(text.substring(1), pattern)));
	} else {
	    return first_match && isMatch(text.substring(1), pattern.substring(1));
	}
    }

    public static void main(String[] args) {
	String a, b, c, d;
	a = "aaca";
	b = "ab*a*c*a*";
	c = "";
	d = "a*b*c*";
	System.out.println(new Regex().isMatch(a, b));
    }
}
