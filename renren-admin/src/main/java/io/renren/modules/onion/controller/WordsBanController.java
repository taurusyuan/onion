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

import io.renren.modules.onion.entity.WordsBanEntity;
import io.renren.modules.onion.service.WordsBanService;

import javax.servlet.http.HttpServletResponse;


/**
 * 违禁词条表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-04-18 17:45:19
 */
@RestController
@RequestMapping("wordsban")
public class WordsBanController {
	@Autowired
	private WordsBanService wordsBanService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("wordsban:list")


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
			total = wordsBanService .queryTotal(map);
		}
		List<WordsBanEntity> wordsBanList = wordsBanService.queryList(map);
		PageUtils pageUtil = new PageUtils(wordsBanList , total, limit, page);

		return R.ok().put("page", pageUtil);
	}
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("wordsban:info")
	public R info(@PathVariable("id") Long id){
		WordsBanEntity wordsBan = wordsBanService.queryObject(id);
		
		return R.ok().put("wordsBan", wordsBan);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("wordsban:save")
	public R save(@RequestBody WordsBanEntity wordsBan){
		wordsBanService.save(wordsBan);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("wordsban:update")
	public R update(@RequestBody WordsBanEntity wordsBan){
		wordsBanService.update(wordsBan);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("wordsban:delete")
	public R delete(@RequestBody Long[] ids){
		wordsBanService.deleteBatch(ids);
		
		return R.ok();
	}
	/**
	 * 导出
	 */
	@RequestMapping("/download")
	@RequiresPermissions("wordsBan:download")
	public void downloadProbe(HttpServletResponse response) throws RRException {
		Map<String, Object> map = new HashMap<>();
		List<WordsBanEntity> wordsBanList = wordsBanService.queryList(map);
		CollectionToFile.collectionToFile(response,  wordsBanList, WordsBanEntity.class);
	}
}
