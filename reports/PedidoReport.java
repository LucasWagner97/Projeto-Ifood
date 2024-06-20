package com.projeto.ifood.reports;

import java.io.ByteArrayOutputStream;
import java.util.List;

import org.apache.commons.io.IOUtils;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;
import com.projeto.ifood.dtos.PedidoDTO;

public class PedidoReport {

private List<PedidoDTO> lista;
	
	private static Font FONT_TITULO = new Font(Font.FontFamily.TIMES_ROMAN, 25, Font.BOLD);
	
	public PedidoReport(List<PedidoDTO> lista){
		
		this.lista = lista;
		
	}
	
	public byte[] createPDF() {
		
		
		try {
			
			Document documento = new Document(PageSize.A4);
			documento.setMargins(20, 20, 20, 20);
			
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			PdfWriter.getInstance(documento, stream);
			
			documento.open();
			
			Image logo = Image.getInstance(
					IOUtils.toByteArray(
							getClass().getResourceAsStream("/static/imagens/baixados.jpeg")));
					
			documento.add(logo);
			
			
			Paragraph titulo = new Paragraph();
			Phrase phrase = new Phrase("Relatorio de Pedido");
			titulo.add(phrase);
			titulo.setAlignment(Element.ALIGN_CENTER);
			titulo.setSpacingAfter(20);
			
			
			documento.add(titulo);
			
			for(PedidoDTO pedidoDTO: lista) {
				Paragraph dados = new Paragraph();
				dados.add("Codigo: "+pedidoDTO.getIdPedido() + "\n");
				dados.add("Numero: "+pedidoDTO.getNumeroPedido() + "\n");
				dados.add("Endereco: "+pedidoDTO.getEnderecoPedido() + "\n");
				dados.add("Preco: "+pedidoDTO.getPrecoPedido() + "\n");
				dados.add("Acompanhamento: "+pedidoDTO.getAcompanhamentoPedido() + "\n");
				dados.add("Cupom: "+pedidoDTO.getCupomPedido() + "\n");
				dados.add("Telefone: "+pedidoDTO.getTelefonePedido() + "\n");
				
				dados.setSpacingAfter(5);
				documento.add(dados);
				
			}
			
					
			documento.close();
					
			return stream.toByteArray();
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
