package org.apache.jsp.jsps.category;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import java.util.*;

public final class input_005fctg_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(1);
    _jspx_dependants.add("/jsps/common/taglibs.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.release();
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
      out.write("  <html>\r\n");
      out.write("  <head>\r\n");
      out.write("    \r\n");
      out.write("    <title>类别信息录入</title>   \r\n");
      out.write("\t<meta http-equiv=\"pragma\" content=\"no-cache\">\r\n");
      out.write("\t<meta http-equiv=\"cache-control\" content=\"no-cache\">\r\n");
      out.write("\t<meta http-equiv=\"expires\" content=\"0\">    \r\n");
      out.write("\t<meta http-equiv=\"keywords\" content=\"keyword1,keyword2,keyword3\">\r\n");
      out.write("\t<meta http-equiv=\"description\" content=\"This is my page\">\r\n");
      out.write("\t<!--\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"styles.css\">\r\n");
      out.write("\t-->\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      if (_jspx_meth_c_005furl_005f0(_jspx_page_context))
        return;
      out.write("\"/>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      if (_jspx_meth_c_005furl_005f1(_jspx_page_context))
        return;
      out.write("\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\r\n");
      out.write("\t    var g_sel_cnt=0; \r\n");
      out.write("\t    function buildSelector(ctgPid){\r\n");
      out.write("\t       new Ajax.Request(\r\n");
      out.write("            encodeURI(\"categoryMgr?act=getSubCtgs&seed=\"+Math.random()+\"&ctgPid=\"+parseInt(ctgPid)),\r\n");
      out.write("            {\r\n");
      out.write("              method:\"get\",\r\n");
      out.write("              onComplete:function(xhr){\r\n");
      out.write("                  if(xhr.responseText==\"\"){ \r\n");
      out.write("                     return;\r\n");
      out.write("                  }        \r\n");
      out.write("                  var subCtgInfo=\"-1:=请选择=|0:[顶级类别]|\"+xhr.responseText;\r\n");
      out.write("                  var optionStr=subCtgInfo.split(\"|\");\r\n");
      out.write("                                                   \r\n");
      out.write("                  var sel=document.createElement(\"SELECT\");\r\n");
      out.write("                  g_sel_cnt++;\r\n");
      out.write("                  sel.id=\"sel\"+g_sel_cnt;        \r\n");
      out.write("                  for(i=0;i<optionStr.length;i++){\r\n");
      out.write("                     if(i==1&&g_sel_cnt!=1) continue;\r\n");
      out.write("                     var opt=document.createElement(\"OPTION\");\r\n");
      out.write("                     opt.value=optionStr[i].split(\":\")[0];\r\n");
      out.write("                     opt.text=optionStr[i].split(\":\")[1];\r\n");
      out.write("                     sel.add(opt,sel.options[null]);\r\n");
      out.write("                  }          \r\n");
      out.write("                  sel.onchange=function(){            \r\n");
      out.write("                                var ctgPid=this.options[this.selectedIndex].value;                                                                                            \r\n");
      out.write("                                var level=parseInt(this.id.charAt(3));              \r\n");
      out.write("                                var delTimes=g_sel_cnt-level;\r\n");
      out.write("                                for(i=1;i<=delTimes;i++){\r\n");
      out.write("                                    $('ctgSelectArea').removeChild($('ctgSelectArea').lastChild);\r\n");
      out.write("                                    g_sel_cnt--; \r\n");
      out.write("                                }   \r\n");
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
      out.write("                                //alert(ctgLinkStr);\r\n");
      out.write("                                                                \r\n");
      out.write("                                if(ctgPid!=-1) buildSelector(ctgPid);\r\n");
      out.write("                                \r\n");
      out.write("                                if(ctgPid==-1 && level!=1){ \r\n");
      out.write("                                  with($('sel'+(--level))){\r\n");
      out.write("                                     ctgPid=options[selectedIndex].value;\r\n");
      out.write("                                  }\r\n");
      out.write("                                }\r\n");
      out.write("                                \r\n");
      out.write("                                document.forms[0].ctgpid.value=ctgPid;\r\n");
      out.write("                                $(\"ctglink\").innerText=(ctgLinkStr==\"\"?\"[尚未设置]\":ctgLinkStr);\r\n");
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
      out.write("\t    function validateEntry(inputFrm){\r\n");
      out.write("\t        with(inputFrm){\r\n");
      out.write("\t           if(ctgname.value==\"\"){\r\n");
      out.write("\t               alert('商品类别名称不能为空，请重新录入');\r\n");
      out.write("\t               ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${'ctgname'}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(".select();\r\n");
      out.write("\t               return false;\r\n");
      out.write("\t          }\r\n");
      out.write("\t        }\r\n");
      out.write("\t     }\r\n");
      out.write("\t\r\n");
      out.write("\t</script>\r\n");
      out.write("\t\r\n");
      out.write("  </head>\r\n");
      out.write("  \r\n");
      out.write("  <body onload=\"buildSelector(0)\">\r\n");
      out.write("  \r\n");
      out.write("    <form action=\"categoryMgr\" method=\"post\" onsubmit =\"return validateEntry(this);\">\r\n");
      out.write("        <input type=\"hidden\" name=\"act\" value=\"create\"/>\r\n");
      out.write("\t    <div id=\"wrapper\">\r\n");
      out.write("\t\t    <h3>新增商品类别</h3>\r\n");
      out.write("\t\t    <div class=\"formRow\">\r\n");
      out.write("\t\t      <span class=\"rowHeader\">类别名称:</span>\r\n");
      out.write("\t\t      <input type=\"text\" name=\"ctgname\"/>\r\n");
      out.write("\t\t    </div>\r\n");
      out.write("\t\t    <div class=\"formRow\">\r\n");
      out.write("\t\t      <span class=\"rowHeader\">上级类别:</span>\r\n");
      out.write("\t\t      <span id=\"ctgLink\">[尚未设置]</span>\r\n");
      out.write("\t\t      <input type=\"hidden\" name=\"ctgpid\"/>\r\n");
      out.write("\t\t      <div id=\"ctgSelectArea\"><span class=\"rowHeader\">设置:</span></div>\r\n");
      out.write("\t\t    </div>\r\n");
      out.write("\t\t    <div class=\"formRow\">\r\n");
      out.write("\t\t      <input type=\"submit\" value=\"创建类别\"/>\r\n");
      out.write("\t\t    </div> \r\n");
      out.write("\t    </div>\r\n");
      out.write("    </form>\r\n");
      out.write("    \r\n");
      out.write("  </body>\r\n");
      out.write("  \r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
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
    // /jsps/category/input_ctg.jsp(17,46) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f0.setValue("/css/form2.css");
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
    // /jsps/category/input_ctg.jsp(18,37) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f1.setValue("/js/prototype.js");
    int _jspx_eval_c_005furl_005f1 = _jspx_th_c_005furl_005f1.doStartTag();
    if (_jspx_th_c_005furl_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f1);
    return false;
  }
}
