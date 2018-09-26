package ru.tusur.udo.Sensors.core;
/**
 * Интерфейс эмулятора, который будет возвращать список всех датчиков в системе
 */
import java.util.List;

public interface SensorRuntime {
	List<Sensor> getSensor();
}
