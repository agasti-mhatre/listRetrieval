package recommender.recommenderBackend.listRetrieval;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import java.util.List;

import recommender.recommenderBackend.listRetrieval.DTO.ListDTO;
import recommender.recommenderBackend.listRetrieval.DTO.ListNameDTO;

public interface ListsRepository extends MongoRepository<ListDTO, String> {

  @Query(value = "{ '_id': ?0 }", fields = "{ 'lists': { $slice: [?1, ?2]} }")
  ListDTO getLists(String username, int firstItemIndex, int numItems);

  @Query("{ '_id': ?0 }")
  @Update("{ '$push': { 'lists': ?1 } }")
  void insertList(String username, ListNameDTO newList);

  @Query("{ '_id': ?0, 'lists.name': ?1 }")
  @Update("{ '$push': { 'lists.$.eatery': { '$each': ?2 } } }")
  void insertItems(String username, String listName, List<String> listItems);

  @Query(value = "{ '_id' : ?0, 'lists.name' : ?1 }", exists = true)
  boolean hasUser(String username, String listName);
}