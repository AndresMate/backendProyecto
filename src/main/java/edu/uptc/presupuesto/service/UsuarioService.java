package edu.uptc.presupuesto.service;

import edu.uptc.presupuesto.dto.UsuarioDTO;
import edu.uptc.presupuesto.mapper.UsuarioMapper;
import edu.uptc.presupuesto.model.Usuario;
import edu.uptc.presupuesto.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private UsuarioMapper mapper;

    public UsuarioDTO crearUsuario(UsuarioDTO dto) {
        Usuario usuario = mapper.toEntity(dto);
        Usuario savedUsuario = repository.save(usuario);
        return mapper.toDTO(savedUsuario);
    }

    public UsuarioDTO obtenerUsuarioPorUsername(String username) {
        Usuario usuario = repository.findByUsername(username);
        return mapper.toDTO(usuario);
    }

    public Iterable<UsuarioDTO> obtenerUsuarios() {
        Iterable<Usuario> usuarios = repository.findAll();
        return mapper.toDTOs(usuarios);
    }
}