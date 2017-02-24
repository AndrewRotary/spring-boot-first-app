package com.practica.phase2.dao;

import com.practica.phase2.model.Phone;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by student on 2/23/2017.
 */
public interface PhoneRepository extends CrudRepository<Phone, Integer> {
}
