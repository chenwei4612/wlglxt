/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-04-01 08:18:49 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.users.page;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class CarCount_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<title>车辆统计</title>\r\n");

	pageContext.setAttribute("APP_PATH", request.getContextPath());

      out.write("\r\n");
      out.write("<!-- 最新版本的 Bootstrap 核心 CSS 文件 引入样式-->\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${APP_PATH }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/js/jquery-1.12.4.min.js\"></script>\r\n");
      out.write("<link\r\n");
      out.write("\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${APP_PATH }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/bootstrap-3.3.7-dist/css/bootstrap.min.css\"\r\n");
      out.write("\trel=\"stylesheet\">\r\n");
      out.write("<script\r\n");
      out.write("\tsrc=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${APP_PATH }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/bootstrap-3.3.7-dist/js/bootstrap.min.js\"></script>\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${APP_PATH }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/js/echarts.js\"></script>\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${APP_PATH }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/js/echarts.min.js\"></script>\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${APP_PATH }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/staticjs/cfgopts.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div>\r\n");
      out.write("\t<!-- 为ECharts准备一个具备大小（宽高）的Dom -->\r\n");
      out.write("    <div id=\"chartmain\" style=\"float:left;width: 500px;height:400px;\"></div>\r\n");
      out.write("    <div id=\"chartmain2\" style=\"float:left;width: 500px;height:400px;\"></div>\r\n");
      out.write("</div>\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\tvar tt1 = [];\r\n");
      out.write("\t\tvar tt2 = [];\r\n");
      out.write("\t\tvar tt3 = [];\r\n");
      out.write("\t\tvar tt4 = [];\r\n");
      out.write("\t\t$(function() {\r\n");
      out.write("\t\t\t//alert(\"1111\");\r\n");
      out.write("\t\t\t//去首页\r\n");
      out.write("\t\t\tCarCount();\r\n");
      out.write("\t\t\tCarCount2();\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\tfunction CarCount() {\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\turl : \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${APP_PATH}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/CarCount\",\r\n");
      out.write("\t\t\t\ttype : \"GET\",\r\n");
      out.write("\t\t\t\tsuccess : function(result) {\r\n");
      out.write("\t\t\t\t\tconsole.log(result);\r\n");
      out.write("\t\t\t\t\tbuild_emps(result)\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction build_emps(result) {\r\n");
      out.write("\t\t\tvar emps = result.extend.cars;\r\n");
      out.write("\t\t\tconsole.log(emps);\r\n");
      out.write("\t\t\tconsole.log(emps.length);\r\n");
      out.write("\t\t\tif (emps.length > 0) {\r\n");
      out.write("\t\t\t\tfor (var i = 0; i < emps.length; i++) {\r\n");
      out.write("\t\t\t\t\ttt1[i] = emps[i].roadId;\r\n");
      out.write("\t\t\t\t\ttt2[i] = emps[i].num;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t// 使用刚指定的配置项和数据显示图表。\r\n");
      out.write("\t\t\tMChart();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction MChart() {\r\n");
      out.write("\t\t\t// 基于准备好的dom，初始化echarts实例\r\n");
      out.write("            var myChart = echarts.init(document.getElementById('chartmain'));\r\n");
      out.write("\r\n");
      out.write("            // 指定图表的配置项和数据\r\n");
      out.write("            var option = {\r\n");
      out.write("                title: {\r\n");
      out.write("                    text: '统计各线路车辆次数 柱形图'\r\n");
      out.write("                },\r\n");
      out.write("                tooltip: {},\r\n");
      out.write("                legend: {\r\n");
      out.write("                    data:['次数']\r\n");
      out.write("                },\r\n");
      out.write("                xAxis: {\r\n");
      out.write("                \tdata: tt1\r\n");
      out.write("                },\r\n");
      out.write("                yAxis: {},\r\n");
      out.write("                series: [{\r\n");
      out.write("                    name: '数量',\r\n");
      out.write("                    type: 'bar',\r\n");
      out.write("                    data: tt2\r\n");
      out.write("                }]\r\n");
      out.write("            };\r\n");
      out.write("         // 使用刚指定的配置项和数据显示图表。\r\n");
      out.write("            myChart.setOption(option);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction CarCount2() {\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\turl : \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${APP_PATH}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/CarCount2\",\r\n");
      out.write("\t\t\t\ttype : \"GET\",\r\n");
      out.write("\t\t\t\tsuccess : function(result) {\r\n");
      out.write("\t\t\t\t\tconsole.log(result);\r\n");
      out.write("\t\t\t\t\tbuild_emps2(result)\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction build_emps2(result) {\r\n");
      out.write("\t\t\tvar emps = result.extend.cars;\r\n");
      out.write("\t\t\tconsole.log(emps);\r\n");
      out.write("\t\t\tconsole.log(emps.length);\r\n");
      out.write("\t\t\tif (emps.length > 0) {\r\n");
      out.write("\t\t\t\tfor (var i = 0; i < emps.length; i++) {\r\n");
      out.write("\t\t\t\t\tif(emps[i].carType==0){\r\n");
      out.write("\t\t\t\t\t\ttt3[i] = \"重型货车\";\r\n");
      out.write("\t\t\t\t\t}else if(emps[i].carType==1){\r\n");
      out.write("\t\t\t\t\t\ttt3[i] = \"中型货车\";\r\n");
      out.write("\t\t\t\t\t}else if(emps[i].carType==2){\r\n");
      out.write("\t\t\t\t\t\ttt3[i] = \"轻型货车\";\r\n");
      out.write("\t\t\t\t\t}else if(emps[i].carType==3){\r\n");
      out.write("\t\t\t\t\t\ttt3[i] = \"电动车\";\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\ttt4[i] = emps[i].num;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t// 使用刚指定的配置项和数据显示图表。\r\n");
      out.write("\t\t\tMChart2();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction MChart2() {\r\n");
      out.write("\t\t\t// 基于准备好的dom，初始化echarts实例\r\n");
      out.write("            var myChart = echarts.init(document.getElementById('chartmain2'));\r\n");
      out.write("\r\n");
      out.write("            // 指定图表的配置项和数据\r\n");
      out.write("            var option = {\r\n");
      out.write("                title: {\r\n");
      out.write("                    text: '各种车辆类型统计 柱形图'\r\n");
      out.write("                },\r\n");
      out.write("                tooltip: {},\r\n");
      out.write("                legend: {\r\n");
      out.write("                    data:['车辆类型']\r\n");
      out.write("                },\r\n");
      out.write("                xAxis: {\r\n");
      out.write("                \tdata: tt3\r\n");
      out.write("                },\r\n");
      out.write("                yAxis: {},\r\n");
      out.write("                series: [{\r\n");
      out.write("                    name: '车辆数量',\r\n");
      out.write("                    type: 'bar',\r\n");
      out.write("                    data: tt4\r\n");
      out.write("                }]\r\n");
      out.write("            };\r\n");
      out.write("         // 使用刚指定的配置项和数据显示图表。\r\n");
      out.write("            myChart.setOption(option);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
}
