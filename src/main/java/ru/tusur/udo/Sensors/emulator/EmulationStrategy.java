package ru.tusur.udo.Sensors.emulator;

public interface EmulationStrategy {
	void doEmulate(SensorSetter fakeSensor);
	void setTicksCounter(int counter);
	void setMinMax(int min, int max);
}
