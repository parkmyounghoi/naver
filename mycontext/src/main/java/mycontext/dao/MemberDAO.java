package mycontext.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {

	public void insert() {
		System.out.println("insert...");
	}
	
	public void select() {
		System.out.println("select...");
	}
}
