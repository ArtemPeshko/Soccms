package by.peshko.soccms.component.facade;

import by.peshko.soccms.dto.MessageDTO;
import by.peshko.soccms.model.MessageEntity;

import java.util.List;

public interface MessageFacade {

    MessageEntity createMessage(MessageDTO messageDTO);

    MessageDTO getById(Long messageId);

    List<MessageDTO> getAllTheMessages(Long senderID, Long destinationID);
}