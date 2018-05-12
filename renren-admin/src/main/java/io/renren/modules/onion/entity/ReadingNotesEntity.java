package io.renren.modules.onion.entity;

import io.renren.common.utils.excel.annotation.ExportName;

import java.io.Serializable;
import java.util.Date;



/**
 * 读书笔记表
 * @date 2018-04-17 11:27:20
 */
public class ReadingNotesEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//书籍名称
	@ExportName(exportName="书籍名称")
	private String name;
	//内容
	@ExportName(exportName="内容")
	private String content;
	//发表人
	@ExportName(exportName="发表人")
	private String postPeople;
	//审核状态 1为已审核通过 2为审核未通过 3为未审核
	@ExportName(exportName="审核状态 1为已审核通过 2为审核未通过 3为未审核")
	private Integer approvalState;
	//创建时间
	@ExportName(exportName="创建时间")
	private Date createTime;

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
	 * 设置：内容
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：内容
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置：发表人
	 */
	public void setPostPeople(String postPeople) {
		this.postPeople = postPeople;
	}
	/**
	 * 获取：发表人
	 */
	public String getPostPeople() {
		return postPeople;
	}
	/**
	 * 设置：审核状态 1为已审核通过 2为审核未通过 3为未审核
	 */
	public void setApprovalState(Integer approvalState) {
		this.approvalState = approvalState;
	}
	/**
	 * 获取：审核状态 1为已审核通过 2为审核未通过 3为未审核
	 */
	public Integer getApprovalState() {
		return approvalState;
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
}
