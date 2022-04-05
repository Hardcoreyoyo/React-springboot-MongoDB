package ServiceMongoCRUD.mapper;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Response{

	@JsonProperty("data")
	private List<DataItem> data;

	public List<DataItem> getData(){
		return data;
	}
}