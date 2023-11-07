package com.gotour.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductDTO {

	private Integer pro_num;
	private int 	pro_price;
	private String  pro_buy;
}
