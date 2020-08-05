package auto.conf;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import auto.dao.MemberDao;
import auto.service.MemberService;

@Configuration
public class MyCtx {

	@Bean
	@Qualifier("md")
	public MemberDao memberDao1() {
		return new MemberDao();
	}
	
	@Bean
	public MemberDao memberDao2() {
		return new MemberDao();
	}
	
	@Bean
	public MemberService memberService() {
//		MemberService ms = new MemberService(memberDao());
//		return ms;
		MemberService ms = new MemberService();
//		ms.setMemberDao(memberDao());
		return ms;
	}
}
