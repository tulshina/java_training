package ru.stqa.mantis.model;

/**
 * Created by User on 16.04.2017.
 */
public class MailMessage {
    public String to;
    public String text;

    public MailMessage(String to, String text) {
        this.to = to;
        this.text = text;
    }
}
