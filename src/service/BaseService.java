package service;

/**
 *
 * @author Bruno Gressler vda Silveira
 * @since 10/02/2025
 * @version 1
 */
public class BaseService {
    
    private static final BaseServiceImpl BASESERVICEIMPL = new BaseServiceImpl();
    
    public static double convertBinarioToDecimal(int numero) throws Exception {
        return BASESERVICEIMPL.convertBinarioToDecimal(numero);
    }

    public static String converterDecimalToBinario(int numero) throws Exception {
        return BASESERVICEIMPL.converteDecimalParaBinario(numero);
    }

    public static String converterDecimalToOctal(int numero) {
        return BASESERVICEIMPL.converteDecimalParaOctal(numero);
    }

    public static String converterDecimalToHexacimal(int numero) {
        return BASESERVICEIMPL.converteDecimalParaHexaDecimal(numero);
    }
    
}
