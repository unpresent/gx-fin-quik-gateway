package connector;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.gagarkin.gxfin.gate.quik.dto.AllTradesPackage;

import java.sql.Time;
import java.time.LocalTime;

public class TestConnectorParsers {
    @Test
    public void testJacksonAndTestObject() throws Exception {
        final String etalonJson = "{\"str-val\":\"AAA\",\"val2\":\"BBB\",\"val3\":null,\"inner\":{\"val1\":10,\"val2\":\"12:15:33\"}}";
        /*
        LocalTime lt = LocalTime.parse("12:15:33");
        LocalDateTime ldt = LocalDateTime.of(LocalDate.now(), lt);
        Date d = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
         */
        Time t = Time.valueOf(LocalTime.parse("12:15:33"));

        TestObject testObject = new TestObject("AAA", "BBB", null, new TestInnerObject(10, t));
        String testJson;

        ObjectMapper objectMapper = new ObjectMapper();
        testJson = objectMapper.writeValueAsString(testObject);

        Assertions.assertEquals(etalonJson, testJson, "Ошибка Jackson-сериализации TestObject в json-строку");

        testObject = objectMapper.readValue(testJson, TestObject.class);

        Assertions.assertEquals("AAA", testObject.getValue(), "Ошибка Jackson-десериализации (str-val в value) json-строки в TestObject");
        Assertions.assertNotNull(testObject.getInnerObject(),  "Ошибка Jackson-десериализации (inner в innerObject) json-строки в TestObject");
        Assertions.assertEquals(10, testObject.getInnerObject().getValue1(), "Ошибка Jackson-десериализации (inner/val1 в val1) json-строки в TestObject");
    }

    @Test
    public void testJacksonGetAllTradesPackage() throws Exception {
        //*
        String testMessage = "{\n" +
                "    \"all_count\": 1457762,\n" +
                "    \"package_size\": 18,\n" +
                "    \"rows\": [{\n" +
                "            \"row_index\": \"1\",\n" +
                "            \"trade_num\": \"3518016102\",\n" +
                "            \"flags\": \"1025\",\n" +
                "            \"price\": \"0.79\",\n" +
                "            \"qty\": \"25.0\",\n" +
                "            \"value\": \"19750.0\",\n" +
                "            \"accruedint\": \"0.0\",\n" +
                "            \"yield\": \"0.0\",\n" +
                "            \"settlecode\": \"Y2\",\n" +
                "            \"reporate\": \"0.0\",\n" +
                "            \"repovalue\": \"0.0\",\n" +
                "            \"repo2value\": \"0.0\",\n" +
                "            \"repoterm\": \"0\",\n" +
                "            \"sec_code\": \"HYDR\",\n" +
                "            \"class_code\": \"TQBR\",\n" +
                "            \"datetime\": \"2021-01-25T09:59:31.000\",\n" +
                "            \"period\": \"0\",\n" +
                "            \"open_interest\": \"0\",\n" +
                "            \"exchange_code\": \"\"\n" +
                "        }, {\n" +
                "            \"row_index\": \"2\",\n" +
                "            \"trade_num\": \"3518016103\",\n" +
                "            \"flags\": \"1025\",\n" +
                "            \"price\": \"0.79\",\n" +
                "            \"qty\": \"100.0\",\n" +
                "            \"value\": \"79000.0\",\n" +
                "            \"accruedint\": \"0.0\",\n" +
                "            \"yield\": \"0.0\",\n" +
                "            \"settlecode\": \"Y2\",\n" +
                "            \"reporate\": \"0.0\",\n" +
                "            \"repovalue\": \"0.0\",\n" +
                "            \"repo2value\": \"0.0\",\n" +
                "            \"repoterm\": \"0\",\n" +
                "            \"sec_code\": \"HYDR\",\n" +
                "            \"class_code\": \"TQBR\",\n" +
                "            \"datetime\": \"2021-01-25T09:59:31.000\",\n" +
                "            \"period\": \"0\",\n" +
                "            \"open_interest\": \"0\",\n" +
                "            \"exchange_code\": \"\"\n" +
                "        }\n" +
                "    ]\n" +
                "}\n";
        ObjectMapper objectMapper = new ObjectMapper();

        AllTradesPackage tradesPackage = objectMapper.readValue(testMessage,  AllTradesPackage.class);

        Assertions.assertEquals(1457762, tradesPackage.allCount, "Ошибка Jackson-десериализации (all_count в allCount) json-строки в AllTradesPackage");
        Assertions.assertEquals(18, tradesPackage.packageSize, "Ошибка Jackson-десериализации (package_size в packageSize) json-строки в AllTradesPackage");
        Assertions.assertNotNull(tradesPackage.rows,  "Ошибка Jackson-десериализации (rows в rows) json-строки в AllTradesPackage");
    }
}
