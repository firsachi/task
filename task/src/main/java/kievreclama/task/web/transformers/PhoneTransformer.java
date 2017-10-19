package kievreclama.task.web.transformers;

import org.springframework.stereotype.Component;

import kievreclama.task.entity.Phone;
import kievreclama.task.web.models.PhoneModel;

@Component
public class PhoneTransformer implements BaseTransformer<Phone, PhoneModel>{

	@Override
	public Phone modelToEntity(PhoneModel model) {
		Phone phone = new Phone();
		phone.setId(model.getId());
		phone.setNumber(model.getNumber());
		return phone;
	}

	@Override
	public PhoneModel entityToModel(Phone entity) {
		PhoneModel model = new PhoneModel();
		model.setId(entity.getId());
		model.setNumber(entity.getNumber());
		return model;
	}

}
