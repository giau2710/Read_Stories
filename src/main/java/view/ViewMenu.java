package view;

public class ViewMenu {

    public static void showMenuUser() {
        System.out.println("|----Welcome to the reading library----|");
        System.out.println("| 1.Đoc truyen                         |");
        System.out.println("| 2.Doc truyen theo the loai           |");
        System.out.println("|                 0.Thoat chuong trinh |");
        System.out.println("|--------------------------------------|");
        System.out.print("Chon chuc nang: ");

    }
    public static void showMenuAdmin() {
        System.out.println("|---------------Menu Admin-------------|");
        System.out.println("| 1.Them truyen                        |");
        System.out.println("| 2.Xem danh sach truyen               |");
        System.out.println("| 3.Sua tryen                          |");
        System.out.println("| 4.Xoa truyen                         |");
        System.out.println("|                 0.Thoat chuong trinh |");
        System.out.println("|--------------------------------------|");
        System.out.print("Chon chuc nang: ");
    }
}