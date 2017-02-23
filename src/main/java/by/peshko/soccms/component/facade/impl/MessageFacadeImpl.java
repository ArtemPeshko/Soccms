package by.peshko.soccms.component.facade.impl;

import by.peshko.soccms.dto.MessageDTO;
import by.peshko.soccms.component.facade.MessageFacade;
import by.peshko.soccms.model.MessageEntity;
import by.peshko.soccms.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component("messageFacade")
public class MessageFacadeImpl implements MessageFacade {
    @Autowired
    private MessageService messageService;
    @Autowired
    private ConversionService conversionService;

    public MessageEntity createMessage(final MessageDTO messageDTO) {
        MessageEntity messageEntity = conversionService.convert(messageDTO, MessageEntity.class);
        return messageService.createMessage(messageEntity);
    }

    public MessageDTO getById(final Long messageId) {
        return conversionService.convert(messageService.getById(messageId), MessageDTO.class);
    }

    public List<MessageDTO> getAllTheMessages(final Long senderID, final Long destinationID) {
        List<MessageDTO> allTheMessageDTO = new ArrayList<>();

        messageService.getAllTheMessages(senderID, destinationID).
                forEach(elem -> allTheMessageDTO.add(conversionService.convert(elem, MessageDTO.class)));

        return allTheMessageDTO;
    }
}