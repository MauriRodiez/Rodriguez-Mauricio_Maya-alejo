package Dao;

import java.util.List;

public interface IDao<T>{

    //Registrar un Odontologo
    T guardar(T t);

    // Listar odontologos
    List<T> listarOdontologos();

}
