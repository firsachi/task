package informer.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import informer.old.transformer.EmployeeTransformer;
import ua.kyiv.informer.logic.repository.EmployeeDaoImpl;
import ua.kyiv.informer.logic.service.EmployeeService;

class UserAppServiceTest {
	
	@Mock
	private EmployeeDaoImpl employeeDao;
	
	@Mock
	private EmployeeTransformer employeeTransformer;
	
	@InjectMocks
	EmployeeService employeeService = new EmployeeService();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetByIdLogic() {
		employeeService.getId(1);
		verify(employeeDao, times(1)).byId(1);
	}
	
	@Test
	void testDleteLogic() {
		employeeService.delete(1);
		verify(employeeDao, times(1)).byId(1);
	}

	void testFindUsernameLogic() {

	}
}
