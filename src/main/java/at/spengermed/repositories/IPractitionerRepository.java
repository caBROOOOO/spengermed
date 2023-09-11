package at.spengermed.repositories;

import at.spengermed.models.Practitioner;
import org.springframework.data.repository.PagingAndSortingRepository;
public interface IPractitionerRepository extends
        PagingAndSortingRepository<Practitioner, String> {
}
