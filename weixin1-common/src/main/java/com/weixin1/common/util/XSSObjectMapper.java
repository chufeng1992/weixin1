package com.weixin1.common.util;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.module.SimpleModule;
import org.springframework.web.util.HtmlUtils;

public class XSSObjectMapper extends ObjectMapper {
    private static final long serialVersionUID = -3448961813323784217L;

    public XSSObjectMapper() {
        SimpleModule module = new SimpleModule("HTML XSS Serializer",
                new Version(1, 0, 0, ""));
        module.addSerializer(new JsonHtmlXssSerializer(String.class));
        this.registerModule(module);
    }

    class JsonHtmlXssSerializer extends JsonSerializer<String> {

        public JsonHtmlXssSerializer(Class<String> string) {
            super();
        }

        public Class<String> handledType() {
            return String.class;
        }

        public void serialize(String value, JsonGenerator jsonGenerator,
                SerializerProvider serializerProvider) throws IOException,
                JsonProcessingException {
            if (value != null) {
                String encodedValue = HtmlUtils.htmlEscape(value.toString());
                jsonGenerator.writeString(encodedValue);
            }
        }
    }
}
