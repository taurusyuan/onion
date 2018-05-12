package io.renren.modules.onion.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import io.renren.common.exception.RRException;
import io.renren.common.utils.*;
import io.renren.modules.onion.entity.BookClassificationEntity;
import io.renren.modules.onion.entity.BookEntity;
import io.renren.modules.onion.service.BookService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.onion.entity.BookEntity;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;

import javax.servlet.http.HttpServletResponse;

/**
 * 图书信息表
 */
@RestController
@RequestMapping("book")
public class BookController {
    @Autowired
    private BookService bookService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("book:list")
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
            total = bookService.queryTotal(map);
        }
        List<BookEntity> probeList = bookService.queryList(map);
        PageUtils pageUtil = new PageUtils(probeList, total, limit, page);
        return R.ok().put("page", pageUtil);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("book:info")
    public R info(@PathVariable("id") Long id){
			BookEntity book = bookService.queryObject(id);
        return R.ok().put("book", book);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("book:save")
    public R save(@RequestBody BookEntity book){
			bookService.save(book);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("book:update")
    public R update(@RequestBody BookEntity book){
			bookService.update(book);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("book:delete")
    public R delete(@RequestBody Long[] ids){
			bookService.deleteBatch(ids);
        return R.ok();
    }
    /**
     * 导出
     */
    @RequestMapping("/download")
    @RequiresPermissions("book:download")
    public void downloadProbe(HttpServletResponse response) throws RRException {
        Map<String, Object> map = new HashMap<>();
        List<BookEntity> bookList = bookService.queryList(map);
        CollectionToFile.collectionToFile(response, bookList, BookEntity.class);
    }
}
