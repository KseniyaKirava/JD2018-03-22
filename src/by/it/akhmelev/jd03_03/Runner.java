package by.it.akhmelev.jd03_03;

import by.it.akhmelev.jd03_03.beans.Ad;
import by.it.akhmelev.jd03_03.beans.Role;
import by.it.akhmelev.jd03_03.beans.User;
import by.it.akhmelev.jd03_03.dao.DAO;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {
        DAO dao = DAO.getInstance();
        dao.reset();

        System.out.println("\n=== Проверим DAO для бина Role");
        System.out.println(dao.role.getAll(""));
        Role role = new Role(-1, "testRole");
        dao.role.create(role);
        System.out.println(dao.role.getAll(""));
        role.setRole("testRoleForDelete");
        dao.role.update(role);
        System.out.println(dao.role.getAll(""));
        dao.role.delete(role);
        System.out.println(dao.role.getAll(""));

        System.out.println("\n=== Проверим DAO для бина User");
        System.out.println(dao.user.getAll(""));
        User user = new User(-1, "testUser", "testUserPass", "testUserEmail", 2);
        dao.user.create(user);
        System.out.println(dao.user.getAll(""));
        user.setLogin("testUserForDelete");
        dao.user.update(user);
        System.out.println(dao.user.getAll(""));
        dao.user.delete(user);
        System.out.println(dao.user.getAll(""));

        System.out.println("\n=== Проверим DAO для бина Ad");
        System.out.println(dao.ad.getAll(""));
        Ad ad = new Ad(-1, "testAd", 2, 66666.0, 48.0, 3, 5, "пр. Мулявина 3, кв. 33 ", 2);
        dao.ad.create(ad);
        System.out.println(dao.ad.getAll(""));
        ad.setDescription("testAdForDelete");
        dao.ad.update(ad);
        System.out.println(dao.ad.getAll(""));
        dao.ad.delete(ad);
        System.out.println(dao.ad.getAll(""));
    }
}
