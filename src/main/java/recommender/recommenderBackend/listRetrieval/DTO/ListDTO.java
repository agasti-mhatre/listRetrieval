package recommender.recommenderBackend.listRetrieval.DTO;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "user_lists")
public class ListDTO {

  @Id
  private String username;
  private List<ListPropertiesDTO> lists;

}