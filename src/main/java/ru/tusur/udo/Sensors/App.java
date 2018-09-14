package ru.tusur.udo.Sensors;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ru.tusur.udo.Sensors.core.Sensor;
import ru.tusur.udo.Sensors.core.SensorRuntime;

/**
 * 
 *
 */

public class App {

	private static Logger log = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		log.info("Start programm");
		ApplicationContext ctx = 
				new ClassPathXmlApplicationContext("ApplicationConfig.xml");
		
		SensorRuntime emul = (SensorRuntime) ctx.getBean("sensorRuntime");
		List<Sensor> sensorList = emul.getSensor();
		
		for (Sensor sensor : sensorList) {
			log.info(sensor.getImei());
					
		}
	
		
		
		
		
	}
}
