package ru.tusur.udo.Sensors.emulator;

public interface EmulationStrategy {
	void doEmulate(SensorSetter fakeSensor);
	void setTicksCounter(int counter);
	void setMin(int min);
	void setMax(int max);
}
