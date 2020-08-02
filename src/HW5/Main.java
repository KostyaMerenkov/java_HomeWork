package HW5;

public class Main {
    public static void main(String[] args) {
        Employees[] eArray = new Employees[5];
        eArray[0] = new Employees("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30);
        eArray[1] = new Employees("Petrov Petr", "Engineer", "pepetro@mailbox.com", "892312312", 32000, 43);
        eArray[2] = new Employees("Helena Publerg", "Engineer", "helepu@mailbox.com", "8923158945", 31000, 50);
        eArray[3] = new Employees("Dmitriy O", "Engineer", "odmier@mailbox.com", "89231895", 38000, 27);
        eArray[4] = new Employees("Regina Z", "Engineer", "zregin@mailbox.com", "892319684", 42000, 17);

        for (int i = 0; i < eArray.length; i++) {
            if (eArray[i].getAge() > 40) eArray[i].printInfo();
        }
    }


}

