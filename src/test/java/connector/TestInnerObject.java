package connector;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.sql.Time;
import java.util.Date;

@Getter
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

