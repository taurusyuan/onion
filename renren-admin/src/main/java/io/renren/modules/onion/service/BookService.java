package io.renren.modules.onion.service;

import io.renren.modules.onion.entity.BookEntity;

import java.util.List;
import java.util.Map;

/**
 * 图书信息表
 *
 * @date 2018-04-14 15:53:03
 */
public interface BookService {
	
	BookEntity queryObject(Long id);
	
	List<BookEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(BookEntity book);
	
	void update(BookEntity book);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
