package buguw.com.report.util;

import java.io.File;

public class FileTool {
    public static void createDirectory(String directory) {
        File file = new File(directory);
        if (!file.exists()) {
            if (!file.mkdirs()) {
                throw new RuntimeException("create directory failed!");
            }
        }
    }

    public static String getExtensionName(String fileName) {
        File file = new File(fileName);
        int len = file.getName().lastIndexOf(".");
        String temp = file.getName().substring(len, file.getName().length());
        return temp;
    }

    public static String getfileNameWithOutExtensionName(String fileName) {
        File file = new File(fileName);
        int len = file.getName().lastIndexOf(".");
        String temp = file.getName().substring(0, len);
        return temp;
    }
}
