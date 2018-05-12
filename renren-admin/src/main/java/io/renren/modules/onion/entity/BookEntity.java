package io.renren.modules.onion.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import io.renren.common.utils.excel.annotation.ExcelIgnore;
import io.renren.common.utils.excel.annotation.ExportName;

import java.io.Serializable;
import java.util.Date;

/**
 * 图书信息表
 */
@TableName("book")
public class BookEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 书籍名称
	 */
	@ExportName(exportName="书籍名称")
	private String name;
	/**
	 * 出版社
	 */
	@ExportName(exportName="出版社")
	private String publisher;
	/**
	 * 作者
	 */
	@ExportName(exportName="作者")
	private String writer;
	/**
	 * 译者
	 */
	@ExportName(exportName="译者")
	private String translator;
	/**
	 * 分类
	 */
	@ExportName(exportName="分类")
	private Integer classification;
	/**
	 * 上传人
	 */
	@ExportName(exportName="上传人")
	private String uploadPeople;
	/**
	 * 修改人
	 */
	@ExportName(exportName="修改人")
	private String updatePeople;
	/**
	 * 责编
	 */
	@ExportName(exportName="责编")
	@ExcelIgnore
	private String editor;
	/**
	 * 上架状态 1上架 2未上架
	 */
	@ExportName(exportName="上架状态 1上架 2未上架")
	private Integer listOn;
	/**
	 * 创建时间
	 */
	@ExportName(exportName="创建时间")
	private Date createTime;
	/**
	 * 创建时间
	 */
	@ExportName(exportName="分类字典表名")
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
	 * 设置：书籍名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：书籍名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：出版社
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	/**
	 * 获取：出版社
	 */
	public String getPublisher() {
		return publisher;
	}
	/**
	 * 设置：作者
	 */
	public void setWriter(String writer) {
		this.writer = writer;
	}
	/**
	 * 获取：作者
	 */
	public String getWriter() {
		return writer;
	}
	/**
	 * 设置：译者
	 */
	public void setTranslator(String translator) {
		this.translator = translator;
	}
	/**
	 * 获取：译者
	 */
	public String getTranslator() {
		return translator;
	}
	/**
	 * 设置：分类
	 */
	public void setClassification(Integer classification) {
		this.classification = classification;
	}
	/**
	 * 获取：分类
	 */
	public Integer getClassification() {
		return classification;
	}
	/**
	 * 设置：上传人
	 */
	public void setUploadPeople(String uploadPeople) {
		this.uploadPeople = uploadPeople;
	}
	/**
	 * 获取：上传人
	 */
	public String getUploadPeople() {
		return uploadPeople;
	}
	/**
	 * 设置：修改人
	 */
	public void setUpdatePeople(String updatePeople) {
		this.updatePeople = updatePeople;
	}
	/**
	 * 获取：修改人
	 */
	public String getUpdatePeople() {
		return updatePeople;
	}
	/**
	 * 设置：责编
	 */
	public void setEditor(String editor) {
		this.editor = editor;
	}
	/**
	 * 获取：责编
	 */
	public String getEditor() {
		return editor;
	}
	/**
	 * 设置：上架状态 1上架 2未上架
	 */
	public void setListOn(Integer listOn) {
		this.listOn = listOn;
	}
	/**
	 * 获取：上架状态 1上架 2未上架
	 */
	public Integer getListOn() {
		return listOn;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}

	public String getClassificationName() {
		return classificationName;
	}

	public void setClassificationName(String classificationName) {
		this.classificationName = classificationName;
	}
}
