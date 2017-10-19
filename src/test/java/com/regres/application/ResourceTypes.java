package com.regres.application;

public class ResourceTypes {

	private int resourceTypeId;
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
