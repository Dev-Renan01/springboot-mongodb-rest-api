package Service;

import com.devrenan.springboot_mongodb_rest_api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public void save(User user){
        userRepository.save(user);
    }

    public void update(User user){
        if(user.getId() == null){
            throw new RuntimeException("Informe um id Existente!");
        }
        userRepository.save(user);
    }

    public void delete(User user){
        if (user.getId() == null){
            throw new RuntimeException("Informe um id existente!");
        }
        userRepository.deleteById(user.getId());
    }
}
