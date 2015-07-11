package pl.waw.spending.repository;

import org.springframework.data.repository.CrudRepository;

import pl.waw.spending.domain.Spender;

public interface SpenderRepository extends CrudRepository<Spender, Long>{

}
