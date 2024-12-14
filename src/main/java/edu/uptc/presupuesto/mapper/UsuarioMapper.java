package edu.uptc.presupuesto.mapper;

import edu.uptc.presupuesto.dto.UsuarioDTO;
import edu.uptc.presupuesto.model.Usuario;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UsuarioMapper {
    public UsuarioDTO toDTO(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(usuario.getId());
        dto.setUsername(usuario.getUsername());
        dto.setEmail(usuario.getEmail());
        dto.setRol(usuario.getRol());
        dto.setActivo(usuario.isActivo());
        dto.setUltimoAcceso(usuario.getUltimoAcceso());
        return dto;
    }

    public Usuario toEntity(UsuarioDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setId(dto.getId());
        usuario.setUsername(dto.getUsername());
        usuario.setEmail(dto.getEmail());
        usuario.setRol(dto.getRol());
        usuario.setActivo(dto.isActivo());
        usuario.setUltimoAcceso(dto.getUltimoAcceso());
        return usuario;
    }

    public List<UsuarioDTO> toDTOs(Iterable<Usuario> usuarios) {
        List<Usuario> usuarioList = new ArrayList<>();
        usuarios.forEach(usuarioList::add);
        return usuarioList.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}