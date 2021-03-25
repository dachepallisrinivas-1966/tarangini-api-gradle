package com.tarangini.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.stereotype.Service;

import com.tarangini.entity.SubscriberEntity;
import com.tarangini.exception.SubscriberNotFoundException;
import com.tarangini.model.SubscriberModel;
import com.tarangini.repo.SubscriberRepo;

@Service
public class SubscriberServiceImplTest  {

	@Mock
	private SubscriberRepo repo;

	@InjectMocks
	private SubscriberServiceImpl ssImpl;

	@Test
	@DisplayName("SubscriberServiceImpl::getById should return an existing SubscriberModel given existing id")
	void testGetById() throws SubscriberNotFoundException {
		SubscriberEntity testdata = new SubscriberEntity(101L, "Vamsy", LocalDate.now(), "1234512345");
		SubscriberModel expected = new SubscriberModel(101L, "Vamsy", LocalDate.now(), "1234512345");
		Mockito.when(repo.existsById(101L)).thenReturn(true);
		Mockito.when(repo.findById(101L)).thenReturn(Optional.of(testdata));

		SubscriberModel actual = ssImpl.getById(101L);

		assertEquals(expected, actual);

	}

	@Test
	@DisplayName("SubscriberServiceImpl::getById should throw SubscriberNotFoundException given non.existing id")
	void testGetById2() throws SubscriberNotFoundException {
		Mockito.when(repo.existsById(101L)).thenReturn(false);
		assertThrows(SubscriberNotFoundException.class, () -> {
			ssImpl.getById(101L);
		});

	}

}
