package leet_code_contests.weekly.wc283_20220305;

import java.util.LinkedList;
import java.util.List;

public class LC2194CellsInARangeOnAnExcelSheet {
    // Attempt 1
    public List<String> cellsInRange(String s) {
        char startChar = s.charAt(0);
        char endChar = s.charAt(3);

        int startNum = s.charAt(1) - '0';
        int endNum = s.charAt(4) - '0';
        LinkedList<String> output = new LinkedList<>();

        for (char c = startChar; c <= endChar; c++)
        {
            for (int i = startNum; i <= endNum; i++)
                output.add(String.format("%c%d", c, i));

        }
        return output;

    }
}
