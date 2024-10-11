package com.talentoTech.communityNetwork;

import com.talentoTech.communityNetwork.entitys.TipoPublicacion;
import com.talentoTech.communityNetwork.repository.TipoPublicacionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.talentoTech.communityNetwork.entitys.Rol;
import com.talentoTech.communityNetwork.entitys.Usuario;
import com.talentoTech.communityNetwork.repository.UsuarioRepository;
import com.talentoTech.communityNetwork.repository.RolRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
class CommunityNetworkApplicationTests {
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private RolRepository rolRepository;

	@Autowired
	private TipoPublicacionRepository tipoPublicacionRepository;

	@Test
	void contextLoads() {
	}
	@Test
	void testCrearYRecuperarUsuario() {

		TipoPublicacion tipoPublicacion = new TipoPublicacion();
		tipoPublicacion.setNombreTipo("Servicios");
		tipoPublicacionRepository.save(tipoPublicacion);

		Rol rolUser = new Rol();
		rolUser.setNombreRol("User");
		rolRepository.save(rolUser);

		// Crear un nuevo usuario
		Usuario usuario = new Usuario("123456789", "Carlos", "Gomez", "3001234567", "carlos@gomez.com", "password123");
		Usuario usuario1 = new Usuario("123456786", "Luis", "Gomez", "3001234557", "lmazo@gomez.com", "password123");
		// Guardar el usuario en la base de datos
		usuarioRepository.save(usuario1);

		// Recuperar el usuario por su cédula
		Usuario encontrado = usuarioRepository.findById("123456789").orElse(null);

		// Verificar que el usuario se haya guardado y recuperado correctamente
		assertThat(encontrado).isNotNull();
		assertThat(encontrado.getNombre()).isEqualTo("Carlos");
	}
}
