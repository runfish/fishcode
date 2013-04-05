package org.apache.jsp.jsps.goods;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import java.util.*;

public final class input_005fgoods_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(1);
    _jspx_dependants.add("/jsps/common/taglibs.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_005ftest;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fif_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fif_005ftest.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("<html>\r\n");
      out.write("  <head>\r\n");
      out.write("    \r\n");
      out.write(" \r\n");
      out.write("    <title>商品信息录入</title>\r\n");
      out.write("    \r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=EmulateIE7\" /> \r\n");
      out.write("\t<meta http-equiv=\"pragma\" content=\"no-cache\">\r\n");
      out.write("\t<meta http-equiv=\"cache-control\" content=\"no-cache\">\r\n");
      out.write("\t<meta http-equiv=\"expires\" content=\"0\">    \r\n");
      out.write("\t<meta http-equiv=\"keywords\" content=\"keyword1,keyword2,keyword3\">\r\n");
      out.write("\t<meta http-equiv=\"description\" content=\"This is my page\">\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      if (_jspx_meth_c_005furl_005f0(_jspx_page_context))
        return;
      out.write("\"></script>\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      if (_jspx_meth_c_005furl_005f1(_jspx_page_context))
        return;
      out.write("\"/>\r\n");
      out.write("\r\n");
      out.write("   <script type=\"text/javascript\">\r\n");
      out.write("\t\r\n");
      out.write("\t    var g_sel_cnt=0; //全局select元素数量,根据类别层次深度的不同，页面出现的类别select数量也不同。\r\n");
      out.write("\t    \r\n");
      out.write("\t    function buildSelector(ctgPid){\r\n");
      out.write("\r\n");
      out.write("\t       new Ajax.Request(\r\n");
      out.write("            encodeURI(\"goodsMgr?act=getSubCtgs&seed=\"+Math.random()+\"&ctgPid=\"+parseInt(ctgPid)),\r\n");
      out.write("            {\r\n");
      out.write("              method:\"get\",\r\n");
      out.write("              onComplete:function(xhr){\r\n");
      out.write("              \r\n");
      out.write("                  //如果子级别查询不存在，则不再继续创建下级类别\r\n");
      out.write("                  if(xhr.responseText==\"\"){ \r\n");
      out.write("                     //alert(\"不存在下级类别，操作停止!\");\r\n");
      out.write("                     return;\r\n");
      out.write("                  }\r\n");
      out.write("                  \r\n");
      out.write("                  var subCtgInfo=\"-1:=请选择=|0:[顶级类别]|\"+xhr.responseText;\r\n");
      out.write("                  var optionStr=subCtgInfo.split(\"|\");\r\n");
      out.write("                                                   \r\n");
      out.write("                  var sel=document.createElement(\"SELECT\");\r\n");
      out.write("                  g_sel_cnt++;//新增select\r\n");
      out.write("                  sel.id=\"sel\"+g_sel_cnt; //设置新创建的select的id.\r\n");
      out.write("                  \r\n");
      out.write("                  //设置该select的option\r\n");
      out.write("                  \r\n");
      out.write("                  for(i=0;i<optionStr.length;i++){\r\n");
      out.write("                     if(i==1&&g_sel_cnt!=1) continue; //只有第一级select才封装顶级类别选项\r\n");
      out.write("                     var opt=document.createElement(\"OPTION\");\r\n");
      out.write("                     opt.value=optionStr[i].split(\":\")[0];\r\n");
      out.write("                     opt.text=optionStr[i].split(\":\")[1];\r\n");
      out.write("                     sel.add(opt,sel.options[null]); //类似于append到select的options的末尾。\r\n");
      out.write("                  }\r\n");
      out.write("                  \r\n");
      out.write("                  sel.onchange=function(){\r\n");
      out.write("                  \r\n");
      out.write("                                var ctgPid=this.options[this.selectedIndex].value;//要查询子类别的父类别                                                                                             \r\n");
      out.write("                                var level=parseInt(this.id.charAt(3));//当前操作的select的级别\r\n");
      out.write("                                                                \r\n");
      out.write("                                \r\n");
      out.write("                               // alert(\"level:\"+level+\",g_count:\"+g_sel_cnt);\r\n");
      out.write("                               // alert($('ctgSelectArea').childNodes.length);\r\n");
      out.write("                                //for(i=0;i<$('ctgSelectArea').childNodes.length;i++)\r\n");
      out.write("                                //  alert($('ctgSelectArea').childNodes[i].tagName);\r\n");
      out.write("                                \r\n");
      out.write("                                var delTimes=g_sel_cnt-level;\r\n");
      out.write("                                for(i=1;i<=delTimes;i++){\r\n");
      out.write("                                    $('ctgSelectArea').removeChild($('ctgSelectArea').lastChild);\r\n");
      out.write("                                    g_sel_cnt--; //全局计数器减1\r\n");
      out.write("                                }\r\n");
      out.write("                                \r\n");
      out.write("                                var ctgLinkStr=\"\";\r\n");
      out.write("                                for(i=1;i<=g_sel_cnt;i++){\r\n");
      out.write("                                  with($('sel'+i)){\r\n");
      out.write("                                    if(options[selectedIndex].value!=-1){\r\n");
      out.write("                                      if(i==1) \r\n");
      out.write("                                        ctgLinkStr=options[selectedIndex].text;\r\n");
      out.write("                                      else\r\n");
      out.write("                                        ctgLinkStr+=\"->\"+options[selectedIndex].text;\r\n");
      out.write("                                    }\r\n");
      out.write("                                  }\r\n");
      out.write("                                }\r\n");
      out.write("\r\n");
      out.write("                               // alert(ctgLinkStr);\r\n");
      out.write("                                                                \r\n");
      out.write("                                if(ctgPid!=-1) buildSelector(ctgPid);\r\n");
      out.write("                                \r\n");
      out.write("                                if(ctgPid==-1 && level!=1){ //用户选择了非第一级\"请选择\",选择上一级值替代\r\n");
      out.write("                                  with($('sel'+(--level))){\r\n");
      out.write("                                     ctgPid=options[selectedIndex].value;\r\n");
      out.write("                                  }\r\n");
      out.write("                                }\r\n");
      out.write("                                \r\n");
      out.write("                                document.forms[0].goodsctgid.value=ctgPid;//设置隐藏域保存\r\n");
      out.write("                                \r\n");
      out.write("                                //$(\"ctglink\").innerText=(ctgLinkStr==\"\"?\"[尚未设置]\":ctgLinkStr);\r\n");
      out.write("                                \r\n");
      out.write("                               }\r\n");
      out.write("                  \r\n");
      out.write("                   $('ctgSelectArea').appendChild(sel);\r\n");
      out.write("                                 \r\n");
      out.write("              }\r\n");
      out.write("            }            \r\n");
      out.write("           );\r\n");
      out.write("          \r\n");
      out.write("\t    }\r\n");
      out.write("\t    \r\n");
      out.write("\t    function validateEntry(inputFrm){\r\n");
      out.write("\t        with(inputFrm){\r\n");
      out.write("\t           //alert('asdsds');\r\n");
      out.write("\t          //  alert(goodsctgid.value);\r\n");
      out.write("\t           if(goodsname.value==\"\"){\r\n");
      out.write("\t               alert('商品名称不能为空，请重新录入');\r\n");
      out.write("\t               ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${'goodsname'}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(".select();\r\n");
      out.write("\t               return false;\r\n");
      out.write("\t           }\r\n");
      out.write("\t           if(goodsprice.value==\"\"){\r\n");
      out.write("\t               alert('商品价格不能为空，请重新录入');\r\n");
      out.write("\t               ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${'goodsprice'}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(".select();\r\n");
      out.write("\t               return false;\r\n");
      out.write("\t           }\r\n");
      out.write("\t           if(isNaN(goodsprice.value)){\r\n");
      out.write("\t              alert('商品价格必须为数字，请重新录入');\r\n");
      out.write("\t              ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${'goodsprice'}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(".select();\r\n");
      out.write("\t              return false;\r\n");
      out.write("\t           }\r\n");
      out.write("\t           if(goodsqty.value==\"\"){\r\n");
      out.write("\t              alert('商品库存数量不能为空，请重新录入');\r\n");
      out.write("\t              ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${'goodsqty'}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(".select();\r\n");
      out.write("\t              return false;\r\n");
      out.write("\t           }\r\n");
      out.write("\t           if(isNaN(goodsqty.value)||(goodsqty.value<0)){\r\n");
      out.write("\t               alert('商品库存数量必须为大等于零的数字');\r\n");
      out.write("\t               ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${'goodsqty'}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(".select();\r\n");
      out.write("\t               return false;\r\n");
      out.write("\t           }\r\n");
      out.write("\t       \r\n");
      out.write("\t        }\r\n");
      out.write("\t    }\r\n");
      out.write("\t//刷新图片\r\n");
      out.write("\t    function changeImage(object)\r\n");
      out.write("\t    {\r\n");
      out.write("\t       var picUrl=getPath(object);\r\n");
      out.write("\t       if(picUrl)\r\n");
      out.write("\t       {\r\n");
      out.write("           \t\tvar goodsView=document.getElementById(\"goodsview\");\r\n");
      out.write("           \t\tgoodsView.src=picUrl;\r\n");
      out.write("           }\r\n");
      out.write("           else\r\n");
      out.write("           {\r\n");
      out.write("           \t\tgoodsView.src=\"/pics/default.gif\";\r\n");
      out.write("           }\r\n");
      out.write("\t    }\r\n");
      out.write("\t    \r\n");
      out.write("\t//获得上传文件的全路径\r\n");
      out.write("    function getPath(object) \r\n");
      out.write("    { \r\n");
      out.write("      var browserName = navigator.appName;\r\n");
      out.write("      var browserVer = parseInt ( navigator.appVersion );\r\n");
      out.write("      if (( browserName == \"Microsoft Internet Explorer\") && (browserVer+5 >=9) )\r\n");
      out.write("      {\r\n");
      out.write("        object.select();\r\n");
      out.write("        var button=document.getElementById(\"submit\");\r\n");
      out.write("        button.focus();\r\n");
      out.write("        path= document.selection.createRange().text;\r\n");
      out.write("        var array=path.split(\"\\\\\");\r\n");
      out.write("        var realPath=array.join(\"/\");\r\n");
      out.write("        return realPath;\r\n");
      out.write("      }\r\n");
      out.write("      else if (( browserName == \"Microsoft Internet Explorer\") && (browserVer+5 <9) )\r\n");
      out.write("      {\r\n");
      out.write("      \tobject.select();\r\n");
      out.write("        path= document.selection.createRange().text;\r\n");
      out.write("        var array=path.split(\"\\\\\");\r\n");
      out.write("        var realPath=array.join(\"/\");\r\n");
      out.write("        return realPath;\r\n");
      out.write("      }\r\n");
      out.write("      else \r\n");
      out.write("      {\r\n");
      out.write("         alert(\"对不起图片预览功能暂时不支持非IE浏览器!\");\r\n");
      out.write("         return ;\r\n");
      out.write("      }\r\n");
      out.write("    } \r\n");
      out.write("\t\r\n");
      out.write("\t</script>\r\n");
      out.write("\t\r\n");
      out.write("  </head>\r\n");
      out.write("  \r\n");
      out.write("  <body onload=\"buildSelector(0)\">\r\n");
      out.write("     <div id=\"f_title\">品信息登记</div>\r\n");
      out.write("     <form action=\"");
      if (_jspx_meth_c_005furl_005f2(_jspx_page_context))
        return;
      out.write("\" method=\"post\"  onsubmit =\"return validateEntry(this);\" enctype=\"multipart/form-data\">\r\n");
      out.write("      <input type=\"hidden\" name=\"act\" value=\"create\"/>\r\n");
      out.write("      \r\n");
      out.write("        <div class=\"f_row\">\r\n");
      out.write("\t          <span>商品名称:</span>\r\n");
      out.write("\t          <input type=\"text\" name=\"goodsname\" size=\"20\"/>\r\n");
      out.write("\t    </div>\r\n");
      out.write("\t    \r\n");
      out.write("\t    <div class=\"f_row\">\r\n");
      out.write("\t          <span>商品单价:</span>\r\n");
      out.write("\t          <input type=\"text\" name=\"goodsprice\" size=\"20\"/>\r\n");
      out.write("\t    </div>\r\n");
      out.write("\t \r\n");
      out.write("\t    <input type=\"hidden\" name=\"goodsctgid\"/>\r\n");
      out.write("\t    <div id=\"ctgSelectArea\" class=\"f_row\" \"><span class=\"rowHeader\">商品类别:</span></div>\r\n");
      out.write("\t    \r\n");
      out.write("\t    <div class=\"f_row\">\r\n");
      out.write("\t         <span>商品库存数量</span>\r\n");
      out.write("\t         <input type=\"text\" name=\"goodsqty\" size=\"20\"/>\r\n");
      out.write("\t    </div>\r\n");
      out.write("\t    \r\n");
      out.write("\t    <div id=\"imagepath\" class=\"f_row\">\r\n");
      out.write("\t          <span style=\"margin-left:55px;\">\r\n");
      out.write("\t          <image id=\"goodsview\" width=\"200px\" height=\"160px\" src=\"");
      if (_jspx_meth_c_005furl_005f3(_jspx_page_context))
        return;
      out.write("\"/></span><br/>\r\n");
      out.write("\t          <span>商品图片:</span>\r\n");
      out.write("\t          <input type=\"file\" id=\"goodsimage\" name=\"goodsimage\" size=\"60\" onchange=\"changeImage(this);\"/>\r\n");
      out.write("\t   </div>\r\n");
      out.write("\t   \r\n");
      out.write("\t   <div class=\"f_row\" >\r\n");
      out.write("\t       <span>商品说明</span>\r\n");
      out.write("\t     <textarea rows=\"6\" cols=\"50\" name=\"goodsdesc\"></textarea>\r\n");
      out.write("\t     \r\n");
      out.write("\t   </div>\r\n");
      out.write("\t    \r\n");
      out.write("\t  \t<div class=\"f_row\">\r\n");
      out.write("\t          <input id=\"submit\" type=\"submit\" value=\"保存信息\"/>        \t       \r\n");
      out.write("\t    </div>\r\n");
      out.write("     </form>\r\n");
      out.write("    ");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("  </body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005furl_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f0 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f0.setParent(null);
    // /jsps/goods/input_goods.jsp(17,37) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f0.setValue("/js/prototype.js");
    int _jspx_eval_c_005furl_005f0 = _jspx_th_c_005furl_005f0.doStartTag();
    if (_jspx_th_c_005furl_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f1 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f1.setParent(null);
    // /jsps/goods/input_goods.jsp(20,46) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f1.setValue("/css/form.css");
    int _jspx_eval_c_005furl_005f1 = _jspx_th_c_005furl_005f1.doStartTag();
    if (_jspx_th_c_005furl_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f2 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f2.setParent(null);
    // /jsps/goods/input_goods.jsp(193,19) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f2.setValue("/action/goodsMgr");
    int _jspx_eval_c_005furl_005f2 = _jspx_th_c_005furl_005f2.doStartTag();
    if (_jspx_th_c_005furl_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f2);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f3 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f3.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f3.setParent(null);
    // /jsps/goods/input_goods.jsp(216,67) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f3.setValue("/pics/default.gif");
    int _jspx_eval_c_005furl_005f3 = _jspx_th_c_005furl_005f3.doStartTag();
    if (_jspx_th_c_005furl_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f3);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f0.setParent(null);
    // /jsps/goods/input_goods.jsp(231,4) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${not empty err}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("       <script type=\"text/javascript\">\r\n");
        out.write("         alert('");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${err}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("');\r\n");
        out.write("       </script>\r\n");
        out.write("    ");
        int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_005ftest.reuse(_jspx_th_c_005fif_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_005ftest.reuse(_jspx_th_c_005fif_005f0);
    return false;
  }
}
