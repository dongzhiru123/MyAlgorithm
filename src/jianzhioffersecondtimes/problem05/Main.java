package jianzhioffersecondtimes.problem05;

/**
 *请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 * 示例 1：
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *  
 * 限制：
 * 0 <= s 的长度 <= 10000
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.replaceSpace("We are happy."));
    }
    public String replaceSpace(String s) {
        return s.replace(" ", "%20");
    }
}
