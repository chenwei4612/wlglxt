/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-04-01 17:37:31 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.users.page;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class route_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>线路列表</title>\r\n");

	pageContext.setAttribute("APP_PATH", request.getContextPath());

      out.write("\r\n");
      out.write("<!-- web路径：\r\n");
      out.write("不以/开始的相对路径，找资源，以当前资源的路径为基准，经常容易出问题。\r\n");
      out.write("以/开始的相对路径，找资源，以服务器的路径为标准(http://localhost:3306)；需要加上项目名\r\n");
      out.write("\t\thttp://localhost:3306/crud\r\n");
      out.write(" -->\r\n");
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
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<!-- 线路查询的模态框 -->\r\n");
      out.write("\t<div class=\"modal fade\" id=\"routecheckModal\" tabindex=\"-1\" role=\"dialog\"\r\n");
      out.write("\t\taria-labelledby=\"myModalLabel\">\r\n");
      out.write("\t\t<div class=\"modal-dialog\" role=\"document\">\r\n");
      out.write("\t\t\t<div class=\"modal-content\">\r\n");
      out.write("\t\t\t\t<div class=\"modal-header\">\r\n");
      out.write("\t\t\t\t\t<button type=\"button\" class=\"close\" data-dismiss=\"modal\"\r\n");
      out.write("\t\t\t\t\t\taria-label=\"Close\">\r\n");
      out.write("\t\t\t\t\t\t<span aria-hidden=\"true\">&times;</span>\r\n");
      out.write("\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t\t<h4 class=\"modal-title\" id=\"myModalLabel\">线路查询</h4>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"modal-body\">\r\n");
      out.write("\t\t\t\t\t<form class=\"form-horizontal\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t<label class=\"col-sm-2 control-label\">线路Id:</label>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-sm-10\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"text\" name=\"RouteId\" class=\"form-control\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tid=\"RouteId_input\" placeholder=\"RouteId\"> <span\r\n");
      out.write("\t\t\t\t\t\t\t\t\tclass=\"help-block\"></span>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"modal-footer\">\r\n");
      out.write("\t\t\t\t\t<button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">关闭</button>\r\n");
      out.write("\t\t\t\t\t<button type=\"button\" class=\"btn btn-primary\" id=\"route_check_btn\">查询</button>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("<!-- 线路修改的模态框 -->\r\n");
      out.write("\t<div class=\"modal fade\" id=\"routeAddModal\" tabindex=\"-1\" role=\"dialog\"\r\n");
      out.write("\t\taria-labelledby=\"myModalLabel\">\r\n");
      out.write("\t\t<div class=\"modal-dialog\" role=\"document\">\r\n");
      out.write("\t\t\t<div class=\"modal-content\">\r\n");
      out.write("\t\t\t\t<div class=\"modal-header\">\r\n");
      out.write("\t\t\t\t\t<button type=\"button\" class=\"close\" data-dismiss=\"modal\"\r\n");
      out.write("\t\t\t\t\t\taria-label=\"Close\">\r\n");
      out.write("\t\t\t\t\t\t<span aria-hidden=\"true\">&times;</span>\r\n");
      out.write("\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t\t<h4 class=\"modal-title\" id=\"myModalLabel\">新线路添加</h4>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"modal-body\">\r\n");
      out.write("\t\t\t\t\t<form class=\"form-horizontal\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t<label class=\"col-sm-2 control-label\">区域:</label>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-sm-10\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"text\" name=\"area\" class=\"form-control\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tid=\"area_add_input\" placeholder=\"area\"> <span\r\n");
      out.write("\t\t\t\t\t\t\t\t\tclass=\"help-block\"></span>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t<label class=\"col-sm-2 control-label\">配送范围:</label>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-sm-10\">\r\n");
      out.write("\t\t\t\t\t\t\t<textarea class=\"form-control\" rows=\"3\" name=\"dscope\" id=\"scope_add_input\" placeholder=\"Distribution Scope\"></textarea>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t<div class=\"modal-footer\">\r\n");
      out.write("\t\t\t\t\t<button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">关闭</button>\r\n");
      out.write("\t\t\t\t\t<button type=\"button\" class=\"btn btn-primary\" id=\"route_save_btn\">保存</button>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("<!-- 新线路添加的模态框 -->\r\n");
      out.write("\t<div class=\"modal fade\" id=\"routeUpdateModal\" tabindex=\"-1\" role=\"dialog\"\r\n");
      out.write("\t\taria-labelledby=\"myModalLabel\">\r\n");
      out.write("\t\t<div class=\"modal-dialog\" role=\"document\">\r\n");
      out.write("\t\t\t<div class=\"modal-content\">\r\n");
      out.write("\t\t\t\t<div class=\"modal-header\">\r\n");
      out.write("\t\t\t\t\t<button type=\"button\" class=\"close\" data-dismiss=\"modal\"\r\n");
      out.write("\t\t\t\t\t\taria-label=\"Close\">\r\n");
      out.write("\t\t\t\t\t\t<span aria-hidden=\"true\">&times;</span>\r\n");
      out.write("\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t\t<h4 class=\"modal-title\" id=\"myModalLabel\">线路修改</h4>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"modal-body\">\r\n");
      out.write("\t\t\t\t\t<form class=\"form-horizontal\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t<label class=\"col-sm-2 control-label\">区域:</label>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-sm-10\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"text\" name=\"area\" class=\"form-control\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tid=\"area_update_input\" placeholder=\"area\"> <span\r\n");
      out.write("\t\t\t\t\t\t\t\t\tclass=\"help-block\"></span>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t<label class=\"col-sm-2 control-label\">配送范围:</label>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-sm-10\">\r\n");
      out.write("\t\t\t\t\t\t\t<textarea class=\"form-control\" rows=\"3\" name=\"dscope\" id=\"scope_update_input\" placeholder=\"Distribution Scope\"></textarea>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t<div class=\"modal-footer\">\r\n");
      out.write("\t\t\t\t\t<button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">关闭</button>\r\n");
      out.write("\t\t\t\t\t<button type=\"button\" class=\"btn btn-primary\" id=\"route_update_btn\">保存</button>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!-- 搭建显示页面 -->\r\n");
      out.write("\t<div class=\"container\">\r\n");
      out.write("\t\t<!-- title -->\r\n");
      out.write("\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t<div class=\"col-md-12\">\r\n");
      out.write("\t\t\t\t<h1>运输线路管理</h1>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!-- 按钮 -->\r\n");
      out.write("\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t<div class=\"col-md-4 col-md-offset-8\">\r\n");
      out.write("\t\t\t\t<button class=\"btn btn-primary\" id=\"route_check_modal_btn\">\r\n");
      out.write("\t\t\t\t<span class=\"glyphicon glyphicon-search\" aria-hidden=\"true\"></span>查找</button>\r\n");
      out.write("\t\t\t\t<button class=\"btn btn-primary\" id=\"route_add_modal_btn\">\r\n");
      out.write("\t\t\t\t<span class=\"glyphicon glyphicon-plus\" aria-hidden=\"true\"></span>新增</button>\r\n");
      out.write("\t\t\t\t<button class=\"btn btn-danger\" id=\"route_delete_all_btn\">\r\n");
      out.write("\t\t\t\t<span class=\"glyphicon glyphicon-trash\"  aria-hidden=\"true\"></span>删除</button>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!-- 显示表格数据 -->\r\n");
      out.write("\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t<div class=\"col-md-12\">\r\n");
      out.write("\t\t\t\t<table class=\"table table-hover\" id=\"routes_table\">\r\n");
      out.write("\t\t\t\t\t<thead>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<th><input type=\"checkbox\" id=\"check_all\" /></th>\r\n");
      out.write("\t\t\t\t\t\t\t<th>线路Id</th>\r\n");
      out.write("\t\t\t\t\t\t\t<th>区域</th>\r\n");
      out.write("\t\t\t\t\t\t\t<th>配送范围</th>\r\n");
      out.write("\t\t\t\t\t\t\t<th>操作</th>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t</thead>\r\n");
      out.write("\t\t\t\t\t<tbody>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t</tbody>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t<!-- 显示分页信息 -->\r\n");
      out.write("\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t<!--分页文字信息  -->\r\n");
      out.write("\t\t\t<div class=\"col-md-6\" id=\"page_info_area\"></div>\r\n");
      out.write("\t\t\t<!-- 分页条信息 -->\r\n");
      out.write("\t\t\t<div class=\"col-md-6\" id=\"page_nav_area\"></div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\tvar totalRecord, currentPage;\r\n");
      out.write("\t\t//1.页面加载完成以后，直接去发送一个ajax请求，要到分页数据\r\n");
      out.write("\t\t$(function() {\r\n");
      out.write("\t\t\t//去首页\r\n");
      out.write("\t\t\tto_page(1);\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\tfunction to_page(pn) {\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\turl : \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${APP_PATH}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/routes\",\r\n");
      out.write("\t\t\t\tdata : \"pn=\" + pn,\r\n");
      out.write("\t\t\t\ttype : \"GET\",\r\n");
      out.write("\t\t\t\tsuccess : function(result) {\r\n");
      out.write("\t\t\t\t\t//console.log(result);\r\n");
      out.write("\t\t\t\t\t//1.解析并显示员工数据\r\n");
      out.write("\t\t\t\t\tbuild_routes_table(result);\r\n");
      out.write("\t\t\t\t\t//2.解析并显示分页信息\r\n");
      out.write("\t\t\t\t\tbuild_page_info(result);\r\n");
      out.write("\t\t\t\t\t//3.解析并显示分页条\r\n");
      out.write("\t\t\t\t\tbuild_page_nav(result);\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tfunction build_routes_table(result) {\r\n");
      out.write("\t\t\t//清空table表格\r\n");
      out.write("\t\t\t$(\"#routes_table tbody\").empty();\r\n");
      out.write("\t\t\tvar routes = result.extend.pageInfo.list;\r\n");
      out.write("\t\t\t$.each(routes,\r\n");
      out.write("\t\t\t\t\tfunction(index, item) {\r\n");
      out.write("\t\t\t\t\t\t//aler(item.empName);\r\n");
      out.write("\t\t\t\t\t\tvar checkBoxTd = $(\"<td><input type='checkbox' class='check_item'/></td>\");\r\n");
      out.write("\t\t\t\t\t\tvar rouId = $(\"<td></td>\").append(item.rouId);\r\n");
      out.write("\t\t\t\t\t\tvar area = $(\"<td></td>\").append(item.area);\r\n");
      out.write("\t\t\t\t\t\tvar drange = $(\"<td></td>\").append(item.dscope);\r\n");
      out.write("\t\t\t\t\t\tvar editBtn = $(\"<button></button>\").addClass(\r\n");
      out.write("\t\t\t\t\t\t\t\t\"btn btn-primary btn-sm edit_btn\").append(\r\n");
      out.write("\t\t\t\t\t\t\t\t$(\"<span></span>\").addClass(\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\"glyphicon glyphicon-pencil\")).append(\r\n");
      out.write("\t\t\t\t\t\t\t\t\"编辑\");\r\n");
      out.write("\t\t\t\t\t\t//为编辑按钮添加一个自定义的属性，来表示当前员工id\r\n");
      out.write("\t\t\t\t\t\teditBtn.attr(\"edit-rouId\", item.rouId);\r\n");
      out.write("\t\t\t\t\t\tvar delBtn = $(\"<button></button>\").addClass(\r\n");
      out.write("\t\t\t\t\t\t\t\t\"btn btn-danger btn-sm delete_btn\").append(\r\n");
      out.write("\t\t\t\t\t\t\t\t$(\"<span></span>\").addClass(\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\"glyphicon glyphicon-trash\")).append(\r\n");
      out.write("\t\t\t\t\t\t\t\t\"删除\");\r\n");
      out.write("\t\t\t\t\t\t//为删除按钮添加一个自定义的属性来表示当前删除的员工id\r\n");
      out.write("\t\t\t\t\t\tdelBtn.attr(\"del-rouId\", item.rouId);\r\n");
      out.write("\t\t\t\t\t\tvar btnTd = $(\"<td></td>\").append(editBtn).append(\" \")\r\n");
      out.write("\t\t\t\t\t\t\t\t.append(delBtn);\r\n");
      out.write("\t\t\t\t\t\t//append方法执行完成以后还是返回原来的元素\r\n");
      out.write("\t\t\t\t\t\t$(\"<tr></tr>\").append(checkBoxTd).append(rouId).append(area)\r\n");
      out.write("\t\t\t\t\t\t\t\t.append(drange).append(btnTd).appendTo(\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\"#routes_table tbody\");\r\n");
      out.write("\t\t\t\t\t});\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t//解析显示分页信息\r\n");
      out.write("\t\tfunction build_page_info(result) {\r\n");
      out.write("\t\t\t$(\"#page_info_area\").empty();\r\n");
      out.write("\t\t\t$(\"#page_info_area\").append(\r\n");
      out.write("\t\t\t\t\t\"当前\" + result.extend.pageInfo.pageNum + \"页，共\"\r\n");
      out.write("\t\t\t\t\t\t\t+ result.extend.pageInfo.pages + \"页,总\"\r\n");
      out.write("\t\t\t\t\t\t\t+ result.extend.pageInfo.total + \"条记录数\");\r\n");
      out.write("\t\t\ttotalRecord = result.extend.pageInfo.total;\r\n");
      out.write("\t\t\tcurrentPage = result.extend.pageInfo.pageNum;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t//解析显示分页条，点击分页要能去下一页....\r\n");
      out.write("\t\tfunction build_page_nav(result) {\r\n");
      out.write("\t\t\t//page_nav_area\r\n");
      out.write("\t\t\t$(\"#page_nav_area\").empty();\r\n");
      out.write("\t\t\tvar ul = $(\"<ul></ul>\").addClass(\"pagination\");\r\n");
      out.write("\r\n");
      out.write("\t\t\t//构建元素\r\n");
      out.write("\t\t\tvar firstPageLi = $(\"<li></li>\").append(\r\n");
      out.write("\t\t\t\t\t$(\"<a></a>\").append(\"首页\").attr(\"href\", \"#\"));\r\n");
      out.write("\t\t\tvar prePageLi = $(\"<li></li>\").append(\r\n");
      out.write("\t\t\t\t\t$(\"<a></a>\").append(\"&laquo;\"));\r\n");
      out.write("\t\t\tif (result.extend.pageInfo.hasPreviousPage == false) {\r\n");
      out.write("\t\t\t\tfirstPageLi.addClass(\"disabled\");\r\n");
      out.write("\t\t\t\tprePageLi.addClass(\"disabled\");\r\n");
      out.write("\t\t\t} else {\r\n");
      out.write("\t\t\t\t//为元素添加点击翻页的事件\r\n");
      out.write("\t\t\t\tfirstPageLi.click(function() {\r\n");
      out.write("\t\t\t\t\tto_page(1);\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t\tprePageLi.click(function() {\r\n");
      out.write("\t\t\t\t\tto_page(result.extend.pageInfo.pageNum - 1);\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\tvar nextPageLi = $(\"<li></li>\").append(\r\n");
      out.write("\t\t\t\t\t$(\"<a></a>\").append(\"&raquo;\"));\r\n");
      out.write("\t\t\tvar lastPageLi = $(\"<li></li>\").append(\r\n");
      out.write("\t\t\t\t\t$(\"<a></a>\").append(\"末页\").attr(\"href\", \"#\"));\r\n");
      out.write("\t\t\tif (result.extend.pageInfo.hasNextPage == false) {\r\n");
      out.write("\t\t\t\tnextPageLi.addClass(\"disabled\");\r\n");
      out.write("\t\t\t\tlastPageLi.addClass(\"disabled\");\r\n");
      out.write("\t\t\t} else {\r\n");
      out.write("\t\t\t\tnextPageLi.click(function() {\r\n");
      out.write("\t\t\t\t\tto_page(result.extend.pageInfo.pageNum + 1);\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t\tlastPageLi.click(function() {\r\n");
      out.write("\t\t\t\t\tto_page(result.extend.pageInfo.pages);\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\t//添加首页和前一页的提示\r\n");
      out.write("\t\t\tul.append(firstPageLi).append(prePageLi);\r\n");
      out.write("\t\t\t//1,2,3遍历给ul中添加页码提示\r\n");
      out.write("\t\t\t$.each(result.extend.pageInfo.navigatepageNums, function(index,\r\n");
      out.write("\t\t\t\t\titem) {\r\n");
      out.write("\r\n");
      out.write("\t\t\t\tvar numLi = $(\"<li></li>\").append($(\"<a></a>\").append(item));\r\n");
      out.write("\t\t\t\tif (result.extend.pageInfo.pageNum == item) {\r\n");
      out.write("\t\t\t\t\tnumLi.addClass(\"active\");\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\tnumLi.click(function() {\r\n");
      out.write("\t\t\t\t\tto_page(item);\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t\tul.append(numLi);\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t//添加下一页和末页 的提示\r\n");
      out.write("\t\t\tul.append(nextPageLi).append(lastPageLi);\r\n");
      out.write("\r\n");
      out.write("\t\t\t//把ul加入到nav\r\n");
      out.write("\t\t\tvar navEle = $(\"<nav></nav>\").append(ul);\r\n");
      out.write("\t\t\tnavEle.appendTo(\"#page_nav_area\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t//清空表单样式及内容\r\n");
      out.write("\t\tfunction reset_form(ele) {\r\n");
      out.write("\t\t\t$(ele)[0].reset();\r\n");
      out.write("\t\t\t//清空表单样式\r\n");
      out.write("\t\t\t$(ele).find(\"*\").removeClass(\"has-error has-success\");\r\n");
      out.write("\t\t\t$(ele).find(\".help-block\").text(\"\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t//点击新增按钮弹出模态框。\r\n");
      out.write("\t\t$(\"#route_add_modal_btn\").click(function() {\r\n");
      out.write("\t\t\t//清除表单数据（表单完整重置（表单的数据，表单的样式））\r\n");
      out.write("\t\t\treset_form(\"#routeAddModal form\");\r\n");
      out.write("\t\t\t//弹出模态框\r\n");
      out.write("\t\t\t$(\"#routeAddModal\").modal({\r\n");
      out.write("\t\t\t\tbackdrop : \"static\"\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t//点击保存，保存员工。\r\n");
      out.write("\t\t$(\"#route_save_btn\").click(function(){\r\n");
      out.write("\t\t\tvar a=$(\"#area_add_input\").val();\r\n");
      out.write("\t\t\tvar ds=$(\"#scope_add_input\").val();\r\n");
      out.write("\t\t\t//alert(a+\" \"+ds);\r\n");
      out.write("\t\t\t//alert($(\"#routeAddModal form\").serialize());\r\n");
      out.write("\t\t\t//console.log($(\"#routeAddModal form\").serialize());\r\n");
      out.write("\t\t\t//console.log(encodeURI(encodeURI($(\"#routeAddModal form\").serialize())));\r\n");
      out.write("\t\t\t //console.log(decodeURIComponent($(\"#routeAddModal form\").serialize(),true));\r\n");
      out.write("\t\t\t// var RA=decodeURIComponent($(\"#routeAddModal form\").serialize(),true);\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\turl : \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${APP_PATH}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/route\",\r\n");
      out.write("\t\t\t\ttype : \"POST\",\r\n");
      out.write("\t\t\t\tdata : $(\"#routeAddModal form\").serialize(),\r\n");
      out.write("\t\t\t\tsuccess : function(result) {\r\n");
      out.write("\t\t\t\t\t//alert(result.msg);\r\n");
      out.write("\t\t\t\t\t//alert(RA);\r\n");
      out.write("\t\t\t\t\t$(\"#routeAddModal\").modal('hide');\r\n");
      out.write("\t\t\t\t\t//2.来到最后一页，显示保存的信息\r\n");
      out.write("\t\t\t\t\t//发送ajax请求显示最后一页数据即可\r\n");
      out.write("\t\t\t\t\tto_page(totalRecord);\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t//弹出更新对话框\r\n");
      out.write("\t\t$(document).on(\"click\",\".edit_btn\",function() {\r\n");
      out.write("\t\t\t\t\t//alert(\"edit\");\r\n");
      out.write("\t\t\t\t\t//1、查出员工信息，显示员工信息\r\n");
      out.write("\t\t\t\t\tgetRoute($(this).attr(\"edit-rouId\"));\r\n");
      out.write("\t\t\t\t\t//alert($(this).attr(\"edit-rouId\"));\r\n");
      out.write("\t\t\t\t\t//4、把员工的id传递给模态框的更新按钮\r\n");
      out.write("\t\t\t\t\t$(\"#route_update_btn\").attr(\"edit-rouId\",\r\n");
      out.write("\t\t\t\t\t\t\t$(this).attr(\"edit-rouId\"));\r\n");
      out.write("\t\t\t\t\t$(\"#routeUpdateModal\").modal({\r\n");
      out.write("\t\t\t\t\t\tbackdrop : \"static\"\r\n");
      out.write("\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t//查询\r\n");
      out.write("\t\tfunction getRoute(rouId) {\r\n");
      out.write("\t\t\tconsole.log(rouId);\r\n");
      out.write("\t\t\t $.ajax({\r\n");
      out.write("\t\t\t\turl : \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${APP_PATH}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/route/\" + rouId,\r\n");
      out.write("\t\t\t\ttype : \"GET\",\r\n");
      out.write("\t\t\t\tsuccess : function(result) {\r\n");
      out.write("\t\t\t\t\tconsole.log(result);\r\n");
      out.write("\t\t\t\t\t//console.log(\"con\"+phone);\r\n");
      out.write("\t\t\t\t\tvar empData = result.extend.emp;\r\n");
      out.write("\t\t\t\t\t$(\"#area_update_input\").val(empData.area);\r\n");
      out.write("\t\t\t\t\t$(\"#scope_update_input\").val(empData.dscope);\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}); \r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t//点击更新，更新员工信息\r\n");
      out.write("\t\t$(\"#route_update_btn\").click(function() {\r\n");
      out.write("\t\t\t//1、发送ajax请求保存更新的员工数据\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\turl : \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${APP_PATH}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/route/\"+ $(this).attr(\"edit-rouId\"),\r\n");
      out.write("\t\t\t\ttype : \"POST\",\r\n");
      out.write("\t\t\t\tdata : $(\"#routeUpdateModal form\").serialize()+\"&_method=PUT\",\r\n");
      out.write("\t\t\t\tsuccess : function(result) {\r\n");
      out.write("\t\t\t\t\t//alert(result.msg);\r\n");
      out.write("\t\t\t\t\t//1、关闭对话框\r\n");
      out.write("\t\t\t\t\t$(\"#routeUpdateModal\").modal(\"hide\");\r\n");
      out.write("\t\t\t\t\t//2、回到本页面\r\n");
      out.write("\t\t\t\t\tto_page(currentPage);\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\t//单个删除\r\n");
      out.write("\t\t$(document).on(\"click\", \".delete_btn\", function() {\r\n");
      out.write("\t\t\t//1、弹出是否确认删除对话框\r\n");
      out.write("\t\t\tvar area = $(this).parents(\"tr\").find(\"td:eq(2)\").text();\r\n");
      out.write("\t\t\tvar rouId = $(this).attr(\"del-rouId\");\r\n");
      out.write("\t\t\t//alert($(this).parents(\"tr\").find(\"td:eq(0)\").text());\r\n");
      out.write("\t\t\tif (confirm(\"确认删除【\" + area + \"】吗？\")) {\r\n");
      out.write("\t\t\t\t//确认，发送ajax请求删除即可\r\n");
      out.write("\t\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\t\turl : \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${APP_PATH}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/route/\" + rouId,\r\n");
      out.write("\t\t\t\t\ttype : \"DELETE\",\r\n");
      out.write("\t\t\t\t\tsuccess : function(result) {\r\n");
      out.write("\t\t\t\t\t\talert(result.msg);\r\n");
      out.write("\t\t\t\t\t\t//回到本页\r\n");
      out.write("\t\t\t\t\t\tto_page(currentPage);\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t//完成全选/全不选功能\r\n");
      out.write("\t\t$(\"#check_all\").click(function(){\r\n");
      out.write("\t\t\t//attr获取checked是undefined;\r\n");
      out.write("\t\t\t//我们这些dom原生的属性；attr获取自定义属性的值；\r\n");
      out.write("\t\t\t//prop修改和读取dom原生属性的值\r\n");
      out.write("\t\t\t$(\".check_item\").prop(\"checked\",$(this).prop(\"checked\"));\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t//check_item\r\n");
      out.write("\t\t$(document).on(\"click\",\".check_item\",function(){\r\n");
      out.write("\t\t\t//判断当前选择中的元素是否5个\r\n");
      out.write("\t\t\tvar flag = $(\".check_item:checked\").length==$(\".check_item\").length;\r\n");
      out.write("\t\t\t$(\"#check_all\").prop(\"checked\",flag);\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t//点击全部删除，就批量删除\r\n");
      out.write("\t\t$(\"#route_delete_all_btn\").click(function(){\r\n");
      out.write("\t\t\t//\r\n");
      out.write("\t\t\tvar areas = \"\";\r\n");
      out.write("\t\t\tvar del_rouIdstr = \"\";\r\n");
      out.write("\t\t\t$.each($(\".check_item:checked\"),function(){\r\n");
      out.write("\t\t\t\t//this\r\n");
      out.write("\t\t\t\tareas += $(this).parents(\"tr\").find(\"td:eq(2)\").text()+\",\";\r\n");
      out.write("\t\t\t\t//组装线路id字符串\r\n");
      out.write("\t\t\t\tdel_rouIdstr += $(this).parents(\"tr\").find(\"td:eq(1)\").text()+\"-\";\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t//去除empNames多余的,\r\n");
      out.write("\t\t\tareas = areas.substring(0, areas.length-1);\r\n");
      out.write("\t\t\t//去除删除的id多余的-\r\n");
      out.write("\t\t\tdel_rouIdstr = del_rouIdstr.substring(0, del_rouIdstr.length-1);\r\n");
      out.write("\t\t\tif(confirm(\"确认删除【\"+areas+\"】吗？\")){\r\n");
      out.write("\t\t\t\t//发送ajax请求删除\r\n");
      out.write("\t\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\t\turl:\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${APP_PATH}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/route/\"+del_rouIdstr,\r\n");
      out.write("\t\t\t\t\ttype:\"DELETE\",\r\n");
      out.write("\t\t\t\t\tsuccess:function(result){\r\n");
      out.write("\t\t\t\t\t\talert(result.msg);\r\n");
      out.write("\t\t\t\t\t\t//回到当前页面\r\n");
      out.write("\t\t\t\t\t\tto_page(currentPage);\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t//点击新增按钮弹出模态框。\r\n");
      out.write("\t\t$(\"#route_check_modal_btn\").click(function() {\r\n");
      out.write("\t\t\t//清除表单数据（表单完整重置（表单的数据，表单的样式））\r\n");
      out.write("\t\t\treset_form(\"#routecheckModal form\");\r\n");
      out.write("\t\t\t//发送ajax请求，查出route信息，显示在下拉列表中\r\n");
      out.write("\t\t\t//getRoutets(\"#orstAddModal select\");\r\n");
      out.write("\t\t\t//弹出模态框\r\n");
      out.write("\t\t\t$(\"#routecheckModal\").modal({\r\n");
      out.write("\t\t\t\tbackdrop : \"static\"\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\tfunction to_page2(pn,rouId) {\r\n");
      out.write("\t\t\t//var stId=$(\"#orststidModal form\").serialize();\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tconsole.log(rouId);\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\turl : \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${APP_PATH}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/routesID/\"+rouId,\r\n");
      out.write("\t\t\t\tdata : \"pn=\" + pn,\r\n");
      out.write("\t\t\t\ttype : \"GET\",\r\n");
      out.write("\t\t\t\tsuccess : function(result) {\r\n");
      out.write("\t\t\t\t\t//console.log(result);\r\n");
      out.write("\t\t\t\t\t//1.解析并显示员工数据\r\n");
      out.write("\t\t\t\t\tbuild_routes_table(result);\r\n");
      out.write("\t\t\t\t\t//2.解析并显示分页信息\r\n");
      out.write("\t\t\t\t\tbuild_page_info(result);\r\n");
      out.write("\t\t\t\t\t//3.解析并显示分页条\r\n");
      out.write("\t\t\t\t\tbuild_page_nav(result);\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t//点击保存，保存员工。\r\n");
      out.write("\t\t$(\"#route_check_btn\").click(function(){\r\n");
      out.write("\t\t\tvar rouId=$(\"#RouteId_input\").val();\r\n");
      out.write("\t\t\tto_page2(1,rouId);\r\n");
      out.write("\t\t\t//1、关闭对话框\r\n");
      out.write("\t\t\t$(\"#routecheckModal\").modal(\"hide\");\r\n");
      out.write("\t\t});\r\n");
      out.write("\t</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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