import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static Account register(ArrayList<Account> accounts) {
        String userName;
        boolean check;
        do {
            System.out.println("Nhập userName");
            userName = scanner.nextLine();
            check = checkRegister(accounts, userName);
            if (!check) System.out.println("Nhập lại do trùng username!!");
        } while (!check);
        System.out.println("Nhập passWord");
        String passWord = scanner.nextLine();
        System.out.println("Nhập fullName");
        String fullName = scanner.nextLine();
        System.out.println("Nhập phoneNumber");
        String phoneNumber = scanner.nextLine();
        System.out.println("Nhập address");
        String address = scanner.nextLine();
        return new Account(userName, passWord, fullName, phoneNumber, address);
    }

    public static boolean checkRegister(ArrayList<Account> accounts, String userName) {
        for (Account account : accounts) {
            if (account.getUserName().equals(userName))
                return false;
        }
        return true;
    }

    public static void writeAccount(ArrayList<Account> accounts) {
        File file = new File("D:\\hieujava\\BTVN\\src\\Account.txt");
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            for (Account account : accounts) {
                bufferedWriter.write(account.toString() + "\n");
            }
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean readAccount() {
        File file = new File("D:\\hieujava\\BTVN\\src\\Account.txt");
        File fullNameFile = new File("D:\\hieujava\\BTVN\\src\\FullName.txt");
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fullNameFile));
            String c;
            String[] str;
            boolean check = false;
            while ((c = bufferedReader.readLine()) != null) {
                str = c.split(",");
                check = checkLogin(str[1], str[2]);
                if (check) bufferedWriter.write(str[3]);
                break;
            }
            bufferedWriter.close();
            bufferedReader.close();
            return check;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean checkLogin(String userName, String passWord) {
        System.out.println("Nhập vào username");
        String userNameInput = scanner.nextLine();
        System.out.println("Nhập vào password");
        String passWordInput = scanner.nextLine();
        return userName.equals(userNameInput) && passWord.equals(passWordInput);
    }

    public static String readFullName() {
        File file = new File("D:\\hieujava\\BTVN\\src\\FullName.txt");
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String c;
            while ((c = bufferedReader.readLine()) != null) {
                return c;
            }
            bufferedReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static void main(String[] args) {
        ArrayList<Account> accounts = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("------------MENU-----------");
            System.out.println("1.Đăng ký");
            System.out.println("2.Đăng nhặp");
            System.out.println("3.Hiện tất cả account");
            System.out.println("0.Thoát");
            System.out.println("MỜI NHẬP VÀO LỰA CHỌN CỦA BẠN");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Nhập sai định dạng");
                continue;
            }
            switch (choice) {
                case 1:
                    Account account = register(accounts);
                    accounts.add(account);
                    writeAccount(accounts);
                    System.out.println("Đăng ký thành công");
                    break;
                case 2:
                    if (readAccount()) {
                        String fullName = readFullName();
                        System.out.println("Đăng nhập thành công !! xin chào " + fullName);
                    } else {
                        System.out.println("Đăng nhập thất bại !!");
                    }
                    break;
                case 3:
                    for (Account account1 : accounts) {
                        System.out.println(account1);
                    }
                    break;
                case 0:
                    System.exit(0);
            }
        } while (true);
    }
}
