package br.com.benefrancis.pessoal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.benefrancis.pessoal.model.Phone;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Long> {

}
