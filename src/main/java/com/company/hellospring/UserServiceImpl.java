package com.company.hellospring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service  //빈 등록
public class UserServiceImpl implements UserService {
	//Log4jAdvice log4jAdvice = new Log4jAdvice();	
	//DI
	//@Autowired UserDAO dao;
	//@Autowired UserDAOSpring dao;
	@Autowired UserDAOMybatis dao;
	
	public int insertUser(UserDTO dto) {
//		dao.insertUser(dto);
		return dao.insertUser(dto);  //핵심관심
	}
	public UserDTO getUser(UserDTO dto) {
		return dao.getUser(dto);  //핵심관심
	}
	public List<UserDTO> getUsers(UserSearchDTO searchDto) {
		//int a = 5/0;
		System.out.println("사용자 목록 조회");
		return dao.getUsers(searchDto);  //핵심관심
	}
	public int updateUser(UserDTO dto) {
		return dao.updateUser(dto);
	}
	public int deleteUser(UserDTO dto) {
		return dao.deleteUser(dto);
	}
	@Override
	public int getCnt(UserSearchDTO searchDto) {
		return dao.getCnt(searchDto);
	}
}
