package ru.gxfin.gate.quik.api;

import ru.gxfin.gate.quik.model.original.*;
import ru.gxfin.gate.quik.errors.QuikConnectorException;

import java.io.IOException;

/**
 * Определяет API Quik-а
 * @author Vladimir Gagarkin
 * @since 1.0
 */
public interface QuikGetApi {
    /**
     * Получить пакет обезличенных сделок
     * @param fromRowIndex индекс записи в таблице AllTrades, начиная с которого требуется получить пачку
     * @param packageSizeLimit определяет максимально допустимое количество записей в пакете
     * @return набор DTO AllTrade
     * @throws QuikConnectorException   Ошибка в работе Connector-а.
     * @throws IOException              Ошибки при работе с NamedPipe.
     */
    OriginalQuikAllTradesPackage getAllTradesPackage(long fromRowIndex, int packageSizeLimit) throws QuikConnectorException, IOException;

    /**
     * Получить пакет поручений
     * @param fromRowIndex индекс записи в таблице Orders, начиная с которого требуется получить пачку
     * @param packageSizeLimit определяет максимально допустимое количество записей в пакете
     * @return набор DTO Order
     * @throws QuikConnectorException   Ошибка в работе Connector-а.
     * @throws IOException              Ошибки при работе с NamedPipe.
     */
    OriginalQuikOrdersPackage getOrdersPackage(long fromRowIndex, int packageSizeLimit) throws QuikConnectorException, IOException;

    /**
     * Получить пакет сделок
     * @param fromRowIndex индекс записи в таблице Deals, начиная с которого требуется получить пачку
     * @param packageSizeLimit определяет максимально допустимое количество записей в пакете
     * @return набор DTO Deal
     * @throws QuikConnectorException   Ошибка в работе Connector-а.
     * @throws IOException              Ошибки при работе с NamedPipe.
     */
    OriginalQuikDealsPackage getDealsPackage(long fromRowIndex, int packageSizeLimit) throws QuikConnectorException, IOException;

    /**
     * Получить пакет сделок
     * @param fromRowIndex индекс записи в таблице Securities, начиная с которого требуется получить пачку
     * @param packageSizeLimit определяет максимально допустимое количество записей в пакете
     * @return набор DTO Security
     * @throws QuikConnectorException   Ошибка в работе Connector-а.
     * @throws IOException              Ошибки при работе с NamedPipe.
     */
    OriginalQuikSecuritiesPackage getSecuritiesPackage(long fromRowIndex, int packageSizeLimit) throws QuikConnectorException, IOException;

    /**
     * Получить состяние сессии Quik-а
     * @return DTO SessionState
     * @throws QuikConnectorException   Ошибка в работе Connector-а.
     * @throws IOException              Ошибки при работе с NamedPipe.
     */
    OriginalQuikSessionState getSessionState() throws QuikConnectorException, IOException;
}
