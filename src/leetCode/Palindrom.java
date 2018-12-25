package leetCode;

public class Palindrom {
    public String longestPalindrome(String s) {

	return s.length() == 0 ? "" : helper(s, 0, s.length() - 1, new String[s.length()][s.length()]);
    }

    public String helper(String s, int i, int j, String[][] history) {
	System.out.println(i + "              " + j);
	if (i == j) {
	    history[i][j] = s.charAt(i) + "";
	} else if (i - 1 == j) {
	    history[i][j] = s.charAt(i) == s.charAt(j) ? s.charAt(i) + s.charAt(j) + "" : "";
	} else

	if (s.charAt(i) == s.charAt(j)) {
	    if (history[i + 1][j - 1] == null) {
		history[i + 1][j - 1] = helper(s, i + 1, j - 1, history);
	    }
	    history[i][j] = s.charAt(i) + history[i + 1][j - 1] + s.charAt(j);

	} else {
	    if (history[i + 1][j] == null) {
		history[i + 1][j] = helper(s, i + 1, j, history);
	    }
	    if (history[i][j - 1] == null) {
		history[i][j - 1] = helper(s, i, j - 1, history);
	    }
	    history[i][j] = history[i][j - 1].length() > history[i + 1][j].length() ? history[i][j - 1]
		    : history[i + 1][j];
	}
	return history[i][j];
    }

    public static void main(String[] args) {
	String a = "abcdedba";
	System.out.println(new Palindrom().longestPalindrome(a));
    }
}
