package ru.gagarkin.gxfin.gate.quik.api;

import ru.gagarkin.gxfin.gate.quik.data.income.*;
import ru.gagarkin.gxfin.gate.quik.errors.QuikConnectorException;

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
     * @throws QuikConnectorException
     * @throws IOException
     */
    QuikAllTradesPackage getAllTradesPackage(long fromRowIndex, int packageSizeLimit) throws QuikConnectorException, IOException;

    /**
     * Получить пакет поручений
     * @param fromRowIndex индекс записи в таблице Orders, начиная с которого требуется получить пачку
     * @param packageSizeLimit определяет максимально допустимое количество записей в пакете
     * @return набор DTO Order
     * @throws QuikConnectorException
     * @throws IOException
     */
    QuikOrdersPackage getOrdersPackage(long fromRowIndex, int packageSizeLimit) throws QuikConnectorException, IOException;

    /**
     * Получить пакет сделок
     * @param fromRowIndex индекс записи в таблице Deals, начиная с которого требуется получить пачку
     * @param packageSizeLimit определяет максимально допустимое количество записей в пакете
     * @return набор DTO Deal
     * @throws QuikConnectorException
     * @throws IOException
     */
    QuikDealsPackage getDealsPackage(long fromRowIndex, int packageSizeLimit) throws QuikConnectorException, IOException;

    /**
     * Получить пакет сделок
     * @param fromRowIndex индекс записи в таблице Securities, начиная с которого требуется получить пачку
     * @param packageSizeLimit определяет максимально допустимое количество записей в пакете
     * @return набор DTO Security
     * @throws QuikConnectorException
     * @throws IOException
     */
    QuikSecuritiesPackage getSecuritiesPackage(long fromRowIndex, int packageSizeLimit) throws QuikConnectorException, IOException;

    /**
     * Получить состяние сессии Quik-а
     * @return DTO SessionState
     * @throws QuikConnectorException
     * @throws IOException
     */
    QuikSessionState getSessionState() throws QuikConnectorException, IOException;
}
