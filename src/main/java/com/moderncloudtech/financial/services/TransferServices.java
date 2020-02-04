package com.moderncloudtech.financial.services;
/**
 * @author Keith Priddle www.moderncloudtech.com
 * @version 0.1d
 */
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.moderncloudtech.financial.accounts.Account;
import com.moderncloudtech.financial.accounts.Transfer;
import com.moderncloudtech.financial.repositories.TransferRepository;

@Service
public class TransferServices 	{
	
	@Autowired
	private TransferRepository transferRepository;
	public TransferServices(TransferRepository transferRepository) {
		super();
		this.transferRepository = transferRepository;
	}
	
	public List<Transfer> getTransfersByDestination(Long destination){
		List<Transfer> transfers = new ArrayList<>();
		this.transferRepository.findByDestination(destination).forEach(transfers::add);
		return transfers;
	}
	
	public List<Transfer> getTransfersBySource(Long destination, Sort sort){
		List<Transfer> transfers = new ArrayList<>();
		this.transferRepository.findBySource(destination, sort).forEach(transfers::add);
		return transfers;
	}
	
	public List<Transfer> getAllTransfers(){
		List<Transfer> transfers = new ArrayList<>();
		this.transferRepository.findAll().forEach(transfers::add);
		return transfers;
	}
	
	
	public Transfer getTransferById(Long transferId) {
		Transfer transfer = this.transferRepository.findById(transferId).get();
		return transfer;
	}
	
	public List<Transfer> getTransfers(){
		List<Transfer> transfers = new ArrayList<>();
		this.transferRepository.getTransfers().forEach(transfers::add);
		return transfers;
	}
	
	@Transactional
	public ResponseEntity<Transfer> create(Transfer transfer) throws IOException {
		ResponseEntity<Transfer> response;
		/**
		 * new transfer process
		 * Streamlined and removed all sub routines which were unneccesary 
		 **/
		Account src = transferRepository.getAccountById(transfer.getSource());
		Account dest = transferRepository.getAccountById(transfer.getDestination());
		
		BigDecimal transactionCurrencyRate = getCurrencyRateForTransfer(src.getCurrency(),dest.getCurrency());
		
		//Currency Conversion Function
		BigDecimal currencyAmount1 = transfer.getAmount().divide(transactionCurrencyRate, 2, RoundingMode.HALF_DOWN);
		transfer.setDescription(transfer.getDescription().toString() + "(" + transfer.getAmount().toString()+ " @ " + transactionCurrencyRate.toString() + ")");
		
		if (src.isActive()&&dest.isActive()) {
			//Process to update the account balances
			//updateAccountBalances(sourceAccountId, destinationAccountId, currencyAmount, transfer.getAmount());
			src.setBalance(src.getBalance().subtract(transfer.getAmount()));
			dest.setBalance(dest.getBalance().add(currencyAmount1));
			//update the transaction time stamp
			transfer.setTimestamp(LocalDateTime.now());
			this.transferRepository.save(transfer);
			response = new ResponseEntity<Transfer>(transfer, HttpStatus.OK);
		} else {
			response = new ResponseEntity<Transfer>(transfer, HttpStatus.PRECONDITION_FAILED);
			System.out.println("Transfer not saved --- Accounts not active");
		}
			
		
		return response;
		
		}
		

		public BigDecimal getCurrencyRateForTransfer(String base, String curr) throws IOException {
			ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			JsonNode currencyNode = mapper.readTree(
					new URL("https://api.exchangeratesapi.io/latest?base=" + base + "&symbols=" + curr));
			BigDecimal rate = currencyNode.get("rates").get(curr).decimalValue();
						
			return rate;
		}
}
