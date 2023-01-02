package com.milton.auth2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.milton.auth2.model.Utility;
import com.milton.auth2.repository.UtilityRespository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UtilityServiceImpl implements UtilityService{

	@Autowired
	UtilityRespository utilityRespository;

	@Override
	public void save(Utility utility) {
		log.info("saving utility");
		utilityRespository.save(utility);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public Optional<Utility> update(int utilityId, Utility utility) {
		return utilityRespository.findById(utilityId);

	}

	@Override
	public void delete(int utilityId) {
		utilityRespository.deleteById(utilityId);
	}

	@Override
	public List<Utility> getUtilities() {
		List<Utility> utilitys = utilityRespository.findAll();
		return utilitys;
	}

	@Override
	public Optional<Utility> getUtilityById(int utilityId) {
		return utilityRespository.findById(utilityId);
	}

	@Override
	public Utility getUtilityByUtilityName(String utilityName) {
		return utilityRespository.findByUtilityName(utilityName);
	}

}
