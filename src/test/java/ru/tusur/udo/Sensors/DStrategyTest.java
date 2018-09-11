package ru.tusur.udo.Sensors;

import junit.framework.TestCase;
import ru.tusur.udo.Sensors.emulator.DStrategy;
import ru.tusur.udo.Sensors.emulator.EmulationStrategy;
import ru.tusur.udo.Sensors.emulator.FakeSensor;

public class DStrategyTest extends TestCase {

	private FakeSensor sensor;
	private EmulationStrategy strategy;

	@Override
	public void setUp() {
		this.sensor = new FakeSensor();
		this.strategy = new DStrategy();
		this.sensor.setEmulationStrategy(this.strategy);
	}

	public void testDStrategy() {
		int TICKS_COUNT = 5;
		this.strategy.setTicksCounter(TICKS_COUNT);
		double value = 0;
		for (int i = 1; i < 1000; i++) {
			this.sensor.emulate();
			if (i % TICKS_COUNT == 0) {
				if (value == 1) {
					value = 0;
				} else {
					value = 1.0;
				}
			}
			assertEquals(this.sensor.getValue(), value);

		}
	}

}
