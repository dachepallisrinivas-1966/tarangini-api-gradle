package com.tarangini.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import com.tarangini.entity.PackageEntity;
import com.tarangini.model.PackageModel;
import com.tarangini.repo.PackageRepo;

@ExtendWith(MockitoExtension.class)
public class PackageServiceImplTest {

	@Mock
	private PackageRepo repo;
	
	@InjectMocks		/* injecting package repository marked as @Mock into package service implementation */
	private PackageServiceImpl psImpl;
	
	@Test
	@DisplayName("PackageServiceImpl::getAll should return list of existing packages as PackageModel List")
	void testGetAll() {

		List<PackageEntity> testdata = Arrays.asList(new PackageEntity[] {
				new PackageEntity("P01","Pack1", "Pack1", 100.0),
				new PackageEntity("P02","Pack2", "Pack2", 200.0)
			});
		
		Mockito.when(repo.findAll()).thenReturn(testdata);	/* when repo.findAll() is called, then test data */
		
		List<PackageModel> expected = Arrays.asList(new PackageModel[] {
				new PackageModel("P01","Pack1", "Pack1", 100.0),
				new PackageModel("P02","Pack2", "Pack2", 200.0)
			});
		
		
		List<PackageModel> actual = psImpl.getAll();	
		
		assertEquals(expected, actual);
	}



	
	@Test
	@DisplayName("PackageServiceImpl::getByCode should return exeisting package as PackageModel given existing packageCode")
	void testGetByCode() {
		
		PackageEntity testdata =  new PackageEntity("P01","Pack1", "Pack1", 100.0);
		PackageModel expected = new PackageModel("P01","Pack1", "Pack1", 100.0);
		
		Mockito.when(repo.findById(testdata.getPackageCode()))
		.thenReturn(Optional.of(testdata));
		
		PackageModel actual = psImpl.getByCode(testdata.getPackageCode());
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("PackageServiceImpl::getByCode should return null given nonexisting packageCode")
	void testGetByCode2() {		
		
		Mockito.when(repo.findById("P01")).thenReturn(Optional.empty());
		
		PackageModel actual = psImpl.getByCode("P01");
		assertNull(actual);
	}
}
