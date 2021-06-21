package connector;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import ru.gagarkin.gxfin.common.data.AbstractDataPackage;

import java.util.ArrayList;
import java.util.List;

public class TestPackage {
    @JsonProperty(value = "package_size")
    public int quikPackageSize;

    @JsonProperty(value = "all_count")
    public long quikAllCount;

    @JsonProperty(value = "rows")
    @Getter
    private final List<TestObject> rows = new ArrayList<>();
}
