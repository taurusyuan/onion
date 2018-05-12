package io.renren.modules.onion.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import io.renren.modules.onion.dao.FeedbackTypeDao;
import io.renren.modules.onion.entity.FeedbackTypeEntity;
import io.renren.modules.onion.service.FeedbackTypeService;



@Service("feedbackTypeService")
public class FeedbackTypeServiceImpl implements FeedbackTypeService {
	@Autowired
	private FeedbackTypeDao feedbackTypeDao;
	
	@Override
	public FeedbackTypeEntity queryObject(Long id){
		return feedbackTypeDao.queryObject(id);
	}
	
	@Override
	public List<FeedbackTypeEntity> queryList(Map<String, Object> map){
		return feedbackTypeDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return feedbackTypeDao.queryTotal(map);
	}
	
	@Override
	public void save(FeedbackTypeEntity feedbackType){
		feedbackTypeDao.save(feedbackType);
	}
	
	@Override
	public void update(FeedbackTypeEntity feedbackType){
		feedbackTypeDao.update(feedbackType);
	}
	
	@Override
	public void delete(Long id){
		feedbackTypeDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		feedbackTypeDao.deleteBatch(ids);
	}
	
}
