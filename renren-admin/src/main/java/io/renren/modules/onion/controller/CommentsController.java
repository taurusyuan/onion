package io.renren.modules.onion.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import io.renren.common.exception.RRException;
import io.renren.common.utils.*;
import io.renren.modules.onion.entity.BookEntity;
import io.renren.modules.onion.entity.CommentReplyEntity;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.onion.entity.CommentsEntity;
import io.renren.modules.onion.service.CommentsService;

import javax.servlet.http.HttpServletResponse;

/**
 * 图书评论表
 * @date 2018-04-18 17:45:19
 */
@RestController
@RequestMapping("comments")
public class CommentsController {
	@Autowired
	private CommentsService commentsService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("comments:list")

	public R list(String probedata, Integer page, Integer limit){
		//查询列表数据
		Map<String, Object> map = new HashMap<>();
		JSONObject probedata_jsonobject = JSONObject.parseObject(probedata);
		try {
			map.putAll(JSONUtils.jsonToMap(probedata_jsonobject));
		} catch (RuntimeException e) {
			throw new RRException("内部参数错误，请重试！");
		}
		int total = 0;
		if (page == null) {              /*没有传入page,则取全部值*/
			map.put("offset", null);
			map.put("limit", null);
			page = 0;
			limit = 0;
		} else {
			map.put("offset", (page - 1) * limit);
			map.put("limit", limit);
			total = commentsService.queryTotal(map);
		}
		List<CommentsEntity> commentsList = commentsService.queryList(map);
		PageUtils pageUtil = new PageUtils(commentsList, total, limit, page);
		return R.ok().put("page", pageUtil);
	}


	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("comments:info")
	public R info(@PathVariable("id") Long id){
		CommentsEntity comments = commentsService.queryObject(id);
		return R.ok().put("comments", comments);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("comments:save")
	public R save(@RequestBody CommentsEntity comments){
		commentsService.save(comments);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("comments:update")
	public R update(@RequestBody CommentsEntity comments){
		commentsService.update(comments);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("comments:delete")
	public R delete(@RequestBody Long[] ids){
		commentsService.deleteBatch(ids);
		return R.ok();
	}
	/**
	 * 导出
	 */
	@RequestMapping("/download")
	@RequiresPermissions("comments:download")
	public void downloadProbe(HttpServletResponse response) throws RRException {
		Map<String, Object> map = new HashMap<>();
		List<CommentsEntity> commentsList = commentsService.queryList(map);
		CollectionToFile.collectionToFile(response, commentsList, CommentsEntity.class);
	}
}
