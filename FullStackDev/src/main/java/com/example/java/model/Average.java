package com.example.java.model;

import org.springframework.data.annotation.Id;

public class Average {
	@Id
    private String type;

	private float avgData;
	
	public Average(String type, float avgData) {
		this.type=type;
		this.setAvgData(avgData);
	}

	public float getAvgData() {
		return avgData;
	}

	public void setAvgData(float avgData) {
		this.avgData = avgData;
	}
}
