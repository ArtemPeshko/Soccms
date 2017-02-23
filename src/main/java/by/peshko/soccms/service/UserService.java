package by.peshko.soccms.service;

import by.peshko.soccms.model.UserEntity;

import java.util.List;

public interface UserService {

    void createUser(UserEntity userEntity);

    void updateUser(UserEntity userEntity);

    void deleteUser(UserEntity userEntity);

    UserEntity getUserByUsername(String username);

    List<UserEntity> getAllTheUsers();

    List<UserEntity> getUserByUsernameOrEmail(String username, String email);

}
