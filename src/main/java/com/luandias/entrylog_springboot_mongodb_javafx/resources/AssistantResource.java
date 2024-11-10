package com.luandias.entrylog_springboot_mongodb_javafx.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.luandias.entrylog_springboot_mongodb_javafx.domain.Assistant;
import com.luandias.entrylog_springboot_mongodb_javafx.dto.AssistantDTO;
import com.luandias.entrylog_springboot_mongodb_javafx.servicies.AssistantService;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping(value = "/assistants")
public class AssistantResource {

	@Autowired
	private AssistantService assistantService;

	@GetMapping
	public ResponseEntity<List<AssistantDTO>> findAll() {
		List<Assistant> list = assistantService.findAll();
		List<AssistantDTO> listDTO = list.stream().map(x -> new AssistantDTO(x)).toList();
		return ResponseEntity.ok().body(listDTO);
	}

	@SuppressWarnings("rawtypes")
	@GetMapping(value = "/{id}")
	public ResponseEntity AssistantDTO(@PathVariable String id) {
		Assistant assistant = assistantService.findById(id);
		return ResponseEntity.ok().body(assistant);
	}

	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody AssistantDTO assistantDTO) {
		Assistant assistant = assistantService.fromDTO(assistantDTO);
		assistant = assistantService.insert(assistant);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(assistant.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		assistantService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@PathVariable String id, @RequestBody AssistantDTO assistantDTO) {
		Assistant assistant = assistantService.fromDTO(assistantDTO);
		assistant.setId(id);
		assistant = assistantService.update(assistant);
		return ResponseEntity.noContent().build();
	}

}
