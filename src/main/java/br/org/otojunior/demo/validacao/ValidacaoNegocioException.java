/**
 * 
 */
package br.org.otojunior.demo.validacao;

import org.springframework.validation.Errors;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author otoju
 *
 */
@Getter
@AllArgsConstructor
public class ValidacaoNegocioException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	private Errors errors;
}
