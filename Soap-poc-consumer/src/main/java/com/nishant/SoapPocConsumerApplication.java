package com.nishant;


import com.nishant.client.SoapClient;
import com.nishant.api.loaneligibility.Acknowledgement;
import com.nishant.api.loaneligibility.CustomerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@CrossOrigin(origins = "*")
public class SoapPocConsumerApplication {

	@Autowired
	private SoapClient soapClient;

	public static void main(String[] args) {
		SpringApplication.run(SoapPocConsumerApplication.class, args);
	}

	@PostMapping("/getLoanStatus")
	public Acknowledgement invokeSoapCLientToGetLoanStatus(@RequestBody CustomerRequest request){
		return soapClient.getLoanStatus(request);
	}
}
