package com.anajulia.modulo22;

import com.anajulia.entidades.Usuario;
import com.anajulia.repositorios.UsuarioRepositorio;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class Application implements CommandLineRunner {
	private final PasswordEncoder encoder;
	private final UsuarioRepositorio usuarioRepositorio;

	public Application(PasswordEncoder encoder, UsuarioRepositorio usuarioRepositorio) {
		this.encoder = encoder;
		this.usuarioRepositorio = usuarioRepositorio;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Usuario system = new Usuario(
				"12",
				"sistema",
				"123"
		);

		usuarioRepositorio.salvar(system);
	}
}
