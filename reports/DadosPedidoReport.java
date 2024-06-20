package com.projeto.ifood.reports;

import java.io.ByteArrayOutputStream;

import org.apache.commons.io.IOUtils;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.projeto.ifood.dtos.PedidoDTO;

public class DadosPedidoReport {

	
	private PedidoDTO pedidoDTO;
	
	private static Font FONT_TITULO = new Font(Font.FontFamily.TIMES_ROMAN, 25, Font.BOLD);
	
	public DadosPedidoReport(PedidoDTO pedidoDTO){
		
		this.pedidoDTO = pedidoDTO;
		
	}
	
	public byte[] createPDF() {
		
		
		try {
			
			Document documento = new Document(PageSize.A4);
			documento.setMargins(20, 20, 20, 20);
			
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			PdfWriter.getInstance(documento, stream);
			
			documento.open();
			
			Image imagem = Image.getInstance(
					IOUtils.toByteArray(
							getClass().getResourceAsStream("/static/imagens/"+pedidoDTO.getImagemPedido())));
			imagem.setAlignment(Element.ALIGN_CENTER);
					
			documento.add(imagem);
			
			
			
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
				
					
			documento.close();
					
			return stream.toByteArray();
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}





