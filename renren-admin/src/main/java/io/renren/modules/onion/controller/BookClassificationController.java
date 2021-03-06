package io.renren.modules.onion.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import io.renren.common.exception.RRException;
import io.renren.common.utils.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.onion.entity.BookClassificationEntity;
import io.renren.modules.onion.service.BookClassificationService;

import javax.servlet.http.HttpServletResponse;


/**
 * 图书分类字典表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-04-14 15:53:03
 */
@RestController
@RequestMapping("bookclassification")
public class BookClassificationController {
	@Autowired
	private BookClassificationService bookClassificationService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("bookclassification:list")
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
			total = bookClassificationService.queryTotal(map);
		}

		List<BookClassificationEntity> bookClassificationList = bookClassificationService.queryList(map);
		
		PageUtils pageUtil = new PageUtils(bookClassificationList, total, limit, page);
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("bookclassification:info")
	public R info(@PathVariable("id") Long id){
		BookClassificationEntity bookClassification = bookClassificationService.queryObject(id);
		
		return R.ok().put("bookClassification", bookClassification);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("bookclassification:save")
	public R save(@RequestBody BookClassificationEntity bookClassification){
		bookClassificationService.save(bookClassification);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("bookclassification:update")
	public R update(@RequestBody BookClassificationEntity bookClassification){
		bookClassificationService.update(bookClassification);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("bookclassification:delete")
	public R delete(@RequestBody Long[] ids){
		bookClassificationService.deleteBatch(ids);
		
		return R.ok();
	}
	/**
	 * 导出
	 */
	@RequestMapping("/download")
	@RequiresPermissions("bookClassification:download")
	public void downloadProbe(HttpServletResponse response) throws RRException {
		Map<String, Object> map = new HashMap<>();

		List<BookClassificationEntity> bookClassificationList = bookClassificationService.queryList(map);
		CollectionToFile.collectionToFile(response, bookClassificationList, BookClassificationEntity.class);
	}
}
