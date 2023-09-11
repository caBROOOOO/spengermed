package at.spengermed.controller;

import at.spengermed.models.Invoice;
import at.spengermed.models.Observation;
import at.spengermed.repositories.IInvoiceRepository;
import at.spengermed.repositories.IObservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
@RequestMapping(path = "/api/invoice")
@RestController
@CrossOrigin
public class InvoiceController {
    @Autowired
    private IInvoiceRepository invoiceRepository;

    @GetMapping
    public @ResponseBody
    Iterable<Invoice> getAllInvoices() {
        // This returns a JSON or XML with the users
        return invoiceRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Invoice> getInvoice(@PathVariable String id) {
        return invoiceRepository
                .findById(id)
                .map(invoice -> ResponseEntity.ok().body(invoice))
                .orElse(ResponseEntity.notFound().build());
    }

    // Create a new Patient
    @PostMapping()
    public ResponseEntity<Invoice> createInvoice(@RequestBody
                                                 Invoice invoice) {
        invoice.setId(null); // ensure to create new names
        var saved = invoiceRepository.save(invoice);
        return ResponseEntity.created(URI.create("/api/invoice/" +
                saved.getId())).body(saved);
    }

    // Delete a Patient
    @DeleteMapping("/{id}")
    public ResponseEntity<Invoice> deleteInvoice(@PathVariable(value =
            "id") String invoiceId) {
        return invoiceRepository
                .findById(invoiceId)
                .map(
                        invoice -> {
                            invoiceRepository.delete(invoice);
                            return ResponseEntity.ok().<Invoice>build();
                        })
                .orElse(ResponseEntity.notFound().build());

    }

    // Update a Patient
    @PutMapping("/{id}")
    public ResponseEntity<Invoice> updateInvoice(
            @PathVariable(value = "id") String invoiceId,
            @RequestBody Invoice invoiceDetails) {
        return invoiceRepository
                .findById(invoiceId)
                .map(
                        invoice -> {
                            invoice.setLineItem(invoiceDetails.getLineItem());
                            Invoice updatedInvoice =
                                    invoiceRepository.save(invoice);
                            return ResponseEntity.ok(updatedInvoice);
                        }).orElseGet(() -> createInvoice(invoiceDetails));
    }
}