package by.peshko.soccms.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user")
public class UserEntity implements Serializable {
    private static final int TABLE_COLUMN_MAX_LENGTH = 64;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", length = TABLE_COLUMN_MAX_LENGTH)
    private String email;

    @Column(name = "username", length = TABLE_COLUMN_MAX_LENGTH, unique = true)
    private String username;

    @Column(name = "password", length = TABLE_COLUMN_MAX_LENGTH)
    private String password;

    @OneToOne(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JoinColumn(name = "profileID")
    private ProfileEntity profileEntity;

    @Column(name = "enabled")
    private boolean enabled;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "roleID")
    private RoleEntity roleEntity;

    public UserEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setProfileEntity(final ProfileEntity profileEntity) {
        this.profileEntity = profileEntity;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public ProfileEntity getProfileEntity() {
        return profileEntity;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public void setEnabled(final boolean enabled) {
        this.enabled = enabled;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public RoleEntity getRoleEntity() {
        return roleEntity;
    }

    public void setRoleEntity(final RoleEntity roleEntity) {
        this.roleEntity = roleEntity;
    }
}

