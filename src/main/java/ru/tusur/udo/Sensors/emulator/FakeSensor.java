package ru.tusur.udo.Sensors.emulator;

import ru.tusur.udo.Sensors.core.Sensor;

public class FakeSensor implements Sensor,SensorSetter {
	private int status;
	private String imei;
	private double value;
	private int type;
	
	private EmulationStrategy emulationStrategy;
	
	public void setEmulationStrategy(EmulationStrategy emulationStrategy) {
		this.emulationStrategy = emulationStrategy;
	}
	@Override
	public int getStatus() {
		return this.status;
	}
	@Override
	public String getImei() {
		return this.imei;
	}
	@Override
	public double getValue() {
		return this.value;
	}
	@Override
	public int getType() {
		return this.type;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}
	@Override
	public void setValue(double value) {
		this.value = value;
	}
	
	public void setType(int type) {
		this.type = type;
	}
	
	public void emulate() {
		this.emulationStrategy.doEmulate(this);
	}

	
	
	
}
