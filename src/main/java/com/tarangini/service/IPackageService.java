package com.tarangini.service;

import java.util.List;

import com.tarangini.model.PackageModel;

public interface IPackageService {

	List<PackageModel> getAll();
	PackageModel getByCode(String packageCode);
}
