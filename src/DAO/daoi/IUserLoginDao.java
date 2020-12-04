package DAO.daoi;
import java.util.List;
import DAO.pojo.UserLogin;
public interface IUserLoginDao {
	int insert(UserLogin user);
	int delete(int id);
	int delete(UserLogin user);
	int update(UserLogin user);
	UserLogin selectById(int id);
	List<UserLogin> selectList(String table);
	
}
