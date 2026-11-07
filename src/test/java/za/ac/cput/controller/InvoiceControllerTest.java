package za.ac.cput.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import tools.jackson.databind.json.JsonMapper;
import za.ac.cput.domain.Invoice;
import za.ac.cput.domain.Payment;
import za.ac.cput.factory.InvoiceFactory;
import za.ac.cput.service.IInvoiceService;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/* InvoiceControllerTest.java
    InvoiceControllerTest class
    Author: Ayabonga Jervasio Yawa (221241558)
    Date: 22 August 2026
*/

class InvoiceControllerTest {

    Payment payment = Payment.builder().paymentId(1L).build();
    LocalDateTime issuedDate = LocalDateTime.of(2026, 10, 22, 10, 0);
    String invoiceNumber = "INV-001";
    LocalDateTime dueDate = issuedDate.plusDays(30);
    BigDecimal totalAmount = new BigDecimal("25000.00");
    BigDecimal taxAmount = new BigDecimal("3750.00");
    Long invoiceId = 42L;
    Invoice invoice = InvoiceFactory.createInvoice(payment,
            invoiceNumber,
            issuedDate,
            dueDate,
            totalAmount,
            taxAmount);
    IInvoiceService invoiceService;
    MockMvc mockMvc;
    JsonMapper jsonMapper = JsonMapper.builder().build();

    @BeforeEach
    void setUp() {
        invoice.setInvoiceId(invoiceId);
        invoiceService = mock(IInvoiceService.class);
        mockMvc = standaloneSetup(new InvoiceController(invoiceService)).build();
    }

    @Test
    void createInvoice() throws Exception {
        invoice.setInvoiceId(null);
        String requestBody = jsonMapper.writeValueAsString(invoice);
        invoice.setInvoiceId(invoiceId);
        when(invoiceService.create(any(Invoice.class))).thenReturn(invoice);

        mockMvc.perform(post("/api/invoices/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.invoiceId").value(invoiceId.intValue()))
                .andExpect(jsonPath("$.invoiceNumber").value(invoiceNumber));

        ArgumentCaptor<Invoice> invoiceCaptor = ArgumentCaptor.forClass(Invoice.class);
        verify(invoiceService).create(invoiceCaptor.capture());
        Invoice createdInvoice = invoiceCaptor.getValue();

        assertNotNull(createdInvoice);
        assertNull(createdInvoice.getInvoiceId());
        assertEquals(invoice.getPayment(), createdInvoice.getPayment());
        assertEquals(invoice.getInvoiceNumber(), createdInvoice.getInvoiceNumber());
        assertEquals(invoice.getIssuedDate(), createdInvoice.getIssuedDate());
        assertEquals(invoice.getDueDate(), createdInvoice.getDueDate());
        assertEquals(invoice.getTotalAmount(), createdInvoice.getTotalAmount());
        assertEquals(invoice.getTaxAmount(), createdInvoice.getTaxAmount());
    }

    @Test
    void readInvoice() throws Exception {
        when(invoiceService.read(invoiceId)).thenReturn(invoice);

        mockMvc.perform(get("/api/invoices/read/{id}", invoiceId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.invoiceId").value(invoiceId.intValue()));

        verify(invoiceService).read(invoiceId);
    }

    @Test
    void readWithUnknownInvoiceId() throws Exception {
        when(invoiceService.read(invoiceId)).thenReturn(null);

        mockMvc.perform(get("/api/invoices/read/{id}", invoiceId))
                .andExpect(status().isNotFound());

        verify(invoiceService).read(invoiceId);
    }

    @Test
    void updateInvoice() throws Exception {
        invoice.setInvoiceId(invoiceId);
        when(invoiceService.update(any(Invoice.class))).thenAnswer(invocation -> invocation.getArgument(0));

        mockMvc.perform(put("/api/invoices/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonMapper.writeValueAsString(invoice)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.invoiceId").value(invoiceId.intValue()));

        ArgumentCaptor<Invoice> invoiceCaptor = ArgumentCaptor.forClass(Invoice.class);
        verify(invoiceService).update(invoiceCaptor.capture());
        Invoice updatedInvoice = invoiceCaptor.getValue();

        assertNotNull(updatedInvoice);
        assertEquals(invoiceId, updatedInvoice.getInvoiceId());
        assertEquals(invoice.getInvoiceNumber(), updatedInvoice.getInvoiceNumber());
    }

    @Test
    void deleteInvoice() throws Exception {
        mockMvc.perform(delete("/api/invoices/delete/{id}", invoiceId))
                .andExpect(status().isNoContent())
                .andExpect(content().string(""));

        verify(invoiceService).delete(invoiceId);
        verifyNoMoreInteractions(invoiceService);
    }

    @Test
    void getAllInvoices() throws Exception {
        when(invoiceService.getAll()).thenReturn(List.of(invoice));

        mockMvc.perform(get("/api/invoices/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].invoiceId").value(invoiceId.intValue()));

        verify(invoiceService).getAll();
    }

    @Test
    void getAllWithNoInvoices() throws Exception {
        when(invoiceService.getAll()).thenReturn(List.of());

        mockMvc.perform(get("/api/invoices/all"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));

        verify(invoiceService).getAll();
    }

    @Test
    void createInvoiceWithNullPayment() throws Exception {
        invoice.setPayment(null);

        mockMvc.perform(post("/api/invoices/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonMapper.writeValueAsString(invoice)))
                .andExpect(status().isBadRequest());

        verifyNoInteractions(invoiceService);
    }

    @Test
    void createInvoiceWithNullInvoiceNumber() throws Exception {
        invoice.setInvoiceNumber(null);

        mockMvc.perform(post("/api/invoices/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonMapper.writeValueAsString(invoice)))
                .andExpect(status().isBadRequest());

        verifyNoInteractions(invoiceService);
    }

    @Test
    void createInvoiceWithNullIssuedDate() throws Exception {
        invoice.setIssuedDate(null);

        mockMvc.perform(post("/api/invoices/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonMapper.writeValueAsString(invoice)))
                .andExpect(status().isBadRequest());

        verifyNoInteractions(invoiceService);
    }

    @Test
    void createInvoiceWithNullDueDate() throws Exception {
        invoice.setDueDate(null);

        mockMvc.perform(post("/api/invoices/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonMapper.writeValueAsString(invoice)))
                .andExpect(status().isBadRequest());

        verifyNoInteractions(invoiceService);
    }

    @Test
    void createInvoiceWithNullTotalAmount() throws Exception {
        invoice.setTotalAmount(null);

        mockMvc.perform(post("/api/invoices/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonMapper.writeValueAsString(invoice)))
                .andExpect(status().isBadRequest());

        verifyNoInteractions(invoiceService);
    }

    @Test
    void createInvoiceWithNullTaxAmount() throws Exception {
        invoice.setTaxAmount(null);

        mockMvc.perform(post("/api/invoices/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonMapper.writeValueAsString(invoice)))
                .andExpect(status().isBadRequest());

        verifyNoInteractions(invoiceService);
    }

    @Test
    void createInvoiceWithNegativeTotalAmount() throws Exception {
        invoice.setTotalAmount(new BigDecimal("-0.01"));

        mockMvc.perform(post("/api/invoices/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonMapper.writeValueAsString(invoice)))
                .andExpect(status().isBadRequest());

        verifyNoInteractions(invoiceService);
    }

    @Test
    void createInvoiceWithNegativeTaxAmount() throws Exception {
        invoice.setTaxAmount(new BigDecimal("-0.01"));

        mockMvc.perform(post("/api/invoices/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonMapper.writeValueAsString(invoice)))
                .andExpect(status().isBadRequest());

        verifyNoInteractions(invoiceService);
    }

    @Test
    void createInvoiceWithEmptyInvoiceNumber() throws Exception {
        invoice.setInvoiceNumber("");

        mockMvc.perform(post("/api/invoices/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonMapper.writeValueAsString(invoice)))
                .andExpect(status().isBadRequest());

        verifyNoInteractions(invoiceService);
    }

    @Test
    void createInvoiceWithZeroAmounts() throws Exception {
        invoice.setTotalAmount(BigDecimal.ZERO);
        invoice.setTaxAmount(BigDecimal.ZERO);
        when(invoiceService.create(any(Invoice.class))).thenAnswer(invocation -> invocation.getArgument(0));

        mockMvc.perform(post("/api/invoices/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonMapper.writeValueAsString(invoice)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.invoiceId").value(invoiceId.intValue()));

        verify(invoiceService).create(argThat(createdInvoice -> createdInvoice.equals(invoice)));
    }

    @Test
    void updateInvoiceWithNullPayment() throws Exception {
        invoice.setPayment(null);

        mockMvc.perform(put("/api/invoices/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonMapper.writeValueAsString(invoice)))
                .andExpect(status().isBadRequest());

        verifyNoInteractions(invoiceService);
    }

    @Test
    void createInvoiceWithInvalidJson() throws Exception {
        mockMvc.perform(post("/api/invoices/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{invalid"))
                .andExpect(status().isBadRequest());

        verifyNoInteractions(invoiceService);
    }

    @Test
    void readInvoiceWithInvalidId() throws Exception {
        mockMvc.perform(get("/api/invoices/read/invalid"))
                .andExpect(status().isBadRequest());

        verifyNoInteractions(invoiceService);
    }

}
