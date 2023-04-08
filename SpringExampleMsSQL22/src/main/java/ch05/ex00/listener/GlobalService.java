package ch05.ex00.listener;

import java.util.ArrayList;
import java.util.List;

import ch05.ex00.entity.Member;

public class GlobalService {
	static private List<Member> members = new ArrayList<Member>();
    
//	String dbType = "M"; 
	String dbType = "S"; 
	
	public static List<Member> getMembers() {
		return members;
	}

	public static void setMembers(List<Member> members) {
		GlobalService.members = members;
	}

	public String getDbType() {
		return dbType;
	}

	public void setDbType(String dbType) {
		this.dbType = dbType;
	}
	
}
