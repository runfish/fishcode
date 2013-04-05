package org.apache.jsp.jsps;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import java.util.*;
import net.dfrz.supershop01.config.VersionInfo;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(1);
    _jspx_dependants.add("/jsps/common/footer.jsp");
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("<html>\r\n");
      out.write("  <head>\r\n");
      out.write("   \r\n");
      out.write("    <title></title>\r\n");
      out.write("    \r\n");
      out.write("\t<meta http-equiv=\"pragma\" content=\"no-cache\">\r\n");
      out.write("\t<meta http-equiv=\"cache-control\" content=\"no-cache\">\r\n");
      out.write("\t<meta http-equiv=\"expires\" content=\"0\">    \r\n");
      out.write("\t<meta http-equiv=\"keywords\" content=\"keyword1,keyword2,keyword3\">\r\n");
      out.write("\t<meta http-equiv=\"description\" content=\"This is my page\">\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      if (_jspx_meth_c_005furl_005f0(_jspx_page_context))
        return;
      out.write("\">\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      if (_jspx_meth_c_005furl_005f1(_jspx_page_context))
        return;
      out.write("\">\r\n");
      out.write("    \r\n");
      out.write("    <style>\r\n");
      out.write("      *{margin:0;padding:0;}\r\n");
      out.write("      html,body{\r\n");
      out.write("      \theight:100%;\r\n");
      out.write("    \tmargin:0;\r\n");
      out.write("    \tpadding:0;\r\n");
      out.write("      }\r\n");
      out.write("      body{\r\n");
      out.write("    \tbackground:#eae7d7;\r\n");
      out.write("    \ttext-align:center;\r\n");
      out.write("    \tmin-width:626px;\r\n");
      out.write("    \tmin-height:400px;\r\n");
      out.write("      }\r\n");
      out.write("      #center{\r\n");
      out.write("        position:absolute;\r\n");
      out.write("\t    top:50%;\r\n");
      out.write("\t    left:50%;\r\n");
      out.write("\t    margin-top:-198px;\r\n");
      out.write("\t    margin-left:-313px;\r\n");
      out.write("\t    width:624px;\r\n");
      out.write("\t    height:394px;\r\n");
      out.write("\t    border:1px solid silver;\r\n");
      out.write("\t    background:white;\r\n");
      out.write("\t    overflow:auto;\r\n");
      out.write("\t    text-align:center;\r\n");
      out.write("      }\r\n");
      out.write("       #title{\r\n");
      out.write("        position:absolute;\r\n");
      out.write("      \tfont-size:28px;\r\n");
      out.write("      \tfont-family:方正琥珀繁体;\r\n");
      out.write("      \tcolor:white;\r\n");
      out.write("      \ttext-decoration:underline;\r\n");
      out.write("      \twidth:8cm;\r\n");
      out.write("      \theight:2.5cm;\r\n");
      out.write("      \ttop:10px;\r\n");
      out.write("      \tfloat:left;\r\n");
      out.write("      }\r\n");
      out.write("      #bground{\r\n");
      out.write("      \twidth:622px;\r\n");
      out.write("      \theight:388px;\r\n");
      out.write("      }\r\n");
      out.write("      #mainbody{\r\n");
      out.write("        position:absolute;\r\n");
      out.write("        right:5%;\r\n");
      out.write("        top:10%;\r\n");
      out.write("        width:300px;\r\n");
      out.write("        height:175px;\r\n");
      out.write("      }\r\n");
      out.write("      #bottom{\r\n");
      out.write("        position:absolute;\r\n");
      out.write("        top:80%;\r\n");
      out.write("        right:0%;\r\n");
      out.write("      }\r\n");
      out.write("      #submit{\r\n");
      out.write("         position:absolute;\r\n");
      out.write("         cursor:hand;\r\n");
      out.write("         rigth:700px;\r\n");
      out.write("         filter:alpha(opacity=0);\r\n");
      out.write("         width:90px;\r\n");
      out.write("         height:35px;\r\n");
      out.write("      }\r\n");
      out.write("      .error{\r\n");
      out.write("        border:1px solid yellow;\r\n");
      out.write("        background:pink;\r\n");
      out.write("        color:red;\r\n");
      out.write("        width:210px;\r\n");
      out.write("        padding:8px;\r\n");
      out.write("        margin:5px;\r\n");
      out.write("      }  \r\n");
      out.write("    </style>\r\n");
      out.write("    \r\n");
      out.write("    <script type=\"text/javascript\" src=\"jquery-1.8.3.min.js\"></script>\r\n");
      out.write("    \r\n");
      out.write("    <script type=\"text/javascript\">\r\n");
      out.write("       \r\n");
      out.write("      \r\n");
      out.write("       function validateEntry(loginFrm){\r\n");
      out.write("         \r\n");
      out.write("           with(loginFrm){\r\n");
      out.write("             \r\n");
      out.write("              if(username.value==\"\"){\r\n");
      out.write("                 alert(\"用户帐号必须填写!\");\r\n");
      out.write("                 userno.select();\r\n");
      out.write("                 return false;\r\n");
      out.write("              }\r\n");
      out.write("              \r\n");
      out.write("              if(userpwd.value==\"\"){\r\n");
      out.write("                alert(\"登陆密码必须填写!\");\r\n");
      out.write("                userpwd.select();\r\n");
      out.write("                return false;\r\n");
      out.write("              }\r\n");
      out.write("           }\r\n");
      out.write("           return true; \r\n");
      out.write("       }\r\n");
      out.write("    //刷新验证码图片\r\n");
      out.write("    function changeImage(object)\r\n");
      out.write("    {\r\n");
      out.write("       object.src='");
      if (_jspx_meth_c_005furl_005f2(_jspx_page_context))
        return;
      out.write("'+Math.random();\r\n");
      out.write("    }\r\n");
      out.write("   //清楚登入按钮点击后的虚线框\r\n");
      out.write("   function clearLine(object)\r\n");
      out.write("   {\r\n");
      out.write("      object.blur();\r\n");
      out.write("   }\r\n");
      out.write("  </script>\r\n");
      out.write("    \r\n");
      out.write("  </head>\r\n");
      out.write("  \r\n");
      out.write("  <body>\r\n");
      out.write("  <div id=\"center\">\r\n");
      out.write("  <div id=\"title\"><b><i>电子商务后台管理系统</i></b></div>\r\n");
      out.write("   <div id=\"bground\">\r\n");
      out.write("      <img src=\"/shop02/pics/loginpic/loginbg.jpg\" style=\"width:100%;height:100%\"/>\r\n");
      out.write("    </div>\r\n");
      out.write("\t<div id=\"mainbody\">\r\n");
      out.write("\t   <form action=\"");
      if (_jspx_meth_c_005furl_005f3(_jspx_page_context))
        return;
      out.write("\" method=\"post\" onsubmit=\"return validateEntry(this);\">\r\n");
      out.write("\t\t  <div class=\"f_row\">\r\n");
      out.write("\t\t      <span style=\"margin:10px\">用户帐号:</span>\r\n");
      out.write("\t\t      <input type=\"text\" name=\"username\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.userno==null?'hhg0012':param.username}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("\t\t  </div>\r\n");
      out.write("\t\t  <div class=\"f_row\">\r\n");
      out.write("\t\t      <span style=\"margin:10px\">登录密码:</span>\r\n");
      out.write("\t\t      <input type=\"password\" name=\"userpwd\" value=\"123456\"/>        \r\n");
      out.write("\t\t  </div>\r\n");
      out.write("\t\t  <div class=\"f_row\">\r\n");
      out.write("\t\t  <span style=\"margin:10px\">验证码：</span>\r\n");
      out.write("\t\t      <input name=\"imgcode\" type=\"text\" style=\"margin-left:8px;\" size=\"8\"/>\r\n");
      out.write("\t    \t  <img src=\"");
      if (_jspx_meth_c_005furl_005f4(_jspx_page_context))
        return;
      out.write("\" style=\"cursor:hand\" onclick=\"changeImage(this);\"></img>\r\n");
      out.write("\t\t  </div> \r\n");
      out.write("\t\t  <div>\r\n");
      out.write("\t\t    <input type=\"radio\" name=\"isadmin\" value=\"0\" checked=\"checked\"/>普通管理员\r\n");
      out.write("\t\t    <input type=\"radio\" name=\"isadmin\" value=\"1\"/>超级管理员\r\n");
      out.write("\t\t  </div>       \r\n");
      out.write("\t\t     ");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t  <div class=\"f_row\">\r\n");
      out.write("\t      <img style=\"position:absolute;\" src=\"/shop02/pics/loginpic/loginbtn.gif\">    \r\n");
      out.write("\t      <input id=\"submit\" value=\"\" type=\"submit\" onclick=\"clearLine(this);\"/> \r\n");
      out.write("\t\t  </div>                        \r\n");
      out.write("     </form>\r\n");
      out.write("  </div>\r\n");
      out.write("   <div id=\"bottom\">\r\n");
      out.write("         ");
      out.write("\r\n");
      out.write("<hr/>\r\n");
      out.write("<div style=\"margin:10px;text-align:center;color:gray\">\r\n");
      out.write("  ");
      out.print(VersionInfo.buildFooterStr());
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
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
    // /jsps/login.jsp(15,46) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f0.setValue("/css/application.css");
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
    // /jsps/login.jsp(16,49) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
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
    // /jsps/login.jsp(115,19) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f2.setValue("/action/checkCode?rand=");
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
    // /jsps/login.jsp(133,18) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f3.setValue("/action/securityMgr?act=login");
    int _jspx_eval_c_005furl_005f3 = _jspx_th_c_005furl_005f3.doStartTag();
    if (_jspx_th_c_005furl_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f3);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f4(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f4 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f4.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f4.setParent(null);
    // /jsps/login.jsp(145,18) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f4.setValue("/action/checkCode");
    int _jspx_eval_c_005furl_005f4 = _jspx_th_c_005furl_005f4.doStartTag();
    if (_jspx_th_c_005furl_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f4);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f4);
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
    // /jsps/login.jsp(151,7) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${not empty error}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t      <div class=\"error\">\r\n");
        out.write("\t\t\t            ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${error}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("\r\n");
        out.write("\t\t\t      </div>\r\n");
        out.write("\t\t     ");
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
