package com.sanches.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sanches.application.entyties.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
	/**
	 * Lista por cnpj
	 * 
	 * @param cnpj
	 * @return Empresa
	 */
	Empresa findByCnpj(final String cnpj);

}
