package com.mycompany.tecnoparcial.TecnoEmail;

public class MailSender {
    String to;
    String subject;
    String content;

    public MailSender(String to, String subject, String content) {
        this.to = to;
        this.subject = subject;
        this.content = content;
    }
}
