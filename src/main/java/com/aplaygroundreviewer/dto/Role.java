package com.aplaygroundreviewer.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.util.List;


@Builder
@Data
@Entity
@Table(name="roles")
public class Role
{
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Column(nullable=false, unique=true)
	@NonNull
	private String name;

	@ManyToMany(mappedBy="roles")
	private List<User> users;

	public Role() {

	}

	public Role(Integer id, @NonNull String name, List<User> users) {
		this.id = id;
		this.name = name;
		this.users = users;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
}
