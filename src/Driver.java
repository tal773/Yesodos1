public class Driver {

    public static Bridge getBridge(){
        Proxy bridge =  new Proxy();
        // bridge.real = new Real();
        return bridge;
    }
}
