package ru.tusur.udo.Sensors;

import junit.framework.TestCase;
import ru.tusur.udo.Sensors.core.Sensor;

public class SensorTest extends TestCase {
	class SensorImpl implements Sensor {

		public int getStatus() {
			return 22;
		}

		public String getImei() {
			return "super IMEI";
		}

		public double getValue() {
			return 1.0;
		}

		public int getType() {
			return 2;
		}

	}

	public void testSensor() {
		Sensor s = new SensorImpl();
		assertEquals(s.getImei(), "super IMEI");
		assertEquals(s.getStatus(), 22);
		assertEquals(s.getValue(), 1.0);
		assertEquals(s.getType(), 2);
		assertTrue(true);
	}

}
