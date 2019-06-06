package com.parser.ef.repository;

import com.parser.ef.model.LogEntries;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogEntriesRepo extends CrudRepository<LogEntries, Integer> {

    @Query(value = "SELECT distinct log_ip, log_request from log_entries where log_ip in (SELECT s.log_ip FROM log_entries as s where s.log_date>=?1 and s.log_date <= date_add(?1, interval 1 day_hour) group by s.log_ip having count(*)>=?2) and log_date>=?1 and log_date <= date_add(?1, interval 1 day_hour)", nativeQuery = true)
    List<Object[]> getHourlyServerLog(String startDate, int threshold);

    @Query(value = "SELECT distinct log_ip, log_request from log_entries where log_ip in (SELECT s.log_ip FROM log_entries as s where s.log_date>=?1 and s.log_date <= date_add(?1, interval 1 day) group by s.log_ip having count(*)>=?2) and log_date>=?1 and log_date <= date_add(?1, interval 1 day)", nativeQuery = true)
    List<Object[]> getDailyServerLog(String startDate, int threshold);
}
