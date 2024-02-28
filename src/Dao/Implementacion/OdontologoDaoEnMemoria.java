package Dao.Implementacion;

import Dao.IDao;
import Model.Odontologo;
import org.apache.log4j.Logger;

import java.util.List;

public class OdontologoDaoEnMemoria implements IDao<Odontologo> {

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        return null;
    }

    @Override
    public List<Odontologo> listarOdontologos() {
        return null;
    }
}
