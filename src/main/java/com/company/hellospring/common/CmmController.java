package com.company.hellospring.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CmmController {
	/**
	* validator rule dynamic Javascript
	*/
	@RequestMapping("/validator.do")
	public String validate() {
		return "popup/cmm/validator";
	}
}
