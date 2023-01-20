package com.example.java.controller;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.java.model.SensorEntry;
import com.example.java.service.SensorEntryService;

@RestController
@RequestMapping("/sensors")
public class SensorRestController {
	
	@Autowired
	private SensorEntryService sensorEntryService;
	
	@GetMapping(value="/")
	public List<SensorEntry> getAllSensors(){
		return sensorEntryService.findAll();
	}
	
	@GetMapping(value="/byEntryId/{entryId}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public SensorEntry getSensorByEntryId(@PathVariable("entryId") String entryId) {
		return sensorEntryService.findBySensorEntryId(entryId);
	}
	
	@GetMapping(value="/byType/{type}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public List<SensorEntry> getSensorByType(@PathVariable("type") String type){
		return sensorEntryService.findByType(type);
	}
	
	@PostMapping(value="/save")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public ResponseEntity<?> saveOrUpdateSensor(@RequestBody SensorEntry sensor){
		sensorEntryService.saveOrUpdateSensorEntry(sensor);
		return new ResponseEntity<Object>("Sensor added succesfully", HttpStatus.OK);
	}
	
	@GetMapping(value="/average/{type}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public float getSensorAverage(@PathVariable("type") String type){
		return sensorEntryService.average(type);
	}
	
	@GetMapping(value="/deleteEntry/{entryId}")
	@PreAuthorize("hasRole('ADMIN')")
	public void deleteSensorByEntryId(@PathVariable("entryId") String entryId) {
		sensorEntryService.deleteSensorEntryByEntryId(entryId);
	}
	
	@GetMapping("/testDataSet")
	private void createSensorEntry() {
		int entryId = 0;
		String[] type = {"Temp", "Lux"};
		for(Random r = new Random(); entryId<=50; entryId++) {
			sensorEntryService.saveOrUpdateSensorEntry(new SensorEntry(Integer.toString(entryId), Integer.toString(Math.round(r.nextFloat()*5)),
					30 + r.nextFloat()*(50-30), new Date(), type[r.nextInt(type.length)]));
		}		
	}
}
