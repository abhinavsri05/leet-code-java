package n09_string_manipulation;

public class LC0392IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int lenS = s.length();
        int lenT = t.length();

        if (lenS == 0) return true;
        if (lenT == 0) return false;

        int posnS = 0;
        char charS = s.charAt(posnS);

        int i;

        for (i = 0; i < lenT; i++)
        {
            if (charS == t.charAt(i))
            {
                posnS++;
                if (posnS < lenS)
                    charS = s.charAt(posnS);
                else
                    break;
            }
        }
//        return posnS == lenS ? true : false;
        return posnS == lenS;
    }
}
