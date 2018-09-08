package ru.tusur.udo.Sensors.core;

public interface Sensor {
	int getStatus();

	String getImei();

	int getValue();

	int getType();
}