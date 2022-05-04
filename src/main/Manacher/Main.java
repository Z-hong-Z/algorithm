import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        manacher("ababa");

    }

    public static String builder(String s){
        StringBuilder sb = new StringBuilder();
        sb.append("#");
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            sb.append("#");
        }
        return sb.toString();
    }

    public static int manacher(String s){
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chs = builder(s).toCharArray();
        int[] pArray = new int[chs.length];
        int R = -1;
        int C = -1;
        for (int i = 0; i < pArray.length; i++) {
            if (i >= R) {
                int left = i;
                int right = i;
                while (left >= 0 && right < pArray.length && chs[left] == chs[right]) {
                    left--;
                    right++;
                }
                C = i;
                R = right - 1;
                pArray[i] = right - left - 1;
            }else {
                int polo = R  / 2;
                int _i = polo - (i - polo);
                if (pArray[_i] / 2 + i < R){
                    pArray[i] = pArray[_i];
                }else if (pArray[_i] / 2 + i== R){
                    pArray[i] = R - i + 1;
                }else {
                    int left = i - (R - i);
                    int right = R;
                    while (left >= 0 && right < chs.length && chs[left] == chs[right]){
                        left--;
                        right++;
                    }
                    R = right;
                    pArray[i] = right - left - 1;
                    if (right - left - 1 > pArray[C]){
                        C = i;
                    }
                }
            }
        }
        return -1;
    }
}
