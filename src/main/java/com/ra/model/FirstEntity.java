package com.ra.model;

/*import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mytab")*/
public class FirstEntity {
	/*
	 * @Id
	 * 
	 * @GeneratedValue
	 */
    private int id;
    private String name;
    private String description;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public FirstEntity(int id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}
    
    
}
