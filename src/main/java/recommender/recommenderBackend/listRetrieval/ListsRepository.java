package recommender.recommenderBackend.listRetrieval;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import recommender.recommenderBackend.listRetrieval.DTO.ListDTO;

public interface ListsRepository extends MongoRepository<ListDTO, String> {

  @Query(value = "{ 'username': ?0 }", fields = "{ 'lists': { $slice: [?1, ?2]} }")
  ListDTO getListsInRange(String username, int firstItemIndex, int numItems);

}