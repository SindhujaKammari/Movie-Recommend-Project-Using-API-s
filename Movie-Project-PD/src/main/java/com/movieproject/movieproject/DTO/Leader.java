package com.movieproject.movieproject.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Embeddable
public class Leader {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String id;

    @NotNull
    @Min(value = 3, message = "Minimum number of users is 3 including the leader")
    private Integer numOfUsers;

    public Leader() {
    }

    public Leader(String id, Integer numOfUsers) {
        this.id = id;
        this.numOfUsers = numOfUsers;
    }

    public String getId() {
        return id;
    }

    public Integer getNumOfUsers() {
        return numOfUsers;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNumOfUsers(Integer numOfUsers) {
        this.numOfUsers = numOfUsers;
    }
}