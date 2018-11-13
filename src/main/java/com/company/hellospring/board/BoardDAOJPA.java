package com.company.hellospring.board;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class BoardDAOJPA {
	@PersistenceContext
	private EntityManager em;

	// 등록
	public int insertBoard(BoardDTO dto) {
		em.persist(dto);
		return 0;
	}
	// 수정
	public int updateBoard(BoardDTO dto) {
		em.merge(dto);
		return 0;
	}
	// 삭제
	public int deleteBoard(BoardDTO dto) {
		em.remove(em.find(BoardDTO.class, dto.getSeq()));
		return 0;
	}
	// 전체 조회
	public List<BoardDTO> getBoards(BoardDTO dto) {
		System.out.println("===> JPA로 getBoards() 기능 처리");
		return em.createQuery("from BoardDTO b").getResultList();
	}
	// 단건 조회
	public BoardDTO getBoard(BoardDTO dto) {
		return (BoardDTO)em.find(BoardDTO.class, dto.getSeq());
	}
	public int getCount(BoardDTO dto) {
		System.out.println("===> JPA로 getCount() 기능 처리");
		return ((Long)em.createQuery("select count(b) from BoardVO b")  //from은 테이블이 아닌 DTO(VO) 기준
				.getSingleResult()).intValue();
	}
}
