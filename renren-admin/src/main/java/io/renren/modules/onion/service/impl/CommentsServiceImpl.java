package io.renren.modules.onion.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import io.renren.modules.onion.dao.CommentsDao;
import io.renren.modules.onion.entity.CommentsEntity;
import io.renren.modules.onion.service.CommentsService;



@Service("commentsService")
public class CommentsServiceImpl implements CommentsService {
	@Autowired
	private CommentsDao commentsDao;
	
	@Override
	public CommentsEntity queryObject(Long id){
		return commentsDao.queryObject(id);
	}
	
	@Override
	public List<CommentsEntity> queryList(Map<String, Object> map){
		return commentsDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return commentsDao.queryTotal(map);
	}
	
	@Override
	public void save(CommentsEntity comments){
		commentsDao.save(comments);
	}
	
	@Override
	public void update(CommentsEntity comments){
		commentsDao.update(comments);
	}
	
	@Override
	public void delete(Long id){
		commentsDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		commentsDao.deleteBatch(ids);
	}
	
}
