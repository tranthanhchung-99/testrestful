package com.linkin.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.linkin.dao.CommentDao;
import com.linkin.entity.Comment;
import com.linkin.entity.Product;
import com.linkin.entity.User;
import com.linkin.model.CommentDTO;
import com.linkin.service.CommentService;

@Transactional
@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDao commentDao;

	@Override
	public void insert(CommentDTO commentDTO) {
		Comment comment = new Comment();
		comment.setComment(commentDTO.getComment());
		comment.setProduct(new Product(commentDTO.getProductId()));
		comment.setUser(new User(commentDTO.getUserId()));
		comment.setCommentDate(new Date());
		commentDao.insert(comment);

	}

	@Override
	public void update(CommentDTO commentDTO) {
		Comment comment = commentDao.get(commentDTO.getId());
		if (comment != null) {
			comment.setComment(commentDTO.getComment());
			commentDao.update(comment);
		}

	}

	@Override
	public void delete(Long id) {
		Comment comment = commentDao.get(id);
		if (comment != null) {
			commentDao.delete(id);
		}
	}

	@Override
	public CommentDTO get(Long id) {
		return null;
	}

	@Override
	public List<CommentDTO> searchByProduct(Long id) {
		List<Comment> listComments= commentDao.searchByProduct(id);
		List<CommentDTO> commentDTOs= new ArrayList<>();
		for(Comment comment:listComments) {
			CommentDTO commentDTO= new CommentDTO();
			commentDTO.setComment(comment.getComment());
			commentDTO.setCommentDate(String.valueOf(comment.getCommentDate()));
			commentDTO.setProductId(comment.getProduct().getId());
			commentDTOs.add(commentDTO);
		}
		return commentDTOs;
	}
	}

