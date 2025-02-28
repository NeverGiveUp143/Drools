package com.drools.OrderLocation.models;

import org.springframework.lang.Nullable;

public class orderRequest {
	private String productFamily;
	private int storeId;
	@Nullable
	private Integer glassWidth;
	@Nullable
	private Integer glassHeight;
	@Nullable
	private String groupType;
	private String availableMakeLocation;
	private String DefaultMakeLocation;

	public String getDefaultMakeLocation() {
		return DefaultMakeLocation;
	}

	public void setDefaultMakeLocation(String defaultMakeLocation) {
		if (getAvailableMakeLocation().equalsIgnoreCase(defaultMakeLocation)) {
			this.availableMakeLocation = null;
		}
		DefaultMakeLocation = defaultMakeLocation;
	}

	public int getStoreId() {
		return storeId;
	}

	public String getAvailableMakeLocation() {
		return availableMakeLocation;
	}

	public void setAvailableMakeLocation(String availableMakeLocation) {
		this.availableMakeLocation = availableMakeLocation;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public Integer getGlassWidth() {
		return glassWidth;
	}

	public void setGlassWidth(Integer glassWidth) {
		this.glassWidth = glassWidth;
	}

	public Integer getGlassHeight() {
		return glassHeight;
	}

	public void setGlassHeight(Integer glassHeight) {
		this.glassHeight = glassHeight;
	}

	public String getGroupType() {
		return groupType;
	}

	public void setGroupType(String groupType) {
		this.groupType = groupType;
	}

	public String getProductFamily() {
		return productFamily;
	}

	public void setProductFamily(String productFamily) {
		this.productFamily = productFamily;
	}

	public int getGlassArea() {
		if(glassWidth != null && glassHeight!= null) {
			return (glassWidth * glassHeight);
		}
		return 0 ;
	}

}