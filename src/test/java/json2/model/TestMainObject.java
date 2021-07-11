package json2.model;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import ru.gxfin.common.data.AbstractDataObject;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TestMainObject extends AbstractDataObject {
    @JsonProperty
    private int id;

    @JsonProperty()
    @JsonIdentityReference(alwaysAsId = true)
    private TestRefObject testRef;

    @JsonProperty
    private String name;

    @JsonProperty
    private String desc;

    /*
    @JsonCreator
    public static TestMainObject createObject(
        //            @JsonProperty("id") int id,
        //            @JsonProperty("testRef") TestRefObject testRef,
        //            @JsonProperty("name") String name
    ) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        final var result = TestMainObjectsFactory.getInstance().createObject(TestMainObject.class);
        //                .setId(id)
        //                .setTestRef(testRef)
        //                .setName(name + ":XXX");
        return result;
    }
    //*/
}
