package recommender.recommenderBackend.listRetrieval;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import recommender.recommenderBackend.listRetrieval.DTO.ListDTO;
import recommender.recommenderBackend.listRetrieval.DTO.ListNameDTO;

@Service
public class ListRetrievalService {

  @Autowired
  ListsRepository listsRepository;

  @Autowired
  MongoTemplate mongoTemplate;

  @Value("${mongodbValues.id}")
  String id;

  @Value("${mongodbValues.lists}")
  String lists;

  public ListDTO getLists(String username, int firstItemIndex, int numItems) {

    return listsRepository.getListsInRange(username, firstItemIndex, numItems);
  }


  public void createList(String username, String listName) {

    ListNameDTO newList = new ListNameDTO();
    newList.setName(listName);

    Query query = new Query(Criteria.where(id).is(username));
    Update update = new Update().push(lists, newList);
    mongoTemplate.updateFirst(query, update, ListDTO.class);
  }

  public boolean hasList(String username) {

    return false;
  }

}
