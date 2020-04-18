package challenge;

public class Application {
    public static void main(String[] args) {
        CriptografiaCesariana cripto = new CriptografiaCesariana();

            String result = cripto.criptografar(null);
            String descripto = cripto.descriptografar("vhmdp ehp ylqgrv dr dfhohud eudvlo 2019");
            System.out.println(result);
            System.out.println(descripto);

    }
}
