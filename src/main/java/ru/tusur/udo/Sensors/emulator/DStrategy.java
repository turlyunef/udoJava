package ru.tusur.udo.Sensors.emulator;

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
	
	public DStrategy() {
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
	public void setMinMax(int min, int max) {
		this.max = max;
		this.min = min;
	}

}