package com.boot;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.MockitoAnnotations.Mock;

import static org.mockito.Mock.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.boot.controller.ShipwreckController;
import com.boot.model.Shipwreck;
import com.boot.repository.ShipwreckRepository;

public class ShipwreckControllerTest {
	@InjectMocks
	private ShipwreckController sc;
	
	@Mock
	private ShipwreckRepository shipwreckRepository;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testShipwreckGet() {

		Shipwreck sw = new Shipwreck();
		sw.setId(1L);
		when(shipwreckRepository.findOne(1L)).thenReturn(sw);
		Shipwreck wreck = sc.get(1L);
		verify(shipwreckRepository).findOne(1L);
		assertEquals(1L,wreck.getId().longValue());
	}
	
	@Test
	public void testShipwreckdelete() {

		Shipwreck sw = new Shipwreck();
		sw.setId(1L);
		when(shipwreckRepository.findOne(1L)).thenReturn(sw);
		Shipwreck wreck = sc.delete(1L);
		doNothing().when(shipwreckRepository).delete(1L);
		verify(shipwreckRepository).findOne(1L);
		verify(shipwreckRepository).delete(1L);
		assert(true);
	}

}
