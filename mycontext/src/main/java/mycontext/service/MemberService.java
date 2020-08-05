package mycontext.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import mycontext.dao.MemberDAO;

@Service
public class MemberService {

	@Autowired
	MemberDAO dao;
	
	public void join() {
		dao.select();
		dao.insert();
	}
}
