package jianzhioffersecondtimes.problem20;

/**
 *请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 *
 * 例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"0123"都表示数值，
 * 但"12e"、"1a3.14"、"1.2.3"、"+-5"、"-1E-16"及"12e+5.4"都不是。
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.isNumber("1 "));
    }
    public boolean isNumber(String s) {
        char[] chars = s.trim().toCharArray();
        boolean isNum = false, hasDecimalPoint = false, hasE = false;
        for (int i = 0; i < chars.length; i++) {
            if (Character.isDigit(chars[i])) isNum = true;
            else if ('.' == chars[i] && (!hasDecimalPoint) && isNum && (!hasE)) {
                isNum = false;
                hasDecimalPoint = true;
            }
            else if (('e' == chars[i] || 'E' == chars[i]) && !hasE && isNum) {
                isNum = false;
                hasE = true;
            }
            else if (('+' == chars[i] || '-' == chars[i]) && (i == 0)) continue;
            else return false;
        }
        return isNum;
    }
}