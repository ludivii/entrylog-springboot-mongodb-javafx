package com.luandias.entrylog_springboot_mongodb_javafx.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luandias.entrylog_springboot_mongodb_javafx.domain.EntryLog;
import com.luandias.entrylog_springboot_mongodb_javafx.dto.EntryLogDTO;
import com.luandias.entrylog_springboot_mongodb_javafx.repository.EntryLogRepository;
import com.luandias.entrylog_springboot_mongodb_javafx.servicies.exception.ObjectNotFoundException;

@Service
public class EntryLogService {

	@Autowired
	private EntryLogRepository entryLogRepository;

	public List<EntryLog> findAll() {
		return entryLogRepository.findAll();
	}

	public EntryLog findById(String id) {
		Optional<EntryLog> entryLog = entryLogRepository.findById(id);
		return entryLog.orElseThrow(() -> new ObjectNotFoundException("EntryLog not found!"));
	}

	public EntryLog insert(EntryLog entryLog) {
		return entryLogRepository.insert(entryLog);
	}

	public void delete(String id) {
		findById(id);
		entryLogRepository.deleteById(id);
	}

	public EntryLog update(EntryLog entryLog) {
		EntryLog newEntryLog = findById(entryLog.getId());
		updateData(newEntryLog, entryLog);
		return entryLogRepository.save(newEntryLog);
	}

	private void updateData(EntryLog newEntryLog, EntryLog entryLog) {
		newEntryLog.setMoment(entryLog.getMoment());
		newEntryLog.setCompany(entryLog.getCompany());
		newEntryLog.setCargo(entryLog.getCargo());
		newEntryLog.setStatus(entryLog.getStatus());
	}

	public EntryLog fromDTO(EntryLogDTO entryLogDTO) {
		return new EntryLog(entryLogDTO.getId(), entryLogDTO.getMoment(), entryLogDTO.getCompany(),
				entryLogDTO.getCargo(), entryLogDTO.getStatus());
	}
}
