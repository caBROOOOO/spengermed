package at.spengermed.repositories;

import at.spengermed.models.Consent;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IConsentRepository extends PagingAndSortingRepository<Consent, String> {
}
