package ru.tusur.udo.Sensors.core;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class SensorRouters extends RouteBuilder {
	@Autowired
	private JSONProcessor jsonProcessor; // Преобразовывает данные в формат JSON
	@Autowired
	private SensorRuntimeProcessor sensorRuntimeProcessor;
	
	@Value("${sensor.polling.interval}")
	private String sensorPollingInterval;

	@Override
	public void configure() throws Exception {
		from("timer://timer?period="+this.sensorPollingInterval)
		.process(this.sensorRuntimeProcessor)
		.to("direct:json");

		from("direct:json")
		.process(this.jsonProcessor)
		.to("direct:testJSON");

		from("direct:testJSON")
		.process(new Processor() {

			@Override
			public void process(Exchange exchange) throws Exception {
				log.info(exchange.getIn().getBody().toString());
			}
		});

	}

	private void process(Processor processor) {
		// TODO Auto-generated method stub

	}

}
