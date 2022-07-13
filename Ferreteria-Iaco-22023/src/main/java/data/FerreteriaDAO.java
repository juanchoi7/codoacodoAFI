package data;

import static data.Conexion.*;
import java.sql.*;
import java.util.*;
import model.Ferreteria;

public class FerreteriaDAO {

    private static final String SQL_CREATE = "INSERT INTO tornillos(codigoSku, descripcion, pesoUnidad, precio, stock) VALUES(?, ?, ?, ?, ?)";
    private static final String SQL_READ = "SELECT * FROM tornillos WHERE !bajaLogica";
    private static final String SQL_READ_BY_ID = "SELECT * FROM tornillos WHERE idtornillos = ?";
    private static final String SQL_UPDATE_PRECIO = "UPDATE tornillos SET precio = ? WHERE idtornillos = ? ";
    private static final String SQL_UPDATE_STOCK = "UPDATE tornillos SET stock = ? WHERE idtornillos = ? ";
    private static final String SQL_UPDATE_TORNILLO = "UPDATE tornillos SET codigoSku = ?, descripcion = ?, pesoUnidad = ?, precio = ?, stock = ? WHERE idtornillos = ? ";
    private static final String SQL_DELETE = "UPDATE tornillos SET bajaLogica = 1 WHERE idtornillos = ?";
    private static final String SQL_UNDELETE = "UPDATE tornillos SET bajaLogica = 0 WHERE idtornillos = ?";
    private static final String SQL_READ_DELETED = "SELECT * FROM tornillos WHERE bajaLogica";

    public List<Ferreteria> findAll() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Ferreteria tornillo;
        List<Ferreteria> tornillos = new ArrayList();

        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_READ);
            rs = stmt.executeQuery();
            while (rs.next()) {

                int idtornillos = rs.getInt(1);
                String codigoSku = rs.getString(2);
                String descripcion = rs.getString(3);
                int pesoUnidad = rs.getInt(4);
                double precio = rs.getDouble(5);
                int stock = rs.getInt(6);

                tornillo = new Ferreteria(idtornillos, codigoSku, descripcion, pesoUnidad, precio, stock);

                tornillos.add(tornillo);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return tornillos;
    }

    public Ferreteria findById(int id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Ferreteria tornillo = null;

        System.out.println("findById: " + id);

        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_READ_BY_ID);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            while (rs.next()) {

                int idtornillos = rs.getInt(1);
                String codigoSku = rs.getString(2);
                String descripcion = rs.getString(3);
                int pesoUnidad = rs.getInt(4);
                double precio = rs.getDouble(5);
                int stock = rs.getInt(6);

                tornillo = new Ferreteria(idtornillos, codigoSku, descripcion, pesoUnidad, precio, stock);
                System.out.println("tornillo enc: " + tornillo.toString());
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return tornillo;
    }

    public int insert(Ferreteria tornillo) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_CREATE);
            stmt.setString(1, tornillo.getCodigoSku());
            stmt.setString(2, tornillo.getDescripcion());
            stmt.setInt(3, tornillo.getPesoUnidad());
            stmt.setDouble(4, tornillo.getPrecio());
            stmt.setInt(5, tornillo.getStock());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

    public int updatePrecio(Ferreteria tornillo) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_UPDATE_PRECIO);
            stmt.setDouble(1, tornillo.getPrecio());
            stmt.setInt(2, tornillo.getIdtornillo());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

    public int updateStock(Ferreteria tornillo) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_UPDATE_STOCK);
            stmt.setInt(1, tornillo.getStock());
            stmt.setInt(2, tornillo.getIdtornillo());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

    public int updateTornillo(Ferreteria tornillo) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_UPDATE_TORNILLO);
            stmt.setString(1, tornillo.getCodigoSku());
            stmt.setString(2, tornillo.getDescripcion());
            stmt.setInt(3, tornillo.getPesoUnidad());
            stmt.setDouble(4, tornillo.getPrecio());
            stmt.setInt(5, tornillo.getStock());
            stmt.setInt(6, tornillo.getIdtornillo());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

    public int deleteTornillo(Ferreteria tornillo) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, tornillo.getIdtornillo());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

    public int reactivaTornillo(Ferreteria tornillo) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_UNDELETE);
            stmt.setInt(1, tornillo.getIdtornillo());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

    public List<Ferreteria> findAllDeleted() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Ferreteria tornillo;
        List<Ferreteria> tornillos = new ArrayList();

        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_READ_DELETED);
            rs = stmt.executeQuery();
            while (rs.next()) {

                int idtornillos = rs.getInt(1);
                String codigoSku = rs.getString(2);
                String descripcion = rs.getString(3);
                int pesoUnidad = rs.getInt(4);
                double precio = rs.getDouble(5);
                int stock = rs.getInt(6);

                tornillo = new Ferreteria(idtornillos, codigoSku, descripcion, pesoUnidad, precio, stock);

                tornillos.add(tornillo);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return tornillos;
    }
}
