package ua.nure.melnyk.SummaryTask4.Test.serviceImpl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.internal.verification.VerificationModeFactory;
import org.mockito.runners.MockitoJUnitRunner;
import ua.nure.melnyk.summaryTask4.dao.entitydao.ProductDao;
import ua.nure.melnyk.summaryTask4.dao.entitydao.UserDao;
import ua.nure.melnyk.summaryTask4.model.User;
import ua.nure.melnyk.summaryTask4.service.UserService;
import ua.nure.melnyk.summaryTask4.service.serviceImpl.UserServiceImpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    private UserService userService;

    @Mock
    private UserDao userDao;

    @Mock
    private ProductDao productDao;

    @Mock
    private HttpServletRequest request;

    @Mock
    private User testUser;

    @Mock
    private HttpSession session;

    @Before
    public void setUp() {
        userService = new UserServiceImpl(userDao, productDao);
    }

    @Test
    public void testRegisterUser_ShouldRegisterNewUser_TrueIfRegistrationIsSuccess() {
        when(userDao.create(testUser)).thenReturn(true);
        when(testUser.getEmail()).thenReturn("ff@");
        when(request.getSession()).thenReturn(session);
        doNothing().when(session).setAttribute(anyString(), anyObject());
        userService.registerUser(testUser, request);
        verify(userDao).create(testUser);
        verify(testUser).getEmail();
        verify(request).getSession();
        verify(session).setAttribute(anyString(), anyObject());
    }

    @Test
    public void testDeleteUser_ShouldDeleteUserById() throws SQLException {
        doNothing().when(userDao).delete(anyInt());
        userService.deleteUserById(1);
        verify(userDao).delete(anyInt());
    }

    @Test
    public void testFindAllUsers_shouldGetListOfUsers() {
        List<User> testListOfUsers = new ArrayList<>();
        when(userDao.findAll()).thenReturn(testListOfUsers);
        userService.getAllUsers();
        verify(userDao).findAll();
    }
}
