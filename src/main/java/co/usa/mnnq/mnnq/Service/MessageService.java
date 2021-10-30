package co.usa.mnnq.mnnq.Service;


import co.usa.mnnq.mnnq.Model.Message;
import co.usa.mnnq.mnnq.Repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
/**
 *
 * @author mnnq
 */
@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll(){
        return messageRepository.getAll();
    }
    public Optional<Message> getMessage(int id){
        return messageRepository.getMessage(id);
    }
    public Message save(Message m){
        if(m.getIdMessage()==null){
            return messageRepository.save(m);
        }else{
            Optional<Message> maux=messageRepository.getMessage(m.getIdMessage());

            if(maux.isEmpty()){
                return messageRepository.save(m);
            }else {
                return m;
            }
        }
    }
    public Message update(Message m){
        if(m.getIdMessage()!=null){
            Optional<Message> w= messageRepository.getMessage(m.getIdMessage());
            if(!w.isEmpty()){
                if(m.getMessageText()!=null){
                    w.get().setMessageText(m.getMessageText());
                }
                messageRepository.save(w.get());
                return w.get();
            }else{
                return m;
            }
        }else{
            return m;
        }
    }

    public boolean deleteMessage(int messageId) {
        Boolean me = getMessage(messageId).map(message -> {
            messageRepository.delete(message);
            return true;
        }).orElse(false);
        return me;
    }
}
