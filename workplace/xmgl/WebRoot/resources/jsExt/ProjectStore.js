Ext.data.ProjectStore = Ext.extend(Ext.data.Store,{
				 proxy: new Ext.data.HttpProxy({ url: path+'/project/grid' }),
	                reader: new Ext.data.JsonReader({
	                    totalProperty: 'results', root: 'rows', id: 'Prjid',
	                    fields: ['Prjid', 'PrjCode','DptName', 'Username', 'Creatdate', 'Amount']
	                }),
	                sortInfo: { field: 'Creatdate', direction: 'DESC' },
	                remoteSort: false
});

var userStore=new Ext.data.Store({
    autoLoad:false,
    proxy:new Ext.data.HttpProxy({
        url:path+'dept/users'
    }),
    reader:new Ext.data.JsonReader({
        root:'root',
        fields:['Username','Userid']
    })
});
var userCombox = new Ext.form.ComboBox({
    id:'userCombox',
    mode:'local',
    triggerAction:'all',
    //loadingText:'正在加载团体信息，请稍候...',
    store:userStore,
    valueField:'Userid',
    displayField:'Username',
    forceSelection:true,
    editable:false
});


var userStore2=new Ext.data.Store({
    autoLoad:false,
    proxy:new Ext.data.HttpProxy({
        url:path+'dept/users'
    }),
    reader:new Ext.data.JsonReader({
        root:'root',
        fields:['Username','Userid']
    })
});
var userCombox2 = new Ext.form.ComboBox({
    id:'userCombox2',
    mode:'local',
    hiddenName:"Userid",
    allowBlank:false,
    triggerAction:'all',
    fieldLabel:'项目经理',
    //loadingText:'正在加载团体信息，请稍候...',
    store:userStore2,
    valueField:'Userid',
    displayField:'Username',
    forceSelection:true,
    editable:false
});


var userStore3=new Ext.data.Store({
    autoLoad:false,
    proxy:new Ext.data.HttpProxy({
        url:path+'dept/users'
    }),
    reader:new Ext.data.JsonReader({
        root:'root',
        fields:['Username','Userid']
    })
});
var userCombox3 = new Ext.form.ComboBox({
    id:'userCombox3',
    mode:'local',
    hiddenName:"Userid",
    allowBlank:false,
    triggerAction:'all',
    fieldLabel:'项目经理',
    //loadingText:'正在加载团体信息，请稍候...',
    store:userStore3,
    valueField:'Userid',
    displayField:'Username',
    forceSelection:true,
    editable:false
});