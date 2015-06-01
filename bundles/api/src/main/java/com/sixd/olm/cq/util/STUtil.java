package com.st.olm.cq.util;

import java.text.Normalizer;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import javax.jcr.RepositoryException;
import javax.jcr.version.Version;

import com.st.olm.cq.api.ccc.CCCAsset;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.wcm.api.NameConstants;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.day.cq.wcm.api.Revision;
import com.day.cq.wcm.api.WCMException;
import com.day.text.Text;

public class STUtil {

    private static final Logger log = LoggerFactory.getLogger(STUtil.class);

    /**
     * Converts the specified name or arbitrary string into a path by downcasing
     * it and replacing all non-ASCII characters with dashes.
     *
     * @param str
     *            the string to convert
     * @return the path
     */
    public static final String toPath(final String str) {
        if (str == null) {
            return null;
        }
        boolean prev = false;
        final StringBuilder sb = new StringBuilder();
        for (char c : Normalizer.normalize(str.toLowerCase(),
                Normalizer.Form.NFKD).toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                sb.append(c);
                prev = true;
            } else if (prev) {
                sb.append('-');
                prev = false;
            }
        }
        if (sb.toString().endsWith("-")) {
            return sb.substring(0, sb.length() - 1);
        } else {
            return sb.toString();
        }
    }

    /**
     * Converts a UUID into a subpath by splitting the UUID into to character
     * chunks and separating each chunk with a /
     *
     * @param toConvert
     *            the UUID to convert to a subpath
     * @return
     */
    public static final String createPathFromUUID(UUID toConvert) {
        String uuidString = toConvert.toString().replace("-", "");
        int idx = 0;
        StringBuilder path = new StringBuilder();
        while (idx + 1 < uuidString.length() / 2) {
            path.append(uuidString.substring(idx, idx + 2));
            path.append("/");
            idx = idx + 2;
        }
        return path.toString();
    }

    /**
     * Generates a UUID and converts it into a subpath by splitting the UUID
     * into to character chunks and separating each chunk with a /
     *
     * @return the subpath
     */
    public static final String createPathFromUUID() {
        return createPathFromUUID(UUID.randomUUID());
    }

    /**
     * Creates a locale for the specified i18n String. The expected format of
     * the string is en_US or similar.
     *
     * @param i18n
     *            the i18n code
     * @return the locale for the i18n code
     */
    public static final Locale localeFori18nCode(String i18n) {
        if (i18n != null && i18n.contains("_")) {
            return new Locale(i18n.split("_")[0], i18n.split("_")[1]);
        } else {
            return null;
        }
    }

    /**
     * Takes a datetime in the standard CQ format (2014-07-08T10:54:21.858-04:00) and returns
     * the same datetime to a precision of seconds that can be inserted into an Oracle database.
     *
     * @param dt
     * 			the DateTime in CQ format that needs converted
     *
     * @return	a String representing a valid DateTime for Oracle
     */
    public static final String cqDateTimeToOracle(String dt)
    {
        // Expected format from CQ:  yyyy-MM-ddTHH:mm:ss*
        String month = dt.substring(dt.indexOf("-") + 1, dt.indexOf("-") + 3);
        String day = dt.substring(dt.indexOf("-") + 4, dt.indexOf("-") + 6);
        String year = dt.substring(0, 4);
        String hour = dt.substring(dt.indexOf("T") + 1, dt.indexOf("T") + 3);
        String minute = dt.substring(dt.indexOf("T") + 4, dt.indexOf("T") + 6);
        String second = dt.substring(dt.indexOf("T") + 7, dt.indexOf("T") + 9);

        return month + "/" + day + "/" + year + " " + hour + ":" + minute + ":" + second;
    }

    /**
     * @return the latest version number of the resource.  This may have been duplicated with
     * getCurrentVersion.
     */
    public static String getLatestVersion(Resource current)
    {
        String latestVersion = "";

        Collection<Revision> revisions;
        try {
            Page p = current.adaptTo(Page.class);
            PageManager pm = p.getPageManager();
            revisions = pm.getRevisions(current.getPath(), null);
            if (revisions != null && revisions.size() > 0) {
                Iterator<Revision> it = revisions.iterator();

                Version version = it.next().getVersion();
                latestVersion = version.getName();
            }
        } catch (WCMException e) {
            log.error("WCMException in STUtil.getLatestVersion", e);
        } catch (RepositoryException e) {
            log.error("RepositoryException in STUtil.getLatestVersion", e);
        } catch (Exception e) {
            log.error("Unexpected Exception in STUtil.getLatestVersion", e);
        }

        return latestVersion;
    }

    /**
     * @return the current version number of the resource
     */
    public static String getCurrentVersion(PageManager pageManager, Resource resource)
    {
        Collection<Revision> revisions;
        String label = "";

        try
        {
            revisions = pageManager.getRevisions(resource.getPath(), null);
            if (revisions != null && revisions.size() > 0) {
                Iterator<Revision> revisionsIterator = revisions.iterator();
                while(revisionsIterator.hasNext()) {
                    Revision revision = revisionsIterator.next();
                    if(revision.isBaseVersion()) {
                        label = revision.getLabel();
                        return label;
                    }
                }
            }
        }
        catch (Exception e)
        {
            log.error("Exception in CCCListItem.getCurrentVersion on asset resource {}", resource.getPath(), e);
        }

        return label;
    }

    public static final String TIMESTAMP_FORMAT = "yyyy-MM-dd'T'HH:mm:ssZ";

    public static DateTimeFormatter getTimestampFormatter() {
        return DateTimeFormat.forPattern(TIMESTAMP_FORMAT);
    }

    public static Calendar getCalendarFromTimestampString(String timestamp) {
        // a "+" will come in as space from a URL query parameter. replace it
        // back with a "+" so the timezone can be parsed correctly
        timestamp = timestamp.replace(" ", "+");
        return getTimestampFormatter().withOffsetParsed().parseDateTime(timestamp).toGregorianCalendar();
    }

    public static String getTimestampStringFromCalendar(Calendar timestamp) {
        DateTime dateTime = new DateTime(timestamp);
        return dateTime.toString(getTimestampFormatter());
    }

    public static Calendar getPageLastReplication(Page page, boolean getParent) {
        try {

            if (getParent && page.getParent() != null)
                page = page.getParent();

            ValueMap valueMap = page.getContentResource().adaptTo(ValueMap.class);
            return valueMap.get(NameConstants.PN_PAGE_LAST_REPLICATED, Calendar.class);

        } catch(Exception e) {
            // swallow
        }
        return null;
    }

    public static String getCurrentCatalogRootPath(Page currentPage) {
        String catalogRootPath = Text.getAbsoluteParent(currentPage.getPath(), 3);
        return catalogRootPath;
    }

    public static void excludeDuplicateAssets(List<CCCAsset<?>> assets) {
        if(!assets.isEmpty()){
            HashMap<String, CCCAsset<?>> uniques = new HashMap<>();
            for(CCCAsset<?> asset : assets){
                String assetPath = asset.getPath();
                if(!uniques.containsKey(assetPath)){
                    uniques.put(assetPath, asset);
                }
            }
            assets.clear();
            assets.addAll(uniques.values());
        }
    }
}
