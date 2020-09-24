package com.xingtuai.cloud.common.exception;

/**
 * 统一异常
 *
 * @author James
 * @date 2020/9/24
 */
public class CloudException extends RuntimeException {

    private static final long serialVersionUID = 6721058273140441505L;

    public CloudException() {
        super();
    }

    public CloudException(String message) {
        super(message);
    }

    public CloudException(String message, Throwable cause) {
        super(message, cause);
    }

    public CloudException(Throwable cause) {
        super(cause);
    }

}
