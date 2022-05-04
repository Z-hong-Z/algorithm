package KMP;

public class KMP {
    public static void main(String[] args) {
        String str1 = "mississippi";
        String str2 = "issip";
        int kmp = KMP(str1, str2);
        System.out.println(kmp);
    }

    public static int KMP(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() < str2.length()) {
            return -1;
        }
        int[] next = getNextArray(str2);
        int i = 0;
        int j = 0;
        while (i < str1.length() && j < str2.length()) {
            if (str1.charAt(i) == str2.charAt(j)) {
                i++;
                j++;
            } else if (j == 0) {
                i++;
            } else {
                j = next[j];
            }
        }
        return j == str2.length() ? i - str2.length() : -1;
    }

    public static int[] getNextArray(String str2) {
        if (str2.length() == 1) return new int[]{-1};
        char[] chs = str2.toCharArray();
        int[] next = new int[str2.length()];
        next[0] = -1;
        next[1] = 0;
        int index = 0;
        int i = 2;
        while (i < chs.length) {
            if (chs[index] == chs[i - 1]) {
                next[i++] = ++index;
            } else if (index > 0) {
                index = next[index];
            } else {
                next[i++] = 0;
            }
        }
        return next;
    }


}
