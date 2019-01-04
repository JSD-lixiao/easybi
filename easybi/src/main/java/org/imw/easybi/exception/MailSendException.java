package org.imw.easybi.exception;
/*
* 邮件发送失败抛出异常
* */
public class MailSendException extends RuntimeException{

    public MailSendException() {
    }
    public MailSendException(String message) {
        super(message);
    }
}
