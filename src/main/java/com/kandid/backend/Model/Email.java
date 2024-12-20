package com.kandid.backend.Model;

import lombok.Getter;
import lombok.Setter;

public class Email {

    @Getter @Setter
    private String to;

    @Getter @Setter
    private String subject;

    @Getter @Setter
    private String body;

    public Email() {
        to = "";
        subject = "";
        body = "";
    }

    public Email(String to) {
        this.to = to;
        subject = "Kandid's Early Access: You’re on the VIP List!";
        body = """
                Hey Kandidate,
                
                Welcome to Kandid's Early Access Club! 🎊 You’re officially one of the first to explore curated fashion delivered to your doorstep in just 60 minutes.
                
                Here’s a little treat for being early to the party:
                ✨ FLAT 20% OFF on your first 3 orders once we launch!
                
                Get ready to stay ahead of trends, shop smarter, and experience fashion like never before.
                
                We’ll be in touch as we gear up for the big launch—Lucknow, you’re first!
                
                Stay Trendy,
                Team Kandid
                
                P.S. Keep an eye on your inbox—exciting updates are on the way!
                """;
    }

    public Email(String to, String subject, String body) {
        to=this.to;
        subject=this.subject;
        body=this.body;
    }
}
