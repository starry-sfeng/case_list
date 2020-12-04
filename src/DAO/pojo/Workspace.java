package DAO.pojo;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Workspace {
	private int case_id;
	private String case_name;
	private String operation;
	
	public Workspace() {
		
	}
	
	public Workspace(int case_id,String case_name,String operation) {
		this.case_id = case_id;
		this.case_name = case_name;
		this.operation = operation;
	}
	
	public List message() {
		List list = new ArrayList();
		list.add(this.getCase_id());
		list.add(this.getCase_name());
		list.add(this.getOperation());
		return list;
	}
}
