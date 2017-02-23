package by.peshko.soccms.dao;

import by.peshko.soccms.model.UserEntity;

import java.util.List;

public interface UserDao {

    UserEntity createUser(UserEntity user);

    UserEntity updateUser(UserEntity user);

    void deleteUser(UserEntity user);

    UserEntity getUserByUsername(String username);

    List<UserEntity> getAllTheUsers();

    List<UserEntity> getUserByUsernameOrEmail(String username, String email);

    UserEntity getById(Long userId);

}
