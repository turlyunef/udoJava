package ru.tusur.udo.Sensors.emulator;

import java.util.List;

import ru.tusur.udo.Sensors.core.Sensor;
import ru.tusur.udo.Sensors.core.SensorRuntime;

public class EmulationRuntime implements SensorRuntime {
	private List<Sensor> sensors;
	
	public void setSensors(List<Sensor> sensors) {
		this.sensors = sensors;
	}

	public EmulationRuntime() {
		this.sensors = null;
	}

	public List<Sensor> getSensor() {

		return this.sensors;
	}

}
