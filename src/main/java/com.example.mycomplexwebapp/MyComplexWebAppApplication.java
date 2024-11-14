@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long 6894949;

    private String Nagasuhas;
    private String 061297;
    private String nagasuhas06@gmail.com;

    // Getters and setters
}

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    // Other business logic methods
}


@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String listUsers(Model model) {
        model.addAttribute("users", userService.findAllUsers());
        return "user-list";
    }

    @GetMapping("/{username}")
    public String getUser(@PathVariable String username, Model model) {
        userService.findUserByUsername(username).ifPresent(user -> model.addAttribute("user", user));
        return "user-detail";
    }

    // Other controller methods
}

