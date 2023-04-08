package ch06_sll.ex02.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name="ch06_sll_ex02_CategoryH")
@Table(name = "ch04_Category")
public class CategoryH implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer categoryId;
	private String name;
	private String desciption;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
//	@OneToMany(fetch = FetchType.EAGER, mappedBy = "category")
	private Set<ProductEntityH> products; 

	public CategoryH() {
	}

	public CategoryH(String name, String desc) {
		this.name = name;
		this.desciption = desc;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesciption() {
		return desciption;
	}

	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}

	public Set<ProductEntityH> getProducts() {
		return products;
	}

	public void setProducts(Set<ProductEntityH> products) {
		this.products = products;
	}
}