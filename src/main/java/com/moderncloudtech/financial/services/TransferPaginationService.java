package com.moderncloudtech.financial.services;
/**
 * @author Keith Priddle www.moderncloudtech.com
 * @version 0.1d
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.moderncloudtech.financial.accounts.Transfer;
import com.moderncloudtech.financial.repositories.PageableTransferRepository;

@Service
public class TransferPaginationService {

	@Autowired
	private  PageableTransferRepository pageableTransferRepository;
	
	
	@RequestMapping(path="/", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public Page<Transfer> findTransferByCondition(String orderBy, String direction,int page,  int size) {
		Sort sort = null;
		Pageable pageable = PageRequest.of(page, size, sort);
		if (orderBy.equals("source")) {
			if (direction.equals("ASC")) {
				pageable = PageRequest.of(0, 3, Sort.by("source").ascending());
			}
			if (direction.equals("DESC")) {
				pageable = PageRequest.of(0, 3, Sort.by("source").descending());
			}
		} else if (orderBy.equals("currency")){
			if (direction.equals("ASC")) {
				pageable = PageRequest.of(0, 3, Sort.by("currency").ascending());
			}
			if (direction.equals("DESC")) {
				pageable = PageRequest.of(0, 3, Sort.by("currency").descending());
			}	
		}	
		
			
		Page<Transfer> data = pageableTransferRepository.findAll(pageable);
		
		return data;
		}
	
	
	
	
	
	
	
	
	
}
