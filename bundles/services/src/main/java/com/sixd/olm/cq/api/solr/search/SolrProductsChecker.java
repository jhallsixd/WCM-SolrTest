package com.st.olm.cq.api.solr.search;

import com.st.olm.cq.api.products.STProduct;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.commons.json.JSONArray;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;


/**
 * Service to check if products are available in Solr index
 */
@Component
@Service(value = SolrProductsChecker.class)
public class SolrProductsChecker {
    protected final Logger LOGGER = LoggerFactory.getLogger(SolrProductsChecker.class);
    /**
     * Category of documents to be find in Solr
     */
    private static final String PRODUCTS_CATEGORY = "products";
    /**
     * JSON keys in response of Solr API
     */
    private static final String RESPONSE_KEY = "response";
    private static final String DOCS_KEY = "docs";
    private static final String TITLE_MAN_KEY = "title_man";
    /**
     * OR query statement
     */
    private static final String OR_STATEMENT = " OR ";
    /**
     * Query key
     */
    private static final String QUERY_KEY = "query";
    /**
     * Constant for base query
     */
    private static final String BASE_QUERY_KEY = "{\"q\":\"query_placeholder\",\"personalization_type\":\"skip\",\"confidentiality\":\"public\"}";
    /**
     *  Placeholder in the base query
     */
    private static final String QUERY_PLACEHOLDER = "query_placeholder";

    @Reference
    SearchClientServiceImpl searchClientService;

    /**
     * Iterates throw a list of given products and checks their availability in SOLR index. Returns a list of products
     * available in SOLR index.
     *
     * @param products - list of products to be checked
     * @return a list of products available in SOLR index
     */
    public List<STProduct> checkProductsInSolr(List<STProduct> products) {
        String queryString = buildSolrQueryString(products);
        NameValuePair[] query = buildSolrQuery(queryString);
        String apiResponse = searchProductsInSolr(query);
        List<String> documentsTitles = getDocumentsTitles(apiResponse);
        List<STProduct> resultProducts = formResultProducts(products, documentsTitles);
        return resultProducts;

    }

    private String searchProductsInSolr(NameValuePair[] query) {
        String apiResponse = searchClientService.get(query, PRODUCTS_CATEGORY);
        return apiResponse;
    }

    private List<STProduct> formResultProducts(List<STProduct> products, List<String> documentsTitles) {
        List<STProduct> resultProducts = new ArrayList<>();
        for (STProduct product : products) {
            String title = getProductTitle(product);
            if (documentsTitles.contains(title)) {
                resultProducts.add(product);
            }
        }
        return resultProducts;
    }

    private List<String> getDocumentsTitles(String apiResponse) {
        List<String> documentsTitles = new ArrayList<>();
        try {
            JSONObject responseJson = new JSONObject(apiResponse);
            JSONObject responseWS = (JSONObject) responseJson.get(RESPONSE_KEY);
            JSONArray data = responseWS.getJSONArray(DOCS_KEY);
            for (int i = 0; i < data.length(); i++) {
                JSONObject document = data.getJSONObject(i);
                documentsTitles.add((String) document.get(TITLE_MAN_KEY));
            }
        } catch (JSONException e) {
            LOGGER.error("Response from Solr API can't be processed");
        }
        return documentsTitles;
    }

    private String buildSolrQueryString(List<STProduct> products) {
        StringBuilder stringBuilder = new StringBuilder();
        for (STProduct product : products) {
            String title = getProductTitle(product);
            stringBuilder.append(TITLE_MAN_KEY)
                    .append(":")
                    .append(title)
                    .append(OR_STATEMENT);
        }
        stringBuilder.delete(stringBuilder.lastIndexOf(OR_STATEMENT), stringBuilder.length());
        return stringBuilder.toString();
    }

    private String getProductTitle(STProduct product) {
        if (!STProduct.ST_PRMIS_PRODUCT_TYPE.equalsIgnoreCase(product.getType())) {
            STProduct parent = product.getParent();
            if (parent != null) {
                String parentType = parent.getType();
                if (STProduct.ST_PRMIS_PRODUCT_TYPE.equalsIgnoreCase(parentType)) {
                    return parent.getItemName();
                }
            }
        }
        return product.getItemName();
    }

    private NameValuePair[] buildSolrQuery(String queryString) {
        String queryValue = BASE_QUERY_KEY.replaceAll(QUERY_PLACEHOLDER, queryString);
        NameValuePair[] query = new NameValuePair[]{new NameValuePair(QUERY_KEY, queryValue)};
        return query;
    }
}