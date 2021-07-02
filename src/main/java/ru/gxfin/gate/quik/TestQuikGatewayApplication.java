package ru.gxfin.gate.quik;

import lombok.extern.slf4j.Slf4j;
import ru.gxfin.gate.quik.connector.QuikConnector;
import ru.gxfin.gate.quik.data.internal.*;
import ru.gxfin.gate.quik.data.internal.Security;

@Slf4j
// @SpringBootApplication
public class TestQuikGatewayApplication {
    private static QuikConnector connector;

    public static void main(String[] args) {
        Class cls = Security.class;
        for (var field : cls.getFields()) {
            System.out.println("    this." + field.getName() + " = sourceDataObject." + field.getName() + ";");
        }
    }
    /*
    public static void main(String[] args) throws Exception {
        final int packageSizeLimit = 50;
        final int bufferSize = 32 * 1024;
        final String pipeName = "C-QUIK_VTB-";

        log.debug("HELLO WORLD!");
        connector = new QuikConnector(pipeName, bufferSize);
        if (!connector.tryConnect()) {
            log.error("Не удалось установить соединение с Quik-Pipe-ом");
            throw new Exception("Не удалось установить соединение с Quik-Pipe-ом");
        }
        try {
            int limmitLoadCount = 100000;
            int i = 0;
            LocalDateTime started = LocalDateTime.now();
            /*
            for (; i < limmitLoadCount; ) {
                AllTradesPackage allTradesPackage = connector.getAllTradesPackage(i, packageSizeLimit);
                limmitLoadCount = allTradesPackage.allCount < limmitLoadCount ? (int)allTradesPackage.allCount : limmitLoadCount;
                i += allTradesPackage.packageSize;
                log.info("Loaded = {}", i);

                SessionState sessionState = connector.getSessionState();
                log.info("isConnected == {}, version == {}", sessionState.isConnected, sessionState.version);
                // System.out.println("Loaded: " + i);
            }
            if (i < limmitLoadCount) {
                throw new Exception("Количество загруженных анонимных сделок меньше нормы");
            }
            ;

            System.out.println("Время выполнения: " + ChronoUnit.SECONDS.between(started, LocalDateTime.now()) + " с.");
        } finally {
            connector.disconnect();
        }
    }
    //*/
}
