package ru.tusur.udo.Beckend.EJBS;

import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Named;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

@Stateless
@Named("mergeSensorProcessor")
public class MergeSensorProcessor implements Processor{
	
	private static final Logger log = Logger.getLogger(MergeSensorProcessor.class.toString());
	@Override
	public void process(Exchange msg) throws Exception {
		msg.getOut().setBody(msg.getIn().getBody()); //Замкнули вход msg.getIn().getBody() на выход msg.getOut().setBody в процессе
		log.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++MERGE SENSORS");
		
	}

}
