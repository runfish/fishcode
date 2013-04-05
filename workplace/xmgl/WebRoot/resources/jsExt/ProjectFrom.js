var addhander = {saveOk:function(){}}
//新增页面
var formAdd = new Ext.form.FormPanel({
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
							ctrlAny2,
							ctrlAnyHidden2,
							userCombox2,
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

var tbar4= new Ext.Toolbar([
                        	'-',
                        	{text:'重置',
                        	handler:function(){
                        		defaultForm(formAdd.form);}
                        		},
                        	'-',
                        	{text:'保存',
                        	handler:function(){
                        	
                        		if (!formAdd.form.isValid()){
                        						Ext.Msg.show({
                        									icon : Ext.MessageBox.WARNING,
                        									buttons : Ext.Msg.OK,
                        									title : '提示',
                        									msg : '请按照错误提示填写数据。'
                        								});
                        						return;
                        		}

                        		request_post(path+ "/project/save",formAdd.form.getValues(),function(json){
                        			if(json.ok){
                        				ext_alert("新建成功");
                        				defaultForm(formAdd.form);
                        				addwindow.hide();
                        				addhander.saveOk();
                        			}else{
                        				ext_alert(json.msg);
                        			}
                        		});
                        	}
                        	}
]);

var addwindow = new Ext.Window({
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
	tbar:new Ext.Toolbar(['<a href="javascript:">你所在的位置</a>','-','<a href="javascript:qzfun();">项目管理</a>','-','<a href="javascript:">新建项目</a>']),
	listeners : {'render' : function(){
								tbar4.render(this.tbar);
							}
				},
		items: [formAdd]
});
ctrlAnyHander2.hander= function(a){
	userCombox2.setValue("");
	userStore2.reload({ params: { did:a.DptID} });
}
var qzfun = function(){
	addwindow.hide();
}
