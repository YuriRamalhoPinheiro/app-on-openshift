package br.com.yuriramalhopinheiro;

import javax.enterprise.context.Dependent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.cdi.Eager;


@Dependent
@Eager
public interface Repository extends JpaRepository<Produto, Long>{
	
}
