package ru.tusur.udo.Sensors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import junit.framework.TestCase;
import ru.tusur.udo.Sensors.emulator.EmulationStrategy;
import ru.tusur.udo.Sensors.emulator.FakeSensor;
import ru.tusur.udo.Sensors.emulator.AStrategy;

public class AStrategyTest extends TestCase {
	private FakeSensor fakeSensor;
	private EmulationStrategy strategy;

	private static Logger log = LoggerFactory.getLogger(AStrategyTest.class);

	@Override
	public void setUp() {
		this.fakeSensor = new FakeSensor();
		this.strategy = new AStrategy();
		this.fakeSensor.setEmulationStrategy(strategy);
	}

	public void testAStrategy() {
		int MIN = 0;
		int MAX = 3;
		int TICKS_COUNT = 5;
		boolean UP = true; // флаговая переменная направления движения значения датчика: вверх к максимуму
							// или вниз к минимуму
		double DELTA = (MAX - MIN) / TICKS_COUNT;

		this.strategy.setTicksCounter(TICKS_COUNT);
		this.strategy.setMin(MIN);
		this.strategy.setMax(MAX);
		double value = MIN;
		for (int i = 1; i < 10000; i++) {
			this.fakeSensor.emulate();
			if (i % TICKS_COUNT == 0) {
				if (value == MIN) {
					value += DELTA;
					UP = true;
				} else {
					value -= DELTA;
					UP = false;
				}
			} else {
				if (UP == true) {
					value += DELTA;
				} else {
					value -= DELTA;
				}

			}
			assertEquals(this.fakeSensor.getValue(), value);
		}

	}

	public void testAStrategy1() {
		int MIN = 0;
		int MAX = 100;
		int TICKS_COUNT = 10;
		boolean UP = true; // флаговая переменная направления движения значения датчика: вверх к максимуму
							// или вниз к минимуму
		double DELTA = (MAX - MIN) / TICKS_COUNT;

		this.strategy.setTicksCounter(TICKS_COUNT);
		this.strategy.setMin(MIN);
		this.strategy.setMax(MAX);
		double value = 0;
		for (int i = 1; i < 10000; i++) {
			this.fakeSensor.emulate();
			if (i % TICKS_COUNT == 0) {
				if (value == MIN) {
					value += DELTA;
					UP = true;
				} else {
					value -= DELTA;
					UP = false;
				}
			} else {
				if (UP == true) {
					value += DELTA;
				} else {
					value -= DELTA;
				}

			}
			assertEquals(this.fakeSensor.getValue(), value);
		}

	}
}
