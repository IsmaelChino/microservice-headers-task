package mx.ismaelalonso.microserviceheaderstask.constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class with constants for JUnit test class.
 *
 * @author Ismael Alonso.
 */
public class Constants {

  /** Constant with the headers names. */
  public static final String HEADERS_NAMES = "header1 header2 header3";

  /** Constant for the first header name. */
  public static final String HEADER_1 = "header1";

  /** Constant for the second header name. */
  public static final String HEADERS_2 = "header2";

  /** Constant for the third header name. */
  public static final String HEADERS_3 = "header3";

  /** Constant for the first value of the first header. */
  public static final String HEADER_1_VALUE_1 = "h1 v1";

  /** Constant for the second value of the first header. */
  public static final String HEADER_1_VALUE_2 = "h1 v2";

  /** Constant for the third value of the first header. */
  public static final String HEADER_1_VALUE_3 = "h1 v3";

  /** Constant for the first value of the second header. */
  public static final String HEADER_2_VALUE_1 = "h2 v1";

  /** Constant for the second value of the second header. */
  public static final String HEADER_2_VALUE_2 = "h2 v2";

  /** Constant for the first value of the third header. */
  public static final String HEADER_3_VALUE_1 = "h3 v1";

  /** Constant for the int value 2. */
  public static final int VALUE_INT_1 = 1;

  /** Constant for the int value 2. */
  public static final int VALUE_INT_2 = 2;

  /** Constant for the int value 3. */
  public static final int VALUE_INT_3 = 3;

  /** Constant list with the values of the first header. */
  public static final List<String> HEADER_1_VALUES =
      Arrays.asList(HEADER_1_VALUE_1, HEADER_1_VALUE_2, HEADER_1_VALUE_3);

  /** Constant list with the values of the second header. */
  public static final List<String> HEADER_2_VALUES =
      Arrays.asList(HEADER_2_VALUE_1, HEADER_2_VALUE_2);

  /** Constant list with the values of the third header. */
  public static final List<String> HEADER_3_VALUES = Arrays.asList(HEADER_3_VALUE_1);

  private Constants() {}
}
