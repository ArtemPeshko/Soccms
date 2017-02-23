package by.peshko.soccms.dao;

import by.peshko.soccms.model.RoleEntity;

public interface UserRoleDao {

    RoleEntity createUserRole(RoleEntity userRole);

    void updateUserRole(RoleEntity userRole);

    void deleteUserRole(RoleEntity userRole);
}
