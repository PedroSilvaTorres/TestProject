package com.example.java.service;

import java.util.List;

import com.example.java.model.SensorEntry;

public interface SensorEntryService {

	List<SensorEntry> findAll();
	
	SensorEntry findBySensorEntryId(String SensorEntryId);
	
	List<SensorEntry> findByType(String type);
	
	SensorEntry saveOrUpdateSensorEntry(SensorEntry SensorEntry);
	
	void deleteSensorEntryByEntryId(String entryId);
	
	float average(String type);
}
