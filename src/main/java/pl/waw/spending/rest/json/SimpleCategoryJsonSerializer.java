package pl.waw.spending.rest.json;

import java.io.IOException;

import pl.waw.spending.domain.Category;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class SimpleCategoryJsonSerializer extends JsonSerializer<Category>{

	@Override
	public void serialize(Category value, JsonGenerator gen, SerializerProvider serializers) 
		throws IOException, JsonProcessingException {
		gen.writeString(value.getName());
	}

}
