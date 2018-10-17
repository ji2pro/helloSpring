package com.company.hellospring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	
	@Autowired
	UserDAO userDAO;
	
	@RequestMapping("/getUsers.do")
	public String getUsers(Model model) {
		model.addAttribute("list", userDAO.getUsers());
		return "user/getUsers";
	}
	
	@RequestMapping("/updateUserForm.do")
	public String updateUserForm(Model model, UserDTO dto) {
		model.addAttribute("user", userDAO.getUser(dto));
		return "user/updateUser";
	}
}
