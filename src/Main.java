import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();

        userRepository.addUser(new User(1, "Anastasia", "anastasia@gmail.com"));
        userRepository.addUser(new User(2, "Andrej", "andrej@gmail.com"));
        userRepository.addUser(new User(3, "Ivan", "ivan@gmail.com"));

        Optional<User> userById = userRepository.findUserById(2);
        if (userById.isPresent()) {
            System.out.println("Знайдений користувач за id: " + userById.get());
        } else {
            System.out.println("Користувач з таким id не знайдений.");
        }

        Optional<User> userByEmail = userRepository.findUserByEmail("ivan@gmail.com");
        if (userByEmail.isPresent()) {
            System.out.println("Знайдений користувач за email: " + userByEmail.get());
        } else {
            System.out.println("Користувач з таким email не знайдений.");
        }

        Optional<List<User>> allUsers = userRepository.findAllUsers();
        if (allUsers.isPresent()) {
            System.out.println("Кількість користувачів: " + allUsers.get().size());
            allUsers.get().forEach(System.out::println);
        } else {
            System.out.println("Список користувачів порожній.");
        }
    }
}
