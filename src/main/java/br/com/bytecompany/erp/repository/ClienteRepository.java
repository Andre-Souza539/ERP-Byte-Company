package br.com.bytecompany.erp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.bytecompany.erp.orm.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Integer>{

}
