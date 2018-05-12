package io.renren.modules.onion.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import io.renren.modules.onion.dao.ReadingNotesDao;
import io.renren.modules.onion.entity.ReadingNotesEntity;
import io.renren.modules.onion.service.ReadingNotesService;



@Service("readingNotesService")
public class ReadingNotesServiceImpl implements ReadingNotesService {
	@Autowired
	private ReadingNotesDao readingNotesDao;
	
	@Override
	public ReadingNotesEntity queryObject(Long id){
		return readingNotesDao.queryObject(id);
	}
	
	@Override
	public List<ReadingNotesEntity> queryList(Map<String, Object> map){
		return readingNotesDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return readingNotesDao.queryTotal(map);
	}
	
	@Override
	public void save(ReadingNotesEntity readingNotes){
		readingNotesDao.save(readingNotes);
	}
	
	@Override
	public void update(ReadingNotesEntity readingNotes){
		readingNotesDao.update(readingNotes);
	}
	
	@Override
	public void delete(Long id){
		readingNotesDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		readingNotesDao.deleteBatch(ids);
	}
	
}
