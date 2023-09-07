package ua.kyiv.informer.logic.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import ua.kyiv.informer.logic.repository.UserRepositoryImpl;

class UserAppServiceTest {
    @Mock
    UserRepositoryImpl userRepository;
    @Mock
    ModelMapper modelMapper;
    @InjectMocks
    UserAppService userAppService = new UserAppService();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getListUser() {
    }

    @Test
    void findUsername() {
    }
    @Test
    void findUsernameLogic() {
        String username = "roma";
        userAppService.findUsername(username);
        verify(userRepository, times(1)).uniqueUsername(username);
    }

    @Test
    void byUserApp() {
    }

    @Test
    void byUserEditApp() {
    }

    @Test
    void save() {
    }

    @Test
    void delete() {
    }

    @Test
    void changePassword() {
    }

    @Test
    void update() {
    }
}