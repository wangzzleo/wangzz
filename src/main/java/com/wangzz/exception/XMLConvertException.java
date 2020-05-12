package com.wangzz.exception;

public class XMLConvertException extends Exception {
    public XMLConvertException() {
        super("XML 转换异常!");
    }

    public XMLConvertException(String message) {
        super("XML 转换异常!" + message);
    }
}
