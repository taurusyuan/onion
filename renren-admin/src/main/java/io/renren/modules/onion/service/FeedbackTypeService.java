package io.renren.modules.onion.service;

import io.renren.modules.onion.entity.FeedbackTypeEntity;

import java.util.List;
import java.util.Map;

/**
 * 反馈类型字典表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-04-19 15:30:11
 */
public interface FeedbackTypeService {
	
	FeedbackTypeEntity queryObject(Long id);
	
	List<FeedbackTypeEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(FeedbackTypeEntity feedbackType);
	
	void update(FeedbackTypeEntity feedbackType);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
