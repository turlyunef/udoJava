package ru.tusur.udo.Sensors.core;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component

public class SensorRuntimeProcessor implements Processor{
	private static Logger log = LoggerFactory.getLogger(SensorRuntimeProcessor.class);

	@Override
	public void process(Exchange exchange) throws Exception {
		// TODO Auto-generated method stub
		log.info("ПРОЦЕСС SensorRuntimeProcessor");
	}

}
