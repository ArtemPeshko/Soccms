package by.peshko.soccms.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "message")
public class MessageEntity implements Serializable {
    private static final int TABLE_COLUMN_MAX_TEXT_LENGTH = 1024;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "messagedate")
    private Date messageDate;

    @Column(name = "text", length = TABLE_COLUMN_MAX_TEXT_LENGTH)
    private String text;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "senderID")
    private ProfileEntity profileSenderEntity;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "destinationID")
    private ProfileEntity profileDestinationEntity;

    public Date getMessageDate() {
        return messageDate;
    }

    public Long getId() {
        return id;
    }

    public void setText(final String text) {
        this.text = text;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public void setMessageDate(final Date messageDate) {
        this.messageDate = messageDate;
    }

    public String getText() {
        return text;
    }

    public void setProfileDestinationEntity(final ProfileEntity profileDestinationEntity) {
        this.profileDestinationEntity = profileDestinationEntity;
    }

    public void setProfileSenderEntity(final ProfileEntity profileSenderEntity) {
        this.profileSenderEntity = profileSenderEntity;
    }

    public ProfileEntity getProfileDestinationEntity() {
        return profileDestinationEntity;
    }

    public ProfileEntity getProfileSenderEntity() {
        return profileSenderEntity;
    }
}