package recommender.recommenderBackend.listRetrieval;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

import recommender.recommenderBackend.listRetrieval.DTO.ListDTO;
import recommender.recommenderBackend.listRetrieval.DTO.ListNameDTO;

@Service
public class ListRetrievalService {

  @Autowired
  ListsRepository listsRepository;

  @Value("${mongodbValues.id}")
  String id;

  @Value("${mongodbValues.lists}")
  String lists;

  public ListDTO getLists(String username, int firstItemIndex, int numItems) {

    return listsRepository.getLists(username, firstItemIndex, numItems);
  }

  public void createList(String username, String listName) {

    ListNameDTO newList = new ListNameDTO();
    newList.setName(listName);
    listsRepository.insertList(username, newList);
  }

  public void deleteList(String username, String listName) {

    listsRepository.deleteList(username, listName);
  }

  public void insertItems(String username, String listName, List<String> listItems) {

    listsRepository.insertItems(username, listName, listItems);
  }

  public boolean hasList(String username, String listName) {

    return listsRepository.hasUser(username, listName);
  }

}
