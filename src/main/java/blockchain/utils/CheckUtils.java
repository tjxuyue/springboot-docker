package blockchain.utils;

public class CheckUtils {
	public static boolean isEmpty(Object s) {
		if (null == s)
			return true;
		return false;
	}

	public static boolean isEmpty(String s) {
		if (null == s || s.length() == 0)
			return true;
		return false;
	}

	public static boolean isEmpty(String... s) {
		for (String item : s) {
			if (null == item || item.length() == 0)
				return true;
		}
		return false;
	}

}
