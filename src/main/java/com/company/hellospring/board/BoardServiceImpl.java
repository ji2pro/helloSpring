package com.company.hellospring.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	@Autowired
	//BoardDAOMybatis dao;
	BoardDAOJPA dao;

	public List<BoardDTO> getBoards() {
		return dao.getBoards(null);
	}
	public BoardDTO getBoard(BoardDTO dto) {
		return dao.getBoard(dto);
	}
	public int insertBoard(BoardDTO dto) {
		dao.insertBoard(dto);
		return 0;
	}
	public int updateBoard(BoardDTO dto) {
		return 0;
	}
	public int deleteBoard(BoardDTO dto) {
		return 0;
	}	
}