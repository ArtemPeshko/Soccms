package by.peshko.soccms.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "profile")
public class ProfileEntity implements Serializable {
    private static final int TABLE_COLUMN_MAX_LENGTH = 64;

    @OneToOne(mappedBy = "profileEntity", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private UserEntity userEntity;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "profileEntity")
    private Set<PhotoEntity> photos;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "currentProfileEntity")
    private Set<FriendEntity> currentProfileFriends = new HashSet<FriendEntity>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "friendProfileEntity")
    private Set<FriendEntity> friendProfileFriends = new HashSet<FriendEntity>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "profileSenderEntity")
    private Set<MessageEntity> senderMessages = new HashSet<MessageEntity>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "profileDestinationEntity")
    private Set<MessageEntity> destinationMessages = new HashSet<MessageEntity>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "profileSender")
    private List<PostEntity> sentPostsFromSender;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "wallOwnerProfile")
    private List<PostEntity> wallOwnerPosts;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstname", length = TABLE_COLUMN_MAX_LENGTH)
    private String firstname;

    @Column(name = "lastname", length = TABLE_COLUMN_MAX_LENGTH)
    private String lastname;

    @Column(name = "email", length = TABLE_COLUMN_MAX_LENGTH)
    private String email;

    @Column(name = "birthDate", length = TABLE_COLUMN_MAX_LENGTH)
    private Date birthDate;

    @Column(name = "age", length = TABLE_COLUMN_MAX_LENGTH)
    private Integer age;

    @Column(name = "sex", length = TABLE_COLUMN_MAX_LENGTH)
    private String sex;

    @Column(name = "city", length = TABLE_COLUMN_MAX_LENGTH)
    private String city;

    @Column(name = "phoneNumber", length = TABLE_COLUMN_MAX_LENGTH)
    private String phoneNumber;

    public ProfileEntity() {
    }

    public String getSex() {
        return sex;
    }

    public void setSex(final String sex) {
        this.sex = sex;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setAge(final Integer age) {
        this.age = age;
    }

    public void setPhoneNumber(final String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setFirstname(final String firstname) {
        this.firstname = firstname;
    }

    public void setBirthDate(final Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getCity() {
        return city;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(final String lastname) {
        this.lastname = lastname;
    }

    public void setCity(final String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public Long getId() {
        return id;
    }

    public void setUserEntity(final UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setSenderMessages(final Set<MessageEntity> senderMessages) {
        this.senderMessages = senderMessages;
    }

    public Set<MessageEntity> getSenderMessages() {
        return senderMessages;
    }

    public Set<MessageEntity> getDestinationMessages() {
        return destinationMessages;
    }

    public void setDestinationMessages(final Set<MessageEntity> destinationMessages) {
        this.destinationMessages = destinationMessages;
    }

    public void setFriendProfileFriends(final Set<FriendEntity> friendProfileFriends) {
        this.friendProfileFriends = friendProfileFriends;
    }

    public Set<FriendEntity> getCurrentProfileFriends() {
        return currentProfileFriends;
    }

    public void setCurrentProfileFriends(final Set<FriendEntity> currentProfileFriends) {
        this.currentProfileFriends = currentProfileFriends;
    }

    public Set<FriendEntity> getFriendProfileFriends() {
        return friendProfileFriends;
    }

    public void setPhotos(final Set<PhotoEntity> photos) {
        this.photos = photos;
    }

    public Set<PhotoEntity> getPhotos() {
        return photos;
    }

    public void setSentPostsFromSender(final List<PostEntity> sentPostsFromSender) {
        this.sentPostsFromSender = sentPostsFromSender;
    }

    public List<PostEntity> getSentPostsFromSender() {
        return sentPostsFromSender;
    }

    public void setWallOwnerPosts(final List<PostEntity> wallOwnerPosts) {
        this.wallOwnerPosts = wallOwnerPosts;
    }

    public List<PostEntity> getWallOwnerPosts() {
        return wallOwnerPosts;
    }

}