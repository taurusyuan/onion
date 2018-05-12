package io.renren.modules.onion.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import io.renren.modules.onion.dao.BookDao;
import io.renren.modules.onion.entity.BookEntity;
import io.renren.modules.onion.service.BookService;



@Service("bookService")
public class BookServiceImpl implements BookService {
	@Autowired
	private BookDao bookDao;
	
	@Override
	public BookEntity queryObject(Long id){
		return bookDao.queryObject(id);
	}
	
	@Override
	public List<BookEntity> queryList(Map<String, Object> map){
		return bookDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return bookDao.queryTotal(map);
	}
	
	@Override
	public void save(BookEntity book){
		bookDao.save(book);
	}
	
	@Override
	public void update(BookEntity book){
		bookDao.update(book);
	}
	
	@Override
	public void delete(Long id){
		bookDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		bookDao.deleteBatch(ids);
	}
	
}
