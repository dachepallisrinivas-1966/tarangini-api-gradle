package com.tarangini.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tarangini.entity.PackageEntity;
import com.tarangini.model.PackageModel;
import com.tarangini.repo.PackageRepo;

@Service
public class PackageServiceImpl implements IPackageService {

	@Autowired
	private PackageRepo packageRepo;
	
	@Autowired
	private EMParser parser;
	
	
	public PackageServiceImpl() {
		
	}
	
	public PackageServiceImpl(PackageRepo packageRepo) {
		super();
		this.packageRepo = packageRepo;
		this.parser = new EMParser();
	}

	@Override
	public List<PackageModel> getAll() {
		return packageRepo.findAll().stream().map(parser::parse).collect(Collectors.toList());
	}

	@Override
	public PackageModel getByCode(String packageCode) {
		return parser.parse(packageRepo.findById(packageCode).orElse(null));
	}
	
}
