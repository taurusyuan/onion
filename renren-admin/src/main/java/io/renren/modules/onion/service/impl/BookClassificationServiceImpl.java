package io.renren.modules.onion.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import io.renren.modules.onion.dao.BookClassificationDao;
import io.renren.modules.onion.entity.BookClassificationEntity;
import io.renren.modules.onion.service.BookClassificationService;



@Service("bookClassificationService")
public class BookClassificationServiceImpl implements BookClassificationService {
	@Autowired
	private BookClassificationDao bookClassificationDao;
	
	@Override
	public BookClassificationEntity queryObject(Long id){
		return bookClassificationDao.queryObject(id);
	}
	
	@Override
	public List<BookClassificationEntity> queryList(Map<String, Object> map){
		return bookClassificationDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return bookClassificationDao.queryTotal(map);
	}
	
	@Override
	public void save(BookClassificationEntity bookClassification){
		bookClassificationDao.save(bookClassification);
	}
	
	@Override
	public void update(BookClassificationEntity bookClassification){
		bookClassificationDao.update(bookClassification);
	}
	
	@Override
	public void delete(Long id){
		bookClassificationDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		bookClassificationDao.deleteBatch(ids);
	}
	
}
