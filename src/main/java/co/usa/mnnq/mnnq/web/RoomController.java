package co.usa.mnnq.mnnq.web;


import co.usa.mnnq.mnnq.Model.Room;
import co.usa.mnnq.mnnq.Service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
/**
 *
 * @author mnnq
 */
@CrossOrigin(origins="*", methods={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping("/api/Room")
public class RoomController {

    @Autowired
    private RoomService roomService;
    @GetMapping("/all")
    public List<Room> getRoom(){
        return roomService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Room> getRoom(@PathVariable("id") int id){
        return roomService.getRoom(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)

    public Room save(@RequestBody Room r){
        return roomService.save(r);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Room update(@RequestBody Room r) {
        return roomService.update(r);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int roomId) {
        return roomService .deleteRoom(roomId);
    }
}
