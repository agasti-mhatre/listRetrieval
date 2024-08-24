package recommender.recommenderBackend.listRetrieval.DTO;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class ListNameDTO {

  public List<String> eatery;
  public String name;

  public ListNameDTO() {
    eatery = new ArrayList<>();
  }
}
