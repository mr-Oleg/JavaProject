package services.implementations;

import dao.interfaces.TypeOfRoomDAO;
import models.TypeOfRoom;
import services.interfaces.TypeOfRoomService;

import java.util.List;

public class TypeOfRoomServiceImpl implements TypeOfRoomService {

    private TypeOfRoomDAO tordao;

    public TypeOfRoomServiceImpl(TypeOfRoomDAO tordao) {
        this.tordao = tordao;
    }

    @Override
    public TypeOfRoom findById(int id) {
        return tordao.findById(id);
    }

    @Override
    public void save(TypeOfRoom tor) {
        tordao.save(tor);
    }

    @Override
    public void update(TypeOfRoom tor) {
        tordao.update(tor);
    }

    @Override
    public void delete(TypeOfRoom tor) {
        tordao.delete(tor);
    }

    @Override
    public List<TypeOfRoom> findAll() {
        return tordao.findAll();
    }
}
