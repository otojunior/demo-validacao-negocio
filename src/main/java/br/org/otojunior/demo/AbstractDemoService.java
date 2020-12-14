/**
 * 
 */
package br.org.otojunior.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
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
	@Autowired
	private ApplicationContext context;
	
	/**
	 * 
	 * @param entidade
	 * @throws ValidacaoNegocioException 
	 */
	public E salvar(
			final E entidade,
			final Class<? extends Validator> classeValidator,
			final JpaRepository<E, Long> repositorio) throws ValidacaoNegocioException {
		if (classeValidator != null) {
			validar(entidade, classeValidator);
		}
		return repositorio.saveAndFlush(entidade);
	}

	/**
	 * @param entidade
	 * @param classeValidator
	 */
	public void validar(
			final E entidade,
			final Class<? extends Validator> classeValidator) {
		Errors errors = new BeanPropertyBindingResult(
			entidade,
			entidade.getClass().getSimpleName());
		
		ValidationUtils.invokeValidator(
			context.getBean(classeValidator),
			entidade,
			errors);
		
		if (errors.hasErrors()) {
			throw new ValidacaoNegocioException(errors);
		}
	}
}
