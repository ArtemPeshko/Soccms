package by.peshko.soccms.service.impl;

import by.peshko.soccms.dao.MessageDao;
import by.peshko.soccms.model.MessageEntity;
import by.peshko.soccms.service.MessageService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("messageService")
public class MessageServiceImpl implements MessageService {
    private static final Logger LOGGER = Logger.getLogger(MessageServiceImpl.class);

    @Autowired
    private MessageDao messageDao;

    @Transactional
    public MessageEntity createMessage(final MessageEntity messageEntity) {
        LOGGER.info("Created message from profileID " + messageEntity.getProfileSenderEntity().getId() + " to prfileID " +
                messageEntity.getProfileDestinationEntity().getId());
        return messageDao.createMessage(messageEntity);

    }

    @Transactional(readOnly = true)
    public MessageEntity getById(final Long messageId) {
        LOGGER.info("Got message with ID " + messageId);

        return messageDao.getById(messageId);
    }

    @Override
    public void deleteMessage(final MessageEntity messageEntity) {
        messageDao.deleteMessage(messageEntity);
    }

    @Transactional(readOnly = true)
    public List<MessageEntity> getAllTheMessages(final Long senderID, final Long destinationID) {
        LOGGER.info("Got list of messages from profileID  " + senderID + " to profileID " + destinationID);
        return messageDao.getAllTheMessages(senderID, destinationID);
    }

}