/**
 * 
 */
package br.org.otojunior.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.otojunior.demo.entidade.Pessoa;
import br.org.otojunior.demo.service.PessoaService;

/**
 * @author otoju
 *
 */
@RestController
@RequestMapping("/api")
public class PessoaRest extends AbstractDemoRest {
	@Autowired
	private PessoaService service;
	
	/**
	 * 
	 * @param dto
	 * @return
	 */
	@PostMapping("/pessoa")
	public ResponseEntity<Pessoa> inserir(@RequestBody PessoaDto dto) {
		Pessoa entidade = new Pessoa();
		entidade.setCodigo(dto.getCodigo());
		entidade.setNome(dto.getNome());
		
		Pessoa retorno = service.inserir(entidade);
		return ResponseEntity.ok(retorno);
	}
	
	/**
	 * 
	 * @param dto
	 * @return
	 */
	@GetMapping("/pessoa")
	public ResponseEntity<List<Pessoa>> listar() {
		List<Pessoa> retorno = service.listar();
		return ResponseEntity.ok(retorno);
	}
}
