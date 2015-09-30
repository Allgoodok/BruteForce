/**
 * Created by vlad on 30.09.15.
 */
public class Test {

    public static void main(String[] args) {
        char[] charset = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        BruteForce bf = new BruteForce(charset, 1);
        ClientAuthentication clientAuthentication = new ClientAuthentication();
        String attempt = bf.toString();
        while (true)
        {
            if (clientAuthentication.Authenticate("http://127.0.0.1:80", "vlad", attempt, "out/a.txt") == 200)
            {
                System.out.println("Password Found: " + attempt);
                break;
            }else{
                System.out.println("Wrong attempt: " + attempt);
            }
            attempt = bf.toString();
            System.out.println("" + attempt);
            bf.increment();
        }
    }
}
