package ua.kyiv.informer.logic.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import ua.kyiv.informer.old.model.DepartmentModel;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kyiv.informer.logic.entity.Company;
import ua.kyiv.informer.logic.repository.CompanyDaoImpl;
import ua.kyiv.informer.ui.company.CompanyModel;

@Service("companyService")
public class CompanyService {

	private final CompanyDaoImpl companyDao;

	private final ModelMapper modelMapper;

	@Autowired
	public CompanyService(CompanyDaoImpl companyDao, ModelMapper modelMapper) {
		this.companyDao = companyDao;
		this.modelMapper = modelMapper;
	}

	@Transactional
	public void save(CompanyModel value) {
		companyDao.add(modelMapper.map(value, Company.class));
	}

	@Transactional
	public void update(CompanyModel value) {
		companyDao.update(modelMapper.map(value, Company.class));
	}

	public List<CompanyModel> all(String namedQuery) {
		return companyDao.byList(namedQuery).stream().parallel()
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

	public boolean findQnique(CompanyModel model) {
		return !companyDao.existsByCompanyName(model.getId(), model.getNameCompany());
	}
	
	@Transactional
	public void delete(CompanyModel companyModel) {
		companyDao.delete(companyDao.byId(companyModel.getId()));
	}

	public Set<CompanyModel> all(boolean disable) {
		return companyDao.byList(disable)
				.stream().map(company -> modelMapper.map(company, CompanyModel.class))
				.collect(Collectors.toSet());
	}

	@Transactional
	public Set<DepartmentModel> getCompanyDepartments(int companyId) {
		return companyDao.byId(companyId).getDepartments()
                .stream().map(department -> modelMapper.map(department, DepartmentModel.class)).collect(Collectors.toSet());
	}

}
