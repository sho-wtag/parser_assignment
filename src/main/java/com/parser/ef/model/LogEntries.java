package com.parser.ef.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;


@ToString
@Entity
public class LogEntries {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Date logDate;
    private String logIp;
    private String logRequest;
    private int logStatus;
    private String logUserAgent;

    public LogEntries(Date logDate, String logIp, String logRequest, int logStatus, String logUserAgent) {
        this.logDate = logDate;
        this.logIp = logIp;
        this.logRequest = logRequest;
        this.logStatus = logStatus;
        this.logUserAgent = logUserAgent;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getLogDate() {
        return logDate;
    }

    public void setLogDate(Date logDate) {
        this.logDate = logDate;
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

    public int getLogStatus() {
        return logStatus;
    }

    public void setLogStatus(int logStatus) {
        this.logStatus = logStatus;
    }

    public String getLogUserAgent() {
        return logUserAgent;
    }

    public void setLogUserAgent(String logUserAgent) {
        this.logUserAgent = logUserAgent;
    }
}
