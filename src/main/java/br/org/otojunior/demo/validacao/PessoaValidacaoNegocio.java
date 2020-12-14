/**
 * 
 */
package br.org.otojunior.demo.validacao;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import br.org.otojunior.demo.entidade.Pessoa;
import lombok.extern.slf4j.Slf4j;

/**
 * @author otoju
 *
 */
@Slf4j
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PessoaValidacaoNegocio extends AbstractDemoValidacaoNegocio {
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
	private void validarCodigo(Pessoa pessoa, Errors errors) {
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
	private void validarNome(Pessoa pessoa, Errors errors) {
		log.debug("Pessoa[nome={}]", pessoa.getNome());
		ValidationUtils.rejectIfEmpty(errors, "nome", "pessoa.nome.vazio");
		if (pessoa.getNome() != null && pessoa.getNome().length() < 3) {
			errors.rejectValue("nome", "pessoa.nome.tamanhoInvalido");
		}
	}
}
