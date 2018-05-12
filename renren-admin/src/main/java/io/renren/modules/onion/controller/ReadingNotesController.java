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

import io.renren.modules.onion.entity.ReadingNotesEntity;
import io.renren.modules.onion.service.ReadingNotesService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;

import javax.servlet.http.HttpServletResponse;


/**
 * 读书笔记表
 * @date 2018-04-17 11:27:20
 */
@RestController
@RequestMapping("readingnotes")
public class ReadingNotesController {
	@Autowired
	private ReadingNotesService readingNotesService;
	
	/**
	 * 列表
	 */

	@RequestMapping("/list")
	@RequiresPermissions("readingnotes:list")
	public R list(String probedata, Integer page, Integer limit)throws Exception{
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
			total = readingNotesService.queryTotal(map);
		}
		List<ReadingNotesEntity> probeList = readingNotesService.queryList(map);
		PageUtils pageUtil = new PageUtils(probeList, total, limit, page);

		return R.ok().put("page", pageUtil);
	}




	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("readingnotes:info")
	public R info(@PathVariable("id") Long id){
		ReadingNotesEntity readingNotes = readingNotesService.queryObject(id);
		return R.ok().put("readingNotes", readingNotes);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("readingnotes:save")
	public R save(@RequestBody ReadingNotesEntity readingNotes){
		readingNotesService.save(readingNotes);
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("readingnotes:update")
	public R update(@RequestBody ReadingNotesEntity readingNotes){
		readingNotesService.update(readingNotes);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("readingnotes:delete")
	public R delete(@RequestBody Long[] ids){
		readingNotesService.deleteBatch(ids);
		return R.ok();
	}
	/**
	 * 导出
	 */
	@RequestMapping("/download")
	@RequiresPermissions("readingNotes:download")
	public void downloadProbe(HttpServletResponse response) throws RRException {
		Map<String, Object> map = new HashMap<>();

		List<ReadingNotesEntity> readingNotesList = readingNotesService.queryList(map);
		CollectionToFile.collectionToFile(response, readingNotesList, ReadingNotesEntity.class);
	}
}
