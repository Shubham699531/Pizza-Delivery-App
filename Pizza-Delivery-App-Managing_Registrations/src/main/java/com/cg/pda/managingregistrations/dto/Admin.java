package com.cg.pda.managingregistrations.dto;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;
import javax.persistence.Version;

import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import com.vladmihalcea.hibernate.type.array.IntArrayType;
import com.vladmihalcea.hibernate.type.array.StringArrayType;


//@Entity
//@SequenceGenerator(name = "admin_id_gen", sequenceName = "admin_id_gen", allocationSize = 1)
public class Admin {

//	@Id
//	@GeneratedValue(generator = "admin_id_gen")
//	private int adminId;
//	@Column(length = 50)
//	private String name;
//	@Column(length = 50, unique = true)
//	private String email;
//	@Column(length = 50, unique = true)
//	private String userName;
//	@Column(length = 50)
//	private String password;
	
	@TypeDefs({
	    @TypeDef(
	        name = "string-array",
	        typeClass = StringArrayType.class
	    ),
	    @TypeDef(
	        name = "int-array",
	        typeClass = IntArrayType.class
	    )
	})
	@MappedSuperclass
	public class BaseEntity {
	 
	    @Id
	    private Long id;
	 
	    @Version
	    private Integer version;
	 
	    //Getters and setters omitted for brevity
	}
}
