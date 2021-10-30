package co.usa.mnnq.mnnq.Repository;


import co.usa.mnnq.mnnq.Model.Reservation;
import co.usa.mnnq.mnnq.Repository.Crud.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
/**
 *
 * @author mnnq
 */
@Repository
public class ReservationRepository {

    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    public List<Reservation> getAll(){
        return (List<Reservation>) reservationCrudRepository.findAll();
    }
    public Optional<Reservation> getReservation(int id){
        return reservationCrudRepository.findById(id);
    }

    public Reservation save(Reservation rt){
        return reservationCrudRepository.save(rt);
    }
    public void delete(Reservation rt){
        reservationCrudRepository.delete(rt);
    }
}
