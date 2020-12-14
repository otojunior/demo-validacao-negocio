/**
 * 
 */
package br.org.otojunior.demo.rest;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
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
	public Map<String, List<ObjectError>> handleErrors(final ValidacaoNegocioException ex) {
		List<ObjectError> errors = ex
			.getErrors()
			.getAllErrors();
		errors.forEach(o -> log.error("Erro: {}", o.getCode()));
		return Collections.singletonMap("erros", errors);
	}
}
