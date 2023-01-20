package com.example.java.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("SensorEntry")
public class SensorEntry {

	@Id
    private String entryId;

	private String id;
    private float data;
    private Date timestamp;
    private String type;
    
    public SensorEntry(String entryId, String id, float data, Date timestamp, String type) {
    	this.entryId = entryId;
        this.id = id;
        this.data = data;
        this.timestamp = timestamp;
        this.type = type;
    }

	public String getEntryId() {
		return entryId;
	}

	public void setEntryId(String entryId) {
		this.entryId = entryId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public float getData() {
		return data;
	}

	public void setData(float data) {
		this.data = data;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
