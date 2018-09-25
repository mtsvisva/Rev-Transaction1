package com.example.Transaction;

import java.text.DecimalFormat;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

private static DecimalFormat deci = new DecimalFormat(".##");

@RequestMapping(method = RequestMethod.POST,value="/transactions")
public ResponseEntity <?> example(@RequestParam("amount") double amount,@RequestParam("timestamp") long timestamp){
	
	System.out.println (deci.format(amount));
	long epoch = System.currentTimeMillis();
	if(timestamp-epoch < 60000)
	{
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
