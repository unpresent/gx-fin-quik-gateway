package json.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.sql.Time;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Accessors(chain = true)
public class TestInnerObject {
    @JsonProperty(value = "val1")
    private int value1;

    @JsonProperty(value = "val2")
    private Time value2;

    private TestInnerObject() {
    }

    public TestInnerObject(int value1, Time value2) {
        this.value1 = value1;
        this.value2 = value2;
    }
}

