package com.cecgil.springboot_greendogdelivery.entities;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "orders")
public class Order {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(optional = true)
	private Client client;

	@ManyToMany(cascade = CascadeType.ALL)
	private List<ItemOrder> itens;

	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date data;

	@Min(1)
	private Double valorTotal;

	public Order() {}

	public Order(Long id, Client client, List<ItemOrder> itens, Double valorTotal) {
		super();
		this.id = id;
		this.client = client;
		this.itens = itens;
		this.data = new Date();
		this.valorTotal = valorTotal;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Client getClient() {
		return client;
	}

	public void setCliente(Client client) {
		this.client = client;
	}

	public List<ItemOrder> getItens() {
		return itens;
	}

	public void setItens(List<ItemOrder> itens) {
		this.itens = itens;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ( (id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
        Order other = (Order) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", cliente=" + client + ", itens=" + itens + ", data=" + data + ", valorTotal=" + valorTotal + "]";
	}
}
