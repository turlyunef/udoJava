package ru.tusur.udo.Sensors.emulator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author turluynef Стратегия поведения дискретного датчика
 *
 */
public class DStrategy implements EmulationStrategy {
	private int counter;
	private int min;
	private int max;
	private double value;
	private int tick;
	private static Logger log = LoggerFactory.getLogger(DStrategy.class);

	public DStrategy() {
		//log.info("Strategy DStrategy created from bean of ApplicationContext");
		this.value = 0;
		this.tick = 1;

	}

	@Override
	public void doEmulate(SensorSetter sensor) {
		if (this.tick % this.counter == 0) {
			if (this.value == 0) {
				this.value = 1;
			} else
				this.value = 0;
			this.tick = 1;
		} else
			this.tick++;
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
