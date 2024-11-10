package com.luandias.entrylog_springboot_mongodb_javafx.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.luandias.entrylog_springboot_mongodb_javafx.domain.Assistant;

@Repository
public interface AssistantRepository extends MongoRepository<Assistant, String> {

}
