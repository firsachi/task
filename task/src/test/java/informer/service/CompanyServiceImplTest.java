package informer.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import ua.kyiv.informer.logic.entity.Company;
import ua.kyiv.informer.logic.repository.CompanyDaoImpl;
import ua.kyiv.informer.logic.service.CompanyService;
import ua.kyiv.informer.logic.service.CompanyService;

class CompanyServiceImplTest {
	
	@Mock
	private CompanyDaoImpl companyDao;
	
	@Mock
	private ModelMapper modelMapper;
	
	//@InjectMocks
	//CompanyService companyService = new CompanyServiceImpl();
	
	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}
	/*
	@Test
	void testByIdTimes() {
		Company expected = new Company();
		expected.setId(1);
		when(companyDao.byId(1)).thenReturn(expected);
	//	companyService.byId(1);
		verify(companyDao, times(1)).byId(1);
	}

	@Test
	void testAllSizeOneTimes() {
		List<Company> listCompany = new ArrayList<Company>();
		listCompany.add(new Company());
		when(companyDao.byList("allCompany")).thenReturn(listCompany);
	//	companyService.all("allCompany");
		verify(companyDao, times(1)).byList("allCompany");
	}
	
	@Test
	void testAllSize() {
		int sizeList = 10;
		List<Company> listCompany = new ArrayList<Company>();
		do {
			listCompany.add(new Company());
		} while (sizeList != listCompany.size());
		when(companyDao.byList("allCompany")).thenReturn(listCompany);
	//	assertEquals(sizeList, companyService.all("allCompany").size());
	}


	 */
}
