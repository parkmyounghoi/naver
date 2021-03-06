package mycontext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import mycontext.conf.MyConf;
import mycontext.service.MemberService;

public class MainAnno {
	
//	@Autowired
//	MemberService ms;
	
	public MainAnno() {
		AnnotationConfigApplicationContext acac =
				new AnnotationConfigApplicationContext(MyConf.class);
		
		MemberService ms = acac.getBean("memberService",MemberService.class);
		ms.join();

	}
	
	public static void main(String[] args) {
		new MainAnno();
	}
}
