package com.regres.application;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "resource_types")
public class ResourceTypes {
	@Id
	@Column(name = "resource_type_id")
	private int resourceTypeId;
	@Column(name = "type_name")
	private String typeName;

	public ResourceTypes() {
	}

	public ResourceTypes(int resourceTypeId, String typeName) {
		super();
		this.resourceTypeId = resourceTypeId;
		this.typeName = typeName;
	}

	public int getResourceTypeId() {
		return resourceTypeId;
	}

	public void setResourceTypeId(int resourceTypeId) {
		this.resourceTypeId = resourceTypeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	@Override
	public String toString() {
		return "ResourceTypes [resourceTypeId=" + resourceTypeId + ", typeName=" + typeName + "]";
	}
}
