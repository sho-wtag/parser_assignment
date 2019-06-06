package com.parser.ef.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@ToString
@Entity
public class LogEntriesBlocked {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String logIp;
    private String logRequest;
    private String logMessage;

    public LogEntriesBlocked(String logIp, String logRequest, String logMessage) {
        this.logIp = logIp;
        this.logRequest = logRequest;
        this.logMessage = logMessage;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogIp() {
        return logIp;
    }

    public void setLogIp(String logIp) {
        this.logIp = logIp;
    }

    public String getLogRequest() {
        return logRequest;
    }

    public void setLogRequest(String logRequest) {
        this.logRequest = logRequest;
    }

    public String getLogMessage() {
        return logMessage;
    }

    public void setLogMessage(String logMessage) {
        this.logMessage = logMessage;
    }
}
