package com.linkin.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "price")
	private Long price;

	@Column(name = "image")
	private String image;

	@Column(name = "description")
	private String description;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
	@Column(name = "review")
	private List<Review> review;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
	@Column(name = "comments")
	private List<Comment> comments;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	@ManyToOne
	@JoinColumn(name = "thuongHieu_id")
	private ThuongHieu thuongHieu;

	@ManyToOne
	@JoinColumn(name = "kichThuoc_id")
	private KichThuoc kichThuoc;

	@ManyToOne
	@JoinColumn(name = "gioiTinh_id")
	private GioiTinh gioiTinh;

	public Product(Long id) {
		super();
		this.id = id;

	}

	public Product() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public GioiTinh getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(GioiTinh gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Review> getReview() {
		return review;
	}

	public void setReview(List<Review> review) {
		this.review = review;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public ThuongHieu getThuongHieu() {
		return thuongHieu;
	}

	public void setThuongHieu(ThuongHieu thuongHieu) {
		this.thuongHieu = thuongHieu;
	}

	public KichThuoc getKichThuoc() {
		return kichThuoc;
	}

	public void setKichThuoc(KichThuoc kichThuoc) {
		this.kichThuoc = kichThuoc;
	}

}
