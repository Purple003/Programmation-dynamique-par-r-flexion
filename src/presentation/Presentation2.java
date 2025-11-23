package presentation;

import dao.IDao;
import metier.IMetier;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Presentation2 {
    public static void main(String[] args) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("config.txt"));

            String daoClassName = scanner.nextLine().trim();
            String metierClassName = scanner.nextLine().trim();

            Class<?> cDao = Class.forName(daoClassName);
            IDao dao = (IDao) cDao.getDeclaredConstructor().newInstance();

            Class<?> cMetier = Class.forName(metierClassName);
            IMetier metier = (IMetier) cMetier.getDeclaredConstructor().newInstance();

            Method setDaoMethod = cMetier.getMethod("setDao", IDao.class);
            setDaoMethod.invoke(metier, dao);

            System.out.println("Résultats = " + metier.calcul());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) scanner.close();
        }
    }
}
