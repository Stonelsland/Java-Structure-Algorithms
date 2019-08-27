package HashTable;

import java.util.Scanner;

public class HashTableDemo {

    public static void main(String[] args) {

        //创建哈希表
        HashTable hashTable = new HashTable(10);
        //定义简单菜单
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("add:添加\tlist:显示\tfind:查询\tdelete:删除\texit:退出");
            key = scanner.next();
            switch (key) {
                case "add":
                    System.out.println("id: ");
                    int id = scanner.nextInt();
                    System.out.println("name: ");
                    String name = scanner.next();
                    Person person = new Person(id, name);
                    hashTable.add(person);
                    break;
                case "list":
                    hashTable.list();
                    break;
                case "find":
                    System.out.println("id:  ");
                    id = scanner.nextInt();
                    hashTable.findPersonById(id);
                    break;
                case "delete":
                    System.out.println("id:  ");
                    id = scanner.nextInt();
                    hashTable.deletePersonById(id);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }
        }
    }
}

//创建哈希表管理多条链表
class HashTable {
    private PersonLinkedList[] personLinkedLists;
    private int size;//链表数
    private int personLinkedListNo = 0;

    public HashTable(int size) {
        this.size = size;
        personLinkedLists = new PersonLinkedList[size];
        //分别初始化每个链表
        for (int i = 0; i < size; i++) {
            personLinkedLists[i] = new PersonLinkedList();
        }
    }

    //添加个人信息
    public void add(Person person) {
        //根据员工id判断加入哪条链表
        personLinkedListNo = hashFun(person.id);
        //将person添加到对应链表中
        personLinkedLists[personLinkedListNo].add(person);
    }

    //遍历所有链表
    public void list() {
        for (int i = 0; i < size; i++) {
            personLinkedLists[i].list(i);
        }
    }

    //根据输入id查找信息
    public void findPersonById(int id) {
        personLinkedListNo = hashFun(id);
        Person person = personLinkedLists[personLinkedListNo].findPersonById(id);
        if (person != null) {
            System.out.printf("在第%d条链表中找到id=%d的个人信息", (personLinkedListNo + 1), id);
        } else {
            System.out.println("未找到匹配项");
        }
    }

    //根据id删除信息
    public void deletePersonById(int id) {
        personLinkedListNo = hashFun(id);
        personLinkedLists[personLinkedListNo].deletePersonById(id);
    }

    //使用简单取模法创建散列函数
    public int hashFun(int id) {
        return id % size;
    }

}

//创建个人信息属性
class Person {

    public int id;
    public String name;
    public Person next;

    public Person(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
}

//创建链表
class PersonLinkedList {
    private Person head;//头指针指向第一个有效数据,默认为null

    //添加
    public void add(Person person) {
        //若添加人为第一个
        if (head == null) {
            head = person;
            return;
        }
        //若不是第一个,则需辅助变量帮助定位
        Person cp = head;
        while (true) {
            if (cp.next == null) {//已到链表结尾处
                break;
            }
            cp = cp.next;//后移
        }
        //退出时将p加入链表
        cp.next = person;
    }

    //遍历
    public void list(int no) {
        if (head == null) {
            System.out.println("第" + (no + 1) + "条链表(空)");
            return;
        }
        System.out.print("第" + (no + 1) + "条链表");
        Person cp = head;
        while (true) {
            System.out.printf("==> id=%d\tname:%s\t", cp.id, cp.name);
            if (cp.next == null) {
                break;
            }
            cp = cp.next;//遍历
        }
        System.out.println();
    }

    //根据id查询个人信息
    public Person findPersonById(int id) {
        if (head == null) {
            System.out.print("链表空\t");
            return null;
        }
        Person cp = head;//辅助定位指针
        while (true) {
            if (cp.id == id) {
                break;//这时cp指向查找结果            }
            }
            if (cp.next == null) {
                cp = null;
                break;
            }
            cp = cp.next;
        }
        return cp;
    }

    //根据id删除个人信息
    public void deletePersonById(int id) {
        if (head == null) {
            System.out.print("链表空\t");
        }
        Person cp = head;//辅助定位指针
        while (true) {
            //判断待删除节点是否为头节点
            if (head.id == id) {
                head = head.next;
                break;
            }
            if (cp.next.id == id) {
                cp.next = cp.next.next;
                break;
            }
            if (cp.next == null) {
                System.out.println("未找到匹配信息");
                break;
            }
        }

    }
}
