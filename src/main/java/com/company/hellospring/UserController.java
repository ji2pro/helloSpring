package com.company.hellospring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	
	@Autowired  //DI(Dependency Injection)
	UserService userService;
	
	@RequestMapping("/getUsers.do")
	public String getUsers(Model model) {
		model.addAttribute("list", userService.getUsers());
		return "user/getUsers";
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
