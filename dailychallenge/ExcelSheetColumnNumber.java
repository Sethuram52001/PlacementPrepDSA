/*
Problem:
Given a string columnTitle that represents the column title as appear in an Excel sheet, return its corresponding column number.

Link: https://leetcode.com/problems/excel-sheet-column-number/

Solution:

*/

public class ExcelSheetColumnNumber {
    public int titleToNumber(String columnTitle) {
        int n = columnTitle.length();
        int colNo = 0, j = 0;
        for(int i = n - 1; i >= 0; i--) {
            colNo += (int)Math.pow(26, i)*(columnTitle.charAt(n - i - 1) - 'A' + 1);
        }
        return colNo;
    }
}
