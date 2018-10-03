package ru.tusur.udo.Beckend.EJBS;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

@Stateless
public class SensorRoutes extends RouteBuilder {
	@Inject
	@Named("sensorDBProcessor")
	Processor sensorDBProcessor;
	
	@Inject
	@Named("mergeSensorProcessor")
	Processor mergeSensorProcessor;

	@Override
	public void configure() throws Exception {
		from("timer://timer?period=1000")
		.process(this.sensorDBProcessor)
		.to("direct:mergeSensors");
		
		from("direct:mergeSensors")
		.process(this.mergeSensorProcessor);
		
	}

}
