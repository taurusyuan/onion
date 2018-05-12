package io.renren.modules.onion.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import io.renren.modules.onion.dao.FeedbackDao;
import io.renren.modules.onion.entity.FeedbackEntity;
import io.renren.modules.onion.service.FeedbackService;



@Service("feedbackService")
public class FeedbackServiceImpl implements FeedbackService {
	@Autowired
	private FeedbackDao feedbackDao;
	
	@Override
	public FeedbackEntity queryObject(Long id){
		return feedbackDao.queryObject(id);
	}
	
	@Override
	public List<FeedbackEntity> queryList(Map<String, Object> map){
		return feedbackDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return feedbackDao.queryTotal(map);
	}
	
	@Override
	public void save(FeedbackEntity feedback){
		feedbackDao.save(feedback);
	}
	
	@Override
	public void update(FeedbackEntity feedback){
		feedbackDao.update(feedback);
	}
	
	@Override
	public void delete(Long id){
		feedbackDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		feedbackDao.deleteBatch(ids);
	}
	
}
