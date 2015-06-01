package com.sixd.olm.cq.api;

public interface SharedConstants {

    /**
     * Constant for base content path
     */
    String CONTENT_PATH = "/content";

	/**
	 * Constant for the ccc content base path
	 */
    String CCC_PATH = "/content/ccc/";

	/**
	 * Constant for the ccc content fragment path
	 */
    String CCC_FRAGMENT_PATH = "/content/ccc/fragment/";
    /**
	 * Constant for the ccc content resource path
	 */
    String CCC_RESOURCE_PATH = "/content/ccc/resource/";
    /**
     * Constant for the CCC tag path
     */
    String CCC_TAG = "/etc/tags/ccc/";

	/**
	 * Constant for the Resources tag path
	 */
    String RESOURCES_TAG = "/etc/tags/ccc/resource";

    /**
	 * Constant for the Fragment tag path
	 */
    String FRAGMENT_TAG = "/etc/tags/ccc/fragment";

    String PRMIS_PRODUCTS_PATH = "/etc/prmis/products";

    String PRMIS_APPLICATIONS_PATH = "/etc/prmis/applications";

	/**
	 * Constant for the CQ Page Content Primary Type
	 */
    String CQ_PAGE_CONTENT_TYPE = "cq:PageContent";

	/**
	 * Constant for the ST ASSET Type
	 */
    String ST_ASSET_TYPE = "st:asset";

    /**
     * Constant for PRMIS Content
     */
    String ST_PRMIS_CONTENT = "st:prmisContent";
	/**
	 * Constant for the dms-content node
	 */
    String DMS_CONTENT = "dms-content";

	/**
	 * Constant for the translations node
	 */
    String TRANSLATIONS = "translations";

	/**
	 * Constant for the resource type prefix for the product pages
	 */
    String PRODUCT_RESOURCE_TYPE_PREFIX = "st-site/components/pages/products/";

    /**
     * Constant for the resource page component
     */
    String RESOURCE_ASSET_TYPE = "st-ccc/components/pages/resource";


    String FRAGMENT_PAGE_TEMPLATE = "/apps/st-ccc/templates/fragment";
    String FRAGMENT_PAGE_TYPE = "st-ccc/components/pages/fragment";
    String FRAGMENT_TRANSLATION_PAGE_TEMPLATE = "/apps/st-ccc/templates/fragment/translation";
    String FRAGMENT_TRANSLATION_PAGE_TYPE = "st-ccc/components/pages/fragment/translation";

    String EXPORT_RESOURCES_JOB_TOPIC_FILES = "st/job/export_resource_assets/files";

    String EXPORT_RESOURCES_JOB_TOPIC_CSV = "st/job/export_resource_assets/csv";

    String EXPORT_RESOURCES_TYPE_PARAMETER = "type";

    String EXPORT_RESOURCES_ROOTPATH_PARAMETER = "rootPath";

    String EXPORT_RESOURCES_ALL_TRANSLATION_PARAMETER = "allTranslations";

    String EXPORT_RESOURCES_LANGUAGES_PARAMETER = "languages";

    String EXPORT_RESOURCES_TAG_PARAMETER = "tag";

    String EXPORT_RESOURCES_ASSET_PATHS_PARAMETER = "assetPaths";

    String EXPORT_RESOURCES_TYPE_FILES = "files";

    String EXPORT_RESOURCES_TYPE_CSV = "csv";

    /**
	 * Constant for the application/json response type
	 */
    String APPLICATION_JSON = "application/json";

	/**
	 * Constant for English File prefix
	 */
    String EN_PREFIX = "en.";

    /**
	 * Constant for the fragment template
	 */
    String FRAGMENT_TEMPLATE = "/apps/st-ccc/templates/fragment";

    /**
     * Constant for the Fragment tag id start path
     */
    String TAG_ID_START_STRING = "ccc:";


    String EVENT_ROOT = "/content/ccc/fragment/corporate/event_information/event";
    String NEWS_ROOT = "/content/ccc/fragment/sales_and_marketing/e-news/e-news_article";
    String PRESS_RELEASES_ROOT = "/content/ccc/fragment/press";
    String ST_ADMIN_ROOT = "/etc/stconfig/";
    String ST_ADMIN_STATIC_ROOT = ST_ADMIN_ROOT + "widgets/fragments/static_fragments_root";
    String DESIGN_RESOURCES_ROOT = ST_ADMIN_STATIC_ROOT + "/design_resources";
    String FEATURED_VIDEOS_ROOT = ST_ADMIN_STATIC_ROOT + "/featured_videos";
    String UPCOMING_SEMINARS_ROOT = ST_ADMIN_STATIC_ROOT + "/upcoming_seminars";
    String E_DESIGN_ROOT = ST_ADMIN_STATIC_ROOT + "/eDesign";
    String RIGHT_RAIL_ROOT = "/etc/stconfig/right-rail/static";
    String HTML_PARAGRAPH_END = "</p>";
    String APPLICATION_PDF = "application/pdf";
    String PDF_SHORT = "PDF";
    String DESIGN_CONFIG_PATH = "designConfigPath";
    String CONFIG_INHERITABLE = "designInheritable";
    String FREE_SAMPLE_PROPERTY = "445";
    String PRMIS_FREE_SAMPLE_PROPERTY = "1167";
    String ST_VERT_DISTRIBUTORS = "ST_VERT_DISTRIBUTORS";
    String ST_VERT_EMPLOYEE = "ST_VERT_EMPLOYEE";
    String ST_VERT_REPS = "ST_VERT_REPS";
    String VIDEO_LIST_ROOT = "/content/ccc/fragment/multimedia/video/video_list/";
}
