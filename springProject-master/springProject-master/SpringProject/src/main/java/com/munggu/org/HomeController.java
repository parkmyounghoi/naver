package com.munggu.org;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private TestSigleTon tt1;
	@Autowired
	private TestSigleTon tt2;
	@Autowired
	private TestSigleTon tt3;
	
	@Autowired
	private BasicDataSource ds;
	
	@Autowired
	private SqlSession ss;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, HttpSession session) {
		
		session.setAttribute("menu", "home");
		
		// ctrl + shift + c 주석 설정
//		System.out.println(tt1.getA());
//		System.out.println(tt2);
//		System.out.println(tt3);
//		
//		System.out.println(ds);
//		try {
//			Connection conn = ds.getConnection();
//			System.out.println("연결 잘 되어져 있음.");
//			PreparedStatement pstmt = conn.prepareStatement("insert into aaa " + 
//															" (idx,id,remark) " + 
//															" values " + 
//															" ((select max(idx)+1 from aaa),'id','remark')");
//			pstmt.executeUpdate();
//			pstmt.close();
//			conn.close();
//		}catch (Exception e) {
//			e.printStackTrace();
//		} 
		return "home";
	}
	
}




