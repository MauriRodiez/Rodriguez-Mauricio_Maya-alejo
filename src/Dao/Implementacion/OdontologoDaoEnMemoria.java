package Dao.Implementacion;

import Dao.IDao;
import Model.Odontologo;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class OdontologoDaoEnMemoria implements IDao<Odontologo> {

    Logger logger = Logger.getLogger(OdontologoDaoEnMemoria.class);
    List <Odontologo> odontologosList = new ArrayList<>();

    public OdontologoDaoEnMemoria() {
    }

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        odontologosList.add(odontologo);
        logger.info("Odontologo guardado " + odontologo);
        return odontologo;
    }

    @Override
    public List<Odontologo> listarOdontologos() {
        logger.info("La lista de odontologos es: " + odontologosList);
        return odontologosList;
    }
}