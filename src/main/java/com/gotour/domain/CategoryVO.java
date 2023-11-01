package com.gotour.domain;

import lombok.Data;

@Data
public class CategoryVO {
/*
 * CREATE TABLE CATEGORY_TBL(
        CG_CODE            NUMBER    PRIMARY KEY,    -- 카테고리 코드
        CG_PARENT_CODE         NUMBER    NULL,           -- 상위카테고리 코드
        CG_NAME            VARCHAR2(50)    NOT NULL,
        FOREIGN KEY(CG_PARENT_CODE) REFERENCES CATEGORY_TBL(CG_CODE)
);

 */
	private Integer cg_code;
	private Integer cg_parent_code;
	private String cg_name;
	
}
