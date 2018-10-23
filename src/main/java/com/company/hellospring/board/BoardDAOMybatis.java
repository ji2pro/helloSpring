package com.company.hellospring.board;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAOMybatis {
	@Autowired
	SqlSessionTemplate mybatis;

	// 전체 조회
	public List<BoardDTO> getBoards() {
		System.out.println("board mybatis 목록 조회 ===");
		return mybatis.selectList("board.getBoards");
	}

	// 단건 조회
	public BoardDTO getBoard(BoardDTO dto) {
		return null;
	}

	// 등록
	public int insertBoard(BoardDTO dto) {
		return mybatis.insert("board.insertBoard");
	}
	
	public int insertBoardProc(BoardDTO dto) {
		return mybatis.insert("board.insertBoardProc", dto);
	}

	// 수정
	public int updateBoard(BoardDTO dto) {
		return 0;
	}

	// 삭제
	public int deleteBoard(BoardDTO dto) {
		return 0;
	}
}
