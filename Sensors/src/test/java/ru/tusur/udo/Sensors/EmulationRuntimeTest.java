package ru.tusur.udo.Sensors;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import ru.tusur.udo.Sensors.core.Sensor;
import ru.tusur.udo.Sensors.emulator.EmulationRuntime;

public class EmulationRuntimeTest extends TestCase {
	private EmulationRuntime sensorRuntime;
	

	@Override
	public void setUp() {
		this.sensorRuntime = new EmulationRuntime();
		this.sensorRuntime.setSensors(new ArrayList<Sensor>());
	}

	public void testEmulationRuntime() {
		assertNotNull(this.sensorRuntime);
		List<Sensor> sensors = this.sensorRuntime.getSensor();
		assertNotNull(sensors);

	}

}
