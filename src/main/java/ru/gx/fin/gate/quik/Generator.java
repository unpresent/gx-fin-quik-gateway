package ru.gx.fin.gate.quik;

import ru.gx.data.AbstractDataObject;
import ru.gx.fin.gate.quik.model.internal.QuikAllTrade;

public class Generator {
    public static void main(String[] args) {
        System.out.println(generateSqlJsonToRecordset(QuikAllTrade.class));
    }

    public static String generateSqlJsonToRecordset(Class<? extends AbstractDataObject> dataObjectClass) {
        var result = "";
        for (var fi : dataObjectClass.getDeclaredFields()) {
            result = result + fi.getName();
        }
        return result;
    }
 }
