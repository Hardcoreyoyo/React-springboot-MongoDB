package ServiceMongoCRUD.mapper;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DataItem{

	@JsonProperty("date")
	private String date;

	@JsonProperty("note")
	private String note;

	@JsonProperty("id")
	private String id;

	@JsonProperty("time")
	private String time;

	public String getDate(){
		return date;
	}

	public String getNote(){
		return note;
	}

	public String getId(){
		return id;
	}

	public String getTime(){
		return time;
	}
}