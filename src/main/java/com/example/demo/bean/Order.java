package com.example.demo.bean;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString 
public class Order implements Serializable{
	private static final long serialVersionUID = 1L;
	private String order;
}
