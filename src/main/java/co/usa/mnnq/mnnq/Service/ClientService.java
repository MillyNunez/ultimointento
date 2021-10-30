package co.usa.mnnq.mnnq.Service;

import co.usa.mnnq.mnnq.Model.Client;
import co.usa.mnnq.mnnq.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
/**
 *
 * @author mnnq
 */
@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.getAll();
    }
    public Optional<Client> getClient(int id){
        return clientRepository.getClient(id);
    }
    public Client save(Client cl){
        if(cl.getIdClient()==null){
            return clientRepository.save(cl);
        }else{
            Optional<Client> claux=clientRepository.getClient(cl.getIdClient());

            if(claux.isEmpty()){
                return clientRepository.save(cl);
            }else {
                return cl;
            }
        }
    }
    public Client update(Client cl){
        if(cl.getIdClient()!=null){
            Optional<Client> x= clientRepository.getClient(cl.getIdClient());
            if(!x.isEmpty()){
                if(cl.getName()!=null){
                    x.get().setName(cl.getName());
                }
                if(cl.getAge()!=null){
                    x.get().setAge(cl.getAge());
                }
                if(cl.getPassword()!=null){
                    x.get().setPassword(cl.getPassword());
                }
                clientRepository.save(x.get());
                return x.get();
            }else{
                return cl;
            }
        }else{
            return cl;
        }
    }

    public boolean deleteClient(int clientId) {
        Boolean cli = getClient(clientId).map(client -> {
            clientRepository.delete(client);
            return true;
        }).orElse(false);
        return cli;
    }
}
