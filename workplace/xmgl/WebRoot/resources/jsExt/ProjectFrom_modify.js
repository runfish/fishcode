var addhander2 = {saveOk:function(){}}
//新增页面
var formAdd2 = new Ext.form.FormPanel({
			frame : false,
			width:700,
			border : false,
			labelAlign:"left",
			autoStroll : true,
			layout:"form",
			labelAlign : DEFAULTLABELALIGN,
			labelWidth : DEFAULTLABELWIDTH,
			items : [
			         		{xtype:"textfield",
							allowBlank:false,
							fieldLabel:"项目名称",
							name:'PrjCode'},
							ctrlAny3,
							ctrlAnyHidden3,
							userCombox3,
							new Ext.form.Hidden({
								name:"Prjid",
								value:""
							}),
							new Ext.form.DateField({format:DEFAULTDATEFORMAT,allowBlank:false,name:"Creatdate",fieldLabel:"立项时间"}),
							new Ext.form.NumberField({name:"Amount",fieldLabel:"投资金额(万元)",decimalPrecision:10,allowBlank:false}),
							new Ext.form.TextArea({
								width:300,
								name:"note",
								fieldLabel:"备注",
								height:60
							})
			         ]
});

var tbar3= new Ext.Toolbar([
                        	'-',
                        	{text:'清空',
                        	handler:function(){
                        		defaultForm(formAdd2.form);}
                        		},
                        	'-',
                        	{text:'修改',
                        	handler:function(){
                        	
                        		if (!formAdd2.form.isValid()){
                        						Ext.Msg.show({
                        									icon : Ext.MessageBox.WARNING,
                        									buttons : Ext.Msg.OK,
                        									title : '提示',
                        									msg : '请按照错误提示填写数据。'
                        								});
                        						return;
                        		}

                        		request_post(path+ "/project/update",formAdd2.form.getValues(),function(json){
                        			if(json.ok){
                        				ext_alert("修改成功");
                        				defaultForm(formAdd2.form);
                        				addwindow2.hide();
                        				addhander2.saveOk();
                        			}else{
                        				ext_alert(json.msg);
                        			}
                        		});
                        	}
                        	}
]);

var addwindow2 = new Ext.Window({
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
	tbar:new Ext.Toolbar(['<a href="javascript:">你所在的位置</a>','-','<a href="javascript:qzfun2();">项目管理</a>','-','<a href="javascript:">修改项目</a>']),
	listeners : {'render' : function(){
								tbar3.render(this.tbar);
							}
				},
		items: [formAdd2]
});

var qzfun2 = function(){
	addwindow2.hide();
}

ctrlAnyHander3.hander= function(a){
	userCombox3.setValue("");
	userStore3.reload({ params: { did:a.DptID} });
}
