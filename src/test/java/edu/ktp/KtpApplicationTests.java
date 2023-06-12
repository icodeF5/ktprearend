package edu.ktp;

import edu.ktp.dao.SchoolDao;
import edu.ktp.dao.UserDao;
import edu.ktp.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class KtpApplicationTests {

    @Autowired
    public UserDao userDao;

    @Autowired
    public SchoolDao schoolDao;

    @Test
    void contextLoads() {
        User user = userDao.getUser("2790895170@qq.com");
        System.out.println(user.getRole());
    }

}
