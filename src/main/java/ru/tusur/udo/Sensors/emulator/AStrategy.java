package ru.tusur.udo.Sensors.emulator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AStrategy implements EmulationStrategy {
	private int counter;
	private int min;
	private int max;
	private int value;
	private int tick;
	private boolean UP = true;

	private static Logger log = LoggerFactory.getLogger(AStrategy.class);

	public AStrategy() {
		this.value = 0;
		this.tick = 1;

	}

	@Override
	public void doEmulate(SensorSetter fakeSensor) {
		double DELTA = ((max - min) / counter);
		if (tick % counter == 0) {
			this.tick = 1;
			if (value == this.min) {
				value += DELTA;
				UP = true;

			} else {
				value -= DELTA;
				UP = false;

			}

		} else {
			this.tick++;
			if (UP == true) {
				value += DELTA;
			} else {
				value -= DELTA;
			}

		}

	}

	@Override
	public void setTicksCounter(int counter) {
		this.counter = counter;
	}

	@Override
	public void setMinMax(int min, int max) {
		this.max = max;
		this.min = min;
	}

}
