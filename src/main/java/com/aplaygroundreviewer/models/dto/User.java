package com.aplaygroundreviewer.models.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Email;

import javax.annotation.sql.DataSourceDefinition;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Entity
@Table(name="users")
public class User
{
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Column(nullable=false)
	@NotBlank
	private String userName;

	@Column(nullable=false, unique=true)
	@NotBlank
	@Email(message="{errors.invalid_email}")
	private String email;

	@Column(nullable=false)
	@NotBlank
	@Size(min=4)
	private String password;
	
	@ManyToMany(cascade=CascadeType.MERGE)
	@JoinTable(
	      name="user_role",
	      joinColumns={@JoinColumn(name="USER_ID", referencedColumnName="ID")},
	      inverseJoinColumns={@JoinColumn(name="ROLE_ID", referencedColumnName="ID")})
	private List<Role> roles;
	

	public List<Role> getRoles()
	{
		return roles;
	}
	public void setRoles(List<Role> roles)
	{
		this.roles = roles;
	}
}
