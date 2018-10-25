package com.company.hellospring;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.company.hellospring.common.Paging;

@Controller
public class UserController {
	@Autowired  //DI(Dependency Injection)
	UserService userService;
	
	@ModelAttribute("roleMap")  //model.addAttribute("roleMap", map)
	public Map<String, String> roleMap() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("admin", "관리자");
		map.put("user", "사용자");
		map.put("super", "최고관리자");
		return map;
	}
	
	@RequestMapping("/getUsers.do")
	public ModelAndView getUsers(ModelAndView mv,
								 UserSearchDTO searchDto,
								 Paging paging) {
		//조회할 레코드 건수
		paging.setPageUnit(3);
		
		//현재 페이지 번호. 없으면 1page로 설정
		if(paging.getPage() == null) {
			paging.setPage(1);
		}
		//전체 건수
		int total = userService.getCnt(searchDto);
		paging.setTotalRecord(total);
		mv.addObject("pagning", paging);
		
		//시작/마지막 레코드 번호
		searchDto.setStart(paging.getFirst());
		searchDto.setEnd(paging.getLast());
		mv.addObject("list", userService.getUsers(searchDto));
		
		mv.setViewName("user/getUsers");
		return mv;
	}
	//수정 폼
	@RequestMapping("/updateUserForm.do")
	public String updateUserForm(Model model, UserDTO dto) {
		model.addAttribute("user", userService.getUser(dto));
		return "user/updateUser";
	}
	//수정 처리
	@RequestMapping("/updateUser.do")
	public String updateUser(Model model, UserDTO dto) {
		model.addAttribute("user", userService.updateUser(dto));
		return "redirect:/getUsers.do";
	}
	//등록 폼
	@RequestMapping("/insertUserForm.do")
	public String insertUserForm(Model model, UserDTO dto) {
		return "user/insertUser";
	}
	//등록 처리
	@RequestMapping("/insertUser.do")
	public String insertUser(Model model, UserDTO dto) {
		model.addAttribute("user", userService.insertUser(dto));
		return "redirect:/getUsers.do";
	}
}
