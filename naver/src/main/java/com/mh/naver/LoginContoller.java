package com.mh.naver;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.scribejava.core.model.OAuth2AccessToken;

@Controller
public class LoginContoller {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	NaverLoginBO naverLoginBO;

	@RequestMapping(value = "/naverLogin", method = RequestMethod.GET)
	public ModelAndView naverLogin(HttpSession session) {
		/* �׾Ʒ� ���� URL�� �����ϱ� ���Ͽ� getAuthorizationUrl�� ȣ�� */
		String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);

//		model.addAttribute("url",naverAuthUrl);
		return new ModelAndView("login/naverLogin", "url", naverAuthUrl);
	}

	@RequestMapping(value = "/callback", method = RequestMethod.GET)
	public String callback(@RequestParam String code,
							@RequestParam String state,
							HttpSession session, Model model,
							UserVO vo) throws Exception {
		/* �׾Ʒ� ������ ���������� �Ϸ�Ǹ� code �Ķ���Ͱ� ���޵Ǹ� �̸� ���� access token�� �߱� */
		logger.info("naver login............");
		JsonParser json = new JsonParser();

		OAuth2AccessToken oauthToken = naverLoginBO.getAccessToken(session, code, state);
		
		String apiResult = naverLoginBO.getUserProfile(oauthToken);
		logger.info("apiResult = "+apiResult);
		//apiResult = 
//		{"resultcode":"00","message":"success",
//		 "response":{"id":"29275747","email":"dron512@naver.com"}}
		vo = json.changeJson(apiResult); // vo�� userEmail, userGender, userNaver ����
		System.out.println("vo = "+ vo);
//		if (service.selectNaver(vo) > 0) { // ���Ǹ����
			session.setAttribute("login", vo);
//		} else {
//			service.insertNaver(vo);
//			session.setAttribute("login", vo);
//		}

		return "/login/callback";
	}

}