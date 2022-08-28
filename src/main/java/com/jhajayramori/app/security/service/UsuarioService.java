package com.jhajayramori.app.security.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhajayramori.app.security.entity.User;
import com.jhajayramori.app.security.repository.iUsuarioRepository;



@Service
@Transactional
public class UsuarioService {
    @Autowired
    iUsuarioRepository iusuarioRepository;

    public Optional<User> getByNombreUsuario(String nombreUsuario){
        return iusuarioRepository.findByNombreUsuario(nombreUsuario);
    }

    public boolean existsByNombreUsuario(String nombreUsuario){
        return iusuarioRepository.existsByNombreUsuario(nombreUsuario);
    }
    public boolean existsByEmail(String email){
        return iusuarioRepository.existsByEmail(email);
    }
    public void save(User usuario){
        iusuarioRepository.save(usuario);
    }
}