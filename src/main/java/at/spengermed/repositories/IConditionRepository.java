package at.spengermed.repositories;

import at.spengermed.models.Condition;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IConditionRepository extends PagingAndSortingRepository<Condition, String> {
}
