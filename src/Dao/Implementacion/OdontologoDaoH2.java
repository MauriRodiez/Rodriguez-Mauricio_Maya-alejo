package Dao.Implementacion;

import DB.Database;
import Dao.IDao;
import Model.Odontologo;
import org.apache.log4j.Logger;
import org.h2.command.Prepared;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDaoH2 implements IDao<Odontologo> {

    private static final Logger LOGGER =  Logger.getLogger(OdontologoDaoH2.class);
    private static final String SQL_INSERT_ODONTOLOGO = "INSERT INTO ODONTOLOGOS (MATRICULA, NOMBRE, APELLIDO) VALUES (?,?,?)";
    private static final String SQL_SELECT = "SELECT * FROM ODONTOLOGOS";
    Connection connection = null;

    public OdontologoDaoH2(){
        Database.createTable();
    }
    @Override
    public Odontologo guardar(Odontologo odontologo) {

        try {
            connection = Database.getConnection();

            PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT_ODONTOLOGO, Statement.RETURN_GENERATED_KEYS);
            psInsert.setString(1, odontologo.getMatricula());
            psInsert.setString(2, odontologo.getNombre());
            psInsert.setString(3, odontologo.getApellido());

            psInsert.execute();

            ResultSet rsInsert = psInsert.getGeneratedKeys();
            while(rsInsert.next()){
                odontologo.setId((long) rsInsert.getInt(1));
            }

        } catch (Exception e) {
            LOGGER.error("Se produjo un error y no es posible cargar los datos " + e.getMessage());
        } finally {
            try {
                connection.close();
                LOGGER.info("Se cerro la conexion!");
            } catch (SQLException e) {
                LOGGER.error("No se pudo cerrar la conexion " + e.getMessage());
            }
        }

        LOGGER.info("Se ha creado un registro para odontologo " + odontologo);

        return odontologo;
    }

    @Override
    public List<Odontologo> listarOdontologos() {

        List<Odontologo> listadoOdontologos = new ArrayList<>();
        Odontologo odontologo = null;

        try {
            connection = Database.getConnection();

            PreparedStatement psListar = connection.prepareStatement(SQL_SELECT);

            ResultSet rsListar = psListar.executeQuery();

            while (rsListar.next()){
                odontologo = new Odontologo(
                        rsListar.getLong(1),
                        rsListar.getString(2),
                        rsListar.getString(3),
                        rsListar.getString(4)
                );
                listadoOdontologos.add(odontologo);
            }

        } catch (Exception e) {
            LOGGER.error("Se produjo un error y no es posible cargar los datos " + e.getMessage());
        } finally {
            try {
                connection.close();
                LOGGER.info("Se cerro la conexion!");
            } catch (SQLException e) {
                LOGGER.error("No se pudo cerrar la conexion " + e.getMessage());
            }
        }

        LOGGER.info("Se listan todos los odontologos" + listadoOdontologos);

        return listadoOdontologos;
    }
}
