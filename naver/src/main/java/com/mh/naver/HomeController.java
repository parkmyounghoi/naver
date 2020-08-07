package com.mh.naver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mh.naver.dao.MemberDAO;
import com.sun.istack.internal.Nullable;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	MemberDAO memberDao;
	
	@GetMapping("/hello")
	public String hello(
						@RequestParam(required = false, value = "name") String name
						, Model model) {
		System.out.println("name = " + name);
		model.addAttribute("hello","hello ~~~");
		return "hello";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "site/main";
	}
	
	@RequestMapping(value = "/dstest", method = RequestMethod.GET)
	public String dstest(Locale locale, Model model) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement("select * from member");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));
				System.out.println(rs.getString(5));
			}
			
			conn.commit();
		}catch (Exception e) {
			e.printStackTrace();
//			conn.rollback();
		}finally {
			try {
				if(rs!=null)
					rs.close();
				if(pstmt!=null)
					pstmt.close();
				if(conn!=null)
					conn.close();
			}catch (Exception e) {
			}
		}
		return "dstest";
	}
	
	@RequestMapping(value = "/dstest2", method = RequestMethod.GET)
	public String dstest2() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		List<MemberDTO> list = jdbcTemplate.query("select * from member where email=?",
				new RowMapper<MemberDTO>() {
			@Override
			public MemberDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				MemberDTO memberDTO = new MemberDTO(rs.getInt(1),
						rs.getString(2),
						rs.getString(3), 
						rs.getString(4),
						rs.getString(5) );
				return memberDTO;
			}
		},"dron512@naver.com");
		
		for(MemberDTO md : list) {
			System.out.println("md = "+ md);
		}
		
		int rowCnt = jdbcTemplate.queryForObject("select count(*) from member", Integer.class);
		System.out.println("행 갯수 = "+rowCnt);
		
		jdbcTemplate.update("update member set password='aaa'");
		jdbcTemplate.update("update member set password=? where email=?","bbb","dron512@naver.com");
		
//		jdbcTemplate.update("insert into member " + 
//							"(EMAIL,PASSWORD,NAME,REGDATE) " + 
//							"values " + 
//							"('ddd@naver.com','5555','kim',now())");
		KeyHolder keyholder = new GeneratedKeyHolder();
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement("insert into member " + 
						"(EMAIL,PASSWORD,NAME,REGDATE) " + 
						"values " + 
						"('fff@naver.com','5555','kim',now())",new String[] {"ID"});
				return pstmt;
			}
		},keyholder);
		
		Number keyValue = keyholder.getKey();
		System.out.println("keyValue = "+keyValue);
				
//		A a = new A() {
//			@Override
//			public void doA() {
//				// TODO Auto-generated method stub
//			}
//		};
		return "dstest";
	}
	
	// insert 시에는 해당되는 email 이 없으면 insert
	@RequestMapping(value = "/member", method = RequestMethod.GET)
	public String member(Locale locale, Model model) {
		return "member";
	}
	
	// insert 시에는 해당되는 email 이 없으면 insert
	@RequestMapping(value = "/memberinsert", method = RequestMethod.GET)
	public String memberinsert(MemberDTO md) {
		System.out.println("md = "+ md);
		MemberDTO newMd = memberDao.selectOne(md);
		if(newMd == null) {
			memberDao.insert(md);
			System.out.println("insert 했습니다.");
		}
		else {
			System.out.println("ggg@naver.com 메일은 이미 존재 합니다.");
		}
		return "result";
	}

	// update 시에는 해당되는 email 이 있으면 update
	@RequestMapping(value = "/memberupdate", method = RequestMethod.GET)
	public String memberupdate(MemberDTO md, Model model) {
		memberDao.update(md);
		model.addAttribute("result", "update");
		return "result";
	}
	
	// insert 시에는 해당되는 email 이 없으면 delete
	@RequestMapping(value = "/memberdelete", method = RequestMethod.GET)
	public String memberdelete(MemberDTO md, Model model) {
		model.addAttribute("result", "delete");
		memberDao.delete(md);
		return "result";
	}
	
	// 모든 내용 뿌려주기
	// 커맨드 객체 내용 없을시... 기본생성자...생성 필수..
	@RequestMapping(value = "/memberselect", method = RequestMethod.GET)
	public String memberselect(MemberDTO md, Model model) {
		model.addAttribute("result", "select");
		List<MemberDTO> list = memberDao.selectAll();
		model.addAttribute("list",list);
		return "result";
	}
	
	@RequestMapping(value = "/membertrac", method = RequestMethod.GET)
	@Transactional
	public String membertrac(MemberDTO md, Model model) {
		model.addAttribute("result", "trac");
		try {
			memberDao.insert(md);
			memberDao.update(md);
			memberDao.delete(md);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "result";
	}
	
		
		
}

//interface A {
//	public void doA();
//}











