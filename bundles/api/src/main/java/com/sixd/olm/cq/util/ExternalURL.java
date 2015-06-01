package com.st.olm.cq.util;

import com.adobe.cq.sightly.WCMUse;
import com.day.cq.commons.Externalizer;

public class ExternalURL extends WCMUse {

    private final static String PATH = "path";
    private String absoluteUrl;

    @Override
    public void activate() throws Exception {
        String path = get(PATH, String.class);
        if (path != null)
            absoluteUrl = externalize(path);
    }

    private String externalize(String path) {
        return getResourceResolver().adaptTo(Externalizer.class).absoluteLink(getRequest(), "http", path);
    }

    public String getAbsoluteUrl() {
        return absoluteUrl;
    }
}