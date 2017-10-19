package kievreclama.task.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kievreclama.task.model.FactoryDao;
import kievreclama.task.web.transformers.RoomTransformer;

@Service
public class ServiceRoom {

	@Autowired
	private FactoryDao factoryDao;
	
	@Autowired
	private RoomTransformer roomTransformer;
	
}
