package com.isoft.util;

/**分页
 * @author chenhy
 * @date @time 2019/6/19 13:38
 */
public class Page {

	private String code;
	private String msg;
	private Object data;
	private int count;

	public String getCode () {
		return code;
	}

	public void setCode (String code) {
		this.code = code;
	}

	public String getMsg () {
		return msg;
	}

	public void setMsg (String msg) {
		this.msg = msg;
	}

	public Object getData () {
		return data;
	}

	public void setData (Object data) {
		this.data = data;
	}

	public int getCount () {
		return count;
	}

	public void setCount (int count) {
		this.count = count;
	}
}
