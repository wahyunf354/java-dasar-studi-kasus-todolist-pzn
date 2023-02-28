package com.pzn.java.todolist;

public class Main {
    public static String[] model = new String[10];

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        viewShowTodoList();
    }

    /**
     * Menampilkan todo list
     */
    public static void showTodoList() {
        for (int i = 0; i < model.length; i++) {
            String todo = model[i];
            int no = i + 1;
            if (todo != null) {
                System.out.println(no + ". " + todo);
            }
        }
    }

    public static void testShowTodoList() {
        model[0] = "Belajar Java Dasar";
        model[1] = "Studi kasus java dasar : Aplikasi Todolist";
        showTodoList();
    }

    /**
     * Menambah todo ke list
     */
    public static void addTodoListString (String todo) {

        Boolean isFull = true;

        // cek apakah model penuh
        for (int i = 0; i < model.length; i++) {
            if (model[i] == null) {
                isFull = false;
                break;
            }
        }

        // jike penuh, kita resize ukuran array 2x lipatt
        if(isFull) {
            String[] tmp = model;
            model = new String[model.length * 2];

            for(int i = 0; i < tmp.length; i++) {
                model[i] = tmp[i];
            }
        }

        // tambahkan ke posisi yang data array nya Null
        for (int i = 0; i < model.length; i++) {
            if (model[i] == null) {
                model[i] = todo;
                break;
            }
        }
    }

    public static void testAddTodoList () {
        for (int i = 0; i < 25; i++) {
            addTodoListString("Task ke. " + i);
        }
        showTodoList();
    }

    /**
     * Menghapus todo list
     */
    public static boolean removeTodoList(Integer number) {
        if ((number - 1) >= model.length) {
            return false;
        } else if (model[number - 1] == null) {
            return false;
        } else {
            model[number - 1] = null;

            for (int i = (number-1); i < model.length; i++) {
                if(i == (model.length - 1)) {
                    model[i] = null;
                } else {
                    model[i] = model[i + 1];
                }
            }

            return true;
        }
    }

    public static void testRemoveTodoList() {
        addTodoListString("Satu");
        addTodoListString("Dua");
        addTodoListString("Tiga");
        addTodoListString("Empat");
        addTodoListString("Lima");

        boolean result = removeTodoList(20);
        System.out.println(result);

        result = removeTodoList(7);
        System.out.println(result);

        result = removeTodoList(2);
        System.out.println(result);

        showTodoList();
    }


    public static String input(String info) {
        System.out.print(info + ": ");
        String data = scanner.nextLine();
        return data;
    }

    public static void testInput(){
        String name = input("Nama");
        System.out.println("Hi " + name);
    }
    /**
     * Menampilkan view todo list
     */
    public static void viewShowTodoList() {
        while (true) {
            System.out.println("TODO LIST");
            showTodoList();
            System.out.println("MENU ");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x. Keluar");

            String input = input("Pilih");
            if (input.equals("1")) {
                viewAddTodoList();
            } else if(input.equals("2")) {
                viewRemoveTodoList();
            } else if (input.equals("x")) {
                break;
            } else {
                System.out.println("Pilihan tidak dimengerti");
            }
        }
    }

    public static void testViewShowTodoList() {
        addTodoListString("Satu");
        addTodoListString("Dua");
        addTodoListString("Tiga");
        addTodoListString("Empat");
        addTodoListString("Lima");
        viewShowTodoList();
    }

    /**
     * Menampilkan view menambah todo list
     */
    public static void viewAddTodoList() {
        System.out.println("MENAMBAH TODO LIST");

        String todo = input("Todo (x Jika Batal): ");
        if(todo.equals("x")){
            // batal
        } else {
            addTodoListString(todo);
        }
    }

    public static void testViewAddTodoList() {
        viewAddTodoList();

        showTodoList();
    }

    /**
     * Menampilkan menghapus todo list
     */
    public static void viewRemoveTodoList() {
        System.out.println("MENGAHAPUS TODO LIST");
        String number = input("Nomor yang dihapus (x jika batal): ");

        if(number.equals("x")) {
            // batal
        } else {
            boolean isSuccess = removeTodoList(Integer.valueOf(number));
            if (!isSuccess) {
                System.out.println("Gagal menghapus todolist: " + number);
            }
        }
    }

    public static void testViewRemoveTodoList() {
        addTodoListString("Satu");
        addTodoListString("Dua");
        addTodoListString("3");
        showTodoList();

        viewRemoveTodoList();

        showTodoList();

    }
}