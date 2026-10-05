package com.movieproject.movieproject.DTO;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Embeddable 
public class Leader {

    @JsonProperty(access=JsonProperty.Access.READ_ONLY)
    private String Id;

    @NotNull
    @Min(value = 2 , message="Min amount of users in 3 (including leader)")
    private Integer numOfUsers;

    public Leader(){}

    public Leader(String Id , Integer numOfUsers, String status){
        this.Id = Id;
        this.numOfUsers = numOfUsers;
    }

    public String getId(){return Id;}
    public Integer getNumOfUsers(){return numOfUsers;} 
    

    public void setId(String Id){this.Id = Id;}
    public void setNumOfUsers(Integer numOfUsers){this.numOfUsers = numOfUsers;}
    

}
