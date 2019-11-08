package services.implementations;

import dao.interfaces.RoomDAO;
import models.Room;
import services.interfaces.RoomService;

import java.util.List;

public class RoomServiceImpl implements RoomService {

    private RoomDAO rdao;

    public RoomServiceImpl(RoomDAO rdao){
        this.rdao = rdao;
    }

    @Override
    public Room findById(int id) {
        return rdao.findById(id);
    }

    @Override
    public void save(Room r) {
        rdao.save(r);
    }

    @Override
    public void update(Room r) {
        rdao.update(r);
    }

    @Override
    public void delete(Room r) {
        rdao.delete(r);
    }

    @Override
    public List<Room> findAll() {
        return rdao.findAll();
    }
}
