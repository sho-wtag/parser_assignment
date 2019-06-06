package com.parser.ef.repository;

import com.parser.ef.model.LogEntriesBlocked;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogEntriesBlockedRepo extends CrudRepository<LogEntriesBlocked, Integer> {


}
