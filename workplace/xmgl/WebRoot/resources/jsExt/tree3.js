var loaderAssetType3 = new Ext.tree.TreeLoader({
	dataUrl: path + "/dept/tree",
	baseParams: { nodeid: "01" }
});
var ctrlAnyHidden3 = new Ext.form.Hidden({
	name:"Dptid",
	value:""
});


loaderAssetType3.on("beforeload", function(loaderAssetType3, node) {
	//if(node.attributes.id == null)node.attributes.id="01";
    loaderAssetType3.baseParams.nodeid = node.id;
}, loaderAssetType3);
var ctrlAny3 = new Ext.form.ComboBox({
    store: new Ext.data.SimpleStore({ fields: [], data: [[]] }),
    editable: false,
    allowBlank:false,
  //  shadow: false,
    //columnWidth:.5,
    hiddenName: 'DptName1',
    fieldLabel:"所属单位",
    readOnly:true,
    emptyText: '请选单位...',
    mode: 'local',
    maxLength:20,
    triggerAction: 'all',
   // autoHeight: true,
    tpl: '<tpl for="."><div id="divAny3" style="height:200px;"></div></tpl>'
  //  selectedClass: '',
   // onSelect: Ext.emptyFn
});
var ctrlAnyHander3 = {hander:function(a){}};
var treeAny3 = new Ext.tree.TreePanel({
    frame: false,
    border: false,
    useArrows: false,
    enableDD: false,
    containerScroll: false,
    loader: loaderAssetType3,
    autoShow: true,
    root: new Ext.tree.AsyncTreeNode({
        text: '北京信息管理公司',
        id: "01",
        expanded:true,
        qtip:'北京信息管理公司'
    }),
    listeners: {
        click: function(n) {
        	
        	ctrlAny3.setValue(n.attributes.text); //DptID
        	ctrlAnyHidden3.setValue(n.attributes.DptID);
            ctrlAny3.collapse();
            ctrlAnyHander3.hander(n.attributes);
           
        }
    }
});

//渲染到下拉框中
ctrlAny3.on('expand', function() {
	treeAny3.dataUrl = path + "/dept/tree";
    //end
	treeAny3.render('divAny3');
	treeAny3.show();
});