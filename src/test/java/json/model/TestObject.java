package json.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import ru.gx.data.AbstractDataObject;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString
@Accessors(chain = true)
public class TestObject extends AbstractDataObject {
    @JsonProperty(value = "str-val", required = true)
    private String value;

    @JsonProperty(value = "val2")
    private String value2;

    @JsonProperty(value = "val3")
    private String value3;

    @JsonProperty(value = "inner")
    private TestInnerObject innerObject;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "code")
    @JsonIdentityReference(alwaysAsId = true)
    private TestDictObject refToDict;

    @JsonProperty(value = "refToDict")
    public TestObject setRefToDict(String code) {
        this.refToDict = TestDictObject.getByCode(code);
        return this;
    }

    private TestObject() {
    }

    public TestObject(String value, String value2, String value3, TestInnerObject innerObject, TestDictObject refToDict) {
        this.value = value;
        this.value2 = value2;
        this.value3 = value3;
        this.innerObject = innerObject;
        this.refToDict = refToDict;
    }
}
