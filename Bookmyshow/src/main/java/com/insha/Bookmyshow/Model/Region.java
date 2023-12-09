package com.insha.Bookmyshow.Model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

public class Region extends BaseModel{

    private String name;
}
