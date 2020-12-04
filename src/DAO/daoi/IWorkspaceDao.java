package DAO.daoi;

import java.util.List;

import DAO.pojo.UserLogin;
import DAO.pojo.Workspace;

public interface IWorkspaceDao {
	int insert(Workspace wk);
	int delete(int id);
	int update(Workspace wk);
	Workspace selectById(int id);
	List<Workspace> selectList(String table);
}
