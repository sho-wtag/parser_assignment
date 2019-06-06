package com.parser.ef.service;

import com.parser.ef.model.LogEntriesBlocked;
import com.parser.ef.parser.FileParser;
import com.parser.ef.repository.LogEntriesBlockedRepo;
import com.parser.ef.repository.LogEntriesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProcessorService {

    @Autowired
    private LogEntriesRepo logEntriesRepo;

    @Value("${accesslog}")
    private String filePath;
    @Value("${startDate}")
    private String startDate;
    @Value("${duration}")
    private String duration;
    @Value("${threshold}")
    private String threshold;

    @Autowired
    FileParser fileParser;

    @Autowired
    LogEntriesBlockedRepo logEntriesBlockedRepo;

    public void processFile() {
        fileParser.processFile(filePath);
    }

    public void queryDb() {
        List<LogEntriesBlocked> logEntriesBlockeds;
        if (duration.equalsIgnoreCase("hourly")) {
            List<Object[]> records = logEntriesRepo.getHourlyServerLog(startDate, Integer.parseInt(threshold));
            logEntriesBlockeds = generateBlockedEntries(records);
        } else {
            List<Object[]> records = logEntriesRepo.getDailyServerLog(startDate, Integer.parseInt(threshold));
            logEntriesBlockeds = generateBlockedEntries(records);
        }
        logEntriesBlockedRepo.saveAll(logEntriesBlockeds);
    }

    private List<LogEntriesBlocked> generateBlockedEntries(List<Object[]> records) {
        List<LogEntriesBlocked> logEntriesBlocked = new ArrayList<>();
        records.forEach(record -> {
            LogEntriesBlocked logEntries = new LogEntriesBlocked(String.valueOf(record[0]),
                    String.valueOf(record[1]), "Threshold(" + threshold + " )for given ip is reached");
            System.out.println(logEntries);
            logEntriesBlocked.add(logEntries);
        });
        return logEntriesBlocked;
    }
}
