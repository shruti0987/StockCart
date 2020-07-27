package repository;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import model.RStock;
import model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
Collection<SavedStocks> findByuserid(long userid);
	long findByUsername(String username);
	/*@Query("Select user_id from Users where user_name = :username")
	Long getIdByUsername(@Param("username") String username); //returns the userId of the given user
	
	@Query("Select * from SavedStocks where user_id = :userId")
	Collection<RStock> getSavedStocks(@Param("userId") Long userId); //returns the stocks saved by the given user(using the user id)
*/
}
