package io.renren.modules.onion.service;

import io.renren.modules.onion.entity.WordsBanEntity;

import java.util.List;
import java.util.Map;

/**
 * 违禁词条表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-04-18 17:45:19
 */
public interface WordsBanService {
	
	WordsBanEntity queryObject(Long id);
	
	List<WordsBanEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(WordsBanEntity wordsBan);
	
	void update(WordsBanEntity wordsBan);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
