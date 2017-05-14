package learnforfun.mvc.DAO;

/**
 * Created by Omar on 06-May-17.
 */
public interface UserHistoryDAO {
    public void insert(String username);

    public void delete(String username);

    public boolean exists(String username);
}
