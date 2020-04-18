package challenge;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CriptografiaCesariana implements Criptografia {
    //Tratando alfabeto
    List<String> alphabet = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
            "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z");

    @Override
    public String criptografar(String texto){
       if(texto.isEmpty()) {
           throw new IllegalArgumentException("Insira um texto");
       }

       return encode(texto);
    }

    @Override
    public String descriptografar(String texto) {
        if(texto.isEmpty()) {
            throw new IllegalArgumentException("Insira um texto");
        }
        return decode(texto);
    }

    public String encode(String texto) {
        ArrayList<String> response = new ArrayList<>();

        String textoOriginal = texto.toLowerCase();

        char[] arrayTexto = textoOriginal.toCharArray();

        int casas = 3;
        for(char letra : arrayTexto) {
            int posLetra = alphabet.indexOf(String.valueOf(letra));
            String letraUse = String.valueOf(letra);
            if (!(letraUse.matches("([,])|([.])|(\\d)|([\" \"])"))) {
                if (posLetra > 21) {
                    int posIterada = 0;
                    while (posLetra < 24) {
                        posIterada++;
                        posLetra++;
                    }

                    int posReplace = (casas - 1) - posIterada;

                    response.add(alphabet.get(posReplace));
                } else {
                    int posReplace = posLetra + casas;

                    response.add(alphabet.get(posReplace));
                }
            } else {
                response.add(letraUse);
            }
        }

        String resposta = "";
        for (String r : response) {
            resposta += r;
        }

        return resposta;
    }

    public String decode(String texto) {
        String ciphered = texto.toLowerCase();
        //Tratando parametros recebidos
        char [] letters = ciphered.toCharArray();

        int places = 3;

        ArrayList<String> arrayAlphabet = new ArrayList<>();
        arrayAlphabet.addAll(alphabet);


        //Variaveis para tratamento da resposta
        ArrayList<String> response = new ArrayList<>();
        String deciphered = "";

        for(int i = 0; i < letters.length; i++) {
            String letter = String.valueOf(letters[i]);

            if(!(letter.matches("([,])|([.])|(\\d)|([\" \"])"))) {
                int positionReplace = arrayAlphabet.indexOf(letter);

                if(positionReplace - places < 0) {
                    int placesIterate = 0;

                    for(int p = 0; positionReplace > 0; p-- ) {
                        positionReplace--;
                        placesIterate++;
                    }

                    positionReplace = (places - 1)- placesIterate;
                    positionReplace = 25  - positionReplace;

                    letter = arrayAlphabet.get(positionReplace);
                    response.add(letter);
                } else {
                    positionReplace -= places;
                    letter = arrayAlphabet.get(positionReplace);
                    response.add(letter);
                }

            } else {
                response.add(letter);
            }

        }

        for(int i = 0; response.size() > i; i++) {
            deciphered += response.get(i);
        }

        return deciphered;
    }

}
