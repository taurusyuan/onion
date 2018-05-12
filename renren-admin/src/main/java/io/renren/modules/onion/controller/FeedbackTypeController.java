package io.renren.modules.onion.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import io.renren.common.exception.RRException;
import io.renren.common.utils.*;
import io.renren.modules.onion.entity.BookClassificationEntity;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.onion.entity.FeedbackTypeEntity;
import io.renren.modules.onion.service.FeedbackTypeService;

import javax.servlet.http.HttpServletResponse;


/**
 * 反馈类型字典表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-04-19 15:30:11
 */
@RestController
@RequestMapping("feedbacktype")
public class FeedbackTypeController {
	@Autowired
	private FeedbackTypeService feedbackTypeService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("feedbacktype:list")

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
			total = feedbackTypeService.queryTotal(map);
		}
		List<FeedbackTypeEntity> feedbackTypeList = feedbackTypeService.queryList(map);
		PageUtils pageUtil = new PageUtils(feedbackTypeList, total, limit, page);

		return R.ok().put("page", pageUtil);
	}
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("feedbacktype:info")
	public R info(@PathVariable("id") Long id){
		FeedbackTypeEntity feedbackType = feedbackTypeService.queryObject(id);
		
		return R.ok().put("feedbackType", feedbackType);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("feedbacktype:save")
	public R save(@RequestBody FeedbackTypeEntity feedbackType){
		feedbackTypeService.save(feedbackType);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("feedbacktype:update")
	public R update(@RequestBody FeedbackTypeEntity feedbackType){
		feedbackTypeService.update(feedbackType);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("feedbacktype:delete")
	public R delete(@RequestBody Long[] ids){
		feedbackTypeService.deleteBatch(ids);
		
		return R.ok();
	}
	/**
	 * 导出
	 */
	@RequestMapping("/download")
	@RequiresPermissions("feedbackType:download")
	public void downloadProbe(HttpServletResponse response) throws RRException {
		Map<String, Object> map = new HashMap<>();
		List<FeedbackTypeEntity> feedbackTypeList = feedbackTypeService.queryList(map);
		CollectionToFile.collectionToFile(response, feedbackTypeList, FeedbackTypeEntity.class);
	}
}
