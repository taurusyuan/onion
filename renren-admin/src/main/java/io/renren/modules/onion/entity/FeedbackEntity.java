package io.renren.modules.onion.entity;

import io.renren.common.utils.excel.annotation.ExportName;

import java.io.Serializable;
import java.util.Date;



/**
 * 反馈意见表
 * @date 2018-04-18 17:45:19
 */
public class FeedbackEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//用户名
	@ExportName(exportName="用户名")
	private String userName;
	//类型
	@ExportName(exportName="类型")
	private Integer type;
	//意见
	@ExportName(exportName="意见")
	private String feedback;
	//处理状态 1为已处理 2为未处理
	@ExportName(exportName="处理状态 1为已处理 2为未处理")
	private Integer treatmentState;
	//联系方式
	@ExportName(exportName="联系方式")
	private String tel;
	//类型字典表名
	@ExportName(exportName="类型字典表名")
	private String typeName;
	//反馈时间
	@ExportName(exportName="反馈时间")
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
	 * 设置：用户名
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * 获取：用户名
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * 设置：类型
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 获取：类型
	 */
	public Integer getType() {
		return type;
	}
	/**
	 * 设置：意见
	 */
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	/**
	 * 获取：意见
	 */
	public String getFeedback() {
		return feedback;
	}
	/**
	 * 设置：处理状态 1为已处理 2为未处理
	 */
	public void setTreatmentState(Integer treatmentState) {
		this.treatmentState = treatmentState;
	}
	/**
	 * 获取：处理状态 1为已处理 2为未处理
	 */
	public Integer getTreatmentState() {
		return treatmentState;
	}
	/**
	 * 设置：联系方式
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}
	/**
	 * 获取：联系方式
	 */
	public String getTel() {
		return tel;
	}
	/**
	 * 设置：反馈时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：反馈时间
	 */
	public Date getCreateTime() {
		return createTime;
	}

	public String getTypeName() {return typeName; }

	public void setTypeName(String typeName) {this.typeName = typeName; }

}
