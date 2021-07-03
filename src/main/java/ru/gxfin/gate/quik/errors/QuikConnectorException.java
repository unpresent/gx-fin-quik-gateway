package ru.gxfin.gate.quik.errors;

import ru.gxfin.gate.quik.api.QuikNamedPipeMessenger;

/**
 * Сигнализирует об ошибках в логие работы QuikConnector-а
 *
 * @author  Vladimir Gagarkin
 * @see     QuikNamedPipeMessenger
 * @since   1.0
 */
public class QuikConnectorException extends Exception {
    // static final long serialVersionUID;

    /**
     * Constructs an {@code QuikConnectorException} with {@code null}
     * as its error detail message.
     */
    public QuikConnectorException() {
        super();
    }

    /**
     * Constructs an {@code QuikConnectorException} with the specified detail message.
     *
     * @param message
     *        The detail message (which is saved for later retrieval
     *        by the {@link #getMessage()} method)
     */
    public QuikConnectorException(String message) {
        super(message);
    }

    /**
     * Constructs an {@code QuikConnectorException} with the specified detail message
     * and cause.
     *
     * <p> Note that the detail message associated with {@code cause} is
     * <i>not</i> automatically incorporated into this exception's detail
     * message.
     *
     * @param message
     *        The detail message (which is saved for later retrieval
     *        by the {@link #getMessage()} method)
     *
     * @param cause
     *        The cause (which is saved for later retrieval by the
     *        {@link #getCause()} method).  (A null value is permitted,
     *        and indicates that the cause is nonexistent or unknown.)
     *
     * @since 1.0
     */
    public QuikConnectorException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs an {@code QuikConnectorException} with the specified cause and a
     * detail message of {@code (cause==null ? null : cause.toString())}
     * (which typically contains the class and detail message of {@code cause}).
     * This constructor is useful for IO exceptions that are little more
     * than wrappers for other throwables.
     *
     * @param cause
     *        The cause (which is saved for later retrieval by the
     *        {@link #getCause()} method).  (A null value is permitted,
     *        and indicates that the cause is nonexistent or unknown.)
     *
     * @since 1.0
     */
    public QuikConnectorException(Throwable cause) {
        super(cause);
    }
}
