package com.example.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.java.model.Average;
import com.example.java.model.SensorEntry;
import com.example.java.repository.SensorEntryRepository;

@Service
public class SensorEntryServiceImpl implements SensorEntryService{

	@Autowired
	private SensorEntryRepository sensorEntryRepository;
	
	@Override
	public List<SensorEntry> findAll() {
		return sensorEntryRepository.findAll();
	}

	@Override
	public SensorEntry findBySensorEntryId(String SensorEntryEntryId) {
		return sensorEntryRepository.findBySensorEntryId(SensorEntryEntryId);
	}

	@Override
	public List<SensorEntry> findByType(String type) {
		return sensorEntryRepository.findBySensorType(type);
	}

	@Override
	public SensorEntry saveOrUpdateSensorEntry(SensorEntry SensorEntry) {
		return sensorEntryRepository.save(SensorEntry);
	}

	@Override
	public void deleteSensorEntryByEntryId(String entryId) {
		sensorEntryRepository.deleteById(entryId);		
	}

	@Override
	public float average(String type) {
		return sensorEntryRepository.averageBySensorType(type).getAvgData();
	}
}
