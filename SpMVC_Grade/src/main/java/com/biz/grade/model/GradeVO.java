package com.biz.grade.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class GradeVO {
	
	private long seq;			
	private String g_no;	
	private String g_name;	
	private int g_kor;		
	private int g_eng;		
	private int g_math;	
	private int g_total;	
	private float g_avg;
}
