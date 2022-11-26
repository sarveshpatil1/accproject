package SearchEngine;
 
public class EditDistance {
	public static int editDistance(String str1, String str2) {
		int len1 = str1.length();
		int len2 = str2.length();

		int[][] my_array = new int[len1 + 1][len2 + 1];

		for (int i = 0; i <= len1; i++) {
			my_array[i][0] = i;
		}

		for (int j = 0; j <= len2; j++) {
			my_array[0][j] = j;
		}

		for (int i = 0; i < len1; i++) {
			char c1 = str1.charAt(i);
			for (int j = 0; j < len2; j++) {
				char c2 = str2.charAt(j);

				if (c1 == c2) {
					my_array[i + 1][j + 1] = my_array[i][j];
				} else {
					int replace = my_array[i][j] + 1;
					int insert = my_array[i][j + 1] + 1;
					int delete = my_array[i + 1][j] + 1;

					int min = replace > insert ? insert : replace;
					min = delete > min ? min : delete;
					my_array[i + 1][j + 1] = min;
				}
			}
		}
		return my_array[len1][len2];
	}
}
