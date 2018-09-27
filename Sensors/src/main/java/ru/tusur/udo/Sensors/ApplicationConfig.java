package ru.tusur.udo.Sensors;

import java.util.List;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ru.tusur.udo.Sensors.core.Sensor;
import ru.tusur.udo.Sensors.core.SensorRouters;
import ru.tusur.udo.Sensors.core.SensorRuntime;
import ru.tusur.udo.Sensors.emulator.EmulationRuntime;

@Configuration
@ComponentScan(basePackages = {"ru.tusur.udo.sensors.core"})
public class ApplicationConfig {
	private static Logger log = LoggerFactory.getLogger(ApplicationConfig.class);
/**
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
	}*/
	@Bean
	SensorRouters sensorRoutes() {
		return new SensorRouters();
	}
	
	
	@Bean
	CamelContext camelContext() throws Exception {
		CamelContext ctx = new DefaultCamelContext();
		ctx.addRoutes(sensorRoutes());
		ctx.start();
		return ctx;
	}
}
