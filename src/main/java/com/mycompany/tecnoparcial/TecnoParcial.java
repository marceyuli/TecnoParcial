/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tecnoparcial;

import java.io.IOException;

import com.mycompany.tecnoparcial.TecnoEmail.MailService;

/**
 *
 * @author USER
 */
public class TecnoParcial {

    public static void main(String[] args) throws IOException, InterruptedException {

        MailService mails = new MailService();
        int emails = mails.getEmails();
        while (true) {
            int emails_query = mails.getEmails();

            if (emails_query > emails) {
                mails.sendMail(emails + 1, emails_query);
                emails = emails_query;
            }

            System.out.println("Esperando a leer nuevos emails...");
            Thread.sleep(10000);

        }

    }
}
