package com.tarangini.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tarangini.model.PackageModel;
import com.tarangini.service.IPackageService;

@RestController
@RequestMapping("/packages")
@CrossOrigin
public class PackageRestController {

	@Autowired
	private IPackageService packageService;
	
	@GetMapping
	public ResponseEntity<List<PackageModel>> getAll(){
		return ResponseEntity.ok(packageService.getAll());
	}
	
	@GetMapping("/{packageCode}")
	public ResponseEntity<PackageModel> getByCode(@PathVariable("packageCode") String packageCode){
		return ResponseEntity.ok(packageService.getByCode(packageCode));
	}
}
