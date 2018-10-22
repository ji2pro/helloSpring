package com.company.hellospring;

import java.util.List;

public interface UserService {

	//등록
	public int insertUser(UserDTO dto);
	//수정
	public int updateUser(UserDTO dto);
	//삭제(회원 탈퇴)
	public int deleteUser(UserDTO dto);
	//단건 조회
	public UserDTO getUser(UserDTO dto);
	//전체 조회(검색)
	public List<UserDTO> getUsers();
}
