var loaderAssetType = new Ext.tree.TreeLoader({
	dataUrl: path + "/dept/tree",
	baseParams: { nodeid: "01" }
});

loaderAssetType.on("beforeload", function(loaderAssetType, node) {
	//if(node.attributes.id == null)node.attributes.id="01";
    loaderAssetType.baseParams.nodeid = node.id;
}, loaderAssetType);
var ctrlAnyHidden = new Ext.form.Hidden({
	name:"dept",
	value:""
});
var ctrlAnyHander = {hander:function(a){}};
var ctrlAny = new Ext.form.ComboBox({
    store: new Ext.data.SimpleStore({ fields: [], data: [[]] }),
    editable: false,
    shadow: false,
    name: 'AssetTypeAny',
    emptyText: '请选单位...',
    mode: 'local',
    triggerAction: 'all',
    autoHeight: true,
    tpl: '<tpl for="."><div id="divAny" style="height:200px;"></div></tpl>',
    selectedClass: '',
    onSelect: Ext.emptyFn
});

var treeAny = new Ext.tree.TreePanel({
    frame: false,
    border: false,
    useArrows: false,
    enableDD: false,
    containerScroll: false,
    loader: loaderAssetType,
    autoShow: true,
    root: new Ext.tree.AsyncTreeNode({
        text: '北京信息管理公司',
        id: "01",
        expanded:true,
        qtip:'北京信息管理公司'
    }),
    listeners: {
        click: function(n) {
        	ctrlAny.setValue(n.attributes.text); 
            ctrlAnyHidden.setValue(n.attributes.id);
            ctrlAny.collapse();
            ctrlAnyHander.hander(n.attributes);
        }
    }
});

//渲染到下拉框中
ctrlAny.on('expand', function() {
	treeAny.dataUrl = path + "/dept/tree";
    //end
	treeAny.render('divAny');
	treeAny.show();
});