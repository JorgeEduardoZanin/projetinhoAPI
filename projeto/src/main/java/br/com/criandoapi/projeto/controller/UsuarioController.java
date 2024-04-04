package br.com.criandoapi.projeto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.criandoapi.projeto.entities.Usuario;
import br.com.criandoapi.projeto.repository.IUsuario;

@RestController
@CrossOrigin("*")
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private IUsuario jdbc;

	@GetMapping
	public ResponseEntity<List<Usuario>> ListaUsuarios() {
		List<Usuario> lista = (List<Usuario>) jdbc.findAll();
		return ResponseEntity.ok().body(lista);
	}

	@PostMapping
	public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario usuario) {
		Usuario usuarioNovo = jdbc.save(usuario);
		return ResponseEntity.ok().body(usuarioNovo);
	}

	@PutMapping
	public ResponseEntity<Usuario> editarUsuario(@RequestBody Usuario usuario) {
		Usuario usuarioNovo = jdbc.save(usuario);
		return ResponseEntity.ok().body(usuarioNovo);
	}
	
	@DeleteMapping("/{id}")
	public Optional <Usuario> deleteUsuario(@PathVariable Long id) {
		Optional <Usuario>usuario =jdbc.findById(id);
		jdbc.deleteById(id);
		return usuario;
	}
}
