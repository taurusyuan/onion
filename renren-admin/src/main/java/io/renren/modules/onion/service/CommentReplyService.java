package io.renren.modules.onion.service;

import io.renren.modules.onion.entity.CommentReplyEntity;

import java.util.List;
import java.util.Map;

/**
 * 评论回复表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-04-18 17:45:19
 */
public interface CommentReplyService {
	
	CommentReplyEntity queryObject(Long id);
	
	List<CommentReplyEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(CommentReplyEntity commentReply);
	
	void update(CommentReplyEntity commentReply);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
