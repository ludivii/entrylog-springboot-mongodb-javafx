package com.luandias.entrylog_springboot_mongodb_javafx.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luandias.entrylog_springboot_mongodb_javafx.domain.Assistant;
import com.luandias.entrylog_springboot_mongodb_javafx.dto.AssistantDTO;
import com.luandias.entrylog_springboot_mongodb_javafx.repository.AssistantRepository;
import com.luandias.entrylog_springboot_mongodb_javafx.servicies.exception.ObjectNotFoundException;

@Service
public class AssistantService {

	@Autowired
	private AssistantRepository assistantRepository;

	public List<Assistant> findAll() {
		return assistantRepository.findAll();
	}

	public Assistant findById(String id) {
		Optional<Assistant> assistant = assistantRepository.findById(id);
		return assistant.orElseThrow(() -> new ObjectNotFoundException("Assistant not found!"));
	}

	public Assistant insert(Assistant assistant) {
		return assistantRepository.insert(assistant);
	}

	public void delete(String id) {
		findById(id);
		assistantRepository.deleteById(id);
	}

	public Assistant update(Assistant assistant) {
		Assistant newAssistant = findById(assistant.getId());
		updateData(newAssistant, assistant);
		return assistantRepository.save(newAssistant);
	}

	private void updateData(Assistant newAssistant, Assistant assistant) {
		newAssistant.setName(assistant.getName());
		newAssistant.setRg(assistant.getRg());
		newAssistant.setCpf(assistant.getCpf());
		newAssistant.setBirthdate(assistant.getBirthdate());

	}

	public Assistant fromDTO(AssistantDTO assistantDTO) {
		return new Assistant(assistantDTO.getId(), assistantDTO.getName(), assistantDTO.getRg(), assistantDTO.getCpf(),
				assistantDTO.getBirthdate());
	}
}
