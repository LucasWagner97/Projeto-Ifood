package com.projeto.ifood.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.ifood.dtos.PedidoDTO;
import com.projeto.ifood.entities.Pedido;
import com.projeto.ifood.reports.PedidoReport;
import com.projeto.ifood.repositories.PedidoRepository;

@Service
public class PedidoService {
	
		@Autowired
		private PedidoRepository pedidoRepository;
		
		public void salvar(PedidoDTO pedidoDTO) throws Exception{
			Pedido pedido = new Pedido();
			pedido.setId(pedidoDTO.getIdPedido());
			pedido.setNumero(pedidoDTO.getNumeroPedido());
			pedido.setEndereco(pedidoDTO.getEnderecoPedido());
			pedido.setPreco(pedidoDTO.getPrecoPedido());
			pedido.setAcompanhamento(pedidoDTO.getAcompanhamentoPedido());
			pedido.setCupom(pedidoDTO.getCupomPedido());
			pedido.setTelefone(pedidoDTO.getTelefonePedido());
			pedido.setImagem(pedidoDTO.getImagemPedido());
			pedidoRepository.save(pedido);
		}
		
	    public List<PedidoDTO> listarTodos(){
	    	List<Pedido> lista = pedidoRepository.findAll();
	    	List<PedidoDTO> listaDTO = new ArrayList<>();
	    	for(Pedido pedido: lista) {
	    		PedidoDTO pedidoDTO = new PedidoDTO();
	    		pedidoDTO.setIdPedido(pedido.getId());
	    		pedidoDTO.setNumeroPedido(pedido.getNumero());
	    		pedidoDTO.setEnderecoPedido(pedido.getEndereco());
	    		pedidoDTO.setPrecoPedido(pedido.getPreco());
	    		pedidoDTO.setAcompanhamentoPedido(pedido.getAcompanhamento());
	    		pedidoDTO.setCupomPedido(pedido.getCupom());
	    		pedidoDTO.setTelefonePedido(pedido.getTelefone());
	    		pedidoDTO.setImagemPedido(pedido.getImagem());
	    		listaDTO.add(pedidoDTO);
	    	}
	    	return listaDTO;
	    }
		
	    public void excluir(Long id)throws Exception {
	    	Pedido pedido = pedidoRepository.findById(id).get();
	    	if(pedido != null) {
	    		pedidoRepository.delete(pedido);
	    	}
	    	
	    }
	    
	    public byte[] gerarRelatorio() {
	    	return new PedidoReport(listarTodos()).createPDF();
	    }
	    
	

}
