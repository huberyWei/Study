package cn.com.david.base;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Commonly used constants
 * 
 * Please feel free to add more commonly used constants
 * 
 * @author David
 *
 */
public interface Constants {

  String DAM_LOGO_ICONS_FOLDER = "/logo-icons/";
  String DEFAULT_ERROR_IMAGE = "errors/Teaser_180x100.jpg";
  String MPA_LOGO = "mpa/mpa.png";
  String EFFICIENT_DYNAMICS_LOGO = "efficientDynamics/efficient-dynamics-logo.png";
  String CONNECTED_DRIVE_LOGO = "connectedDrive/connected-drive-logo.png";
  String GSA_SEARCH_LOGO = "search/search-logo.jpg";
  String ENERGYLABELS_ICONS_PATH = DAM_LOGO_ICONS_FOLDER + "energyLabels";

  String CONTENT_TYPE_JSON = "application/json";
  String CONTENT_TYPE_TEXT = "text/plain";
  String CONTENT_TYPE_XML = "text/xml";
  public final static String ENCODING_UTF8 = "UTF-8";

  public final static String DATA = "data";
  public final static String CURRENT_DATA_PATH = "CURRENT_DATA_PATH";

  // use this for initial homepage site
  public final static String HOME = "index";

  public final String SWITCH_MASTER = "ITCHY";//$NON-NLS-N$
  public final String SWITCH_SLAVE = "SCRATCHY";//$NON-NLS-N$

  String SELECTOR_TILE = "tile";

  // file extension with point
  String EXTENSION_HTML = ".html";
  String EXTENSION_TXT = ".txt";
  String EXTENSION_XSD = ".xsd";
  // file extension without point
  String HTML_EXT = "html"; //$NON-NLS-N$
  String TXT_EXT = "txt"; //$NON-NLS-N$

  String IMPORT_SUFFIX = "IMPORT_SUFFIX";
  String HEALTH_CHECK = "healthcheck";

  // boolean values

  String BOOLEAN_FALSE = "false";
  String BOOLEAN_TRUE = "true";

  String BOOLEAN_NO = "no";
  String BOOLEAN_YES = "yes";

  String BOOLEAN_ON = "on";
  String BOOLEAN_OFF = "off";

  // constants for request methods
  String REQUEST_METHOD_DELETE = "DELETE";
  String REQUEST_METHOD_GET = "GET";
  String REQUEST_METHOD_POST = "POST";
  String REQUEST_METHOD_PUT = "PUT";


}
