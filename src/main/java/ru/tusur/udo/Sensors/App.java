package ru.tusur.udo.Sensors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ru.tusur.udo.Sensors.emulator.EmulationStrategy;

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
		EmulationStrategy s = (EmulationStrategy) ctx.getBean("dstrategy");
		
		
	}
}
