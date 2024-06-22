
package Hotel.dao;

import Hotel.entity.DatPhong;
import Hotel.entity.HoaDonThanhToan;
import Hotel.utils.JdbcHelPer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class HoaDonThanhToanDAO {

    public List<HoaDonThanhToan> select() {
        String sql = "SELECT * FROM HoaDonThanhToan";
        return select(sql);
    }
public void delete(String MaHD) {
        String sql = "DELETE FROM HoaDonThanhToan WHERE MaHD=?";
        JdbcHelPer.executeUpdate(sql, MaHD);
    }
    public void insert(HoaDonThanhToan model) {
        String sql = "INSERT INTO HoaDonThanhToan (MaHD, MaDP, MaNV, MaKH, NgayBD, NgayTra, ThanhTien, NgayLap) VALUES (?, ?, ?, ?, ?, ?,?,?)";
        JdbcHelPer.executeUpdate(sql,
                model.getMaHD(),
                model.getMaDP(),
                model.getMaNV(),
                model.getMaKH(),
                model.getNgayThue(),
                model.getNgayTraD(),
                model.getThanhTien(),
                model.getNgayLap()
        );
    }

    public HoaDonThanhToan findById(String maphong) {
        String sql = "SELECT * FROM HoaDonThanhToan WHERE MaHD=?";
        List<HoaDonThanhToan> list = select(sql, maphong);
        return list.size() > 0 ? list.get(0) : null;

    }

    private List<HoaDonThanhToan> select(String sql, Object... args) {
        List<HoaDonThanhToan> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelPer.executeQuery(sql, args);
                while (rs.next()) {
                    HoaDonThanhToan model = readFromResultSet(rs);
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }

    private HoaDonThanhToan readFromResultSet(ResultSet rs) throws SQLException {
        HoaDonThanhToan model = new HoaDonThanhToan();
        model.setMaHD(rs.getString("MaHD"));
        model.setMaDP(rs.getInt("MaDP"));
        model.setMaNV(rs.getString("MaNV"));
        model.setMaKH(rs.getString("MaKH"));
        model.setNgayThue(rs.getDate("NgayBD"));
        model.setNgayTraD(rs.getDate("NgayTra"));
        model.setThanhTien(rs.getFloat(String.valueOf("ThanhTien")));
        model.setNgayLap(rs.getDate("NgayLap"));

        return model;

    }
}
