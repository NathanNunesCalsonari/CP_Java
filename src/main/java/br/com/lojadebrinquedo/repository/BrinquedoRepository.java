package br.com.lojadebrinquedo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lojadebrinquedo.entity.Brinquedo;

@Repository
public interface BrinquedoRepository extends JpaRepository<Brinquedo, Long> {
}

