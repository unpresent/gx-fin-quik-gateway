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
import ru.gx.fin.gate.quik.model.original.OriginalQuikAllTrade;
import ru.gx.fin.gate.quik.model.original.OriginalQuikAllTradesPackage;
import ru.gx.fin.gate.quik.model.original.OriginalQuikSecurity;

import java.sql.Time;
import java.time.LocalTime;

@Testable
public class TestParsers {
    public static ObjectMapper getObjectMapper() {
        return new ObjectMapper().registerModule(new JavaTimeModule());
    }

    @Test
    public void testJsonAndTestObject() throws Exception {
        final String etalonJson = "{\"str-val\":\"AAA\",\"val2\":\"BBB\",\"val3\":null,\"inner\":{\"val1\":10,\"val2\":\"12:15:33\"},\"refToDict\":\"A1\"}";
        /*
        LocalTime lt = LocalTime.parse("12:15:33");
        LocalDateTime ldt = LocalDateTime.of(LocalDate.now(), lt);
        Date d = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
         */
        Time t = Time.valueOf(LocalTime.parse("12:15:33"));

        var testObject = new TestObject("AAA", "BBB", null, new TestInnerObject(10, t), new TestDictObject("A1", "Первый"));
        String testJson;

        final var objectMapper = getObjectMapper();
        testJson = objectMapper.writeValueAsString(testObject);
        System.out.println(testJson);

        Assertions.assertEquals(etalonJson, testJson, "Ошибка Jackson-сериализации TestObject в json-строку");

        testObject = objectMapper.readValue(testJson, TestObject.class);

        Assertions.assertEquals("AAA", testObject.getValue(), "Ошибка Jackson-десериализации (str-val в value) json-строки в TestObject");
        Assertions.assertNotNull(testObject.getInnerObject(), "Ошибка Jackson-десериализации (inner в innerObject) json-строки в TestObject");
        Assertions.assertEquals(10, testObject.getInnerObject().getValue1(), "Ошибка Jackson-десериализации (inner/val1 в val1) json-строки в TestObject");
    }

    @SuppressWarnings("UnusedAssignment")
    @Test
    public void testJsonAndTestPackage() throws Exception {
        Time t = Time.valueOf(LocalTime.parse("12:15:33"));
        TestPackage testPackage = new TestPackage();

        TestObject testObject = new TestObject("AAA", "BBB", null, new TestInnerObject(10, t), new TestDictObject("A1", "Первый"));
        testPackage.getRows().add(testObject);

        testObject = new TestObject("CCC", "DDD", null, new TestInnerObject(20, Time.valueOf(LocalTime.parse("23:59:59"))), new TestDictObject("A1", "Первый"));
        testPackage.getRows().add(testObject);

        String testJson;

        final var objectMapper = getObjectMapper();

        testJson = objectMapper.writeValueAsString(testPackage);
        System.out.println(testJson);

        testPackage = objectMapper.readValue(testJson, TestPackage.class);
    }

    @Test
    public void testJson2AllTrade() throws Exception {
        //*
        String testMessage = """
                {
                            "row_index": "1",
                            "trade_num": "3518016102",
                            "flags": "1025",
                            "price": "0.79",
                            "qty": "25.0",
                            "value": "19750.0",
                            "accruedint": "0.0",
                            "yield": "0.0",
                            "settlecode": "Y2",
                            "reporate": "0.0",
                            "repovalue": "0.0",
                            "repo2value": "0.0",
                            "repoterm": "0",
                            "sec_code": "HYDR",
                            "class_code": "TQBR",
                            "datetime": "2021-01-25 09:59:31.000",
                            "period": "0",
                            "open_interest": "0",
                            "exchange_code": ""
                }
                """;
        final var objectMapper = getObjectMapper();

        OriginalQuikAllTrade testOriginalQuikAllTrade = objectMapper.readValue(testMessage, OriginalQuikAllTrade.class);

        Assertions.assertEquals(1, testOriginalQuikAllTrade.getRowIndex(), "Ошибка Jackson-десериализации (row_index в rowIndex) json-строки в AllTrade");
        Assertions.assertEquals("3518016102", testOriginalQuikAllTrade.getTradeNum(), "Ошибка Jackson-десериализации (trade_num в 3518016102) json-строки в AllTrade");
    }

    @Test
    public void testJson2AllTradesPackageShort() throws Exception {
        String testMessage = """
                {
                    "all_count": 1457762,
                    "package_size": 18
                }
                """;
        final var objectMapper = getObjectMapper();

        TestPackage testPackage = objectMapper.readValue(testMessage, TestPackage.class);

        Assertions.assertEquals(1457762, testPackage.quikAllCount, "Ошибка Jackson-десериализации (all_count в allCount) json-строки в AllTradesPackage");
        Assertions.assertEquals(18, testPackage.quikPackageSize, "Ошибка Jackson-десериализации (package_size в packageSize) json-строки в AllTradesPackage");
    }

    @Test
    public void testJson2AllTradesPackage() throws Exception {
        //*
        String testMessage = """
                {
                    "all_count": 1457762,
                    "package_size": 18,
                    "rows": [{
                            "row_index": "1",
                            "trade_num": "3518016102",
                            "flags": "1025",
                            "price": "0.79",
                            "qty": "25.0",
                            "value": "19750.0",
                            "accruedint": "0.0",
                            "yield": "0.0",
                            "settlecode": "Y2",
                            "reporate": "0.0",
                            "repovalue": "0.0",
                            "repo2value": "0.0",
                            "repoterm": "0",
                            "sec_code": "HYDR",
                            "class_code": "TQBR",
                            "datetime": "2021-01-25 09:59:31.000",
                            "period": "0",
                            "open_interest": "0",
                            "exchange_code": ""
                        }, {
                            "row_index": "2",
                            "trade_num": "3518016103",
                            "flags": "1025",
                            "price": "0.79",
                            "qty": "100.0",
                            "value": "79000.0",
                            "accruedint": "0.0",
                            "yield": "0.0",
                            "settlecode": "Y2",
                            "reporate": "0.0",
                            "repovalue": "0.0",
                            "repo2value": "0.0",
                            "repoterm": "0",
                            "sec_code": "HYDR",
                            "class_code": "TQBR",
                            "datetime": "2021-01-25 09:59:31.000",
                            "period": "0",
                            "open_interest": "0",
                            "exchange_code": ""
                        }
                    ]
                }
                """;
        final var objectMapper = getObjectMapper();
        final var tradesPackage = objectMapper.readValue(testMessage, OriginalQuikAllTradesPackage.class);

        Assertions.assertEquals(1457762, tradesPackage.getQuikAllCount(), "Ошибка Jackson-десериализации (all_count в allCount) json-строки в AllTradesPackage");
        Assertions.assertEquals(18, tradesPackage.getQuikPackageSize(), "Ошибка Jackson-десериализации (package_size в packageSize) json-строки в AllTradesPackage");
        Assertions.assertNotNull(tradesPackage.getObjects(), "Ошибка Jackson-десериализации (rows в rows) json-строки в AllTradesPackage");
        // Assertions.assertEquals(18, tradesPackage.size(), "Ошибка Jackson-десериализации (rows в rows) json-строки в AllTradesPackage - количество записей");
    }

    @Test
    public void TestGenerate() {
        final var cls = OriginalQuikSecurity.class;
        for (var m : cls.getDeclaredFields()) {
            final var fieldNameInMethod = m.getName().substring(0, 1).toUpperCase() + m.getName().substring(1);
            System.out.println(".set" + fieldNameInMethod + "(source.get" + fieldNameInMethod + "())");
        }
    }
}
