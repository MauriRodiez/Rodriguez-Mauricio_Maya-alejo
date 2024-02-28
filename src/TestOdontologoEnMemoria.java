import Dao.Implementacion.OdontologoDaoEnMemoria;
import Dao.Implementacion.OdontologoDaoH2;
import Model.Odontologo;
import Service.OdontologoService;

public class TestOdontologoEnMemoria {
    public static void main(String[] args) {

        // Odontologo en Memoria
        Odontologo odontologo = new Odontologo(1L, "ABC", "Raul", "Martinez");
        Odontologo odontologo1 = new Odontologo(2L, "DFG", "Eduardo", "Gonzalez");

        OdontologoService odontologoService = new OdontologoService();
        odontologoService.setOdontologoIDao(new OdontologoDaoEnMemoria());

        odontologoService.guardar(odontologo);
        odontologoService.guardar(odontologo1);

        odontologoService.listadoOdontologos();

        // Odontologo en H2

        odontologoService.setOdontologoIDao(new OdontologoDaoH2());

        odontologoService.guardar(odontologo);
        odontologoService.guardar(odontologo1);

        odontologoService.listadoOdontologos();

    }
}
