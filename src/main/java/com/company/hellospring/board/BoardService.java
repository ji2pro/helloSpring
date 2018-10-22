package com.company.hellospring.board;

import java.util.List;

public interface BoardService {
	//전체 조회
	public List<BoardDTO> getBoards();
	//단건 조회
	public BoardDTO getBoard(BoardDTO dto);
	//등록
	public int insertBoard(BoardDTO dto);
	//수정
	public int updateBoard(BoardDTO dto);
	//삭제
	public int deleteBoard(BoardDTO dto);
}
