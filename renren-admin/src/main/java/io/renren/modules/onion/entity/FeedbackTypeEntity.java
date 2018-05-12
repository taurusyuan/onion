package io.renren.modules.onion.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import io.renren.common.utils.excel.annotation.ExportName;


import java.io.Serializable;
import java.util.Date;



/**
 * 反馈类型字典表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-04-19 15:30:11
 */
@TableName("feedback_reply")
public class FeedbackTypeEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 *
	 */
	@TableId
	//
	private Long id;
	//类型名
	@ExportName(exportName="类型名")
	private String typeName;

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
	 * 设置：类型名
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	/**
	 * 获取：类型名
	 */
	public String getTypeName() {
		return typeName;
	}
}
