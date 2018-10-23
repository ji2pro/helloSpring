package com.company.hellospring;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.company.hellospring.emp.EmpDTO;

/*
 * List, Set, Map
 */
public class CollectionTest {
	public static void main(String[] args) {
		//List test
		List<String> list = new ArrayList<String>();
		//추가
		list.add("바나나");
		list.add("사과");
		list.add(0,"딸기");
		//변경
		list.set(1,"포도");
		//System.out.println(list);
		//조회
		//System.out.println(list.get(1));
		//삭제
		list.remove(1);
		//System.out.println(list);
		//전체 조회
		//일반 for문
		System.out.println("일반 for문 ======================");
		for(int i=0; i<list.size(); i++) {
			String temp = list.get(i);
			System.out.println(temp);
		}
		//확장 for문
		System.out.println("확장 for문 ======================");
		for(String temp:list) {
			System.out.println(temp);
		}
		//iterator
		System.out.println("iterator ========================");
		Iterator<String> iter = list.iterator();
		while(iter.hasNext()) {
			String temp = iter.next();
			System.out.println(temp);
		}
		
		
		List<EmpDTO> empList = new ArrayList<EmpDTO>();
		//추가
		empList.add(new EmpDTO("100", "kim", "a@b.c", "99/11/01", "IT"));
		empList.add(new EmpDTO("101", "park", "b@b.c", "99/11/01", "IT"));
		empList.add(new EmpDTO("102", "choi", "c@b.c", "99/11/01", "IT"));
		System.out.println(empList);
		//전체 조회
		System.out.println("확장 for문 ======================");
		for(EmpDTO tempEmp : empList) {
			System.out.println(tempEmp.getEmployeeId() + tempEmp.getLastName());
		}
		//iterator
		System.out.println("iterator ========================");
		Iterator<EmpDTO> empIter = empList.iterator();
		while(empIter.hasNext()) {
			EmpDTO temp = empIter.next(); 
			System.out.println(temp.getEmployeeId() + temp.getLastName());
		}
	}
}
