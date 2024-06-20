package com.projeto.ifood.dtos;

public class PedidoDTO {
		
		private Long idPedido;
		private Integer numeroPedido;
		private String enderecoPedido;
		private Double precoPedido;
		private Boolean acompanhamentoPedido;
		private Boolean cupomPedido;
		private Integer telefonePedido;
		private String imagemPedido;
		
		public Long getIdPedido() {
			return idPedido;
		}
		public void setIdPedido(Long idPedido) {
			this.idPedido = idPedido;
		}
		public Integer getNumeroPedido() {
			return numeroPedido;
		}
		public void setNumeroPedido(Integer numeroPedido) {
			this.numeroPedido = numeroPedido;
		}
		public String getEnderecoPedido() {
			return enderecoPedido;
		}
		public void setEnderecoPedido(String enderecoPedido) {
			this.enderecoPedido = enderecoPedido;
		}
		public Double getPrecoPedido() {
			return precoPedido;
		}
		public void setPrecoPedido(Double precoPedido) {
			this.precoPedido = precoPedido;
		}
		public Boolean getAcompanhamentoPedido() {
			return acompanhamentoPedido;
		}
		public void setAcompanhamentoPedido(Boolean acompanhamentoPedido) {
			this.acompanhamentoPedido = acompanhamentoPedido;
		}
		public Boolean getCupomPedido() {
			return cupomPedido;
		}
		public void setCupomPedido(Boolean cupomPedido) {
			this.cupomPedido = cupomPedido;
		}
		public Integer getTelefonePedido() {
			return telefonePedido;
		}
		public void setTelefonePedido(Integer telefonePedido) {
			this.telefonePedido = telefonePedido;
		}
		public String getImagemPedido() {
			return imagemPedido;
		}
		public void setImagemPedido(String imagemPedido) {
			this.imagemPedido = imagemPedido;
		}
		

}
		