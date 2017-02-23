package by.peshko.soccms.dao;

import by.peshko.soccms.model.MessageEntity;

import java.util.List;

public interface MessageDao {

    MessageEntity createMessage(MessageEntity messageEntity);

    void deleteMessage(MessageEntity messageEntity);

    MessageEntity getById(Long messageId);

    List<MessageEntity> getAllTheMessages(Long senderID, Long destinationID);
}