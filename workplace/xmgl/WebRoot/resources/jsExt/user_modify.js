var qzfun_=null;
//新增页面
	var formModify = new Ext.form.FormPanel({
			frame : false,
			width:700,
			border : false,
			labelAlign:"left",
			autoStroll : true,
			layout:"form",
			labelAlign : DEFAULTLABELALIGN,
			labelWidth : DEFAULTLABELWIDTH,
			items : [{//行一
						layout:"column",
						border : false,
						frame : false,
						items:[{
							columnWidth:.5,
							layout:"form",
							border : false,
							items:[{
								xtype:"textfield",
								allowBlank:false,
								fieldLabel:"用户名",
								name:'Username'
							},new Ext.form.Hidden({
								name:"Userid",
								value:""
							})]
						},{
						columnWidth:.25,
						layout:"form",
						border : false,
						items:[new Ext.form.Radio({boxLabel:"男",name:"Sex",inputValue:2,checked:true,fieldLabel:"性别"})]
						
						},{
						columnWidth:.25,
						layout:"form",
						border : false,
						items:[new Ext.form.Radio({boxLabel:"女",name:"Sex",inputValue:1,checked:false,labelSeparator:""})]
						}]
					},{//行二
						layout:"column",
						border : false,
						frame : false,
						items:[{
							columnWidth:.5,
							border : false,
							layout:"form",
							items:[{
							 xtype : "textfield",
							  fieldLabel : "登陆名",
							  allowBlank:false,
							  name:"LogonName"
							}]
						}
						,{
							columnWidth:.5,
							border : false,
							layout:"form",
							items:[new Ext.form.DateField({format:DEFAULTDATEFORMAT,
								name:"Birthday",
								allowBlank:false,
								fieldLabel:"出生日期",
								renderer:function(value){
									return "2012-3-9";
								}
							})]
							
						}]
					},{//行三
						layout:"column",
						border : false,
						frame : false,
						items:[{
							columnWidth:.5,
							border : false,
							layout:"form",
							items:[{
							 xtype : "textfield",
							 allowBlank:false,
							  fieldLabel : "密码",
							  name:"Password"
							}]
						}
						,{
							columnWidth:.5,
							border : false,
							layout:"form",
							items:[{
							 xtype : "textfield",
							  fieldLabel : "办公电话",
							  name:"Bphone"
							}]
							
						}]
					},{//行四
						layout:"column",
						border : false,
						frame : false,
						items:[{
							columnWidth:.5,
							border : false,
							layout:"form",
							items:[ctrlAny3,ctrlAnyHidden3]
						}
						,{
							columnWidth:.5,
							border : false,
							layout:"form",
							items:[{
							 xtype : "textfield",
							  fieldLabel : "职务",
							  name:"Headship"
							}]
							
						}]
					},{//行五
						layout:"form",
						border : false,
						frame : false,
						items:[
							new Ext.form.TextArea({
								width:300,
								name:"note",
								fieldLabel:"备注",
								height:60
							})
						]
					}

				
				]
	});
	var tbar4= new Ext.Toolbar([
	'-',
	{text:'清空',
	handler:function(){
		defaultForm(formModify.form);}
		},
	'-',
	{text:'修改',
	handler:function(){
	
		if (!formModify.form.isValid()){
						Ext.Msg.show({
									icon : Ext.MessageBox.WARNING,
									buttons : Ext.Msg.OK,
									title : '提示',
									msg : '请按照错误提示填写数据。'
								});
						return;
						
		}

		request_post(path + "/user/modify",formModify.form.getValues(),function(json){
			if(json.ok){
				ext_alert("修改成功");
				defaultForm(formModify.form);
				modifywindow.hide();
				userStore.reload({ params: { start: 0, limit: DEFAULTGRIDLINENUMBER} });
			}else{
				ext_alert(json.msg);
			}
		});
	}
	}
	]);
var modifywindow = new Ext.Window({
    //title: '资产详细信息',
    frame: true,
    border:false,
    closable: false,
   // layout: 'fit',
    closeAction: 'hide',
    modal: true,
    resizable: false,
    maximized: true,
    minimizable: false,
    maximizable: false,
	tbar:new Ext.Toolbar(['<a href="javascript:">你所在的位置</a>','-','<a href="javascript:qzfun_();">用户管理</a>','-','<a href="javascript:">用户修改</a>']),
	listeners : {'render' : function(){
								tbar4.render(this.tbar);
							}
				},
		items: [formModify]
	});

	
