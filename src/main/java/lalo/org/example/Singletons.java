package org.example;

public class Singletons {
    public static void main(String[] args) {
        ClassBasedEagerSingleton first = ClassBasedEagerSingleton.getInstance();
        ClassBasedEagerSingleton second = ClassBasedEagerSingleton.getInstance();
        System.out.println(second.info);
        first.info="Modified";
        System.out.println(second.info);

        ClassBasedLazySingleton third = ClassBasedLazySingleton.getInstance();
        System.out.println(third.info);

        ClassBasedEagerStaticBlockSingleton fourth =
                // Direct access to instance is possible here
                ClassBasedEagerStaticBlockSingleton.instance;
        System.out.println(fourth.info);

        /* Using an enum-based singleton */
        EnumBasedSingleton fifth = EnumBasedSingleton.instance;
        System.out.println("fifth: "+fifth.getInfo());
        EnumBasedSingleton sixth = EnumBasedSingleton.instance.getInstance();
        sixth.setInfo("New enum info");
        System.out.println("fifth: "+fifth.getInfo());
        System.out.println("sixth: "+fifth.getInfo());

    }

}

class ClassBasedEagerSingleton{
    public String info = "Hello";
    // instance is created when class is loaded by JVM, making this an
    // "eager" type singleton:
    private static ClassBasedEagerSingleton instance = new ClassBasedEagerSingleton();
    private ClassBasedEagerSingleton(){}
    public static ClassBasedEagerSingleton getInstance() {
        return instance;
    }
}

class ClassBasedEagerStaticBlockSingleton{
    public String info = "Hello static block";

    // instance may be public so getInstance() is not required:
    public static ClassBasedEagerStaticBlockSingleton instance;
    private ClassBasedEagerStaticBlockSingleton(){}
    // instance is created using a static block. It is still an
    // "eager" type singleton, but initialization is more flexible,
    // allowing, for example, to handle exceptions:
    static {
        instance = new ClassBasedEagerStaticBlockSingleton();
    }

}

class ClassBasedLazySingleton{
    public String info;
    private static ClassBasedLazySingleton instance;
    private ClassBasedLazySingleton(String info){
        this.info = info;
    }
    public static ClassBasedLazySingleton getInstance() {
        // instance is created when it is first needed, so
        // this is a "lazy" type singleton:
        if (instance==null){
            instance = new ClassBasedLazySingleton("Hello");
        }
        return instance;
    }
}

enum EnumBasedSingleton{

    /* This approach has serialization and thread-safety guaranteed by the
     enum implementation itself. */

    instance ("Enum Based Singleton");
    private String info;

    EnumBasedSingleton(String info){
        this.info = info;
    }
    public EnumBasedSingleton getInstance(){
        return instance;
    }

    public String getInfo() {
        return info;
    }
    public void setInfo(String info) {
        this.info = info;
    }
}
