package by.peshko.soccms.dto.converter;

import by.peshko.soccms.dto.MessageDTO;
import by.peshko.soccms.dto.ProfileDTO;
import by.peshko.soccms.model.MessageEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class MessageDTOConverter implements Converter<MessageEntity, MessageDTO> {
    public MessageDTO convert(final MessageEntity messageEntity) {
        if (messageEntity == null) {
            return null;
        }

        MessageDTO messageDTO = new MessageDTO();

        messageDTO.setId(messageEntity.getId());
        messageDTO.setMessageDate(messageEntity.getMessageDate());
        messageDTO.setText(messageEntity.getText());

        ProfileDTO profileSenderDTO = new ProfileDTO();
        profileSenderDTO.setProfileID(messageEntity.getProfileSenderEntity().getId());
        profileSenderDTO.setFirstname(messageEntity.getProfileSenderEntity().getFirstname());
        profileSenderDTO.setLastname(messageEntity.getProfileSenderEntity().getLastname());
        profileSenderDTO.setEmail(messageEntity.getProfileSenderEntity().getEmail());
        profileSenderDTO.setBirthDate(messageEntity.getProfileSenderEntity().getBirthDate());
        profileSenderDTO.setAge(messageEntity.getProfileSenderEntity().getAge());
        profileSenderDTO.setSex(messageEntity.getProfileSenderEntity().getSex());
        profileSenderDTO.setCity(messageEntity.getProfileSenderEntity().getCity());
        profileSenderDTO.setPhoneNumber(messageEntity.getProfileSenderEntity().getPhoneNumber());
        messageDTO.setSenderProfileDTO(profileSenderDTO);

        ProfileDTO profileDestinationDTO = new ProfileDTO();
        profileDestinationDTO.setProfileID(messageEntity.getProfileDestinationEntity().getId());
        profileDestinationDTO.setFirstname(messageEntity.getProfileDestinationEntity().getFirstname());
        profileDestinationDTO.setLastname(messageEntity.getProfileDestinationEntity().getLastname());
        profileDestinationDTO.setEmail(messageEntity.getProfileDestinationEntity().getEmail());
        profileDestinationDTO.setBirthDate(messageEntity.getProfileDestinationEntity().getBirthDate());
        profileDestinationDTO.setAge(messageEntity.getProfileDestinationEntity().getAge());
        profileDestinationDTO.setSex(messageEntity.getProfileDestinationEntity().getSex());
        profileDestinationDTO.setCity(messageEntity.getProfileDestinationEntity().getCity());
        profileDestinationDTO.setPhoneNumber(messageEntity.getProfileDestinationEntity().getPhoneNumber());
        messageDTO.setDestinationProfileDTO(profileDestinationDTO);

        return messageDTO;
    }
}