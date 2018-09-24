package com.example.Transaction;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionGetController {
	
	static int count=0;
	static double net=0.0;
	static double avg=0.0;
	static double min=10000;
	static double max=0.0;
	 
	//TransactionReq tr = new TransactionReq();
	
	@RequestMapping(method = RequestMethod.POST,value="/statistics")
	
	public ResponseEntity <List<TransactionReq>> example(@RequestBody List<TransactionReq> stats){
		
		/*tg.setCount(8);
		tg.setAvg(4.73);
		tg.setMin(min);
		tg.setMax(max);
		tg.setTotal(total);
		if()
		{
			return ResponseEntity.status(HttpStatus.CREATED).build();
		}
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}*/
	
	long epoch = System.currentTimeMillis();	
	System.out.println(epoch);
	stats.stream().forEach(trans -> {
	
	  if ((trans.getTimestamp()-epoch)<60000)
	  {
		    
			trans.setCount(count+=1);
			trans.setAvg(avg=net/count);
			if ( trans.getAmount() < min) 
			{
				min =  trans.getAmount();
			}
			if (trans.getAmount() > max) 
			{
				max = trans.getAmount();
			}
			trans.setTotal(net += trans.getAmount());
	  }
	});

    return new ResponseEntity<List<TransactionReq>>(HttpStatus.OK);
	
	}
    @ResponseBody 
	@RequestMapping(method = RequestMethod.GET, value="/statistics")
	 public ResponseEntity<TransactionGet> statsDetails(TransactionGet transacResponse) {
	
    	
    	transacResponse.setCount(count);
    	transacResponse.setAvg(avg);
    	transacResponse.setMin(min);
    	transacResponse.setMax(max);
    	transacResponse.setTotal(net); 
    	
		 return new ResponseEntity<TransactionGet>(transacResponse,HttpStatus.OK);
	
	}
		
		
 }
