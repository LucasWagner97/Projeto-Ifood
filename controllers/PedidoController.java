package com.projeto.ifood.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.ifood.services.PedidoService;
import com.projeto.ifood.dtos.PedidoDTO;
import com.projeto.ifood.enums.MensagemEnum;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/pedido")
@Tag(name = "Pedidos", description = "Ifood API")
public class PedidoController {
		
		@Autowired
		private PedidoService pedidoService;
		
		@GetMapping("/listar")
		public List<PedidoDTO> listarTodos(){
			return pedidoService.listarTodos();
		}
		
		@PostMapping("/salvar")
		@Operation(summary = "", description = "Salvar dados de pedido na base de dados.")
	    @ApiResponse(responseCode = "200", description = "Sucesso")
	    @ApiResponse(responseCode = "404", description = "Não encontrado")


		public ResponseEntity salvar(@RequestBody PedidoDTO pedidoDTO) {
			try {
				pedidoService.salvar(pedidoDTO);
				return ResponseEntity.ok(MensagemEnum.CADASTRADO.getDescricao());
			}catch (Exception e) {
				 return ResponseEntity.badRequest().body(e.getMessage());
			}
		}

		@PostMapping("/excluir/{id}")
		@Operation(summary = "", description = "Excluir dados do pedido")
	    @ApiResponse(responseCode = "200", description = "Sucesso")
	    @ApiResponse(responseCode = "404", description = "Não encontrado")


		public ResponseEntity excluir(@PathVariable Long id) {
			try {
				pedidoService.excluir(id);
				return ResponseEntity.ok(MensagemEnum.EXCLUIDO.getDescricao());
			}catch (Exception e) {
				 return ResponseEntity.badRequest().body(e.getMessage());
			}
		}

		@GetMapping("/gerar/relatorio")
		@Operation(summary = "", description = "Realizar download do relatorio em PDF.")
		public ResponseEntity gerarRelatorio() {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_PDF);
			headers.setContentDispositionFormData(
					"attachment", "pedido.pdf");
			return ResponseEntity.ok().headers(headers)
					.body(pedidoService.gerarRelatorio());
		}
		
		@GetMapping("/gerar/relatorio/{id}")
		@Operation(summary = "", description = "Realizar download do relatorio em PDF.")
		public ResponseEntity gerarRelatorio(@PathVariable Long id) {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_PDF);
			headers.setContentDispositionFormData(
					"attachment", "pedido.pdf");
			return ResponseEntity.ok().headers(headers)
					.body(pedidoService.gerarRelatorio());
		}
		

}
