<%--
  Copyright 2013 - Six Dimensions
  All Rights Reserved

  ==============================================================================

  Global WCM script.

  This script can be used by any other script in order to get the default
  Taglibs, sling objects and CQ objects defined.

  the following page context attributes are initialized via the <cq:defineObjects/>
  tag:

    @param slingRequest SlingHttpServletRequest
    @param slingResponse SlingHttpServletResponse
    @param resource the current resource
    @param currentNode the current node
    @param log default logger
    @param sling sling script helper

    @param componentContext component context of this request
    @param editContext edit context of this request
    @param properties properties of the addressed resource (aka "localstruct")
    @param pageManager page manager
    @param currentPage containing page addressed by the request (aka "actpage")
    @param resourcePage containing page of the addressed resource (aka "myPage")
    @param pageProperties properties of the containing page
    @param component current CQ5 component
    @param designer designer
    @param currentDesign design of the addressed resource  (aka "actdesign")
    @param resourceDesign design of the addressed resource (aka "myDesign")
    @param currentStyle style of the addressed resource (aka "actstyle")

  ==============================================================================

--%><%@page session="false" %><%
%><%@taglib prefix="sling" uri="http://sling.apache.org/taglibs/sling" %><%
%><%@taglib prefix="cq" uri="http://www.day.com/taglibs/cq/1.0" %><%
%><%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%
%><%@taglib prefix="ext" uri="http://labs.sixdimensions.com/tld/ext" %><%
%><%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %><%
%><%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %><%
%><%@page import="com.day.cq.wcm.api.WCMMode" %><% 
%><cq:defineObjects /><cq:setContentBundle />
<%
// as per http://labs.sixdimensions.com/blog/2013-04-02/what-my-cq-mode/
boolean isEdit = WCMMode.fromRequest(request) == WCMMode.EDIT;
boolean isDesign = WCMMode.fromRequest(request) == WCMMode.DESIGN;
%>
<c:set var="isEdit" value="<%= isEdit %>" /><c:set var="isDesign" value="<%= isDesign %>" />