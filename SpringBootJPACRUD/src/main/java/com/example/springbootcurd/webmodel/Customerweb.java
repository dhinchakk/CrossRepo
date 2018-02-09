package com.example.springbootcurd.webmodel;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"id",
"firstName",
"lastName",
"address"
})
public class Customerweb {

@JsonProperty("id")
public Long id;
@JsonProperty("firstName")
public String firstName;
@JsonProperty("lastName")
public String lastName;
@JsonProperty("address")
public List<Addressweb> address;
@Override
public String toString() {
	return "Customerweb [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
			+ "]";
}


}


