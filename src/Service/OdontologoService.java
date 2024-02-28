package Service;

import Dao.IDao;
import Model.Odontologo;

import java.util.List;

public class OdontologoService {

    private IDao<Odontologo> odontologoIDao;

    public OdontologoService() {

    }

    public void setOdontologoIDao(IDao<Odontologo> odontologoIDao) {
        this.odontologoIDao = odontologoIDao;
    }

    public Odontologo guardar(Odontologo odontologo){
        return odontologoIDao.guardar(odontologo);
    }

    public List<Odontologo> listadoOdontologos(){
        return odontologoIDao.listarOdontologos();
    }
}
