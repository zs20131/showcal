package net.showcal.tool;

/**
 * Created by DEV005 on 2015/7/21.
 */
public class StringUtil {
    public static String substring(String text, int start, int end) {
        if(end < text.length()) {
            return text.substring(start, end) + "...";
        } else {
            return text.substring(start, end);
        }
    }
}
