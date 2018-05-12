package io.renren.modules.onion.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import io.renren.modules.onion.dao.WordsBanDao;
import io.renren.modules.onion.entity.WordsBanEntity;
import io.renren.modules.onion.service.WordsBanService;



@Service("wordsBanService")
public class WordsBanServiceImpl implements WordsBanService {
	@Autowired
	private WordsBanDao wordsBanDao;
	
	@Override
	public WordsBanEntity queryObject(Long id){
		return wordsBanDao.queryObject(id);
	}
	
	@Override
	public List<WordsBanEntity> queryList(Map<String, Object> map){
		return wordsBanDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return wordsBanDao.queryTotal(map);
	}
	
	@Override
	public void save(WordsBanEntity wordsBan){
		wordsBanDao.save(wordsBan);
	}
	
	@Override
	public void update(WordsBanEntity wordsBan){
		wordsBanDao.update(wordsBan);
	}
	
	@Override
	public void delete(Long id){
		wordsBanDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		wordsBanDao.deleteBatch(ids);
	}
	
}
