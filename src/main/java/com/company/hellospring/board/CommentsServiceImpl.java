package com.company.hellospring.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("commentsService")
public class CommentsServiceImpl implements CommentsService {

	@Autowired
	CommentsMybatisDAO dao;
	
	public void insertComments(CommentsVO vo) {
		dao.insertComments(vo);
	}
	public void updateComments(CommentsVO vo) {
		dao.updateComments(vo);
	}
	public void deleteComments(CommentsVO vo) {
		dao.deleteComments(vo);
	}	
	public List<CommentsVO> getCommentsList(CommentsVO vo) {
		return dao.getCommentsList(vo);
	}
	public CommentsVO getComments(CommentsVO vo) {
		return dao.getComments(vo);
	}
}
