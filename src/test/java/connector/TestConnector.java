package connector;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Assertions;
import ru.gxfin.gate.quik.connector.QuikConnector;
import ru.gxfin.gate.quik.errors.QuikConnectorException;
import ru.gxfin.gate.quik.model.original.OriginalQuikAllTradesPackage;
import ru.gxfin.gate.quik.model.original.OriginalQuikSessionState;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestConnector {
    private QuikConnector connector;

    // @Test
    @SuppressWarnings("unused")
    public void TestConnectorRun() throws IOException, QuikConnectorException {
        final int packageSizeLimit = 20;
        final int bufferSize = 32 * 1024;
        final String pipeName = "TestQuik01";

        final var objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

        Logger.getGlobal().setLevel(Level.ALL);

        this.connector = new QuikConnector(objectMapper, pipeName, bufferSize);
        Assertions.assertTrue(this.connector.tryConnect(), "Не удалось установить соединение с Quik-Pipe-ом");
        try {
            int limmitLoadCount = 1000;
            OriginalQuikSessionState sessionState = this.connector.getSessionState();
            System.out.println(sessionState);
            Assertions.assertTrue(sessionState.isConnected(), "Не удалось установить соединение с Quik-Pipe-ом");

            int i = 0;
            while (i < limmitLoadCount) {
                OriginalQuikAllTradesPackage allTradesPackage = this.connector.getAllTradesPackage(i, packageSizeLimit);
                limmitLoadCount = allTradesPackage.getQuikAllCount() < limmitLoadCount ? (int)allTradesPackage.getQuikAllCount() : limmitLoadCount;
                i += allTradesPackage.getQuikPackageSize();
                System.out.println("Loaded: " + i);
            }
        } finally {
            this.connector.disconnect();
        }
    }
}
