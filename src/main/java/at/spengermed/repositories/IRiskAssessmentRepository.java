package at.spengermed.repositories;

import at.spengermed.models.RiskAssessment;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IRiskAssessmentRepository extends PagingAndSortingRepository<RiskAssessment, String> {
}
