package com.gemalto.petclinic.services.springdatajpa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.gemalto.petclinic.models.Owner;
import com.gemalto.petclinic.repositories.OwnerRepository;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    @Mock
    private OwnerRepository ownerRepository;

    @InjectMocks
    private OwnerSDJpaService ownerSDJpaService;

    private Long ownerId = 1L;
    private String lastName = "Smith";

    @BeforeEach
    void setUp() {
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(any())).thenReturn(getOwner());
        Owner foundOwner = ownerSDJpaService.findByLastName(lastName);

        assertEquals(lastName, foundOwner.getLastName());
        assertEquals(ownerId, foundOwner.getId());

        // default is 1 times
        verify(ownerRepository).findByLastName(any());
        verify(ownerRepository, times(1)).findByLastName(any());
    }

    private Owner getOwner() {
        return Owner.builder().id(ownerId).lastName(lastName).build();
    }

    @Test
    void findAll() {
        when(ownerRepository.findAll()).thenReturn(getOwnerSet());
        Set<Owner> owners = ownerSDJpaService.findAll();
        assertNotNull(owners);
        assertEquals(2, owners.size());
    }

    private Set<Owner> getOwnerSet() {
        Set<Owner> ownerSet = new HashSet<>();
        ownerSet.add(Owner.builder().id(1L).build());
        ownerSet.add(Owner.builder().id(2L).build());
        return ownerSet;
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(getOwner()));
        Owner owner = ownerSDJpaService.findById(ownerId);
        assertNotNull(owner);
    }

    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());
        Owner owner = ownerSDJpaService.findById(ownerId);
        assertNull(owner);
    }

    @Test
    void save() {
        when(ownerRepository.save(any())).thenReturn(getOwner());
        Owner savedOwner = ownerSDJpaService.save(Owner.builder().build());
        assertNotNull(savedOwner);
        assertEquals(ownerId, savedOwner.getId());
    }

    @Test
    void delete() {
        ownerSDJpaService.delete(getOwner());
        verify(ownerRepository).delete(any());
    }

    @Test
    void deleteById() {
        ownerSDJpaService.deleteById(ownerId);
        verify(ownerRepository).deleteById(anyLong());
    }
}