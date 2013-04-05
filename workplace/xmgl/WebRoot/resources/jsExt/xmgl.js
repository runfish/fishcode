
var Diqye = function(form){
	this._form = form;
}
Diqye.prototype.restForm =function(){
	var values = this._form.getValues();
	for(var i in values){	
		values[i]='';
	}
	this._form.setValues(values);
	this._form.clearInvalid();
	
}

//将Form表单全部设置为''
function defaultForm(form){
	var diqye = new Diqye(form);
	diqye.restForm();
}

function request_post(url_,param_,success_callback){
	Ext.Ajax.request({
		url:url_,
		//结束
		method : 'post',
		params : param_,
		success : function(
				response,
				options)
			{
				var res = response.responseText;
				var objJson = eval('('
						+ res
						+')');
				success_callback(objJson);
			},
		failure : function(
				response,
				options)
			{
				Ext.Msg.show({
							icon : Ext.MessageBox.ERROR,
							buttons : Ext.Msg.OK,
							title : '错误',
							msg : '页面提交失败，请检查网络连接。'
						});
			}
	});
}

function ext_alert_error(str){
	Ext.Msg.show({
		icon : Ext.MessageBox.ERROR,
		buttons : Ext.Msg.OK,
		title : '提示',
		msg : str
	});
}
function ext_alert(str){
	Ext.Msg.show({
		icon : Ext.MessageBox.INFO,
		buttons : Ext.Msg.OK,
		title : '提示',
		msg : str
	});
}


var C_SEX = [];
C_SEX["1"] = "女";
C_SEX["2"] = "男";


Date.prototype.format = function(f){
    var o ={
        "M+" : this.getMonth()+1, //month
        "d+" : this.getDate(),    //day
        "h+" : this.getHours(),   //hour
        "m+" : this.getMinutes(), //minute
        "s+" : this.getSeconds(), //second
        "q+" : Math.floor((this.getMonth()+3)/3),  //quarter
        "S" : this.getMilliseconds() //millisecond
    }
    if(/(y+)/.test(f))f=f.replace(RegExp.$1,(this.getFullYear()+"").substr(4 - RegExp.$1.length));
    for(var k in o)
        if(new RegExp("("+ k +")").test(f))f = f.replace(RegExp.$1,RegExp.$1.length==1 ? o[k] : ("00"+ o[k]).substr((""+ o[k]).length));return f
}
