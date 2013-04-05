Ext.grid.PageRowNumberer = Ext.extend(Ext.grid.RowNumberer, {
    width : 40, 
    header:'序号',
    renderer:function(value, cellmeta, record, rowIndex, columnIndex, store){
    	if(store.lastOptions.params!=null){
    		var pageindex=store.lastOptions.params.start;
    		return pageindex + rowIndex + 1;
    	} else {
    		return rowIndex + 1;
    	}
    }   
});