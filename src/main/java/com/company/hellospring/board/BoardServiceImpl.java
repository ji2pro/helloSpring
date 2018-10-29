package com.company.hellospring.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired BoardDAOMybatis dao;

	public List<BoardDTO> getBoards() {
		return dao.getBoards();
	}
	public BoardDTO getBoard(BoardDTO dto) {
		return null;
	}
	public int insertBoard(BoardDTO dto) {
		return dao.insertBoardProc(dto);
	}
	public int updateBoard(BoardDTO dto) {
		return 0;
	}
	public int deleteBoard(BoardDTO dto) {
		return 0;
	}	
}