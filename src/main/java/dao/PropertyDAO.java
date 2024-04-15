package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Property;
import resources.SQLite;

public class PropertyDAO {

	public List<Property> getPropertiesByFilters(String area, String city, String propertyType) {
		List<Property> properties = new ArrayList<>();
		String sql = "SELECT * FROM HollyUnits WHERE Area LIKE ? AND City LIKE ? AND PropertyType LIKE ?";

		try (Connection con = SQLite.GetSqlite(); PreparedStatement pstmt = con.prepareStatement(sql)) {

			pstmt.setString(1, area.isEmpty() ? "%" : area);
			pstmt.setString(2, city.isEmpty() ? "%" : city);
			pstmt.setString(3, propertyType.isEmpty() ? "%" : propertyType);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Property property = new Property();
				property.setId(rs.getInt("ID"));
				property.setName(rs.getString("Name"));
				property.setDescription(rs.getString("Description"));
				property.setCity(rs.getString("City"));
				property.setArea(rs.getString("Area"));
				property.setPropertyType(rs.getString("PropertyType"));
				property.setLocation(rs.getString("Location"));
				property.setHomeNo(rs.getInt("HomeNo"));
				property.setRefID(rs.getInt("RefID"));

				// Now fetch photos for this property
				property.setPhotos(getPhotosForProperty(property.getId(), con, property));

				properties.add(property);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return properties;
	}

	private List<Property.Photo> getPhotosForProperty(int unitID, Connection con, Property property) {
		List<Property.Photo> photos = new ArrayList<>();
		String sql = "SELECT * FROM HollyPhotos WHERE UnitID = ?";

		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, unitID);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Property.Photo photo = property.new Photo(); // Create a new Photo instance via the Property instance
				photo.setId(rs.getInt("ID"));
				photo.setUnitID(rs.getInt("UnitID"));
				photo.setLink(rs.getString("Link"));
				photo.setCover(rs.getInt("Cover") == 1);

				photos.add(photo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return photos;
	}
}
