package by.peshko.soccms.dto;

import java.io.Serializable;
import java.util.Date;

public class MessageDTO implements Serializable {
    private static final int HASH_NUMBER = 31;
    private Long id;
    private Date messageDate;
    private String text;
    private ProfileDTO senderProfileDTO;
    private ProfileDTO destinationProfileDTO;

    public void setMessageDate(final Date messageDate) {
        this.messageDate = messageDate;
    }

    public Date getMessageDate() {
        return messageDate;
    }

    public void setText(final String text) {
        this.text = text;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public ProfileDTO getDestinationProfileDTO() {
        return destinationProfileDTO;
    }

    public ProfileDTO getSenderProfileDTO() {
        return senderProfileDTO;
    }

    public void setSenderProfileDTO(final ProfileDTO senderProfileDTO) {
        this.senderProfileDTO = senderProfileDTO;
    }

    public void setDestinationProfileDTO(final ProfileDTO destinationProfileDTO) {
        this.destinationProfileDTO = destinationProfileDTO;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MessageDTO)) {
            return false;
        }

        MessageDTO that = (MessageDTO) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) {
            return false;
        }
        if (getMessageDate() != null ? !getMessageDate().equals(that.getMessageDate()) : that.getMessageDate() != null) {
            return false;
        }
        if (getText() != null ? !getText().equals(that.getText()) : that.getText() != null) {
            return false;
        }
        if (getSenderProfileDTO() != null ? !getSenderProfileDTO().equals(that.getSenderProfileDTO()) :
                that.getSenderProfileDTO() != null) {
            return false;
        }
        return getDestinationProfileDTO() != null ? getDestinationProfileDTO().equals(that.getDestinationProfileDTO()) :
                that.getDestinationProfileDTO() == null;

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = HASH_NUMBER * result + (getMessageDate() != null ? getMessageDate().hashCode() : 0);
        result = HASH_NUMBER * result + (getText() != null ? getText().hashCode() : 0);
        result = HASH_NUMBER * result + (getSenderProfileDTO() != null ? getSenderProfileDTO().hashCode() : 0);
        result = HASH_NUMBER * result + (getDestinationProfileDTO() != null ? getDestinationProfileDTO().hashCode() : 0);
        return result;
    }
}