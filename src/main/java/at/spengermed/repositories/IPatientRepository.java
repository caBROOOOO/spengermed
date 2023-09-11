package at.spengermed.repositories;

import at.spengermed.models.Patient;

import org.springframework.data.repository.PagingAndSortingRepository;
public interface IPatientRepository extends
        PagingAndSortingRepository<Patient, String> {
}