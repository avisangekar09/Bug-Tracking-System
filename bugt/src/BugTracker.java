
import java.sql.*;
        import java.util.ArrayList;
import java.util.List;

public class BugTracker {
    public void reportBug(Bug bug) {
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement statement = conn.prepareStatement("INSERT INTO bugs (description, status, priority) VALUES (?, ?, ?)")) {
            statement.setString(1, bug.getDescription());
            statement.setString(2, bug.getStatus());
            statement.setString(3, bug.getPriority());
            statement.executeUpdate();
            System.out.println("Bug reported successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Bug> getAllBugs() {
        List<Bug> bugs = new ArrayList<>();
        try (Connection conn = DatabaseManager.getConnection();
             Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM bugs")) {
            while (resultSet.next()) {
                Bug bug = new Bug(
                        resultSet.getString("description"),
                        resultSet.getString("status"),
                        resultSet.getString("priority"));
                bugs.add(bug);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bugs;
    }
    public void updateBug(int id, String status, String priority) {
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement statement = conn.prepareStatement("UPDATE bugs SET status = ?, priority = ? WHERE id = ?")) {
            statement.setString(1, status);
            statement.setString(2, priority);
            statement.setInt(3, id);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Bug updated successfully!");
            } else {
                System.out.println("Bug with ID " + id + " not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteBug(int id) {
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement statement = conn.prepareStatement("DELETE FROM bugs WHERE id = ?")) {
            statement.setInt(1, id);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Bug deleted successfully!");
            } else {
                System.out.println("Bug with ID " + id + " not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

