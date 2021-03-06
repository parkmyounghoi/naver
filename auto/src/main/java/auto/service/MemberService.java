package auto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.sun.istack.internal.Nullable;

import auto.dao.MemberDao;

public class MemberService {

	@Autowired
//	@Qualifier("memberDao")
	MemberDao memberDao;
	
	public MemberService() {
	}
	
	public MemberService(MemberDao memberDao) {
		super();
		this.memberDao = memberDao;
	}
	
//	@Autowired
//	@Autowired(required = false)
//	@Qualifier("my")
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public void join() {
		memberDao.select();
		memberDao.insert();
	}
	
}
