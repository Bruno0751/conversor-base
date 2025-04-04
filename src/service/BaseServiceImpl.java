package service;

/**
 *
 * @author Bruno Gressler vda Silveira
 * @since 10/02/2025
 * @version 1
 */
public class BaseServiceImpl {

    public double convertBinarioToDecimal(int numero) throws Exception {
        /*
        2 - 10
        3 - 11
        4 - 100
        5 - 101
        6 - 110
        7 - 111
        8 - 1000
        9 - 1001
        10 - 1010
        11 - 1011
        12 - 1100
        13 - 1101
        14 - 1111
        15 - 1111
        16 - 10000
        17 - 10001
        18 - 10010
        19 - 10011
         */
        double resultado = 0;
        String nrBinarioAux = String.valueOf(numero);
        final byte BASE = 2;
        double listaResults[] = new double[nrBinarioAux.length()];
        int count = 0;

        while (count < nrBinarioAux.length()) {
            byte nr;
            char nrAux;
            double decimal;
            if (count == 0) {
                nrAux = nrBinarioAux.charAt(nrBinarioAux.length() - 1);
                nr = Byte.parseByte(String.valueOf(nrAux));
                double pow = Math.pow(BASE, count);
                decimal = nr * pow;
                listaResults[0] = decimal;
            } else {
                nrAux = nrBinarioAux.charAt(nrBinarioAux.length() - count - 1);
                nr = Byte.parseByte(String.valueOf(nrAux));
                double pow = Math.pow(BASE, count);
                decimal = nr * pow;
                listaResults[count] = decimal;
            }
            System.out.println(nr);
            count++;
        }
        count = 0;
        double x;
        double y;
        while (count < listaResults.length) {
            if (count == 0) {
                x = listaResults[count];
                if (nrBinarioAux.length() > 1) {
                    y = listaResults[count + 1];
                    resultado = x + y;
                }

            } else {
                try {
                    resultado += listaResults[count + 2];
                } catch (Exception ignored) {
                    throw new Exception(ignored.getMessage());
                }
            }
            count++;
        }

        return resultado;
    }

    String converteDecimalParaBinario(int valor) {
        return Integer.toBinaryString(valor);
    }

    String converteDecimalParaOctal(int numero) {
        return Integer.toOctalString(numero);
    }

    String converteDecimalParaHexaDecimal(int numero) {
        return Integer.toHexString(numero).toUpperCase();
    }
}
