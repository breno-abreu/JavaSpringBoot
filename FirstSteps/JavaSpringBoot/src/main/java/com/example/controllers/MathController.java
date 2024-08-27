package com.example.controllers;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.exceptions.UnsupportedMathOperationException;
import com.example.util.MathUtils;

@RestController
public class MathController {

	// API methods
	
	@GetMapping(value="/sum/{n1}/{n2}")
	public Double sum(
			@PathVariable(value="n1") String n1,
			@PathVariable(value="n2") String n2
		) throws UnsupportedMathOperationException {
		
		if(!MathUtils.isNumeric(n1) || !MathUtils.isNumeric(n2)) 
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		
		return MathUtils.convertToDouble(n1) + MathUtils.convertToDouble(n2);
	}
	
	@GetMapping(value="/sub/{n1}/{n2}")
	public Double sub(
			@PathVariable String n1,
			@PathVariable String n2
		) throws UnsupportedMathOperationException {
		
		if(!MathUtils.isNumeric(n1) || !MathUtils.isNumeric(n2)) 
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		
		return MathUtils.convertToDouble(n1) - MathUtils.convertToDouble(n2);
	}
	
	@GetMapping(value="/div/{n1}/{n2}")
	public Double div(
			@PathVariable(value="n1") String n1,
			@PathVariable(value="n2") String n2
		) throws UnsupportedMathOperationException {
		
		if(!MathUtils.isNumeric(n1) || !MathUtils.isNumeric(n2)) 
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		
		return MathUtils.convertToDouble(n1) / MathUtils.convertToDouble(n2);
	}
	
	@GetMapping(value="/mult/{n1}/{n2}")
	public Double mult(
			@PathVariable(value="n1") String n1,
			@PathVariable(value="n2") String n2
		) throws UnsupportedMathOperationException {
		
		if(!MathUtils.isNumeric(n1) || !MathUtils.isNumeric(n2)) 
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		
		return MathUtils.convertToDouble(n1) * MathUtils.convertToDouble(n2);
	}
	
	@GetMapping(value="/avg/{n1}/{n2}/{n3}")
	public Double avg(
			@PathVariable(value="n1") String n1,
			@PathVariable(value="n2") String n2,
			@PathVariable(value="n3") String n3
		) throws UnsupportedMathOperationException {
		
		if(!MathUtils.isNumeric(n1) || !MathUtils.isNumeric(n2)) 
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		
		return (MathUtils.convertToDouble(n1) + MathUtils.convertToDouble(n2) + MathUtils.convertToDouble(n3)) / 3;
	}
	
	@GetMapping(value="/sqrt/{n1}")
	public Double sqrt(
			@PathVariable(value="n1") String n1
		) throws UnsupportedMathOperationException {
		
		if(!MathUtils.isNumeric(n1)) 
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		
		return Math.sqrt(MathUtils.convertToDouble(n1));
	}
}
