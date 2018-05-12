package io.renren.modules.onion.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import io.renren.modules.onion.dao.CommentReplyDao;
import io.renren.modules.onion.entity.CommentReplyEntity;
import io.renren.modules.onion.service.CommentReplyService;



@Service("commentReplyService")
public class CommentReplyServiceImpl implements CommentReplyService {
	@Autowired
	private CommentReplyDao commentReplyDao;
	
	@Override
	public CommentReplyEntity queryObject(Long id){
		return commentReplyDao.queryObject(id);
	}
	
	@Override
	public List<CommentReplyEntity> queryList(Map<String, Object> map){
		return commentReplyDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return commentReplyDao.queryTotal(map);
	}
	
	@Override
	public void save(CommentReplyEntity commentReply){
		commentReplyDao.save(commentReply);
	}
	
	@Override
	public void update(CommentReplyEntity commentReply){
		commentReplyDao.update(commentReply);
	}
	
	@Override
	public void delete(Long id){
		commentReplyDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		commentReplyDao.deleteBatch(ids);
	}
	
}
