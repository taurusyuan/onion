package io.renren.modules.onion.service;

import io.renren.modules.onion.entity.BookClassificationEntity;

import java.util.List;
import java.util.Map;

/**
 * 图书分类字典表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-04-14 15:53:03
 */
public interface BookClassificationService {
	
	BookClassificationEntity queryObject(Long id);
	
	List<BookClassificationEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(BookClassificationEntity bookClassification);
	
	void update(BookClassificationEntity bookClassification);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
