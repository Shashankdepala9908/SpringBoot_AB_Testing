package com.example.WebAppTestingAB.model;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
public class ClickEvent {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Instant timestamp;
    private String username;
    private String variant;    // "Alpha" or "Beta"
    private String buttonId;
    private String ip;

    // getters/setters
    public Long getId(){return id;}
    public Instant getTimestamp(){return timestamp;}
    public void setTimestamp(Instant t){this.timestamp=t;}
    public String getUsername(){return username;}
    public void setUsername(String u){this.username=u;}
    public String getVariant(){return variant;}
    public void setVariant(String v){this.variant=v;}
    public String getButtonId(){return buttonId;}
    public void setButtonId(String b){this.buttonId=b;}
    public String getIp(){return ip;}
    public void setIp(String i){this.ip=i;}
}
