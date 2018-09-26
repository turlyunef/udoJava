package ru.tusur.udo.Sensors.core;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;

public class SensorRouters extends RouteBuilder{
@Autowired
private JSONProcessor jsonProcessor; //Преобразовывает данные в формат JSON
@Autowired
private SensorRuntimeProcessor sensorRuntimeProcessor; //Преобразовывает данные в формат JSON


	@Override
	/*public void configure() throws Exception {
		from("timer://timer?period=500")
		.process(this.sensorRuntimeProcessor)
		.to("direct:json");
		
		from("direct:json")
		.process(this.jsonProcessor);*/
	public void configure() throws Exception {
		from("timer://timer?period=500").process("Привет из Camel");
		
	}

}
