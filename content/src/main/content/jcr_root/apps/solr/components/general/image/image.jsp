<%--
  Copyright 2013 - Six Dimensions
  All Rights Reserved

  ==============================================================================

  Renders an image.
  
  Author: dklco, msam

  ==============================================================================

--%>
<%@include file="/apps/st-site/global.jsp"%>
<div class="image">
	${bindings.image}
	<cq:text property="image/jcr:description" placeholder="" tagName="small"/>
</div>