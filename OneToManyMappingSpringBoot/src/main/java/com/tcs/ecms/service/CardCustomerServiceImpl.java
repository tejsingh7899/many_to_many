package com.tcs.ecms.service;

import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.tcs.ecms.dto.CardDTO;
import com.tcs.ecms.dto.CustomerDTO;
import com.tcs.ecms.entity.Card;
import com.tcs.ecms.entity.Customer;
import com.tcs.ecms.exception.HDFCBankException;
import com.tcs.ecms.repository.CardRepository;
import com.tcs.ecms.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service(value = "cardCustomerService")
@Transactional
 public class CardCustomerServiceImpl  implements CardCustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CardRepository cardRepository;

    @Override
    public CustomerDTO getCustomerDetails(Integer customerId) throws HDFCBankException {

        Optional<Customer> optional = customerRepository.findById(customerId);
        Customer customer = optional.orElseThrow(()->new HDFCBankException("Service.CUSTOMER_NOT_FOUND"));

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setEmailId(customer.getEmailId());
        customerDTO.setName(customer.getName());
        customerDTO.setCustomerId(customer.getCustomerId());
        customerDTO.setDateOfBirth(customer.getDateOfBirth());
        List<Card> cards = customer.getCards();
        List<CardDTO> cardDTOs = new LinkedList<>();
        if (!cards.isEmpty()) {
            cardDTOs = cards.stream()
                    .map(c -> new CardDTO(c.getCardId(), c.getCardNumber(), c.getExpiryDate()))
                    .collect(Collectors.toList());
        }
        customerDTO.setCards(cardDTOs);
        return customerDTO;
    }

    @Override
    public byte[] generateCustomerReport(List<CustomerDTO> customerDTO) throws HDFCBankException {

        ByteArrayOutputStream out = new ByteArrayOutputStream();

        com.lowagie.text.Document document = new com.lowagie.text.Document();
        PdfWriter.getInstance(document, out);

        document.open();
        document.add(new Paragraph("Customer Report"));
        document.add(new Paragraph("Generated On: " + LocalDate.now()));
        document.add(new Paragraph(" "));

        PdfPTable table = new PdfPTable(3);
        table.addCell("CustomerId");
        table.addCell("EmailId");
        table.addCell("name");
        table.addCell("DateOfBirth");

        for (CustomerDTO c : customerDTO) {
            table.addCell(c.getEmailId());
            table.addCell(c.getName());
        }
        document.add(table);
        document.close();

        return out.toByteArray();


    }
}
