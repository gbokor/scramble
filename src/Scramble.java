import java.util.regex.Pattern;

public class Scramble {

	public String textScramble(String s) {

		StringBuilder ret = new StringBuilder();

		String[] parts = s.split(" "); // splitting the input string

		for (String part : parts) { // iterate over the parts
			if (part.length() > 3) { // if there are more than 3 characters, scrambling is necessary
				if (Pattern.matches(".*\\p{Punct}", part)) { // checking punctuation at the end of the words

					StringBuilder p = new StringBuilder(part.substring(0, part.length() - 1)).reverse();

					p.setCharAt(0, part.charAt(0));
					p.setCharAt(p.length() - 1, part.charAt(part.length() - 2));
					p.append(part.charAt(part.length() - 1));

					ret.append(p + " ");

				} else if (part.contains("'")) { // checking for apostrophe

					int index = part.indexOf("'");
					StringBuilder p = new StringBuilder(part.substring(0, index)).reverse();

					p.setCharAt(0, part.charAt(0));
					p.setCharAt(p.length() - 1, part.charAt(index - 1));
					p.append(part.substring(index, part.length()));

					ret.append(p + " ");

				} else { // words without special characters
					StringBuilder p = new StringBuilder(part).reverse();

					p.setCharAt(0, part.charAt(0));
					p.setCharAt(p.length() - 1, part.charAt(part.length() - 1));

					ret.append(p + " ");
				}
			} else // if there are 1-3 characters, no scrambling is necessary
				ret.append(part + " ");
		}

		return ret.toString();
	}
}
