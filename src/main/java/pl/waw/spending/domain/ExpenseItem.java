package pl.waw.spending.domain;

import java.math.BigDecimal;

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
	
	@ManyToOne
	@JoinColumn
	private ExpenseSource source;

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

	public ExpenseSource getSource() {
		return source;
	}

	public void setSource(ExpenseSource source) {
		this.source = source;
	}
}
