package com.company.hellospring;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.hellospring.emp.EmpService;

@Controller
public class ChartController {
	@Autowired EmpService empService; 
	
	@RequestMapping("/getEmpChart.do")
	@ResponseBody
	public List<Map<String, Object>> getEmpChart() {
		//부서별 사원 수
		return empService.getEmpChart();
	}
}
