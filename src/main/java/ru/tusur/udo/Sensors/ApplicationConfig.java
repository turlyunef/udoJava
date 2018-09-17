package ru.tusur.udo.Sensors;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ru.tusur.udo.Sensors.core.Sensor;
import ru.tusur.udo.Sensors.core.SensorRuntime;
import ru.tusur.udo.Sensors.emulator.EmulationRuntime;

@Configuration
public class ApplicationConfig {
	private static Logger log = LoggerFactory.getLogger(ApplicationConfig.class);

	@Bean
	public ClassPathXmlApplicationContext xmlContext() {
		log.info("SUPER CREATE xmlContext");
		return new ClassPathXmlApplicationContext("ApplicationConfig.xml");

	}

	@Bean
	SensorRuntime sensorRuntime() {
		EmulationRuntime s = new EmulationRuntime();
		s.setSensors((List<Sensor>) xmlContext().getBean("sensors"));
		log.info("SUPER CREATE sensorRuntime");
		s.start();
		return s;
	}

}
