package at.spengermed.repositories;

import at.spengermed.models.Measure;

import org.springframework.data.repository.PagingAndSortingRepository;
public interface IMeasureRepository extends
        PagingAndSortingRepository<Measure, String> {
}