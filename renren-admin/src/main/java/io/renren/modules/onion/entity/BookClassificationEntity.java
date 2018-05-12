package io.renren.modules.onion.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import io.renren.common.utils.excel.annotation.ExportName;

import java.io.Serializable;
import java.util.Date;

/**
 * 图书分类字典表
 */
@TableName("book_classification")
public class BookClassificationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 书籍分类名称
	 */
	@ExportName(exportName="书籍分类名称")
	private String classificationName;

	/**
	 * 设置：
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：书籍分类名称
	 */
	public void setClassificationName(String classificationName) {
		this.classificationName = classificationName;
	}
	/**
	 * 获取：书籍分类名称
	 */
	public String getClassificationName() {
		return classificationName;
	}
}
