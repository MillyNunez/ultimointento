package co.usa.mnnq.mnnq.Repository;

import co.usa.mnnq.mnnq.Model.Client;
import co.usa.mnnq.mnnq.Repository.Crud.ClientCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
/**
 *
 * @author mnnq
 */
@Repository
public class ClientRepository {
    @Autowired
    private ClientCrudRepository clientCrudRepository;

    public List<Client> getAll(){
        return (List<Client>) clientCrudRepository.findAll();
    }
    public Optional<Client> getClient(int id){
        return clientCrudRepository.findById(id);
    }

    public Client save(Client cl){
        return clientCrudRepository.save(cl);
    }
    public void delete(Client cl){
        clientCrudRepository.delete(cl);
    }
}
