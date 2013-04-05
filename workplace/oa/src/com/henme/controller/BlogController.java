package com.henme.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;

import com.jfinal.aop.Before;
import com.jfinal.aop.ClearInterceptor;
import com.jfinal.aop.ClearLayer;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.render.DwzRender;
import com.jfinal.upload.UploadFile;

/**
 * BlogController
 */



public class BlogController extends Controller {
	// @Before(CacheInterceptor.class)
	// @CacheName(value = "list")

	private BlogService blogService = new BlogService();

	@Before({ BlogPageInfo.class })
	
	public void index() {
		BlogPageInfo pageInfo = getAttr("pageInfo");
		setAttr("page", blogService.paginate(pageInfo));
		// this.keepPara();
		// setAttr("title",pageInfo.title);
		render("page.html");
	}

	@RequiresPermissions("blog:list")
	public void list() {
		setAttr("page", Db.paginate(getParaToInt("pageNum", 1),
				getParaToInt("numPerPage", 5),
				"select id,title,content", " from  blog"));
		setAttr("collist", new String[] { "title", "content" });
		render("list.html");
	}

	@Before(BlogValidator.class)
	public void save() {
		Blog model = getModel(Blog.class);
		if (model.getInt("id") == null) {
			model.save();
		} else {
			model.update();
		}
		render(DwzRender.closeCurrentAndRefresh("pageBlog"));
	}

	public void edit() {
		int id = getParaToInt(0);
		Blog blog = Blog.dao.findById(id);
		if (id == 0) {
			blog = new Blog();
		} else if (blog == null) {
			render(DwzRender.error("该记录已被删除，请您先刷新列表"));
		}
		setAttr("blog", blog);
	}

	// closeCurrent

	public void delete() {
		Blog.dao.deleteById(getParaToInt());
		render(DwzRender.success());
	}

	public void upload() {
		List<UploadFile> files = getFiles();
		System.out.println(getPara("text"));
		System.out.println(files);
	}

	public void download() {
		renderFile("/upload/JFinal-1.0.8-手册.pdf");
	}

}
