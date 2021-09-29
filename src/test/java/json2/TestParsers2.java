package json2;

import json2.model.TestMainObject;
import json2.model.TestRefObject;
import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;
import org.testcontainers.shaded.com.fasterxml.jackson.core.JsonProcessingException;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.UUID;

@Testable
public class TestParsers2 {
    @Test
    public void testObjectWithRef2Json() throws JsonProcessingException {
        final var mapper = new ObjectMapper();

        final var o1 = new TestMainObject()
                .setId(1)
                .setTestRef(
                        new TestRefObject()
                                .setCode("A")
                                .setName("Аaa")
                )
                .setName("Объект 1 типа aaa");

        final var json = mapper.writeValueAsString(o1);
        System.out.println(json);
    }

    @Test
    public void testJson2ObjectWithRef() throws IOException {
        System.out.println(UUID.fromString("00000000-0000-0000-0000-000000000000"));

        final var mapper = new ObjectMapper();
        final var strRef1 = "{\"code\":\"A\",\"name\":\"Аaa\"}";
        final var strRef2 = "{\"code\":\"B\",\"name\":\"Bbb\"}";
        final var strRef3 = "{\"code\":\"C\",\"name\":\"Ccc\"}";

        final var strMain1 = "{\"id\":1,\"testRef\":\"A\",\"name\":\"Объект 1 типа Aaa\",\"nothing\":0,\"desc\":\"Какое-то описание 1\"}";
        final var strMain2 = "{\"id\":2,\"testRef\":\"C\",\"name\":\"Объект 2 типа Ccc\"}";
        final var strMain3 = "{\"id\":2,\"testRef\":null,\"name\":\"Объект 3 типа Ddd\"}";

        final var r1 = mapper.readValue(strRef1, TestRefObject.class);
        final var r2 = mapper.readValue(strRef2, TestRefObject.class);
        final var r3 = mapper.readValue(strRef3, TestRefObject.class);

        final var o1 = mapper.readValue(strMain1, TestMainObject.class);
        final var o2 = mapper.readValue(strMain2, TestMainObject.class);
        final var o3 = mapper.readValue(strMain3, TestMainObject.class);

        System.out.println(o1);
    }
}
