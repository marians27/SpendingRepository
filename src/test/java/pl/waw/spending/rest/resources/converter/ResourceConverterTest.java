package pl.waw.spending.rest.resources.converter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ResourceConverterTest {

	private ResourceConverter<String, Integer> mockedImplementation;
	
	@Before
	public void prepareForTest() {
		mockedImplementation = (i) -> {return i.toString();};
	}
	
	@Test
	public void testEmptyList() {
		List<String> convertedList = mockedImplementation.convertToResources(new ArrayList<Integer>());
		Assert.assertTrue(convertedList.isEmpty());
	}
	
	@Test(expected = NullPointerException.class)
	public void exceptionOnNullInputList() {
		mockedImplementation.convertToResources(null);
	}
	
	@Test
	public void verifyWholeListConverted() {
		List<Integer> inList = Arrays.asList(1, 2, 3, 4);
		List<String> convertedList = mockedImplementation.convertToResources(inList);
		Assert.assertEquals(inList.size(), convertedList.size());
		for (int i = 0; i < inList.size(); i++) {
			Assert.assertEquals(inList.get(i).toString(), convertedList.get(i));
		}
	}
}
