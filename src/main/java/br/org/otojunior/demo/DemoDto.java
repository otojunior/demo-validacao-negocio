/**
 * 
 */
package br.org.otojunior.demo;

import java.io.Serializable;

import javax.validation.constraints.AssertTrue;

import org.springframework.validation.annotation.Validated;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author otoju
 *
 */
@Getter
@Setter
@Slf4j
@Validated
public class DemoDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer codigo;
	private String nome;
	
	@AssertTrue
	public boolean validarCodigo() {
		log.info("validarCodigo");
		return true;
	}
	
	@AssertTrue
	public boolean validarNome() {
		log.info("validarNome");
		return true;
	}
}
