import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Run {
    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String code = bCryptPasswordEncoder.encode("123456");
        System.out.println(code);
    }
}
