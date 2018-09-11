package ru.tusur.udo.Sensors.core;
/**
 * 
 * @author u201
 * Интерфейс датчиков для опроса значений датчиков Рантаймом (читает их параметры раз во сколько то секунд)
 */
public interface Sensor {
	int getStatus();

	String getImei();

	double getValue();

	int getType();
}