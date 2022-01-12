package informer.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.internal.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import informer.entity.Company;
import informer.model.CompanyModel;
import informer.repository.CompanyDaoImpl;


@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyDaoImpl companyDao;
	
	@Autowired
	private ModelMapper modelMapper;

	@Transactional
	public void save(CompanyModel value) {
		companyDao.add(modelMapper.map(value, Company.class));
	}

	@Transactional
	public void update(CompanyModel value) {
		companyDao.update(modelMapper.map(value, Company.class));
	}

	@Override
	public boolean fieldValueExists(Object value, String fieldName) throws UnsupportedOperationException {
		Assert.notNull(fieldName);
		if (!fieldName.equals("nameCompany")) {
            throw new UnsupportedOperationException("Field name not supported");
        }

        if (value == null) {
            return false;
        }
        
        try {
        	String nameCompany = (String) value;
        	if (this.companyDao.existsByCompanyName(nameCompany)) {
            	return false;
            } else {
				return true;
			}
        	
        } catch (NumberFormatException e) {
        	return false;
		}
	}

	public List<CompanyModel> all(String namedQery) {
		return companyDao.byList(namedQery).stream().parallel()
				.map(entity -> modelMapper.map(entity, CompanyModel.class))
				.collect(Collectors.toList());
	}

	public CompanyModel byId(int id) {
		return modelMapper.map(companyDao.byId(id), CompanyModel.class);
	}

	@Transactional
	public boolean delete(int id) {
		if (companyDao.byId(id).getEmployees().isEmpty()) {
			companyDao.delete(companyDao.byId(id));
			return true;
		} else {
			return false;
		}
	}

}
