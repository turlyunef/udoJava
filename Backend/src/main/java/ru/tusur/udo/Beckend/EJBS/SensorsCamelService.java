package ru.tusur.udo.Beckend.EJBS;

import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

@Singleton
@Startup
public class SensorsCamelService {
	private static final Logger log = Logger.getLogger(SensorsCamelService.class.toString());
	
	@Inject
	SensorCamelContext sensorCamelContext;
	
	@Inject
	SensorRoutes sensorRoutes;
	
	@PostConstruct
	public void init() {
	
			try {
				this.sensorCamelContext.addRoutes(this.sensorRoutes);
				this.sensorCamelContext.start();
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		log.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++@PostConstruct");
	}
}
