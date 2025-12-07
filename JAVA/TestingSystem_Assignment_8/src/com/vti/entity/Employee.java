package com.vti.entity;

public class Employee<T> {
	private int id;
	private String name;
	private T[] salaries;

	public Employee(int id, String name, T[] salarEmployee1) {
		super();
		this.id = id;
		this.name = name;
		this.salaries = salarEmployee1;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public T getSalaries() {
		return (T) salaries;
	}

	public void setSalaries(T salaries) {
		this.salaries = (T[]) salaries;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salaries=" + salaries + "]";
	}

}
