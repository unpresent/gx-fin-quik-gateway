package json2.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import json2.memdata.TestRefObjectsMemRepo;
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
@JsonIdentityInfo(property = "code", generator = ObjectIdGenerators.PropertyGenerator.class, resolver = TestRefObjectsMemRepo.class)
public class TestRefObject extends AbstractDataObject {
    @JsonProperty
    private String code;

    @JsonProperty
    private String parentCode;

    @JsonProperty
    private String name;
}
