package io.renren.modules.onion.service;

import io.renren.modules.onion.entity.ReadingNotesEntity;

import java.util.List;
import java.util.Map;

/**
 * 读书笔记表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-04-17 11:27:20
 */
public interface ReadingNotesService {
	
	ReadingNotesEntity queryObject(Long id);
	
	List<ReadingNotesEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ReadingNotesEntity readingNotes);
	
	void update(ReadingNotesEntity readingNotes);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
