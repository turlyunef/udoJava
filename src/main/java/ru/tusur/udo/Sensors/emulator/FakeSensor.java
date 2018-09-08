package ru.tusur.udo.Sensors.emulator;

import ru.tusur.udo.Sensors.core.Sensor;

public class FakeSensor implements Sensor {
	private int status;
	private String imei;
	private int value;
	private int type;
	
	private EmulationStrategy emulationStrategy;
	
	
	
	
	public void setEmulationStrategy(EmulationStrategy emulationStrategy) {
		this.emulationStrategy = emulationStrategy;
	}

	public int getStatus() {
		return this.status;
	}

	public String getImei() {
		return this.imei;
	}

	public int getValue() {
		return this.value;
	}

	public int getType() {
		return this.type;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public void setType(int type) {
		this.type = type;
	}
	
	
	
}
