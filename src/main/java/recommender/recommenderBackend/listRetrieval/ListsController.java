package recommender.recommenderBackend.listRetrieval;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

import recommender.recommenderBackend.listRetrieval.DTO.ListDTO;

@Controller
public class ListsController {

  @Autowired
  private ListRetrievalService listRetrievalService;

  @QueryMapping
  public ListDTO getLists(@Argument String username,
                          @Argument int firstItemIndex,
                          @Argument int numItems) {

    return listRetrievalService.getLists(username, firstItemIndex, numItems);
  }

  @MutationMapping
  public String createList(@Argument String username,
                            @Argument String listName) {

    if (listRetrievalService.hasList(username, listName)) {

      return "List already exists";
    }

    listRetrievalService.createList(username, listName);
    return "List has been created";
  }

  @MutationMapping
  public String insertItems(@Argument String username,
                            @Argument String listName,
                            @Argument List<String> items) {

    listRetrievalService.insertItems(username, listName, items);
    return "";
  }

}
