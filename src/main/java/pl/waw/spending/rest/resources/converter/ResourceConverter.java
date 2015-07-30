package pl.waw.spending.rest.resources.converter;

import java.util.List;
import java.util.stream.Collectors;

public interface ResourceConverter<R, T> {
	
	R convertToResource(T domainObject);
	
	default List<R> convertToResources(List<T> domainObject) {
		return domainObject.stream().map(this::convertToResource).collect(Collectors.toList());
	}
}
