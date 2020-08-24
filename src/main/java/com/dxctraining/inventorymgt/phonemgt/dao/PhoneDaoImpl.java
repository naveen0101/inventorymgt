package com.dxctraining.inventorymgt.phonemgt.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.dxctraining.inventorymgt.phonemgt.entities.Phone;
import com.dxctraining.inventorymgt.phonemgt.exceptions.*;
@Repository
public class PhoneDaoImpl implements IPhoneDao {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Phone save(Phone phone) {
		em.persist(phone);
		return phone;
	}

	@Override
	public Phone findPhoneById(int id) {
		Phone phone = em.find(Phone.class, id);
		if (phone == null) {
			throw new PhoneNotFoundException("Phone not found");
		}
		return phone;
	}

	@Override
	public Phone remove(int id) {
		Phone phone = findPhoneById(id);
		em.remove(phone);
		return phone;
	}

	@Override
	 public List<Phone> allPhones() {
      String jpaql="from Phone";
      TypedQuery<Phone>query=em.createQuery(jpaql,Phone.class);
      List<Phone>phoneList=query.getResultList();
      return phoneList;
  }
	@Override
	public Phone add(Phone phone) {
		em.persist(phone);
		return phone;
	}
        @Override
	public Phone update(Phone phone) {
		em.merge(phone);
		return phone;

	}
}
