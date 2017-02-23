package by.peshko.soccms.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "user_role")
public class RoleEntity implements Serializable {
    private static final int TABLE_COLUMN_MAX_LENGTH = 45;

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "role", length = TABLE_COLUMN_MAX_LENGTH)
    private String role;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "roleEntity")
    private List<UserEntity> users;

    public RoleEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(final String role) {
        this.role = role;
    }

    public List<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(final List<UserEntity> users) {
        this.users = users;
    }
}
