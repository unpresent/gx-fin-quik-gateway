package json2.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TestMainObjectB extends TestMainObject {
    @JsonProperty
    private LocalDateTime time;
}
