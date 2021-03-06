package auto;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import auto.conf.MyCtx;
import auto.service.MemberService;

// 아래 git에 책 소스 올렸져 있어요.
// https://github.com/parkmyounghoi/spring5
public class MainAnno {

	public static void main(String[] args) {
		
		
		AnnotationConfigApplicationContext acac =
				new AnnotationConfigApplicationContext(MyCtx.class);

		MemberService ms = acac.getBean("memberService",MemberService.class);
		ms.join();
	}
}
