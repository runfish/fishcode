package com.moudel.ext;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.ActiveRecordException;
import com.jfinal.plugin.activerecord.DbKit;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.TableInfo;
import com.jfinal.plugin.activerecord.TableInfoMapping;

//默认此插件 对Sqllite的支持有Bug 因此修复
public  class SqliteModel<M extends Model> extends Model<M> implements Serializable {
	static SqliteModel ins = new SqliteModel();
	@Override
	public boolean save() {
		TableInfo tableInfo = TableInfoMapping.me().getTableInfo(getClass());
		
		StringBuilder sql = new StringBuilder();
		List<Object> paras = new ArrayList<Object>();
		DbKit.getDialect().forModelSave(tableInfo, getAttrs(), sql, paras);
		Connection conn = null;
		PreparedStatement pst = null;
		int result = 0;
		try {
			conn = DbKit.getConnection();
			pst = conn.prepareStatement(sql.toString());
			
			DbKit.getDialect().fillStatement(pst, paras);
			// for (int i=0, size=paras.size(); i<size; i++) {
				// pst.setObject(i + 1, paras.get(i));
			// }
			
			result = pst.executeUpdate();
			// if (isSupportAutoIncrementKey)
			return result >= 1;
		} catch (Exception e) {
			throw new ActiveRecordException(e);
		} finally {
			DbKit.close(pst, conn);
		}
	}
	
	public Map attrs(){
		return getAttrs();
	}
	
	
	
	
}