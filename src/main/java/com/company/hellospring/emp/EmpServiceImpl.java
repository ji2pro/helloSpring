package com.company.hellospring.emp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpServiceImpl implements EmpService {
	@Autowired EmpDAO dao;

	public List<Map<String, Object>> getEmpChart() {
		return dao.getEmpChart();
	}
}
