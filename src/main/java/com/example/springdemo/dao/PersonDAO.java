package com.example.springdemo.dao;

import com.example.springdemo.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
	private static int id = 0;
	private List<Person> people;

	{
		people = new ArrayList<>();
		people.add(new Person(++id, "ATL"));
		people.add(new Person(++id, "ЛСП"));
		people.add(new Person(++id, "Скриптонит"));
		people.add(new Person(++id, "Pharaoh"));
		people.add(new Person(++id, "Bumble B"));
	}

	public List<Person> index() {
		return  people;
	}

	public Person show(int id) {
		return  this.people.get(id);
	}

}
