package model;

import java.util.List;

/**
 * Represents a property with associated photos.
 */
public class Property {
	private int id;
	private String name;
	private String description;
	private String city;
	private String area;
	private String propertyType;
	private String location;
	private int homeNo;
	private int refID;
	private List<Photo> photos; // To store photos related to the property

	// Constructors
	public Property() {
	}

	// Getters and setters
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getHomeNo() {
		return homeNo;
	}

	public void setHomeNo(int homeNo) {
		this.homeNo = homeNo;
	}

	public int getRefID() {
		return refID;
	}

	public void setRefID(int refID) {
		this.refID = refID;
	}

	public List<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}

	public class Photo {
		private int id;
		private int unitID;
		private String link;
		private boolean isCover; // true if Cover = 1

		// Constructors
		public Photo() {
		}

		// Getters and setters
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getUnitID() {
			return unitID;
		}

		public void setUnitID(int unitID) {
			this.unitID = unitID;
		}

		public String getLink() {
			return link;
		}

		public void setLink(String link) {
			this.link = link;
		}

		public boolean isCover() {
			return isCover;
		}

		public void setCover(boolean isCover) {
			this.isCover = isCover;
		}
	}
}

/**
 * Represents a photo related to a property.
 */
