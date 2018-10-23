package com.company.hellospring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.hellospring.board.BoardDAOMybatis;
import com.company.hellospring.board.BoardDTO;
import com.company.hellospring.emp.EmpDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:servlet-context-test.xml")

public class EmpDAOClient {
	@Autowired EmpDAO dao;
	@Autowired BoardDAOMybatis boardDAO;
	
	@Test
	public void getCnt() {
		//System.out.println("전체 건수 : " + dao.getCnt());
		/*List<EmpDTO> list = dao.getSalaryTop3();
		for(EmpDTO emp : list) {
			System.out.println(emp.getFirstName() + " " +
							   emp.getEmployeeId() + " : " +
							   emp.getSalary());
		}*/
		/*EmpDTO dto = new EmpDTO();
		//dto.setFirstName("Den");
		dto.setDepartmentId("110");
		dto.setSalary("7000");
		List<EmpDTO> list = dao.getEmps(dto);
		System.out.println("조회건수 : " + list.size());
		for(EmpDTO emp : list) {
			System.out.println(emp);
		}*/
		/*List<Map<String,Object>> list = dao.getEmpDept();
		//System.out.println(list);
		for(int i=0; i<list.size(); i++) {
			HashMap<String, Object> map = (HashMap<String, Object>)list.get(i);
			System.out.println(map.get("deptName") +
							   " 부서의 " +
							   map.get("fName"));
		}
		
		EmpDTO dto = new EmpDTO();
		dto.setLastName("홍길동");
		dto.setEmail("f@b.c");
		dto.setHireDate("2018/01/01");
		dto.setJobId("IT_PROG");
		dao.insertEmp(dto);
		System.out.println("등록 사원번호 : " + dto.getEmployeeId());*/
		
		//게시글 등록
		BoardDTO dto = new BoardDTO();
		dto.setTitle("프로시저 테스트");
		dto.setWriter("폴 피닉스");
		dto.setContent("등록 테스트입니다.");
		boardDAO.insertBoardProc(dto);
		System.out.println(dto.getSeq());
		System.out.println(dto.getOut_msg());
	}
}
