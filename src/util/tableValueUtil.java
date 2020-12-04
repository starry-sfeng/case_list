package util;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sun.xml.internal.messaging.saaj.packaging.mime.Header;

import DAO.daoi.IUserLoginDao;
import DAO.daoi.IWorkspaceDao;
import DAO.daoimpl.UserLoginDaoImpl;
import DAO.daoimpl.WorkspaceDaoImpl;
import DAO.pojo.UserLogin;
import DAO.pojo.Workspace;

public class tableValueUtil {
	public static List getTableValue(String tableName,int id) {
		if(tableName.equals("normal_account_login")) {
			IUserLoginDao user = new UserLoginDaoImpl();
			UserLogin userLogin = user.selectById(id);
			List list = userLogin.message();
			return list;
		}
		if(tableName.equals("workspace")) {
			IWorkspaceDao wk = new WorkspaceDaoImpl();
			Workspace workspace = wk.selectById(id);
			List list = workspace.message();
			return list;
		}
		return null;
		
	}
	
}
