package json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import json.model.TestDictObject;
import json.model.TestInnerObject;
import json.model.TestObject;
import json.model.TestPackage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;
import ru.gxfin.gate.quik.model.income.QuikAllTrade;
import ru.gxfin.gate.quik.model.income.QuikAllTradesPackage;
import ru.gxfin.gate.quik.model.internal.AllTradesPackage;

import java.sql.Time;
import java.time.LocalTime;

@Testable
public class TestParsers {
    @Test
    public void testJsonAndTestObject() throws Exception {
        final String etalonJson = "{\"str-val\":\"AAA\",\"val2\":\"BBB\",\"val3\":null,\"inner\":{\"val1\":10,\"val2\":\"12:15:33\"},\"refToDict\":\"A1\"}";
        /*
        LocalTime lt = LocalTime.parse("12:15:33");
        LocalDateTime ldt = LocalDateTime.of(LocalDate.now(), lt);
        Date d = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
         */
        Time t = Time.valueOf(LocalTime.parse("12:15:33"));

        TestObject testObject = new TestObject("AAA", "BBB", null, new TestInnerObject(10, t), new TestDictObject("A1", "Первый"));
        String testJson;

        ObjectMapper objectMapper = new ObjectMapper();
        testJson = objectMapper.writeValueAsString(testObject);
        System.out.println(testJson);

        Assertions.assertEquals(etalonJson, testJson, "Ошибка Jackson-сериализации TestObject в json-строку");

        testObject = objectMapper.readValue(testJson, TestObject.class);

        Assertions.assertEquals("AAA", testObject.getValue(), "Ошибка Jackson-десериализации (str-val в value) json-строки в TestObject");
        Assertions.assertNotNull(testObject.getInnerObject(),  "Ошибка Jackson-десериализации (inner в innerObject) json-строки в TestObject");
        Assertions.assertEquals(10, testObject.getInnerObject().getValue1(), "Ошибка Jackson-десериализации (inner/val1 в val1) json-строки в TestObject");
    }

    @Test
    public void testJsonAndTestPackage() throws Exception {
        Time t = Time.valueOf(LocalTime.parse("12:15:33"));
        TestPackage testPackage = new TestPackage();

        TestObject testObject = new TestObject("AAA", "BBB", null, new TestInnerObject(10, t), new TestDictObject("A1", "Первый"));
        testPackage.getRows().add(testObject);

        testObject = new TestObject("CCC", "DDD", null, new TestInnerObject(20, Time.valueOf(LocalTime.parse("23:59:59"))), new TestDictObject("A1", "Первый"));
        testPackage.getRows().add(testObject);

        String testJson;

        ObjectMapper objectMapper = new ObjectMapper();

        testJson = objectMapper.writeValueAsString(testPackage);
        System.out.println(testJson);

        testPackage = objectMapper.readValue(testJson, TestPackage.class);
    }

    @Test
    public void testJson2AllTrade() throws Exception {
        //*
        String testMessage = "{\n" +
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
                "}\n";
        ObjectMapper objectMapper = new ObjectMapper();

        QuikAllTrade testQuikAllTrade = objectMapper.readValue(testMessage,  QuikAllTrade.class);

        Assertions.assertEquals(1, testQuikAllTrade.getRowIndex(), "Ошибка Jackson-десериализации (row_index в rowIndex) json-строки в AllTrade");
        Assertions.assertEquals("3518016102", testQuikAllTrade.getTradeNum(), "Ошибка Jackson-десериализации (trade_num в 3518016102) json-строки в AllTrade");
    }

    @Test
    public void testJson2AllTradesPackageShort() throws Exception {
        String testMessage = "{\n" +
                "    \"all_count\": 1457762,\n" +
                "    \"package_size\": 18\n" +
                "}\n";
        ObjectMapper objectMapper = new ObjectMapper();

        TestPackage testPackage = objectMapper.readValue(testMessage,  TestPackage.class);

        Assertions.assertEquals(1457762, testPackage.quikAllCount, "Ошибка Jackson-десериализации (all_count в allCount) json-строки в AllTradesPackage");
        Assertions.assertEquals(18, testPackage.quikPackageSize, "Ошибка Jackson-десериализации (package_size в packageSize) json-строки в AllTradesPackage");
    }

    @Test
    public void testJson2AllTradesPackage() throws Exception {
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
        final var objectMapper = new ObjectMapper()
                .registerModule(new JavaTimeModule());

        final var tradesPackage = objectMapper.readValue(testMessage,  QuikAllTradesPackage.class);

        Assertions.assertEquals(1457762, tradesPackage.getQuikAllCount(), "Ошибка Jackson-десериализации (all_count в allCount) json-строки в AllTradesPackage");
        Assertions.assertEquals(18, tradesPackage.getQuikPackageSize(), "Ошибка Jackson-десериализации (package_size в packageSize) json-строки в AllTradesPackage");
        Assertions.assertNotNull(tradesPackage.getItems(),  "Ошибка Jackson-десериализации (rows в rows) json-строки в AllTradesPackage");
        // Assertions.assertEquals(18, tradesPackage.size(), "Ошибка Jackson-десериализации (rows в rows) json-строки в AllTradesPackage - количество записей");

        final var stdAllTrades = new AllTradesPackage(tradesPackage);
        testMessage = objectMapper.writeValueAsString(stdAllTrades);
    }
}
