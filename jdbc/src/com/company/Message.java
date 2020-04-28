package com.company;

import java.util.Date;
import java.util.Objects;

public class Message {
    int idMessage;
    int idFrom;
    int idTo;
    String subject;
    String body;
    Date date;

    @Override
    public String toString() {
        return "Message{" +
                "idMessage=" + idMessage +
                ", idFrom=" + idFrom +
                ", idTo=" + idTo +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                ", date=" + date +
                '}';
    }

    public Message(int idMessage, int idFrom, int idTo, String subject, String body, Date date) {
        this.idMessage = idMessage;
        this.idFrom = idFrom;
        this.idTo = idTo;
        this.subject = subject;
        this.body = body;
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return idMessage == message.idMessage &&
                idFrom == message.idFrom &&
                idTo == message.idTo &&
                Objects.equals(subject, message.subject) &&
                Objects.equals(body, message.body) &&
                Objects.equals(date, message.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMessage, idFrom, idTo, subject, body, date);
    }

    public int getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(int idMessage) {
        this.idMessage = idMessage;
    }

    public int getIdFrom() {
        return idFrom;
    }

    public void setIdFrom(int idFrom) {
        this.idFrom = idFrom;
    }

    public int getIdTo() {
        return idTo;
    }

    public void setIdTo(int idTo) {
        this.idTo = idTo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
