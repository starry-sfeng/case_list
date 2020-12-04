package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class tableHeaderUtil {
	public static List getTableHeader(String tableName) {
		if(tableName.equals("normal_account_login")) {
			List<String> tableHeader = new ArrayList<>(Arrays.asList("case_id", "case_name", "except_result","user_name","password","assertion_keyword","run"));
			return tableHeader;
		}
		
		if(tableName.equals("workspace")) {
			List<String> tableHeader = new ArrayList<>(Arrays.asList("case_id", "case_name", "operation"));
			return tableHeader;
		}
		
		return null;
	}
}
