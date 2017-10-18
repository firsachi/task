package kievreclama.task.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kievreclama.task.model.FactoryDao;
import kievreclama.task.model.dao.PhoneDao;
import kievreclama.task.web.models.PhoneModel;
import kievreclama.task.web.transformers.PhoneTransformer;

@Service
public class PhoneService {
	
	@Autowired
	private FactoryDao factoryDao;
	
	@Autowired
	private PhoneTransformer phoneTransformer;
	
	@Transactional
	public void add(PhoneModel model) {
		PhoneDao phoneDao = factoryDao.createPhoneDao();
		phoneDao.add(phoneTransformer.modelToEntity(model));
	}

}
