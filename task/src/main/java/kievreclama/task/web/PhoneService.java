package kievreclama.task.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kievreclama.task.dao.impl.PhoneDaoImpl;
import kievreclama.task.web.models.PhoneModel;
import kievreclama.task.web.transformers.PhoneTransformer;

@Service
public class PhoneService {
	
	@Autowired
	private PhoneDaoImpl phoneDao;
	
	@Autowired
	private PhoneTransformer phoneTransformer;
	
	@Transactional
	public void add(PhoneModel model) {
		phoneDao.insert(phoneTransformer.modelToEntity(model));
	}
	
	@Transactional
	public void update(PhoneModel model) {
		phoneDao.update(phoneTransformer.modelToEntity(model));
	}

	@Transactional
	public PhoneModel byId(int id) {
		return phoneTransformer.entityToModel(phoneDao.byId(id));
	}

}
