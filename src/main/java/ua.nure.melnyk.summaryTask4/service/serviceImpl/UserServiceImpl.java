package ua.nure.melnyk.summaryTask4.service.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.nure.melnyk.summaryTask4.dao.entitydao.ProductDao;
import ua.nure.melnyk.summaryTask4.dao.entitydao.UserDao;
import ua.nure.melnyk.summaryTask4.exception.UserDaoException;
import ua.nure.melnyk.summaryTask4.model.User;
import ua.nure.melnyk.summaryTask4.repository.Cart;
import ua.nure.melnyk.summaryTask4.service.UserService;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * User Service
 * Business logic
 */
public class UserServiceImpl implements UserService {

    private static final Logger logger
            = LoggerFactory.getLogger(UserServiceImpl.class);

    private UserDao userDao;
    private ProductDao productDao;

    public UserServiceImpl(UserDao userDao, ProductDao productDao) {
        this.userDao = userDao;
        this.productDao = productDao;
    }

    public UserServiceImpl() {
    }

    @Override
    public boolean registerUser(User user, HttpServletRequest request) {
        boolean isCreated = userDao.create(user);
        if (isCreated) {
            user = userDao.getUserByEmail(user.getEmail());
            request.getSession().setAttribute("user", user);
            return true;
        }
        return false;
    }

    @Override
    public void deleteUserById(int id) {
        userDao.delete(id);

    }

    private void sendMail(User user) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("erklareb@gmail.com", "0782justwar0321");
                    }
                });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("erklareb@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("vasiliy.ivanov0782@gmail.com"));
            message.setSubject("Block account message");
            message.setText("You was blocked");
            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean login(String email, String password, HttpServletRequest request) {
        boolean result = false;
        try {
            User user = userDao.getUserByEmail(email);
            result = processLogin(user, email, password, request);
        } catch (UserDaoException e) {
            logger.info("Service exception", e);
        }
        return result;
    }

    @Override
    public User updateUser(User user) {
        userDao.update(user);
        return user;
    }

    @Override
    public List<User> getAllUsers() {

        return userDao.findAll();
    }

    @Override
    public boolean addProductToCart(int productId, HttpServletRequest request) {
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
        }
        cart.addToCart(productDao.select(productId));
        request.getSession().setAttribute("cart", cart);
        if (cart.getCart().isEmpty()) {
            return false;
        }
        return true;
    }

    @Override
    public User blockUser(int id) {
        User user = userDao.select(id);
        user.setBlock(true);
        sendMail(user);
        return userDao.update(user);
    }

    @Override
    public User unLockUser(int id) {
        User user = userDao.select(id);
        user.setBlock(false);
        return userDao.update(user);

    }

    private boolean processLogin(User user, String email, String password, HttpServletRequest request) {
        if (user != null) {
            if (user.getPassword().equals(password)) {
                request.getSession().setAttribute("user", user);
                return true;
            }
        }
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("login", "Email or password if not correct");
        request.setAttribute("errorMap", errorMap);
        return false;
    }
}
