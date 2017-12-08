package com.bbj.bizlogic.base.domain;

/**
 * 请求相应对象
 * @author bage
 *
 */
public class BBJResponse extends BBJObject{

	private static final long serialVersionUID = 1L;
	
	private String msg;
	private Object data;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public BBJResponse(String msg, Object data) {
		super();
		this.msg = msg;
		this.data = data;
	}
	@Override
	public String toString() {
		return "BBJResponse [msg=" + msg + ", data=" + data + "]";
	}

}
