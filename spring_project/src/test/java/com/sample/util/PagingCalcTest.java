package com.sample.util;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PagingCalcTest {

	
	PagingCalc pagingCalc ;
	
	@Before
	public void setup() {
		pagingCalc = new PagingCalc(25, 10, 10, 5); // 총 25개의 글을, 10개의 게시글로 나누고, 10개의 페이지씩 표현할것이다.
	}
	
	
	@Test
	public void testTotalPage() {
		assertEquals(pagingCalc.getCountList(), 10);
		assertEquals(pagingCalc.getTotalpage(), 3);	
	}
	
	@Test
	public void testCurPage() {
		
	}
	
}
