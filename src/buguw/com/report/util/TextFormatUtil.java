package buguw.com.report.util;

public final class TextFormatUtil {
    public static String containFormat(Object obj) {
        return " [" + String.valueOf(obj) + "] ";
    }

    public static String formatStr(String str) {
        StringBuffer buffer = new StringBuffer();
        String[] tmps = str.split("\\s*");
        for (int i = 0; i < tmps.length; i++) {
            buffer.append(tmps[i]);
        }
        return buffer.toString();
    }

    public static String formatLine() {
        return null;
    }

    /**
     * 字符串首字母大写
     * @param strs
     * @return String[]
     */
    public static String capitalize(String strs) {
        if (strs == null || "".equals(strs)) {
            return null;
        }
       String  str = new StringBuffer(strs.length()).append(Character.toTitleCase(strs.charAt(0))).append(strs.substring(1))
                .toString();
        return str;
    }

}
