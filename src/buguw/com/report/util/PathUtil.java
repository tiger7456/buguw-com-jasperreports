package buguw.com.report.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PathUtil {
	public static String formatPath(String path) {
		if (path != null) {
			path = path.replaceAll("\\\\", "/");
			String regex = "\\*|.*//.*$|//*|.*//.*$";
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(path);
			while (m.matches()) {
				path = path.replaceAll("//", "/");
				m = p.matcher(path);
			}
			if (!path.endsWith("/")) {
				path = path + "/";
			}
		}

		return path;
	}

	public static String[] getPathList(String path) {
		String target = formatPath(path);
		String[] tempList = target.split("/");
		List tempArrayList = new ArrayList();
		for (int i = 0; i < tempList.length; i++) {
			if (tempList[i] != null && tempList[i].length() > 0) {
				tempArrayList.add(tempList[i]);
			}
		}
		return (String[]) tempArrayList.toArray(new String[0]);
	}
	
}

