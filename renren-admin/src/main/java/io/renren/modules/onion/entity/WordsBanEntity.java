package io.renren.modules.onion.entity;

import io.renren.common.utils.excel.annotation.ExportName;

import java.io.Serializable;
import java.util.Date;

/**
 * 违禁词条表
 * @date 2018-04-18 17:45:19
 */
public class WordsBanEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//违禁词条
	@ExportName(exportName="违禁词条")
	private String word;
	//发表人
	@ExportName(exportName="发表人")
	private String postPeople;
	//审核状态  1为已审核通过 2为审核未通过 3为未审核
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
	 * 设置：违禁词条
	 */
	public void setWord(String word) {
		this.word = word;
	}
	/**
	 * 获取：违禁词条
	 */
	public String getWord() {
		return word;
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
