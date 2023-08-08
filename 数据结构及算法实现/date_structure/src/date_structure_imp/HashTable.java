package date_structure_imp;

/**
 * @author MrkWinter
 * @version 1.0
 */
public class HashTable {
    private int size;
    private HashLinkList[] hashLinkArray;

    //初始化
    public HashTable(int size) {
        this.size = size;
        this.hashLinkArray = new HashLinkList[size];
        for (int i = 0; i < hashLinkArray.length; i++) {
            hashLinkArray[i] = new HashLinkList();
        }
    }

    //增
    public void add(Emp emp) {
        int hash = hash(emp.getNo());
        hashLinkArray[hash].add(emp);
    }

    //删
    public void delete(int no) {
        int hash = hash(no);
        hashLinkArray[hash].delete(no);
    }

    //查
    public Emp select(int no) {
        int hash = hash(no);
        return hashLinkArray[hash].select(no);
    }

    //改
    public void update(int no, String name) {
        int hash = hash(no);
        hashLinkArray[hash].update(no, name);
    }

    //遍历
    public void list() {
        for (int i = 0; i < hashLinkArray.length; i++) {
            if (!hashLinkArray[i].isEmp())
                hashLinkArray[i].list();
        }
    }

    //散列函数
    public int hash(int no) {
        return no % size;
    }
}

class HashLinkList {
    private Emp headEmp;

    //空
    public boolean isEmp() {
        return headEmp == null;
    }

    //增
    public void add(Emp emp) {
        if (headEmp == null) {
            headEmp = emp;
            return;
        }
        Emp curEmp = headEmp;
        while (curEmp.next != null) {
            curEmp = curEmp.next;
        }
        curEmp.next = emp;
    }

    //删
    public void delete(int no) {
        if (headEmp == null)
            return;
        Emp curEmp = headEmp;
        while (curEmp.next != null) {
            if (curEmp.next.getNo() == no) {
                if (curEmp.next.next == null) {
                    curEmp.next = null;
                    break;
                }
                curEmp.next = curEmp.next.next;
                break;
            }
            curEmp = curEmp.next;
        }
    }

    //查
    public Emp select(int no) {
        if (headEmp == null)
            return null;
        Emp curEmp = headEmp;
        while (curEmp != null) {
            if (curEmp.getNo() == no)
                return curEmp;
            curEmp = curEmp.next;
        }
        return null;
    }

    //改
    public void update(int no, String name) {
        Emp dEmp = select(no);
        dEmp.setName(name);
    }

    //遍历
    public void list() {
        if (headEmp == null)
            return;
        Emp curEmp = headEmp;
        while (curEmp != null) {
            System.out.println(curEmp);
            curEmp = curEmp.next;
        }
    }
}

class Emp {
    private int no;
    private String name;
    public Emp next;

    public Emp(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}