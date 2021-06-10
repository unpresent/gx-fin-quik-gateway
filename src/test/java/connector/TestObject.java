package connector;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class TestObject {
    @JsonProperty(value = "str-val", required = true)
    private String value;

    @JsonProperty(value = "val2")
    private String value2;

    @JsonProperty(value = "val3")
    private String value3;

    @JsonProperty(value = "inner")
    private TestInnerObject innerObject;

    private TestObject() {
    }

    public TestObject(String value, String value2, String value3, TestInnerObject innerObject) {
        this.value = value;
        this.value2 = value2;
        this.value3 = value3;
        this.innerObject = innerObject;
    }
}
