package com.example.angularspringbootserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by chathuran on 1/24/2020.
 */
@RestController
public class TestController
{
	@GetMapping(value = "/test")
	public void test(){
		System.out.println("Test Mappign");
	}
}
