package com.recupera.Login.controller.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.recupera.Login.model.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, String> {


    Usuario findByEmail(String email);

    @Query(value = "select * from login.usuario where email = :email and senha = :senha", nativeQuery = true)
    public Usuario login(String email, String senha);

}
