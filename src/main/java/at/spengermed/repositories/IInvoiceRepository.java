package at.spengermed.repositories;

import at.spengermed.models.Invoice;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IInvoiceRepository extends PagingAndSortingRepository<Invoice, String> {
}
