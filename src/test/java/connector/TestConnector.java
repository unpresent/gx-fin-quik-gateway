package connector;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;
import ru.gxfin.gate.quik.connector.QuikConnector;
import ru.gxfin.gate.quik.errors.QuikConnectorException;
import ru.gxfin.gate.quik.model.income.QuikAllTradesPackage;
import ru.gxfin.gate.quik.model.income.QuikSessionState;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestConnector {
    private QuikConnector connector;

    // @Test
    public void TestConnectorRun() throws IOException, QuikConnectorException, InterruptedException {
        final int packageSizeLimit = 20;
        final int bufferSize = 32 * 1024;
        final String pipeName = "TestQuik01";

        Logger.getGlobal().setLevel(Level.ALL);

        this.connector = new QuikConnector(pipeName, bufferSize);
        Assertions.assertEquals(true, this.connector.tryConnect(), "Не удалось установить соединение с Quik-Pipe-ом");
        try {
            int limmitLoadCount = 1000;
            QuikSessionState sessionState = this.connector.getSessionState();
            System.out.println(sessionState);
            Assertions.assertEquals(true, sessionState.isConnected(), "Не удалось установить соединение с Quik-Pipe-ом");

            int i = 0;
            for (; i < limmitLoadCount;) {
                QuikAllTradesPackage allTradesPackage = this.connector.getAllTradesPackage(i, packageSizeLimit);
                limmitLoadCount = allTradesPackage.getQuikAllCount() < limmitLoadCount ? (int)allTradesPackage.getQuikAllCount() : limmitLoadCount;
                i += allTradesPackage.getQuikPackageSize();
                System.out.println("Loaded: " + i);
            }
            Assertions.assertEquals( true, i >= limmitLoadCount, "Количество загруженных анонимных сделок меньше нормы");

        } finally {
            this.connector.disconnect();
        }
    }
}
