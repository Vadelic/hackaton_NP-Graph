package sbrf.hackaton.cit.srv.parse;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class Mapper {
    static ObjectMapper mapper = new ObjectMapper();

    public static <T> T map(String content, Class<T> valueType) {
        try {
            return mapper.readValue(content, valueType);
        } catch (IOException e) {
            return null;
        }
    }
}
