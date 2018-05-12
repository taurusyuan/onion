package io.renren.modules.onion.service;

import io.renren.modules.onion.entity.CommentsEntity;

import java.util.List;
import java.util.Map;

/**
 * 图书评论表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-04-18 17:45:19
 */
public interface CommentsService {
	
	CommentsEntity queryObject(Long id);
	
	List<CommentsEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(CommentsEntity comments);
	
	void update(CommentsEntity comments);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
