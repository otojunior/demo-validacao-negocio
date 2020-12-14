/**
 * 
 */
package br.org.otojunior.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * @author otoju
 *
 */
public abstract class AbstractDemoService<E> {
	/**
	 * 
	 * @param entidade
	 * @throws ValidacaoNegocioException 
	 */
	public E salvar(
			final E entidade,
			final Validator validator,
			final JpaRepository<E, Long> repositorio) {
		if (validator != null) {
			validar(entidade, validator);
		}
		return repositorio.saveAndFlush(entidade);
	}

	/**
	 * @param entidade
	 * @param classeValidator
	 */
	public void validar(
			final E entidade,
			final Validator validator) {
		Errors errors = new BeanPropertyBindingResult(
			entidade,
			entidade.getClass().getSimpleName());
		
		ValidationUtils.invokeValidator(
			validator,
			entidade,
			errors);
		
		if (errors.hasErrors()) {
			throw new ValidacaoNegocioException(errors);
		}
	}
}
