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

import com.luandias.entrylog_springboot_mongodb_javafx.domain.EntryLog;
import com.luandias.entrylog_springboot_mongodb_javafx.dto.EntryLogDTO;
import com.luandias.entrylog_springboot_mongodb_javafx.servicies.EntryLogService;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping(value = "/entrylogs")
public class EntryLogResource {

	@Autowired
	private EntryLogService entryLogService;

	@GetMapping
	public ResponseEntity<List<EntryLogDTO>> findAll() {
		List<EntryLog> list = entryLogService.findAll();
		List<EntryLogDTO> listDTO = list.stream().map(x -> new EntryLogDTO(x)).toList();
		return ResponseEntity.ok().body(listDTO);
	}

	@SuppressWarnings("rawtypes")
	@GetMapping(value = "/{id}")
	public ResponseEntity EntryLogDTO(@PathVariable String id) {
		EntryLog entryLog = entryLogService.findById(id);
		return ResponseEntity.ok().body(entryLog);
	}

	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody EntryLogDTO entryLogDTO) {
		EntryLog entryLog = entryLogService.fromDTO(entryLogDTO);
		entryLog = entryLogService.insert(entryLog);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(entryLog.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		entryLogService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@PathVariable String id, @RequestBody EntryLogDTO entryLogDTO) {
		EntryLog entryLog = entryLogService.fromDTO(entryLogDTO);
		entryLog.setId(id);
		entryLog = entryLogService.update(entryLog);
		return ResponseEntity.noContent().build();
	}

}
