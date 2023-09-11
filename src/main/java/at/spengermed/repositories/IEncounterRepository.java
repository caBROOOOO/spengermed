package at.spengermed.repositories;

import at.spengermed.models.Encounter;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IEncounterRepository extends PagingAndSortingRepository<Encounter, String> {
}
