package ru.tusur.udo.Sensors.emulator;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.beans.factory.annotation.Value;

import ru.tusur.udo.Sensors.App;
import ru.tusur.udo.Sensors.core.Sensor;
import ru.tusur.udo.Sensors.core.SensorRuntime;

//@EnableScheduling
public class EmulationRuntime extends Thread implements SensorRuntime {
	private int counter = 0;
	private static Logger log = LoggerFactory.getLogger(App.class);
	private List<Sensor> sensors;
	
	@Value("${runtime.interval}")
	private int runtimeInterval;
	
	public void setSensors(List<Sensor> sensors) {
		this.sensors = sensors;
	}

	public EmulationRuntime() {
		this.sensors = null;
	}

	public List<Sensor> getSensor() {

		return this.sensors;
	}
	//@Scheduled
	public void run() {
		while(true) {
			this.emulate();
			try {
				sleep(runtimeInterval);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void emulate() {
		this.sensors
		.stream()
		.forEach(sensor -> {
			if (sensor instanceof FakeSensor) {
				FakeSensor s = (FakeSensor) sensor;
				s.emulate();
				log.info(s.getImei()+"="+s.getValue()+" runtimeInterval= "+runtimeInterval);
			}
		});
	}

}
