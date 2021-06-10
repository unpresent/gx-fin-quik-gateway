package connector;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.gagarkin.gxfin.gate.quik.connector.QuikConnector;
import ru.gagarkin.gxfin.gate.quik.errors.QuikConnectorException;
import ru.gagarkin.gxfin.gate.quik.dto.AllTradesPackage;
import ru.gagarkin.gxfin.gate.quik.dto.SessionState;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestConnector {
    private QuikConnector connector;

    @Test
    public void TestConnectorRun() throws IOException, QuikConnectorException, InterruptedException {
        final int packageSizeLimit = 20;
        final int bufferSize = 32 * 1024;
        final String pipeName = "TestQuik01";

        Logger.getGlobal().setLevel(Level.ALL);

        this.connector = new QuikConnector(pipeName, bufferSize);
        Assertions.assertEquals(true, this.connector.tryConnect(), "Не удалось установить соединение с Quik-Pipe-ом");
        try {
            int limmitLoadCount = 1000;
            SessionState sessionState = this.connector.getSessionState();
            System.out.println(sessionState);
            Assertions.assertEquals(true, sessionState.isConnected, "Не удалось установить соединение с Quik-Pipe-ом");

            int i = 0;
            for (; i < limmitLoadCount;) {
                AllTradesPackage allTradesPackage = this.connector.getAllTradesPackage(i, packageSizeLimit);
                limmitLoadCount = allTradesPackage.allCount < limmitLoadCount ? (int)allTradesPackage.allCount : limmitLoadCount;
                i += allTradesPackage.packageSize;
                System.out.println("Loaded: " + i);
            }
            Assertions.assertEquals( true, i >= limmitLoadCount, "Количество загруженных анонимных сделок меньше нормы");

        } finally {
            this.connector.disconnect();
        }
    }
}
