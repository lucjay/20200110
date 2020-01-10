package co.lucjay.countries;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CountryServiceImpl extends CountryService {
	private final String All_SELECT = "select * from countries";
	private final String SEARCH_SELECT = "select * from countries where country_id =?";
	private final String CO_INSERT = "insert into countries values(?,?,?)";
	private final String CO_UPDATE = "update countries set country_name=?, region_id=? where country_id=?";
	private final String CO_DELETE = "delete from countries where country_id = ?";

	@Override
	public List<CountryDto> allSelect() {
		List<CountryDto> list = new ArrayList<CountryDto>();
		CountryDto dto;
		try {
			psmt = conn.prepareStatement(All_SELECT);
			rs = psmt.executeQuery();
			while (rs.next()) {
				dto = new CountryDto();
				dto.setCountry_id(rs.getString("country_id"));
				dto.setCountry_name(rs.getString("country_name"));
				dto.setRegion_id(rs.getInt("region_id"));
				list.add(dto);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public CountryDto select(String key) throws SQLException {
		CountryDto dto = new CountryDto();
		psmt = conn.prepareStatement(SEARCH_SELECT);
		psmt.setString(1, key);
		rs = psmt.executeQuery();
		if (rs.next()) {
			dto.setCountry_id(rs.getString("country_id"));
			dto.setCountry_name(rs.getString("country_name"));
			dto.setRegion_id(rs.getInt("region_id"));
		} else {
			System.out.println("존재하지 않는 레코드 입니다.");

		}
		return dto;
	}

	@Override
	public int insert(CountryDto dto) throws SQLException {
		psmt = conn.prepareStatement(CO_INSERT);
		psmt.setString(1, dto.getCountry_id());
		psmt.setString(2, dto.getCountry_name());
		psmt.setInt(3, dto.getRegion_id());
		int n = psmt.executeUpdate();

		return n;
	}

	@Override
	public int update(CountryDto dto) throws SQLException {
		psmt = conn.prepareStatement(CO_UPDATE);
		psmt.setString(1, dto.getCountry_name());
		psmt.setInt(2, dto.getRegion_id());
		psmt.setString(3, dto.getCountry_id());
		int n = psmt.executeUpdate();
		return n;
	}

	@Override
	public int delete(CountryDto dto) throws SQLException {
		psmt = conn.prepareStatement(CO_DELETE);
		psmt.setString(1, dto.getCountry_id());
		int n = psmt.executeUpdate();
		return n;
	}

}
