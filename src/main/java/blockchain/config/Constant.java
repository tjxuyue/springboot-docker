package blockchain.config;

import org.springframework.stereotype.Component;

@Component
public class Constant {
	public static String METHOD_INVOKE = "invoke";
	public static String METHOD_QUERY = "query";

	public static String MESSAGE_ERROR = "error";

	public static String STATUS_SUCCESS = "0";
	public static String STATUS_ERROR_SERVER = "1";
	public static String STATUS_ERROR_MISSING_BASIC_PARAMETER = "2";
	public static String STATUS_ERROR_BODY_ERROR = "3";
	public static String STATUS_ERROR_URL = "4";
}
