package com.mycompany.tecnoparcial.TecnoEmail;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MailService {
    static final int MAX_T = 10;
    ExecutorService pool = Executors.newFixedThreadPool(MAX_T);
    POP pop;
    SMTP smtp;

    public MailService() {
        pop = new POP();
        smtp = new SMTP();
    }

    public int getEmails() throws IOException {
        int e = 0;

        pop.connect();
        pop.logIn();

        pop.getListAmmount();
        e = pop.emails;

        pop.logOut();
        pop.close();

        return e;
    }

    /**
     * Envia un mail y ejecuta una tarea
     * 
     * @param from
     * @param to
     * @throws IOException
     */
    public void sendMail(int from, int to) throws IOException, InterruptedException {
        System.out.println("Mensajes por responder: " + (to - from + 1));

        ExecutorService pool = Executors.newFixedThreadPool(10);
        List<MailTask> emails = new ArrayList<>();

        pop.connect();
        pop.logIn();
        for (int i = to; i <= from; ++i) {

            String mensaje = pop.getMail(Integer.toString(i));
            String emisor = pop.getFrom(mensaje);
            String subject = pop.getSubject(mensaje);

            System.out.println(emisor);
            System.out.println(subject);

            emails.add(new MailTask(emisor, subject));
        }
        pop.logOut();
        pop.close();

        List<Future<MailSender>> pending;
        pending = pool.invokeAll(emails);
        pool.shutdownNow();
        smtp.connect();
        smtp.logIn();
        for (int i = 0; i < pending.size(); ++i) {

            Future<MailSender> future = pending.get(i);
            if (future.isDone()) {
                try {
                    MailSender m = future.get();
                    smtp.sendMail(m.to, m.subject, m.content);
                    smtp.reset();
                } catch (Exception ex) {
                    Logger.getLogger(MailSender.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        smtp.logOut();
        smtp.close();
    }
}
