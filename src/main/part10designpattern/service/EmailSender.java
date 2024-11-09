package main.part10designpattern.service;
//전략을 실시간으로 교체함
import main.part10designpattern.model.UserB;

public class EmailSender {
    private EmailProvider emailProvider;

    public EmailSender setEmailProvider(EmailProvider emailProvider) {
        this.emailProvider = emailProvider;
        return this;
    }

    public void sendEmail(UserB userb){
        String email = emailProvider.getEmail(userb);
        System.out.println("Sending email: " + email);
    }
}
