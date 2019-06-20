<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 <script type="text/javascript">
 
 //数据字典下拉框
 function pbInitCombox($,form,type,id,value){
		$.ajax({
			url : '<%=request.getContextPath()%>/dictCd/getList?'+type,
			type:'POST',//默认以get提交，以get提交如果是中文后台会出现乱码
			dataType : 'json',
			async: true,
			success : function(data) {
				//layer.msg(JSON.stringify(data));
				$("#"+id).html("");
				$("#"+id).append('<option selected="" value="">请选择</option>');
				for(var i=0;i<data.length;i++){
					if(data[i].dictCd==value){
						$("#"+id).append('<option selected="" value='+data[i].dictCd+'>'+data[i].dictNm+'</option>');
					}else{
						$("#"+id).append('<option value='+data[i].dictCd+'>'+data[i].dictNm+'</option>');
					}
					
					
				}
				form.render();//重新渲染
			}
		});
	}
 
//普通下拉框
 function pbInitComCombox($,form,url,id,idField,textField,value){
		$.ajax({
			url : '<%=request.getContextPath()%>/'+url,
			type:'POST',//默认以get提交，以get提交如果是中文后台会出现乱码
			dataType : 'json',
			async: true,
			success : function(data) {
				//layer.msg(JSON.stringify(data));
				$("#"+id).html("");
				$("#"+id).append('<option selected="" value="">请选择</option>');
				for(var i=0;i<data.length;i++){
					if(data[i][idField]==value){
						$("#"+id).append('<option selected="" value='+data[i][idField]+'>'+data[i][textField]+'</option>');
					}else{
						$("#"+id).append('<option value='+data[i][idField]+'>'+data[i][textField]+'</option>');
					}
					
					
				}
				form.render();//重新渲染
			}
		});
	}
	
 /**
  * 如： 传输页面：window.location.href = "xxx.html?obj="+
  * encodeURIComponent(JSON.stringify(obj)); 接收页面：requestParam =
  * getRequestParam(); data = JSON.parse(decodeURIComponent(requestParam.obj));
  */
 function getRequestParam() {
 	var urlInfo = window.location.href;
 	var argsIndex = urlInfo.indexOf("?");
 	var args = urlInfo.substring((argsIndex + 1)).split("&");
 	var argsInfo = "{";
 	for ( var i = 0; i < args.length; i++) {
 		var argResult = args[i].split("=");
 		argsInfo = argsInfo + "'" + argResult[0] + "':'" + argResult[1] + "'";
 		if (i != args.length - 1) {
 			argsInfo += ',';
 		}
 	}
 	argsInfo += "}";
 	return eval('(' + argsInfo + ')');
 }
  
  /**
  *无权限提示
  **/
 function noAuthTip(res){
	 if(res.msg!=""){
		 pubUtil.msg(res.msg,layer,2,function(){
		},20*1000);
	 }
 }
</script>
