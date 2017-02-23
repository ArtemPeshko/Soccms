package by.peshko.soccms.service;

import by.peshko.soccms.model.MessageEntity;

import java.util.List;

public interface MessageService {

    MessageEntity createMessage(MessageEntity messageEntity);

    MessageEntity getById(Long messageId);

    void deleteMessage(MessageEntity messageEntity);

    List<MessageEntity> getAllTheMessages(Long senderID, Long destinationID);
}