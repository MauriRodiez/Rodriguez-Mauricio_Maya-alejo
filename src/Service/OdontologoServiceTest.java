package Service;

import Dao.Implementacion.OdontologoDaoEnMemoria;
import Dao.Implementacion.OdontologoDaoH2;
import Model.Odontologo;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OdontologoServiceTest {

    @Test
    public void listarOdontologoH2(){
        Odontologo odontologo = new Odontologo(1L, "ABC", "Raul", "Martinez");
        Odontologo odontologo1 = new Odontologo(2L, "DFG", "Eduardo", "Gonzalez");

        OdontologoService odontologoService = new OdontologoService();

        odontologoService.setOdontologoIDao(new OdontologoDaoH2());

        odontologoService.guardar(odontologo);
        odontologoService.guardar(odontologo1);

        String listadoConvertido = odontologoService.listadoOdontologos().toString();

        String listadoTest = "[Odontologo{id=1, matricula='ABC', nombre='Raul', apellido='Martinez'}, Odontologo{id=2, matricula='DFG', nombre='Eduardo', apellido='Gonzalez'}]";

        Assert.assertEquals(listadoTest, listadoConvertido);
    }

    @Test
    public void listarOdontologoEnMemoria(){
        Odontologo odontologo = new Odontologo(1L, "ABC", "Raul", "Martinez");
        Odontologo odontologo1 = new Odontologo(2L, "DFG", "Eduardo", "Gonzalez");

        OdontologoService odontologoService = new OdontologoService();
        odontologoService.setOdontologoIDao(new OdontologoDaoEnMemoria());

        odontologoService.guardar(odontologo);
        odontologoService.guardar(odontologo1);

        odontologoService.listadoOdontologos();

        String listadoConvertido = odontologoService.listadoOdontologos().toString();

        String listadoTest = "[Odontologo{id=1, matricula='ABC', nombre='Raul', apellido='Martinez'}, Odontologo{id=2, matricula='DFG', nombre='Eduardo', apellido='Gonzalez'}]";

        Assert.assertEquals(listadoTest, listadoConvertido);

    }

}