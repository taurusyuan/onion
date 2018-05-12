package io.renren.modules.onion.service;

import io.renren.modules.onion.entity.FeedbackEntity;

import java.util.List;
import java.util.Map;

/**
 * 反馈意见表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-04-18 17:45:19
 */
public interface FeedbackService {
	
	FeedbackEntity queryObject(Long id);
	
	List<FeedbackEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(FeedbackEntity feedback);
	
	void update(FeedbackEntity feedback);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
