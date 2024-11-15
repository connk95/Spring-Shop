package jp.co.sss.shop.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "items_with_categories")
@NamedQuery(name = "findByIdNamedQuery", query = "SELECT i FROM ItemWithCategory i WHERE i.id = :id")
public class ItemWithCategory {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_items_with_categories_gen")
	@SequenceGenerator(name = "seq_items_with_categories_gen", sequenceName = "seq_items_with_categories", allocationSize = 1)
	private Integer id;
	@Column
	private String name;
	@Column
	private Integer price;
	@ManyToOne
	@JoinColumn(name = "category_id", referencedColumnName = "id")
	private Category category;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}