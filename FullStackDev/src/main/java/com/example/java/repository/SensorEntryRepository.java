package com.example.java.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.java.model.SensorEntry;

public interface SensorEntryRepository extends MongoRepository<SensorEntry, String>{

	@Query(value="{type:'?0'}")
	List<SensorEntry> findBySensorType(String type);
	
	@Query(value="{entryId:'?0'}")
	SensorEntry findBySensorEntryId(String id);
	
	public long count();
}
