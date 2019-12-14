package carrent.microservices.repository_;


import carrent.microservices.Information;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface PaginationDao extends PagingAndSortingRepository<Information, Integer> {

}
