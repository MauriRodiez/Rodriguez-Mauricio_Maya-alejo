import Dao.Implementacion.OdontologoDaoEnMemoria;
import Model.Odontologo;
import Service.OdontologoService;

public class TestOdontologoEnMemoria {
    public static void main(String[] args) {

        Odontologo odontologo = new Odontologo(1L, "ABC", "Raul", "Martinez");
        Odontologo odontologo1 = new Odontologo(2L, "DFG", "Eduardo", "Gonzalez");

        OdontologoService odontologoService = new OdontologoService();
        odontologoService.setOdontologoIDao(new OdontologoDaoEnMemoria());

        odontologoService.guardar(odontologo);
        odontologoService.guardar(odontologo1);

        odontologoService.listadoOdontologos();

    }
}
