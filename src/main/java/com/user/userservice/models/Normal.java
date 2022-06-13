package com.user.userservice.models;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Normal")
public class Normal extends User{
}
