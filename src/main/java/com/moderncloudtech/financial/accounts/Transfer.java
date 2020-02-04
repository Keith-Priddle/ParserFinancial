package com.moderncloudtech.financial.accounts;
/**
 * @author Keith Priddle www.moderncloudtech.com
 * @version 0.1d
 */
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="TRANSFER")
public class Transfer {


	@Id
	@Column(name="TRANSID")
	//@GeneratedValue(strategy = GenerationType.TABLE)
	private Long transId;
	
	@Column(name="SOURCE")
	private Long source;
	
	@Column(name="DESTINATION")
	private Long destination;
	
	@Column(name="AMOUNT")
	
	private BigDecimal amount;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="TIMESTAMP")
	private LocalDateTime timestamp;

	public Transfer() {
		
	}
	
	public Transfer(Long transId, Long source, Long destination, BigDecimal amount, String description, LocalDateTime timestamp) {
		this.transId = transId;
		this.source = source;
		this.destination = destination;
		this.amount = amount;
		this.description = description;
		this.timestamp = timestamp;
	}

	
	
	public Long getTransId() {
		return transId;
	}

	public void setTransId(Long transId) {
		this.transId = transId;
	}

	public Long getSource() {
		return source;
	}

	public void setSource(Long source) {
		this.source = source;
	}

	public Long getDestination() {
		return destination;
	}

	public void setDestination(Long destination) {
		this.destination = destination;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	
	
	
	
	
	
}
