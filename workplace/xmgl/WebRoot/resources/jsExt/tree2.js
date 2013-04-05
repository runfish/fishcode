var loaderAssetType2 = new Ext.tree.TreeLoader({
	dataUrl: path + "/dept/tree",
	baseParams: { nodeid: "01" }
});
var ctrlAnyHidden2 = new Ext.form.Hidden({
	name:"Dptid",
	value:""
});

var ctrlAnyHander2 = {hander:function(a){}};
loaderAssetType2.on("beforeload", function(loaderAssetType2, node) {
	//if(node.attributes.id == null)node.attributes.id="01";
    loaderAssetType2.baseParams.nodeid = node.id;
}, loaderAssetType2);
var ctrlAny2 = new Ext.form.ComboBox({
    store: new Ext.data.SimpleStore({ fields: [], data: [[]] }),
    editable: false,
    allowBlank:false,
  //  shadow: false,
    //columnWidth:.5,
    hiddenName: 'DptName',
    fieldLabel:"所属单位",
    readOnly:true,
    emptyText: '请选单位...',
    mode: 'local',
    maxLength:20,
    triggerAction: 'all',
   // autoHeight: true,
    tpl: '<tpl for="."><div id="divAny2" style="height:200px;"></div></tpl>'
  //  selectedClass: '',
   // onSelect: Ext.emptyFn
});

var treeAny2 = new Ext.tree.TreePanel({
    frame: false,
    border: false,
    useArrows: false,
    enableDD: false,
    containerScroll: false,
    loader: loaderAssetType2,
    autoShow: true,
    root: new Ext.tree.AsyncTreeNode({
        text: '北京信息管理公司',
        id: "01",
        expanded:true,
        qtip:'北京信息管理公司'
    }),
    listeners: {
        click: function(n) {
        	
        	ctrlAny2.setValue(n.attributes.text); //DptID
        	ctrlAnyHidden2.setValue(n.attributes.DptID);
            ctrlAny2.collapse();
            ctrlAnyHander2.hander(n.attributes);
           
        }
    }
});

//渲染到下拉框中
ctrlAny2.on('expand', function() {
	treeAny2.dataUrl = path + "/dept/tree";
    //end
	treeAny2.render('divAny2');
	treeAny2.show();
});