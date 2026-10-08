package com.martins.aprendendospring.business;


import com.martins.aprendendospring.infrastructure.entity.Usuario;
import com.martins.aprendendospring.infrastructure.exceptions.ConflictExceptions;
import com.martins.aprendendospring.infrastructure.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public Usuario salvaUsuario(Usuario usuario) {
        try {
            emailExiste(usuario.getEmail());
            return usuarioRepository.save(usuario);
        } catch (ConflictExceptions e) {
            throw new ConflictExceptions("Email ja cadastrado", e.getCause());
        }
    }

    public void emailExiste(String email) {
        try{
            boolean existe = verificaEmailExistents(email);
            if(existe) {
                throw new ConflictExceptions("Email ja cadastrado" + email);
            }
        }catch (ConflictExceptions e) {
            throw new ConflictExceptions("Email ja cadastrado" + e.getCause());
        }
    }

    public boolean verificaEmailExistents(String email) {
        return usuarioRepository.existsByEmail(email);
    }

}
