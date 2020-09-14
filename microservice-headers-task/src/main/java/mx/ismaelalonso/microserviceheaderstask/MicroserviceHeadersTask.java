package mx.ismaelalonso.microserviceheaderstask;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class to solve a microservice task with HTTP headers.
 *
 * @author Ismael Alonso.
 */
public class MicroserviceHeadersTask {

  /**
   * Map the HTTP headers inside the request specified to a {@link Map}.
   *
   * @param request the HttpServletRequest with the HTTP headers
   * @return a map with all the headers in the request
   */
  public Map<String, List<String>> getHeaders(HttpServletRequest request) {
    Map<String, List<String>> headersMap = new HashMap<>();
    ArrayList<String> headersNames = Collections.list(request.getHeaderNames());
    headersNames.forEach(
        headerName -> headersMap.put(headerName, Collections.list(request.getHeaders(headerName))));
    return headersMap;
  }

  /**
   * Map the HTTP headers with the names specified in the headersNames {@link List} to a {@link
   * Map}.
   *
   * @param request the HttpServletRequest with the HTTP headers
   * @param headersNames the list with the headers names to be mapped
   * @return a map with the headers specified in the request and headersNames
   */
  public Map<String, List<String>> getSpecificHeaders(
      HttpServletRequest request, List<String> headersNames) {
    Map<String, List<String>> headersMap = new HashMap<>();
    headersNames.forEach(
        headerName -> headersMap.put(headerName, Collections.list(request.getHeaders(headerName))));
    return headersMap;
  }

}
