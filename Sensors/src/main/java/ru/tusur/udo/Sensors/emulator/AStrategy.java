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
		//log.info("Strategy AStrategy created from bean of ApplicationContext");
		this.value = 0;
		this.tick = 1;

	}

	@Override
	public void doEmulate(SensorSetter sensor) {
		double DELTA = ((max - min) / counter);
		if (tick % counter == 0) {
			
			if (value == this.min) {
				value += DELTA;
				UP = true;
				this.tick = 1;

			} else {
				value -= DELTA;
				UP = false;
				this.tick++;

			}

		} else {
			this.tick++;
			if (UP == true) {
				value += DELTA;
			} else {
				value -= DELTA;
			}

		}
		sensor.setValue(this.value);
	}

	@Override
	public void setTicksCounter(int counter) {
		this.counter = counter;
	}
	@Override
	public void setMin(int min) {
		this.min = min;
	}
	
	@Override
	public void setMax(int max) {
		this.max = max;
	}

	

}
