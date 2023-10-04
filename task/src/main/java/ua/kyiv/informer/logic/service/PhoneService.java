package ua.kyiv.informer.logic.service;

import java.util.List;
import java.util.stream.Collectors;

import jakarta.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import ua.kyiv.informer.logic.entity.Phone;
import ua.kyiv.informer.logic.repository.PhoneRepository;
import ua.kyiv.informer.ui.phone.PhoneModel;


@Service
public class PhoneService {

	private final PhoneRepository phoneDao;

	private final ModelMapper modelMapper;

	public PhoneService(PhoneRepository phoneDao, ModelMapper modelMapper) {
		this.phoneDao = phoneDao;
		this.modelMapper = modelMapper;
	}

	@Transactional
	public void add(PhoneModel model) {
		phoneDao.insert(modelMapper.map(model, Phone.class));
	}
	
	@Transactional
	public void update(PhoneModel model) {
		phoneDao.update(modelMapper.map(model, Phone.class));
	}

	@Transactional
	public PhoneModel byId(int id) {
		return modelMapper.map(phoneDao.byId(id), PhoneModel.class);
	}
	
	@Transactional
	public List<PhoneModel> getAll(String namedQuery){

		return phoneDao.byList(namedQuery).stream().parallel()
				.map(phone -> modelMapper.map(phone, PhoneModel.class))
				.collect(Collectors.toList());
	}

    public boolean checkUniqueNumberPhone(String numberPhone) {
		return  !phoneDao.checkUniqueNumberPhone(numberPhone);
    }
}
