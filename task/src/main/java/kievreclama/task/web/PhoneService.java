package kievreclama.task.web;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kievreclama.task.dao.impl.PhoneDaoImpl;
import kievreclama.task.entity.Phone;
import kievreclama.task.model.FactoryDao;
import kievreclama.task.model.dao.PhoneDao;
import kievreclama.task.web.models.PhoneModel;

@Service
public class PhoneService {
	
	@Autowired
	private FactoryDao factoryDao;
	
	@Autowired
	private PhoneDaoImpl phoneDao;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Transactional
	public void add(PhoneModel model) {
		PhoneDao phoneDao = factoryDao.createPhoneDao();
		phoneDao.add(modelMapper.map(model, Phone.class));
	}
	
	@Transactional
	public void update(PhoneModel model) {
		PhoneDao phoneDao = factoryDao.createPhoneDao();
		phoneDao.upadte(modelMapper.map(model, Phone.class));
	}

	@Transactional
	public PhoneModel byId(int id) {
		PhoneDao phoneDao = factoryDao.createPhoneDao();
		return modelMapper.map(phoneDao.byId(id), PhoneModel.class);
	}
	
	@Transactional
	public List<PhoneModel> getAll(String namedQery){
		return phoneDao.byList(namedQery).stream()
				.map(phone -> modelMapper.map(phone, PhoneModel.class))
				.collect(Collectors.toList());
	}

}
