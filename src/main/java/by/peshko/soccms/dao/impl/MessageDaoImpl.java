package by.peshko.soccms.dao.impl;

import by.peshko.soccms.dao.MessageDao;
import by.peshko.soccms.model.MessageEntity;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository("messageDao")
public class MessageDaoImpl extends AbstractBaseDAO implements MessageDao {
    private static final String GET_ALL_THE_MESSAGES_QUERY = "FROM MessageEntity " +
            "WHERE senderID = :senderID AND destinationID = :destinationID OR senderID = :destinationID AND destinationID = " +
            ":senderID ORDER BY messagedate DESC";

    public MessageEntity createMessage(final MessageEntity messageEntity) {
        super.save(messageEntity);
        return messageEntity;
    }

    @Override
    public void deleteMessage(final MessageEntity messageEntity) {
        super.delete(messageEntity);
    }

    public List<MessageEntity> getAllTheMessages(final Long senderID, final Long destinationID) {
        Query query = super.getCurrentSession().createQuery(GET_ALL_THE_MESSAGES_QUERY);
        query.setParameter("senderID", senderID);
        query.setParameter("destinationID", destinationID);
        return query.list();
    }

    public MessageEntity getById(final Long messageId) {
        return (MessageEntity) super.getById(MessageEntity.class, messageId);
    }
}