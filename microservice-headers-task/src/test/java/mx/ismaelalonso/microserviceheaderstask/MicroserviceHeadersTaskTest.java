package mx.ismaelalonso.microserviceheaderstask;

import mx.ismaelalonso.microserviceheaderstask.constants.Constants;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

/**
 * Unit test for simple MicroserviceHeadersTask.
 *
 * @author Ismael Alonso.
 */
@RunWith(MockitoJUnitRunner.class)
public class MicroserviceHeadersTaskTest {

  /** Class to test. */
  @InjectMocks
  private MicroserviceHeadersTask microserviceHeadersTask = new MicroserviceHeadersTask();

  /** Enumeration test reference for the headers names. */
  private Enumeration<String> headersNames;

  /** Enumeration test reference for the header 1 values. */
  private Enumeration<String> header1Values;

  /** Enumeration test reference for the header 2 values. */
  private Enumeration<String> header2Values;

  /** Enumeration test reference for the header 3 values. */
  private Enumeration<String> header3Values;

  /** HttpServletRequest mock object. */
  private HttpServletRequest request;

  /** List for specific headers names. */
  private List<String> listOfHeaderNames;

  /** Set up method to run before all the test. */
  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    headersNames =
        Collections.enumeration(
            Arrays.asList(Constants.HEADER_1, Constants.HEADERS_2, Constants.HEADERS_3));

    header1Values = Collections.enumeration(Constants.HEADER_1_VALUES);
    header2Values = Collections.enumeration(Constants.HEADER_2_VALUES);
    header3Values = Collections.enumeration(Constants.HEADER_3_VALUES);

    listOfHeaderNames = Arrays.asList(Constants.HEADER_1, Constants.HEADERS_3);

    request = Mockito.mock(HttpServletRequest.class);
  }

  /** Test fot getHeaders(). */
  @Test
  public void getHeadersTest() {
    Mockito.when(request.getHeaderNames()).thenReturn(headersNames);
    Mockito.when(request.getHeaders(Mockito.anyString()))
        .thenReturn(header1Values)
        .thenReturn(header2Values)
        .thenReturn(header3Values);

    Map<String, List<String>> headersMap = microserviceHeadersTask.getHeaders(request);
    List<String> headerOneValues = headersMap.get(Constants.HEADER_1);
    List<String> headerTwoValues = headersMap.get(Constants.HEADERS_2);
    List<String> headerThreeValues = headersMap.get(Constants.HEADERS_3);

    Assert.assertNotNull(headersMap);
    Assert.assertEquals(headersMap.size(), Constants.VALUE_INT_3);
    Assert.assertEquals(headerOneValues.size(), Constants.VALUE_INT_3);
    Assert.assertEquals(headerTwoValues.size(), Constants.VALUE_INT_2);
    Assert.assertEquals(headerThreeValues.size(), Constants.VALUE_INT_1);
  }

  /** Test for getSpecificHeaders(). */
  @Test
  public void getSpecificHeadersTest() {
    Mockito.when(request.getHeaders(Mockito.anyString()))
        .thenReturn(header1Values)
        .thenReturn(header3Values);

    Map<String, List<String>> headersMap =
        microserviceHeadersTask.getSpecificHeaders(request, listOfHeaderNames);
    List<String> headerOneValues = headersMap.get(Constants.HEADER_1);
    List<String> headerThreeValues = headersMap.get(Constants.HEADERS_3);

    Assert.assertNotNull(headersMap);
    Assert.assertEquals(headersMap.size(), Constants.VALUE_INT_2);
    Assert.assertEquals(headerOneValues.size(), Constants.VALUE_INT_3);
    Assert.assertEquals(headerThreeValues.size(), Constants.VALUE_INT_1);
  }
}
