/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-04-27 18:13:41 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import java.util.*;
import java.util.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/view/footer.jsp", Long.valueOf(1524843220949L));
    _jspx_dependants.put("/WEB-INF/view/header.jsp", Long.valueOf(1524850505320L));
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fchoose;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fotherwise;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fchoose = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fotherwise = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fchoose.release();
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.release();
    _005fjspx_005ftagPool_005fc_005fotherwise.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\t<title></title>\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"css/bootstrap.css\">\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"css/wangEditor.css\">\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"css/base.css\">\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"css/login.css\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"header clearfix\">\r\n");
      out.write("    <div class=\"w\">\r\n");
      out.write("        <h1 class=\"logo\"><a href=\"toIndex.do\">211社区</a></h1>\r\n");
      out.write("        <ul class=\"left-nav\">\r\n");
      out.write("            <li class=\"current-nav\"><a href=\"toIndex.do\">首页</a></li>\r\n");
      out.write("            <li><a href=\"listTopic.do\">招聘</a></li>\r\n");
      out.write("            <li><a href=\"listImage.do\">鹊桥</a></li>\r\n");
      out.write("            ");
      out.write("\r\n");
      out.write("        </ul>\r\n");
      out.write("\r\n");
      out.write("        <ul class=\"right-nav\">\r\n");
      out.write("            ");
      if (_jspx_meth_c_005fchoose_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                <li>\r\n");
      out.write("                    <a href=\"#\"><span class=\"glyphicon glyphicon-search\"></span></a>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li><input type=\"text\"></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<!-- 中间主体板块 -->\r\n");
      out.write("\t<div class=\"main w clearfix\">\r\n");
      out.write("\t\t<div class=\"buttons clearfix\">\r\n");
      out.write("\t\t\t<a href=\"#\" id=\"login-button\" class=\"selected\"><span class=\"glyphicon glyphicon-user\"></span>&nbsp;登录</a>\r\n");
      out.write("\t\t\t<a href=\"#\" id=\"register-button\" class=\"unselected\"><span class=\"glyphicon glyphicon-pencil\"></span>&nbsp;注册</a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"contents\">\r\n");
      out.write("\t\t\t<div id=\"login-area\">\r\n");
      out.write("\t\t\t\t<form action=\"login.do\" method=\"post\">\r\n");
      out.write("\t\t\t\t\t<div class=\"error-message\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${error}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"email\">\r\n");
      out.write("\t\t\t\t\t\t邮箱&nbsp;\r\n");
      out.write("\t\t\t\t\t\t<input id=\"login-email\" type=\"text\" name=\"email\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${email}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" required>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"password\">\r\n");
      out.write("\t\t\t\t\t\t密码&nbsp;\r\n");
      out.write("\t\t\t\t\t\t<input type=\"password\" name=\"password\" required>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<button id=\"login-submit\">立即登录</button>\r\n");
      out.write("\t\t\t\t\t<button type=\"button\" id=\"forget-password\">忘记密码</button>\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div id=\"register-area\">\r\n");
      out.write("\t\t\t\t<form action=\"register.do\" method=\"post\">\r\n");
      out.write("\t\t\t\t\t<div id=\"error-message\" class=\"error-message\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${error}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"email\">\r\n");
      out.write("\t\t\t\t\t\t邮箱&nbsp;\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" name=\"email\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${email}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" id=\"email\" required>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"password\">\r\n");
      out.write("\t\t\t\t\t\t密码&nbsp;\r\n");
      out.write("\t\t\t\t\t\t<input type=\"password\" name=\"password\" id=\"password\" required>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"password relative clearfix\">\r\n");
      out.write("\t\t\t\t\t\t<span style=\"position: absolute;left: -30px;\">重复密码&nbsp;</span>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"password\" name=\"repassword\" id=\"repassword\" required style=\"position: absolute;left: 40px;\">\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"relative\">\r\n");
      out.write("\t\t\t\t\t\t<button id=\"register-submit\">立即注册</button>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div><!-- 主体结束 -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"footer\">\r\n");
      out.write("    <div class=\"w\">DF论坛@2016 All Rights Reserved</div>\r\n");
      out.write("</div>");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/jquery-1.10.2.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/base.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t$(function(){\r\n");
      out.write("\t\tvar loginButton = $(\"#login-button\");\r\n");
      out.write("\t\tvar registerButton = $(\"#register-button\");\r\n");
      out.write("\t\tvar lArea = $(\"#login-area\");\r\n");
      out.write("\t\tvar rArea = $(\"#register-area\");\r\n");
      out.write("\t\trArea.hide();\r\n");
      out.write("\r\n");
      out.write("\t\tloginButton.click(function(){\r\n");
      out.write("\t\t\tloginButton.addClass(\"selected\");\r\n");
      out.write("\t\t\tloginButton.removeClass(\"unselected\");\r\n");
      out.write("\t\t\tregisterButton.addClass(\"unselected\");\r\n");
      out.write("\t\t\tregisterButton.removeClass(\"selected\");\r\n");
      out.write("\t\t\tlArea.show();\r\n");
      out.write("\t\t\trArea.hide();\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\tregisterButton.click(function(){\r\n");
      out.write("\t\t\tregisterButton.addClass(\"selected\");\r\n");
      out.write("\t\t\tregisterButton.removeClass(\"unselected\");\r\n");
      out.write("\t\t\tloginButton.addClass(\"unselected\");\r\n");
      out.write("\t\t\tloginButton.removeClass(\"selected\");\r\n");
      out.write("\t\t\tlArea.hide();\r\n");
      out.write("\t\t\trArea.show();\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("        if(location.href.indexOf(\"#register\")>=0){\r\n");
      out.write("            registerButton.click();\r\n");
      out.write("        }else{\r\n");
      out.write("            loginButton.click();\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        //根据是否是注册跳回来，切换到注册页面\r\n");
      out.write("        var hideInfo = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${register}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("        if(hideInfo!=null && hideInfo!=\"\"){\r\n");
      out.write("            registerButton.click();\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t//输入校验\r\n");
      out.write("        //校验邮箱\r\n");
      out.write("        $(\"#email\").blur(function() {\r\n");
      out.write("            var value = $(this).val();\r\n");
      out.write("            if (!/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\\.[a-zA-Z0-9_-]{2,3}){1,2})$/.test(value)) {\r\n");
      out.write("                $(\"#error-message\").text(\"邮箱格式错误啦~\");\r\n");
      out.write("            }else{\r\n");
      out.write("                $(\"#error-message\").text(\"\");\r\n");
      out.write("            }\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("\t\t//忘记密码\r\n");
      out.write("        $(\"#forget-password\").click(function(){\r\n");
      out.write("            //alert($(\"#login-email\").val());\r\n");
      out.write("            $.ajax({\r\n");
      out.write("                type:\"GET\",\r\n");
      out.write("                url:\"forgetPassword.do\",\r\n");
      out.write("                data:{email:$(\"#login-email\").val()},\r\n");
      out.write("                success:function(response,status,xhr){\r\n");
      out.write("                    location.href=\"afterForgetPassword.do\";\r\n");
      out.write("                }\r\n");
      out.write("            });\r\n");
      out.write("        });\r\n");
      out.write("\t});\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fchoose_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:choose
    org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_c_005fchoose_005f0 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _005fjspx_005ftagPool_005fc_005fchoose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
    _jspx_th_c_005fchoose_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fchoose_005f0.setParent(null);
    int _jspx_eval_c_005fchoose_005f0 = _jspx_th_c_005fchoose_005f0.doStartTag();
    if (_jspx_eval_c_005fchoose_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                ");
        if (_jspx_meth_c_005fwhen_005f0(_jspx_th_c_005fchoose_005f0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("                ");
        if (_jspx_meth_c_005fotherwise_005f0(_jspx_th_c_005fchoose_005f0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("            ");
        int evalDoAfterBody = _jspx_th_c_005fchoose_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fchoose_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fchoose.reuse(_jspx_th_c_005fchoose_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fchoose.reuse(_jspx_th_c_005fchoose_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fwhen_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fchoose_005f0, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_005fwhen_005f0 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_005fwhen_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fwhen_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f0);
    // /WEB-INF/view/header.jsp(19,16) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fwhen_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.uid != null}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fwhen_005f0 = _jspx_th_c_005fwhen_005f0.doStartTag();
    if (_jspx_eval_c_005fwhen_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                    <li class=\"login2 relative\">\r\n");
        out.write("                        <a href=\"toMyProfile.do\" id=\"profile\"><img src=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.headUrl}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
        out.write("\"></a>\r\n");
        out.write("                        <ul id=\"down-menu\">\r\n");
        out.write("                            <li><a href=\"toMyProfile.do\">个人主页</a></li>\r\n");
        out.write("                            <li><a href=\"logout.do\">退出登录</a></li>\r\n");
        out.write("                        </ul>\r\n");
        out.write("                    </li>\r\n");
        out.write("                ");
        int evalDoAfterBody = _jspx_th_c_005fwhen_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fwhen_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fotherwise_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fchoose_005f0, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:otherwise
    org.apache.taglibs.standard.tag.common.core.OtherwiseTag _jspx_th_c_005fotherwise_005f0 = (org.apache.taglibs.standard.tag.common.core.OtherwiseTag) _005fjspx_005ftagPool_005fc_005fotherwise.get(org.apache.taglibs.standard.tag.common.core.OtherwiseTag.class);
    _jspx_th_c_005fotherwise_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fotherwise_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f0);
    int _jspx_eval_c_005fotherwise_005f0 = _jspx_th_c_005fotherwise_005f0.doStartTag();
    if (_jspx_eval_c_005fotherwise_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                    <li class=\"login\">\r\n");
        out.write("                        <a href=\"toLogin.do\">登录</a>\r\n");
        out.write("                        <a href=\"toLogin.do\">/</a>\r\n");
        out.write("                        <a href=\"toLogin.do#register\">注册</a>\r\n");
        out.write("                    </li>\r\n");
        out.write("                ");
        int evalDoAfterBody = _jspx_th_c_005fotherwise_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fotherwise_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fotherwise.reuse(_jspx_th_c_005fotherwise_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fotherwise.reuse(_jspx_th_c_005fotherwise_005f0);
    return false;
  }
}
