package com.ADRA.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ADRA.entity.socias;

@Repository
public interface SociaRepository extends CrudRepository<socias, Long>{

}
