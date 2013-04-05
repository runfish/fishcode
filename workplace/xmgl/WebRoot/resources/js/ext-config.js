/*
 * 本系统采用的 EXT 设置，引用时放到 ext-base 和 ext-all 之后 韩占全 2009-03-16
 */

// 显示提示信息
Ext.QuickTips.init();

// 验证信息在控件之后
Ext.form.Field.prototype.msgTarget = 'qtip';

// 默认日期格式：2009-01-01
var DEFAULTDATEFORMAT = 'Y-m-d';

// 默认控件宽度
var DEFAULTCONTROLWIDTH = 185;

// 默认标签位置 top left right
var DEFAULTLABELALIGN = 'right';

// 默认标签宽度
var DEFAULTLABELWIDTH = 120;

// 默认页面行数
var DEFAULTGRIDLINENUMBER = 4;


// 当前日期格式： 2009-01-01，对应 Ext 的 Y-m-d
function GetToday(){
		var d = new Date();
		var y = d.getFullYear();
		var m = '' + (d.getMonth() + 1);
		if (m.length == 1)
			m = '0' + m;
		var dd = '' + d.getDate();
		if (dd.length == 1)
			dd = '0' + dd;
		return y + '-' + m + '-' + dd;
}

function formartDate(d){
	var y = d.getFullYear();
	var m = '' + (d.getMonth() + 1);
	if (m.length == 1)
		m = '0' + m;
	var dd = '' + d.getDate();
	if (dd.length == 1)
		dd = '0' + dd;
	return y + '-' + m + '-' + dd;
}


// 通用高级查询文本框
var AdvancedQueryField = new Ext.form.TextField({
			fieldLabel : '',
			name : 'advancedCondition',
			maxLength : 100,
			allowBlank : true,
			width : 175
		});

// 顶级页地址
var topurl = top.location.href.toLowerCase();
var endlength = (topurl.indexOf('?') > 0) ? topurl.indexOf('?') : topurl.length;
var filename = topurl.substring(topurl.lastIndexOf('/') + 1, endlength);
var urlleft = topurl.substring(0, topurl.lastIndexOf('/'));


// ---------------------------------------------
// Cookie 管理函数
// 设定 Cookie
function setCookie(name, value)
	{
		var Days = 365; // 此 cookie 将被保存 365 天
		var exp = new Date();
		exp.setTime(exp.getTime() + Days * 24 * 60 * 60 * 1000);
		document.cookie = name + "=" + escape(value) + ";expires="
				+ exp.toGMTString();
	}
// 获取 Cookie
function getCookie(name)
	{
		var arr = document.cookie.match(new RegExp("(^| )" + name
				+ "=([^;]*)(;|$)"));
		if (arr != null)
			return unescape(arr[2]);
		return null;
	}
// 清除Cookie
function delCookie(name)
	{
		var exp = new Date();
		exp.setTime(exp.getTime() - 1);
		var cval = getCookie(name);
		if (cval != null)
			document.cookie = name + "=" + cval + ";expires="
					+ exp.toGMTString();
	}

// ---------------------------------------------
// 读取用户偏好设定 -- 设定行数
function readUserSetRowNum()
	{
		var rowNum = getCookie("UserSetRowNum");
		if (typeof(rowNum) != undefined && rowNum > 9 && rowNum < 101)
			{
				DEFAULTGRIDLINENUMBER = rowNum * 1;
			}
	}
readUserSetRowNum();

var wholePageMask = null;
function maskCurrentPage()
	{
		if (wholePageMask != null)
			{
				wholePageMask.destroy();
			}
		wholePageMask = new Ext.LoadMask(Ext.getBody(), {// 也可以是Ext.getCmp('').getEl()窗口名称
			msg : "正在处理...",// 你要写成Loading...也可以
			msgCls : 'z-index:10000;'
		});
		wholePageMask.show();

	}
function cancelMaskCurrentPage()
	{
		if (wholePageMask != null)
			{
				wholePageMask.hide();
				wholePageMask.destroy();
			}
	}

// extjs 日历控件现实问题修改
Ext.override(Ext.menu.Menu, {
			autoWidth : function()
				{
					this.width += "px";
				}
		});
