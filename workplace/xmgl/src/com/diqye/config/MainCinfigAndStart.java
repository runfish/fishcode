package com.diqye.config;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Timer;
import java.util.TimerTask;

import com.diqye.LoginCheck;
import com.diqye.controllers.DeptCtrl;
import com.diqye.controllers.Index;
import com.diqye.controllers.ProjectCtrl;
import com.diqye.controllers.UserCtrl;
import com.diqye.moudels.Dept;
import com.diqye.moudels.Project;
import com.diqye.moudels.User;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.core.JFinal;
import com.jfinal.ext.handler.ContextPathHandler;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.dialect.Sqlite3Dialect;
import com.jfinal.plugin.ehcache.EhCachePlugin;
import com.moudel.ext.C3p0PluginExt;

public class MainCinfigAndStart extends JFinalConfig  {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Timer timer = new Timer("start-timer");
		timer.schedule(new TimerTask() {
			
			public void run() {
				try {
					Runtime.getRuntime().exec("rundll32 url.dll FileProtocolHandler " + "http://localhost:80");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}, 1000*3);
		JFinal.start("WebRoot", 80, "/", 5);
	}

	@Override
	public void configConstant(Constants me) {
		me.setDevMode(false);
		me.setEncoding("UTF-8");
	}

	@Override
	public void configRoute(Routes me) {
		me.add("/", Index.class);
		me.add("/dept",DeptCtrl.class);
		me.add("/user",UserCtrl.class);
		me.add("/project",ProjectCtrl.class); 
	}

	@Override
	public void configPlugin(Plugins me) {
		File profile = null;
		try {
			profile = new File(getClass().getResource("/jdbc.properties").toURI());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		C3p0PluginExt  cp  =  new  C3p0PluginExt(profile,"jdbc:sqlite:" + new File("WebRoot/WEB-INF/xmgl.db").toString()); 
		  
		  me.add(cp); 
	    
	    ActiveRecordPlugin arp = new ActiveRecordPlugin(cp); 
	    arp.setShowSql(true);
	    arp.setDialect(new Sqlite3Dialect());
	    me.add(arp); 
	    arp.addMapping("Bas_DptList","DptID", Dept.class);
	    arp.addMapping("Bas_userinfo", "Userid", User.class);
	    arp.addMapping("Info_prjvalues", "Prjid", Project.class);
	    
	    
	    me.add(new EhCachePlugin());
	}

	@Override
	public void configInterceptor(Interceptors me) {
		me.add(new LoginCheck());
	}

	@Override
	public void configHandler(Handlers me) {
		me.add(new ContextPathHandler());
	}

}
