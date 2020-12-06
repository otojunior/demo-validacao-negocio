/**
 * 
 */
package br.org.otojunior.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author otoju
 *
 */
@RestController
@RequestMapping("/api")
public class DemoRest {
	@Autowired
	private DemoService service;
	
	/**
	 * 
	 * @param dto
	 * @return
	 */
	@PostMapping("/demo")
	public ResponseEntity<DemoEntidade> inserir(@RequestBody DemoDto dto) {
		DemoEntidade entidade = new DemoEntidade();
		entidade.setCodigo(dto.getCodigo());
		entidade.setNome(dto.getNome());
		
		DemoEntidade retorno = service.inserir(entidade);
		return ResponseEntity.ok(retorno);
	}
	
	/**
	 * 
	 * @param dto
	 * @return
	 */
	@GetMapping("/demo")
	public ResponseEntity<List<DemoEntidade>> listar() {
		List<DemoEntidade> retorno = service.listar();
		return ResponseEntity.ok(retorno);
	}
}
