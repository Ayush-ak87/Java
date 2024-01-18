

public class aboutpackage {
    public String str_1 = "I am a public member";
    void printFromClass() {
        System.out.println("Witin Class " + str_1);
    }

    public static void main(String[] args) {
        aboutpackage obj = new aboutpackage();
        obj.printFromClass();
        System.out.println(obj.str_1);
        aboutpackage2 obj2 = new aboutpackage2();
        obj2.printFromOutsideClass();
    }
}

class aboutpackage2{
    void printFromOutsideClass(){
        aboutpackage obj = new aboutpackage();
        System.out.println("Witin Package , outside classes " + obj.str_1);
    }
}
