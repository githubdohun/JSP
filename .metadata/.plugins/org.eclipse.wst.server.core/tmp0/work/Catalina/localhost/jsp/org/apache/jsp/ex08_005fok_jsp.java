/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.80
 * Generated at: 2023-10-17 08:31:11 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Arrays;

public final class ex08_005fok_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.Arrays");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

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
      out.write("\r\n");


	//POST > 한글 인코딩
	request.setCharacterEncoding("UTF-8");

	//텍스트 박스
	//1. 입력O > 입력값 반환
	//2. 컨트롤O + 입력X > 빈문자열 반환
	//3. 컨트롤X (key 오류) > null 반환
	String txt1 = request.getParameter("txt1");
	
	System.out.println(txt1 == null);		//false
	//System.out.println(txt1.equals(""));	//true
	
	
	//암호 박스
	String txt2 = request.getParameter("txt2");
	
	//다중 텍스트
	String txt3 = request.getParameter("txt3");
	
	txt3 = txt3.replace("\r\n","<br>");
	
	//체크 박스
	//1. value 없을 때
	// 체크O > "on" 전송
	// 체크X > null 전송
	//2. value 있을 때
	// 체크O > value 전송
	// 체크X > null 전송
	String cb1 = request.getParameter("cb1");
	
	
	//체크 박스들
	/* 
	String cb2 = request.getParameter("cb2");
	String cb3 = request.getParameter("cb3");
	String cb4 = request.getParameter("cb4");
	
	temp += cb2 + ",";
	temp += cb3 + ",";
	temp += cb4 + ",";
	*/
	
	
	/* 
	String temp = "";
	
	for (int i=2; i<=4; i++) {
	temp += request.getParameter("cb" + i) + ",";		
	}
	*/
	
	//String cb5 = request.getParameter("cb5");
	
	//동일한 name의 컨트롤이 여러개 전송될 때
	String[] cb5 = request.getParameterValues("cb5");
	
	
	//라디오 버튼
	String rb = request.getParameter("rb");
	
	


      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"http://pinnpublic.dothome.co.kr/cdn/example-min.css\">\r\n");
      out.write("<style>\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	<!-- ex08_ok.jsp -->\r\n");
      out.write("	<h1>결과</h1>\r\n");
      out.write("	\r\n");
      out.write("	<h2>텍스트 박스</h2>\r\n");
      out.write("	<div>");
      out.print( txt1 );
      out.write("</div>\r\n");
      out.write("	\r\n");
      out.write("	<h2>암호 박스</h2>\r\n");
      out.write("	<div>");
      out.print( txt2 );
      out.write("</div>\r\n");
      out.write("	\r\n");
      out.write("	<h2>다중 텍스트</h2>\r\n");
      out.write("	<div>");
      out.print( txt3 );
      out.write("</div>\r\n");
      out.write("	\r\n");
      out.write("	<h2>체크 박스</h2>\r\n");
      out.write("	<div>");
      out.print( cb1 );
      out.write("</div>\r\n");
      out.write("	\r\n");
      out.write("	");
      out.write("\r\n");
      out.write("	 \r\n");
      out.write("	 <h2>체크 박스들</h2>\r\n");
      out.write("	<div>");
      out.print( Arrays.toString(cb5) );
      out.write("</div>\r\n");
      out.write("	\r\n");
      out.write("	<h2>라디오 버튼</h2>\r\n");
      out.write("	<div>");
      out.print( rb );
      out.write("</div>\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	 \r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	<script src=\"https://code.jquery.com/jquery-1.12.4.js\"></script>\r\n");
      out.write("	<script src=\"http://pinnpublic.dothome.co.kr/cdn/example-min.js\"></script>\r\n");
      out.write("	<script>\r\n");
      out.write("		\r\n");
      out.write("		\r\n");
      out.write("	\r\n");
      out.write("	</script>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
