package com.parser.ef.parser;

import com.parser.ef.model.LogEntries;
import com.parser.ef.repository.LogEntriesRepo;
import com.parser.ef.service.utils.DateParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class FileParser {

    @Autowired
    LogEntriesRepo logEntriesRepo;

    public void processFile(String fileName) {
        List<LogEntries> logEntries = readFile(fileName);
        persistFileRecords(logEntries);

    }

    private List<LogEntries> readFile(String fileName) {
        List<LogEntries> logEntries = new ArrayList<>();
        Path csvFilePath = Paths.get(fileName);

        try (BufferedReader br = Files.newBufferedReader(csvFilePath,
                StandardCharsets.US_ASCII)) {

            String line = br.readLine();

            while (line != null) {
                String[] attributes = line.split("\\|");
                LogEntries logEntry = generateAccessLog(attributes);
                logEntries.add(logEntry);
                line = br.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return logEntries;
    }

    private void persistFileRecords(List<LogEntries> logEntries) {

        logEntriesRepo.saveAll(logEntries);
    }

    private LogEntries generateAccessLog(String[] metaData) {
        Date date = DateParser.StringToDate(metaData[0]);
        String ip = metaData[1];
        String requestType = metaData[2];
        int response = Integer.parseInt(metaData[3]);
        String version = metaData[4];
        return new LogEntries(date, ip, requestType, response, version);
    }
}
