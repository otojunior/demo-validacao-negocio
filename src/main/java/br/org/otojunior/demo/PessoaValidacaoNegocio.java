/**
 * 
 */
package br.org.otojunior.demo;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import lombok.extern.slf4j.Slf4j;

/**
 * @author otoju
 *
 */
@Slf4j
@Component
public class PessoaValidacaoNegocio implements Validator {
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		return Pessoa.class.isAssignableFrom(clazz);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void validate(Object target, Errors errors) {
		Pessoa pessoa = (Pessoa)target;
		validarCodigo(pessoa, errors);
		validarNome(pessoa, errors);
	}

	/**
	 * 
	 * @param pessoa
	 * @param errors
	 */
	private void validarCodigo(final Pessoa pessoa, final Errors errors) {
		log.debug("Pessoa[codigo={}]", pessoa.getCodigo());
		if (pessoa.getCodigo().intValue() <= 0) {
			errors.rejectValue("codigo", "pessoa.codigo.negativo");
		}
	}

	/**
	 * 
	 * @param pessoa
	 * @param errors
	 */
	private void validarNome(final Pessoa pessoa, final Errors errors) {
		log.debug("Pessoa[nome={}]", pessoa.getNome());
		ValidationUtils.rejectIfEmpty(errors, "nome", "pessoa.nome.vazio");
		if (pessoa.getNome() != null && pessoa.getNome().length() < 3) {
			errors.rejectValue("nome", "pessoa.nome.tamanhoInvalido");
		}
	}
}
