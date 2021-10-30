package co.usa.mnnq.mnnq.Repository;


import co.usa.mnnq.mnnq.Model.Message;
import co.usa.mnnq.mnnq.Repository.Crud.MessageCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
/**
 *
 * @author mnnq
 */
@Repository
public class MessageRepository {

    @Autowired
    private MessageCrudRepository messageCrudRepository;

    public List<Message> getAll(){
        return (List<Message>) messageCrudRepository.findAll();
    }
    public Optional<Message> getMessage(int id){
        return messageCrudRepository.findById(id);
    }

    public Message save(Message m){
        return messageCrudRepository.save(m);
    }
    public void delete(Message m){
        messageCrudRepository.delete(m);
    }

}
