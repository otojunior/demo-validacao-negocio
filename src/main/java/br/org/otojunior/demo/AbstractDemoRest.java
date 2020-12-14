/**
 * 
 */
package br.org.otojunior.demo;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.extern.slf4j.Slf4j;

/**
 * @author otoju
 *
 */
@Slf4j
public abstract class AbstractDemoRest {
	@Autowired
	private ResourceBundle res;
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ValidacaoNegocioException.class)
	public Map<String, List<ObjectError>> handleErrors(final ValidacaoNegocioException ex) {
		List<ObjectError> errors = ex
			.getErrors()
			.getAllErrors();
		errors.forEach(o -> log.error(
			"ERRO: [objectName={}, code={}, msg={}, str={}]",
			o.getObjectName(),
			o.getCode(),
			o.getDefaultMessage(),
			res.getString(o.getCode())));
		return Collections.singletonMap("erros", errors);
	}

	/**
	 * 
	 * @return
	 */
	@Bean
	public ResourceBundle getResourceBundle() {
		return ResourceBundle.getBundle("messages");
	}
}
