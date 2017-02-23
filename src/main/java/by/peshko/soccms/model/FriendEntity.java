package by.peshko.soccms.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "friend")
public class FriendEntity implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "main_profile_id")
    private ProfileEntity currentProfileEntity;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "friends_profile_id")
    private ProfileEntity friendProfileEntity;

    @Column(name = "friend_request_status")
    @Enumerated(EnumType.STRING)
    private FriendRequestApprovalStatus status;

    public void setId(final Long id) {
        this.id = id;
    }

    public ProfileEntity getFriendProfileEntity() {
        return friendProfileEntity;
    }

    public ProfileEntity getCurrentProfileEntity() {
        return currentProfileEntity;
    }

    public void setCurrentProfileEntity(final ProfileEntity currentProfileEntity) {
        this.currentProfileEntity = currentProfileEntity;
    }

    public void setFriendProfileEntity(final ProfileEntity friendProfileEntity) {
        this.friendProfileEntity = friendProfileEntity;
    }

    public Long getId() {
        return id;
    }

    public FriendRequestApprovalStatus getStatus() {
        return status;
    }

    public void setStatus(final FriendRequestApprovalStatus status) {
        this.status = status;
    }
}