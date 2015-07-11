package pl.waw.spending.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ExpenseItem {

	@Id
	@GeneratedValue
	private long id;
	
	@ManyToOne
	@JoinColumn
	private Category category;
	
	private String description;
	
	private BigDecimal amount;
	
	private LocalDate creationDate;
	
	@ManyToOne
	@JoinColumn
	private Spender spender;

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Spender getSpender() {
		return spender;
	}

	public void setSpender(Spender spender) {
		this.spender = spender;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}
	
}
