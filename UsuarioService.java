package com.mycompany.imc.service;

import com.mycompany.imc.model.Usuario;
import com.mycompany.imc.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository = new UsuarioRepository();

    public void registrar(Usuario usuario) {
        if (usuario.getEdad() < 15) {
            throw new IllegalArgumentException("La edad debe ser mayor o igual a 15 años");
        }
        if (usuario.getEstatura() < 1.0 || usuario.getEstatura() > 2.5) {
            throw new IllegalArgumentException("La estatura debe estar entre 1.0 y 2.5 metros");
        }
        usuarioRepository.guardar(usuario);
    }

    public Usuario login(String nombreUsuario, String password) {
        Usuario usuario = usuarioRepository.buscarPorUsuario(nombreUsuario);
        if (usuario != null && usuario.getPassword().equals(password)) {
            return usuario;
        }
        return null;
    }
}
