package penitipanhewan.model.admin;

import koneksi.Conn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import org.apache.log4j.Logger;

public class AdminJdbcImplement implements AdminJdbc {

    private final Connection connection;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;
    private String sql;
    private static final Logger logger = Logger.getLogger(AdminJdbcImplement.class);

    public AdminJdbcImplement() {
        connection = Conn.getConnection();
    }

    @Override
    public Boolean login(String userName, String password) {
        try {
            sql = "SELECT * FROM admin WHERE username = ? AND password = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);
            System.out.println(preparedStatement.toString());
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                resultSet.close();
                preparedStatement.close();
                return true;
            } else {
                resultSet.close();
                preparedStatement.close();
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
            return null;
        }
    }

    @Override
    public void insert(Admin request) {
        logger.debug(request.toString());
        try {
            sql = "INSERT INTO admin (nama, username, `admin`, password, `role`) VALUES(?, ?, ?, ?);";
            preparedStatement = connection.prepareStatement(sql);            
            preparedStatement.setString(1, request.getNama());  
            preparedStatement.setString(2, request.getUserName());
            preparedStatement.setString(3, request.getPassword());
            preparedStatement.setString(4, request.getRole());
            logger.debug(preparedStatement.toString());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public String selectRole(String text) {
        String response = new String();
        try {
            sql = "select * from admin where username = ?;";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, text);
            logger.debug(preparedStatement.toString());
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                response = resultSet.getString("role");
            }
            logger.debug(response);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
            logger.error(e.getMessage());
        }
        return response;
    }
}
