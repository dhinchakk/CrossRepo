package com.example.springbootcurd.webmodel;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "street", "state" })
public class Addressweb {
            
	@Override
	public String toString() {
		return "Addressweb [id=" + id + ", street=" + street + ", state=" + state + "]";
	}
	@JsonProperty("id")
	public Long id;
	@JsonProperty("street")
	public String street;
	@JsonProperty("state")
	public String state;

	

}