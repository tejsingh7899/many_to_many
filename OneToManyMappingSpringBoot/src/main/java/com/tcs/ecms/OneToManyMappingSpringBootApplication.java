package com.tcs.ecms;

import com.tcs.ecms.dto.CustomerDTO;
import com.tcs.ecms.exception.HDFCBankException;
import com.tcs.ecms.service.CardCustomerService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class OneToManyMappingSpringBootApplication implements CommandLineRunner {

    public static final Log LOGGER = LogFactory.getLog(OneToManyMappingSpringBootApplication.class);

    @Autowired
    private CardCustomerService cardCustomerService;

    @Autowired
    private Environment environment;

    public static void main(String[] args) {
        SpringApplication.run(OneToManyMappingSpringBootApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
		getCustomerWithCardDetails();
    }

    public void getCustomerWithCardDetails() {

        try {
            Integer customerId = 1001;
            CustomerDTO customerDTO = cardCustomerService.getCustomerDetails(customerId);
            LOGGER.info(customerDTO);
            if (customerDTO.getCards().isEmpty()) {
                LOGGER.info(environment.getProperty("UserInterface.NO_CARDS"));
            }
        } catch (Exception e) {
            String message = environment.getProperty(e.getMessage(), "Some exception occured.lease check log file for more details!!");
            LOGGER.info(message);
        }

    }
}
