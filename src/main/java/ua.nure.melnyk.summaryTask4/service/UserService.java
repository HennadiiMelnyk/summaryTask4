package ua.nure.melnyk.summaryTask4.service;

import ua.nure.melnyk.summaryTask4.model.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * User Service
 */
public interface UserService {

    /**
     * Extract user from registration post request.Register User. Set user in session
     *
     * @param user
     * @param request
     * @return
     */
    boolean registerUser(User user, HttpServletRequest request);

    /**
     * Delete user with specified id
     *
     * @param id
     */
    void deleteUserById(int id);

    /**
     * Login user
     *
     * @param email
     * @param password
     * @param request
     * @return
     */
    boolean login(String email, String password, HttpServletRequest request);

    /**
     * update user
     *
     * @param user
     * @return
     */
    User updateUser(User user);

    /**
     * get List of Users
     *
     * @return
     */
    List<User> getAllUsers();

    /**
     * Add product to Cart with specified product id
     *
     * @param productId
     * @param request
     * @return
     */
    boolean addProductToCart(int productId, HttpServletRequest request);

    /**
     * update field user isBlock=true
     *
     * @param id
     * @return
     */
    User blockUser(int id);

    /**
     * update field user isBlock=false
     *
     * @param id
     * @return
     */
    User unLockUser(int id);
}
