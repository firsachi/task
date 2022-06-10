package informer.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import informer.db.CompanyDaoImpl;
import informer.db.entity.Company;
import informer.model.CompanyModel;


@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyDaoImpl companyDao;
	
	@Autowired
	private ModelMapper modelMapper;

	public void save(CompanyModel value) {
		companyDao.add(modelMapper.map(value, Company.class));
	}

	public void update(CompanyModel value) {
		companyDao.update(modelMapper.map(value, Company.class));
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

	@Override
	public boolean findQnique(CompanyModel model) {
		return companyDao.existsByCompanyName(model.getId(), model.getNameCompany());
	}
	
	@Transactional
	@Override
	public void delete(CompanyModel companyModel) {
		companyDao.delete(companyDao.byId(companyModel.getId()));
	}

	@Override
	public Set<CompanyModel> all(boolean disable) {
		return companyDao.byList(disable)
				.stream().map(company -> modelMapper.map(company, CompanyModel.class))
				.collect(Collectors.toSet());
	}

}
