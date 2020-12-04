package DAO.pojo;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Setter
@Getter
@ToString
public class UserLogin {
	private int case_id;
	private String case_name;
	private String except_result;
	private String user_name;
	private String password;
	private String assertion_keyword;
	private String run;
	
	public UserLogin() {
		super();
	}
	
	public UserLogin(int case_id,String case_name,String except_result,String user_name,String password,String assertion_keyword,String run) {
		super();
		this.case_id = case_id;
		this.case_name = case_name;
		this.except_result = except_result;
		this.user_name = user_name;
		this.password = password;
		this.assertion_keyword = assertion_keyword;
		this.run = run;
	}
	
	public List message() {
		List list = new ArrayList();
		list.add(this.getCase_id());
		list.add(this.getCase_name());
		list.add(this.getExcept_result());
		list.add(this.getUser_name());
		list.add(this.getPassword());
		list.add(this.getAssertion_keyword());
		list.add(this.getRun());
		return list;
	}
}
