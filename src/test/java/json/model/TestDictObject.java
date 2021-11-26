package json.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import ru.gx.core.data.AbstractDataObject;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString
@Accessors(chain = true)
public class TestDictObject extends AbstractDataObject {
    private static Map<String, TestDictObject> objects = new HashMap<>();

    @JsonProperty
    private String code;

    @JsonProperty
    private String name;

    private TestDictObject() {
    }

    public TestDictObject(String code, String name) {
        this.code = code;
        this.name = name;
        objects.put(code, this);
    }

    public static TestDictObject getByCode(String code) {
        return objects.get(code);
    }
}
