package pl.altkom.asc.lab.micronaut.poc.policy.search.infrastructure.adapters.db;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;

import javax.inject.Singleton;
import java.io.IOException;

@Singleton
class JsonConverter {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(JsonConverter.class);
    private final ObjectMapper jsonMapper;

    public JsonConverter(ObjectMapper jsonMapper) {
        this.jsonMapper = jsonMapper;
    }

    <T> String stringifyObject(T doc) {
        try {
            return jsonMapper.writeValueAsString(doc);
        } catch (JsonProcessingException e) {
            log.error("Failed to serialized policy to json", e);
            return null;
        }
    }

    <T> T objectFromString(String src, Class<T> clazz) {
        try {
            return jsonMapper.readValue(src, clazz);
        } catch (IOException ioExc) {
            log.error("Failed to deserialize from string " + src, ioExc);
            return null;
        }
    }
}
