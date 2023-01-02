package com.milton.auth2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.milton.auth2.model.Utility;


@Repository
public interface UtilityRespository extends JpaRepository<Utility, Integer>{

	Utility findByUtilityName(String utilityName);
}
