package com.isoft.util;

/**
 * @author chenhy
 * @date @time 2019/6/20 10:26
 */
public class Json {
	private boolean isSuccess;
	private String msg;
	private Object data;

	public Json () {
	}
	public static Json error(){
		Json json = new Json();
		json.setMsg("操作失败！");
		json.isSuccess=false;
		return json;
	}
	public static Json errorMsg(String msg){
		Json json = new Json();
		json.setMsg(msg);
		json.isSuccess=false;
		return json;
	}
	public static Json ok(){
		Json json = new Json();
		json.setMsg("操作成功！");
		json.isSuccess=true;
		return json;
	}
	public static Json okMsg(String msg){
		Json json = new Json();
		json.setMsg(msg);
		json.isSuccess=true;
		return json;
	}
	public static Json ok(Object data){
		Json json = new Json();
		json.setMsg("操作成功！");
		json.isSuccess=true;
		json.setData(data);
		return json;
	}
	public boolean isSuccess () {
		return isSuccess;
	}

	public void setSuccess (boolean success) {
		isSuccess = success;
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
}
