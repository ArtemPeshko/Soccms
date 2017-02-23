package by.peshko.soccms.service.impl;

import by.peshko.soccms.dao.ProfileDao;
import by.peshko.soccms.dao.UserDao;
import by.peshko.soccms.model.ProfileEntity;
import by.peshko.soccms.model.RoleEntity;
import by.peshko.soccms.model.UserEntity;
import by.peshko.soccms.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;

@Service("userService")
public class UserServiceImpl implements UserService {
    private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class);
    @Autowired
    private UserDao userDao;
    @Autowired
    private ProfileDao profileDao;
    @Autowired
    private MessageSource messageSource;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public void createUser(final UserEntity userEntity) {
        ProfileEntity profileEntity = new ProfileEntity();
        profileEntity.setUserEntity(userEntity);
        profileEntity.setEmail(userEntity.getEmail());

        userEntity.setProfileEntity(profileEntity);
        userEntity.setEnabled(true);
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));

        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setId(2L);
        roleEntity.setRole("ROLE_USER");
        userEntity.setRoleEntity(roleEntity);

        profileDao.createProfile(profileEntity);
        userDao.createUser(userEntity);
        LOGGER.info(messageSource.getMessage("service.user.save", new Object[]{userEntity}, Locale.ENGLISH));
    }

    @Transactional
    public void updateUser(final UserEntity userEntity) {
        userDao.updateUser(userEntity);
        LOGGER.info(messageSource.getMessage("service.user.update", new Object[]{userEntity}, Locale.ENGLISH));

    }

    @Transactional(readOnly = true)
    public UserEntity getUserByUsername(final String username) {
        LOGGER.info(messageSource.getMessage("service.user.getByLogin", new Object[]{username}, Locale.ENGLISH));
        return userDao.getUserByUsername(username);
    }

    @Transactional
    public void deleteUser(final UserEntity userEntity) {
        userDao.deleteUser(userEntity);
        LOGGER.info(messageSource.getMessage("service.user.delete", new Object[]{userEntity}, Locale.ENGLISH));
    }

    @Transactional(readOnly = true)
    public List<UserEntity> getAllTheUsers() {
        return userDao.getAllTheUsers();
    }

    @Transactional(readOnly = true)
    public List<UserEntity> getUserByUsernameOrEmail(final String username, final String email) {
        return userDao.getUserByUsernameOrEmail(username, email);
    }
}