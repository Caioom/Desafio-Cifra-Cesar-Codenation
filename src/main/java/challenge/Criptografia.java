package challenge;

import java.io.IOException;

public interface Criptografia {

    String criptografar(String texto) throws IOException;

    String descriptografar(String texto);
}
