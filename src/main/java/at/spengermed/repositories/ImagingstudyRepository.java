package at.spengermed.repositories;


import at.spengermed.models.Imagingstudy;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface ImagingstudyRepository extends PagingAndSortingRepository<Imagingstudy, String> {
}
