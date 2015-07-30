package pl.waw.spending.rest.json;

import java.io.IOException;

import pl.waw.spending.domain.Spender;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class SimpleSpenderJsonSerializer extends JsonSerializer<Spender> {

	@Override
	public void serialize(Spender value, JsonGenerator gen, SerializerProvider serializers) 
		throws IOException,	JsonProcessingException {
		gen.writeString(value.getName());
	}

}
