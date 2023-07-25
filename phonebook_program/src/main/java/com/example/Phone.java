package com.example;
import java.util.Scanner;

class node {
    node left;
    node right;
    String name;
    String number;
    String email;

    public node(String name, String no, String email) {
        left = null;
        right = null;
        this.name = name;
        this.number = no;
        this.email = email;
    }
}


class BinaryTree {
    Scanner sc = new Scanner(System.in);
    public static node root;
    String name;
    String number;
    String email;
    private char s;
    int ch;
    static final int COUNT = 10;

    BinaryTree() {
        root = null;
    }

    int flag = 0;

public void insert(String name,String number, String email){
    node ptr;
    node temp = new node(name, number, email);
    if (root == null) {
        root = temp;
    }

    else {
        ptr = root;
        while (flag == 0) {
            if ((temp.name).compareTo(ptr.name) > 0) {
                if (ptr.right != null) {
                    ptr = ptr.right;
                } else {
                    ptr.right = temp;
                    flag = 1;
                }
            }
            if ((temp.name).compareTo(ptr.name) < 0) {
                if (ptr.left != null) {
                    ptr = ptr.left;
                } else {
                    ptr.left = temp;
                    flag = 1;
                }
            }
        }
        flag=0;
    }
    

}

 public void create(String name,String number,String email) {
        Scanner sc = new Scanner(System.in);
        int ch, flag = 0, flag1 = 0;
        node ptr, any;
        do {

           

            while (number.length() != 11) {
                System.out.println("\nThe Contact Number Must 11 Digit!...\n");
                System.out.println("PLEASE ENTER VALID NUMBER!...");
                number = sc.next();
            }
     
            any = root;
            while (any != null) {
                if (any.name.compareTo(number) == 0) {
                    flag = 1;
                    break;
                }
                if ((any.name).compareTo(number) > 0) {
                    any = any.left;
                } else {
                    any = any.right;
                }
            }
            if (flag == 1) {
                System.out.println("This Number is Already Present in Phonebook");
                System.out.println("Enter Some Different Number!");
                number = sc.next();
                while (number.length() != 11) {
                    System.out.println("\nThe Contact Number Must 11 Digit!...\n");
                    System.out.println("PLEASE ENTER VALID NUMBER!...");
                number = sc.next();
                }
               
            }
            int m = email.length() - 1;
            while (m != -1) {
                if (email.charAt(m) == '@') {
                    flag1 = 1;
                }
                if (email.charAt(m) == '.') {
                    flag1 = 2;
                    break;
                }
                m--;
            }
            if (flag1 != 2) {
                System.out.println("Enter Valid Email address : ");
                email = sc.next();
            }
            node temp = new node(name, number, email);
            if (root == null) {
                root = temp;
            }

            else {
                ptr = root;
                while (flag == 0) {
                    if ((temp.number).compareTo(ptr.number) > 0) {
                        if (ptr.right != null) {
                            ptr = ptr.right;
                        } else {
                            ptr.right = temp;
                            flag = 1;
                        }
                    }
                    if ((temp.number).compareTo(ptr.number) < 0) {
                        if (ptr.left != null) {
                            ptr = ptr.left;
                        } else {
                            ptr.left = temp;
                            flag = 1;
                        }
                    }
                }
            }
            flag = 0;

            System.out.println("");
            System.out.println("Do you want to Add any Phone Record (0/1): ");
            ch = sc.nextInt();
        } while (ch != 0);
    }// create()

    public void update() {
        int flag = 0;
        node ptr;
        System.out.println("Enter a Contact Name you want to update : ");
        Scanner scan = new Scanner(System.in);
        String key = scan.next();
        ptr = root;
        while (ptr != null) {
            if ((ptr.name).compareTo(key) == 0) {
                flag = 1;
                break;
            }
            if ((ptr.name).compareTo(key) > 0) {
                ptr = ptr.left;
            } else {
                ptr = ptr.right;
            }
        }
        if (flag == 1) {
            System.out.println("Enter New Number : ");
            String new1;
            new1 = sc.next();
            ptr.number = new1;
        }

    }

    public node search(String key) {
        int flag = 0;
        node ptr;
        ptr = root;
        while (ptr != null) {
            if (ptr.name.compareTo(key) == 0) {
                flag = 1;
                System.out.println("\n\tRECORD FOUND");
                return ptr;
            }
            if ((ptr.name).compareTo(key) > 0) {
                ptr = ptr.left;
            } else {
                ptr = ptr.right;
            }
        }
        if (flag == 0) {
            System.out.println("RECORD NOT FOUND");
            return null;
        }
        return ptr;
    }
    
  

    public void delete() {
        int flag = 0;
        node ptr, parent = null;
        System.out.println("Enter a Contact name you want to delete");
        Scanner scan = new Scanner(System.in);
        String key = scan.next();
        ptr = root;
        while (ptr != null) {
            if ((ptr.name).compareTo(key) == 0) {
                flag = 1;
                break;
            }
            if ((ptr.name).compareTo(key) > 0) {
                parent = ptr;
                ptr = ptr.left;
            } else {
                parent = ptr;
                ptr = ptr.right;
            }
        }
        System.out.println(ptr.name);
        if (flag == 1) {
            if (ptr.left != null && ptr.right == null) {
                if (parent.left == ptr) {
                    parent.left = ptr.left;
                } else {
                    parent.right = ptr.left;
                }
            }
            if (ptr.left == null && ptr.right != null) {
                if (parent.left == ptr) {
                    parent.left = ptr.right;
                } else {
                    parent.right = ptr.right;
                }
            }
            if (ptr.left != null && ptr.right != null) {
                node p;
                p = ptr.left;
                System.out.println("ptr= " + ptr.name);
                while (p.right != null) {
                    parent = p;
                    p = p.right;
                }
                ptr.name = p.name;
                ptr.number = p.number;
                if (p.left != null) {
                    parent.right = p.left;
                } else {
                    ptr.left = null;
                }
            }
            if (ptr.left == null && ptr.right == null) {
                if (parent.left == ptr) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }
        }
    }

    public void inorder(node root)

    {
        if (root != null) {

            System.out.println("" + root.name + "\t    " + root.number + "\t      " + root.email);
            inorder(root.left);
            inorder(root.right);
        }
    }
    
    


    public void display() {
        inorder(root);
        
    }
    
 
}

public class Phone {
    public static String key;
   
    
    public static void main(String s[]) {
        BinaryTree b = new BinaryTree();
        Scanner sc = new Scanner(System.in);
        int ch, ch1;
        String name,number,email;
        b.insert("ahmed", "01157816742", "ahmed@gmail.com");
        b.insert("mohamed", "01006482931", "mohamed@gmail.com");
        b.insert("ali", "01025592621", "ali@gmail.com");
        b.insert("omar", "01025491749", "omar@gmail.com");
        b.insert("mark", "01035272883", "mark@gmail.com");

        System.out.print("\n          WELCOME TO OUR PHONEBOOK          \n");

        do {

            // System.out.println("\n-------------------------------------------------------------------------------------");
            System.out.print(
                    "\n 1. Insert             \n 2. Edit \n 3. All Contacts Information \n 4. Search \n 5. Delete \n 6. Exit \n");
            // System.out.println("\n-------------------------------------------------------------------------------------");
            System.out.println("\nENTER YOUR CHOICE : ");
            ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("Enter the Name : ");
                    name = sc.next();
                    System.out.println("Enter the Contact Number : ");
                    number = sc.next();
                    System.out.println("Enter the Email : ");
                    email = sc.next();
                    b.create(name, number, email);
                    break;
                case 2:
                    b.update();
                    break;
                case 3:
                    System.out.println("-----------------------------------------------");
                    System.out.println("NAME\t|  CONTACT NUMBER  |\tEMAIL");
                    System.out.println("-----------------------------------------------");
                    b.display();
                    System.out.println("-----------------------------------------------");
                 
                    break;
                case 4:
                    System.out.println("Enter a Name to be searched : ");
                    key = sc.next();
                    node ptr = b.search(key);
                    if(ptr!=null){
                        App.main(ptr);
                    }
                    
                    break;
                case 5:
                    b.delete();
                    break;
                case 6:
                    System.out.println("EXITING FROM THE PHONEBOOK!");
                    return;
            }
            System.out.println("");
            System.out.println("Do you want to continue?(0/1) OPERATIONS");
            ch1 = sc.nextInt();
        } while (ch1 == 1);
    }
}

