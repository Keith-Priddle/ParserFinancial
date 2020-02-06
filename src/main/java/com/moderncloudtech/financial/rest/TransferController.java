package com.moderncloudtech.financial.rest;
/**
 * @author Keith Priddle www.moderncloudtech.com
 * @version 0.1d
 */
import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.moderncloudtech.financial.accounts.Transfer;
import com.moderncloudtech.financial.services.TransferServices;



@RestController
public class TransferController {

	private TransferServices transferServices;
	
	
	public TransferController(TransferServices transferServices) {
		super();
		this.transferServices = transferServices;
		}
	
	
	@RequestMapping(path="/Transfer", method=RequestMethod.GET)
	public String getAllTransfers(Model model) {
		model.addAttribute("transfers", this.transferServices);
		return "transfers";
	}
	
	@RequestMapping(path="/Transfer/list", method=RequestMethod.GET, produces = "application/json" )
	public ResponseEntity<List<Transfer>> getAllTransfers(){
		List<Transfer> transfers = transferServices.getTransfers();
		return new ResponseEntity<List<Transfer>>(transfers, HttpStatus.OK);
	}
	
	@RequestMapping(path="/Transfer/d/{destination}", method=RequestMethod.GET)
	public ResponseEntity<List<Transfer>> getByDestination(@PathVariable("destination") Long destination){
		
		List<Transfer> transfers = transferServices.getTransfersByDestination(destination);
		return new ResponseEntity<List<Transfer>>(transfers, HttpStatus.OK);
		
	}
	
	@RequestMapping(path="/Transfer/s/{destination}", method=RequestMethod.GET)
	public ResponseEntity<List<Transfer>> getBySource(@PathVariable("destination") Long destination, Sort sort){
		sort = Sort.by(Sort.Direction.DESC, "source");
		List<Transfer> transfers = transferServices.getTransfersBySource(destination, sort );
		return new ResponseEntity<List<Transfer>>(transfers, HttpStatus.OK);
	}
	
	@RequestMapping(path="/Transfer", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Transfer> createTransfer(@RequestBody Transfer transfer) throws IOException{
		this.transferServices.create(transfer);
		return new ResponseEntity<Transfer>(transfer, HttpStatus.CREATED);
	}
	
	
	//CurrencyService for fx Rates Test
//	@RequestMapping(path="/Currency", method=RequestMethod.GET)
//	public ResponseEntity<Currency> getCurrency() throws IOException {
//		Currency curr = currencyServices.getCurrency();
//		//System.out.println(this.currencyService.webClient.get().retrieve().t
//		
//		return new ResponseEntity<Currency>(curr,HttpStatus.OK);
//		
//	}


	
	
}
