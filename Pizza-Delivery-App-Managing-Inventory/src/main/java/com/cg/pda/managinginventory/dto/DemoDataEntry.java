package com.cg.pda.managinginventory.dto;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.cg.pda.managinginventory.exception.TypeOfPizzaNotAvailableException;
import com.cg.pda.managinginventory.service.InventoryService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class DemoDataEntry {

	@Autowired
	private InventoryService service;
	
	@EventListener //Listens for an event emitted as method parameter
	public void onAppReady(ApplicationReadyEvent event) throws TypeOfPizzaNotAvailableException { //Here, Event Listener is
//		listening on Application Ready Event, which emits an event when 
//		the application is fully loaded and ready to accept service requests
		if (service.findAllPizzas().size() == 0) { //Checking the size of librarian table in database,
//			prevents duplication of values
			try {
//				Gives read and write privileges of JSON/ POJO
				ObjectMapper mapper = new ObjectMapper();
			
//				Reading values from librarians.json file and storing in books array
				Pizza[] pizzas = mapper.readValue(getClass()
						.getClassLoader().getResource
						("pizzas.json"), Pizza[].class);
				
//				Calling repository method for saving librarians in database
				for(Pizza pizza: pizzas) {
					service.addPizza(pizza);
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	
		
	}
}
