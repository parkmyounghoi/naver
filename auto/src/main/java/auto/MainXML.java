package auto;

import org.springframework.context.support.GenericXmlApplicationContext;

import auto.service.MemberService;

public class MainXML {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext gxac = 
				new GenericXmlApplicationContext("MyConf.xml");
		
		String[] beans = gxac.getBeanDefinitionNames();
		
		for (int i = 0; i < beans.length; i++) {
			System.out.println("beans["+i+"]"+beans[i]);
		}
		
		MemberService ms = gxac.getBean("memberService",MemberService.class);
		ms.join();
	}
}
