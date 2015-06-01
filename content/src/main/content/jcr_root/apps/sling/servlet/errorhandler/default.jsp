<%--
  Copyright 1997-2008 Day Management AG
  Barfuesserplatz 6, 4001 Basel, Switzerland
  All Rights Reserved.

  This software is the confidential and proprietary information of
  Day Management AG, ("Confidential Information"). You shall not
  disclose such Confidential Information and shall use it only in
  accordance with the terms of the license agreement you entered into
  with Day.

  ==============================================================================

  Generic Default error handler

   All errors that are not defined with independent JSPs will end up here. This will still search for error
   specific pages to redirect to.

--%><%@page session="false" pageEncoding="utf-8"
         import="com.day.cq.wcm.api.WCMMode,
                    java.io.PrintWriter,
                    org.apache.sling.api.SlingConstants,
                    org.apache.sling.settings.SlingSettingsService,
                    org.apache.sling.api.request.RequestProgressTracker,
                    org.apache.sling.api.request.ResponseUtil,
                    com.day.cq.wcm.api.PageManager,
                    org.apache.commons.lang3.StringEscapeUtils" %>
<%@include file="/libs/foundation/global.jsp"%><%

    Integer scObject = (Integer) request.getAttribute("javax.servlet.error.status_code");

    int statusCode = (scObject != null)
            ? scObject.intValue()
            : HttpServletResponse.SC_INTERNAL_SERVER_ERROR;

    String destination = "";

    String currentPath = request.getRequestURL().toString();

    if(currentPath.contains("st_com/zh")){
        destination = "/content/st_com/zh";
    } else if(currentPath.contains("st_com/ja")){
        destination = "/content/st_com/ja";
    } else if(currentPath.contains("st_com/ko")){
        destination = "/content/st_com/ko";
    } else if(currentPath.contains("st_com/en")){
        destination = "/content/st_com/en";
    }else{
        String referrer = request.getHeader("Referer");
        if (referrer != null){
            if (referrer.contains("st_com/zh")){
                destination = "/content/st_com/zh";
            }else if(referrer.contains("st_com/ja")){
                destination = "/content/st_com/ja";
            }else if(referrer.contains("st_com/ko")){
                destination = "/content/st_com/ko";
            }else{
                destination = "/content/st_com/en";
            }
        }else{
            destination = "/content/st_com/en";
        }
    }
    String completeURL = destination + "/error/" + statusCode;

    if (pageManager.getPage(completeURL) == null) {
        String defaultUrl = destination + "/error/default";
        if (pageManager.getPage(defaultUrl) != null) {
            response.sendRedirect(defaultUrl + ".html");
        } else {
            response.setStatus(statusCode);
            response.setContentType("text/html");
            response.setCharacterEncoding("utf-8");
            out.println("<html>");
            out.println("<head><title>" + statusCode + "Not Found</title></head>");
            out.println("<body>");
            out.println("<h1>Not Found</h1>");
            out.println("<p>Cannot serve request to " + StringEscapeUtils.escapeHtml4(request.getRequestURI()) + "</p>");
            out.println("<hr><address>" + StringEscapeUtils.escapeHtml4(this.getServletConfig().getServletContext().getServerInfo()) + "</address>");
            out.println("</body>");
            out.println("</html>");
        }
    } else {
        response.sendRedirect(completeURL + ".html");
    }
%>