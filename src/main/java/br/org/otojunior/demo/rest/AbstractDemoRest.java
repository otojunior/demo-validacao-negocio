/**
 * 
 */
package br.org.otojunior.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.org.otojunior.demo.validacao.ValidacaoNegocioException;
import lombok.extern.slf4j.Slf4j;

/**
 * @author otoju
 *
 */
@Slf4j
public class AbstractDemoRest {
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ValidacaoNegocioException.class)
	public String handleErrors(final ValidacaoNegocioException ex) {
		ex.getErrors()
			.getAllErrors()
			.forEach(o -> log.error("Erro: {}", o.getCode()));
		return null;
	}
}
