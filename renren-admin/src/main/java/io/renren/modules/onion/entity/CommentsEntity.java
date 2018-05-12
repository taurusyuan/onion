package io.renren.modules.onion.entity;

import io.renren.common.utils.excel.annotation.ExportName;

import java.io.Serializable;
import java.util.Date;

/**
 * 图书评论表
 * @date 2018-04-18 17:45:19
 */
public class CommentsEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//书名
	@ExportName(exportName="书名")
	private String name;
	//评论内容
	@ExportName(exportName="评论内容")
	private String commentContent;
	//评论者
	@ExportName(exportName="评论者")
	private String commentPeople;
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
	 * 设置：书名
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：书名
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：评论内容
	 */
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	/**
	 * 获取：评论内容
	 */
	public String getCommentContent() {
		return commentContent;
	}
	/**
	 * 设置：评论者
	 */
	public void setCommentPeople(String commentPeople) {
		this.commentPeople = commentPeople;
	}
	/**
	 * 获取：评论者
	 */
	public String getCommentPeople() {
		return commentPeople;
	}
	/**
	 * 设置：审核状态 01为已审核通过 2为审核未通过 3为未审核
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
