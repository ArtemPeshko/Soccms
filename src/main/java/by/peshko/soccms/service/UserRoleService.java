package by.peshko.soccms.service;

import by.peshko.soccms.model.RoleEntity;

public interface UserRoleService {

    RoleEntity createUserRole(RoleEntity userRole);

    void updateUserRole(RoleEntity userRole);

    void deleteUserRole(RoleEntity userRole);
}
