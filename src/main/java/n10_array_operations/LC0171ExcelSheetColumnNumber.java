package n10_array_operations;

public class LC0171ExcelSheetColumnNumber {
    public int titleToNumber(String columnTitle) {
        int n = columnTitle.length();
        int value = 0;

        for (int i = 0; i < n; i++)
        {
            value = value * 26;
            value += (columnTitle.charAt(i) - 'A' + 1);
        }

        return value;
    }
}
