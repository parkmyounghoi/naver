package com.munggu.org.freeboard;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.munggu.org.Mvc_Board;

@Controller
public class FreeBoardController {

	@Autowired
	private SqlSession ss;
	
	@RequestMapping(value="/freeboard")
	public String index(Model model, HttpSession session,@RequestParam(defaultValue="1") String pageNum) {
		
		System.out.println("소스 수정");
		String pageCount = ss.selectOne("a.selectPageCount");
		int start = 1;
		int end = 5;
		int pageView = 5;
		
		if( !pageNum.equals("1") ) {
			start = ( Integer.parseInt(pageNum) -1 ) * pageView + 1 ;
			end = start + 4;
		}
		
		session.setAttribute("menu", "freeboard");
		
		Page page = new Page();
		page.setStart(start);
		page.setEnd(end);
		
		List<Mvc_Board> list = ss.selectList("a.selectPage",page);
		
		for( Mvc_Board temp : list) {
			System.out.println(temp);
		}
		
		model.addAttribute("list",list);
		model.addAttribute("pageCount",pageCount);
		
		return "freeboard/index";
	}
	
	@RequestMapping(value="/freeboard/insert")
	public String freebaordInsert(Model model) {
		return "freeboard/insert";
	}
	
	@RequestMapping(value="/freeboard/save")
	public String freebaordSave(Model model, 
			@RequestParam(defaultValue="") String btitle,
			@RequestParam(defaultValue="") String bcontent,
			Mvc_Board mb) {
		
		mb.setBname("작성자입니다.");
		
		ss.insert("a.insertMvc_Board",mb);
		
		return "redirect:/freeboard";
	}
}







