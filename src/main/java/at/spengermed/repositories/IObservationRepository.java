package at.spengermed.repositories;

import at.spengermed.models.Observation;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IObservationRepository extends PagingAndSortingRepository<Observation, String> {
}

