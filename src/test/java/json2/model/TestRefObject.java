package json2.model;

import com.fasterxml.jackson.annotation.*;
import json2.memdata.TestRefObjectsMemRepo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import ru.gxfin.common.data.AbstractDataObject;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Accessors(chain = true)
@JsonIdentityInfo(property = "code", generator = ObjectIdGenerators.PropertyGenerator.class, resolver = TestRefObjectsMemRepo.class)
public class TestRefObject extends AbstractDataObject {
    @JsonProperty
    private String code;

    @JsonProperty
    private String parentCode;

    @JsonProperty(required = false)
    private String name;
}
