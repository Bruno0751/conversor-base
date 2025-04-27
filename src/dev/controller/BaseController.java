package dev.controller;

import javax.swing.JOptionPane;
import dev.service.BaseService;
import java.awt.HeadlessException;

/**
 *
 * @author Bruno Gressler vda Silveira
 * @since 10/02/2025
 * @version 1
 */
public class BaseController {

    public static void init() throws Exception {
        byte op;
        do {
            try {
                op = Byte.parseByte(JOptionPane.showInputDialog(null, "------------CONVERSOR BASES------------\n"
                        + "0 - SAIR\n"
                        + "1 - DECIMAL -> BINARIO\n"
                        + "2 - DECIMAL -> OCTAL\n"
                        + "3 - DECIMAL -> HEXADECIMAL\n"
                        + dev.util.Util.taxarText("4 - BINARIO - > DECIMAL") + "\n"
                        + "---------------------------------------", "", JOptionPane.QUESTION_MESSAGE));
            } catch (HeadlessException | NumberFormatException e) {
                if (e.getMessage().contains("For input string")) {
                    throw new NumberFormatException("DIGITE UMA OPÇÃO DO MENU\n"
                            + "SISTEMA ENCERRADO");
                }
                throw new NumberFormatException(e.getMessage() + "\n"
                        + "SISTEMA ENCERRADO");
            }

            switch (op) {
                case 0:
                    JOptionPane.showMessageDialog(
                            null, "SISTEMA ENCERRADO", "", JOptionPane.INFORMATION_MESSAGE
                    );
                    break;
                default:
                    if (op >= 1 && op <= 3) {
                        int numero;
                        try {
                            numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Numero:", "", JOptionPane.QUESTION_MESSAGE));
                        } catch (NumberFormatException e) {
                            throw new NumberFormatException("FORMATO DE NÚMERO INVÀLIDO");
                        }

                        if (numero >= 1111111111) {
                            JOptionPane.showMessageDialog(null, "ERRO", "", JOptionPane.ERROR_MESSAGE);
                        } else {
                            double resultado;
                            String response;
                            if (numero != 0 && numero != 1) {
                                switch (op) {
                                    case 1:
                                        String result = BaseController.converterDecimalToBinario(numero);
                                        JOptionPane.showMessageDialog(
                                                null, "Binary = " + result + " Decimal = " + String.valueOf(numero), "", JOptionPane.INFORMATION_MESSAGE
                                        );
                                        break;
                                    case 2:
                                        result = BaseController.converterDecimalToOctal(numero);
                                        JOptionPane.showMessageDialog(
                                                null, "Octal = " + result + " Decimal = " + String.valueOf(numero), "", JOptionPane.INFORMATION_MESSAGE
                                        );
                                        break;
                                    case 3:
                                        result = BaseController.converterDecimalToHexacimal(numero);
                                        JOptionPane.showMessageDialog(
                                                null, "HexaDecimal = " + result + " Decimal = " + String.valueOf(numero), "", JOptionPane.INFORMATION_MESSAGE
                                        );
                                        break;
//                                    case 4:
//                                        resultado = BaseController.converterBinarioToDecimal(numero);
//                                        response = BaseController.verifyResponse(resultado);
//                                        JOptionPane.showMessageDialog(
//                                                null, "Binário = " + numero + " Decimal = " + response, "", JOptionPane.INFORMATION_MESSAGE
//                                        );
//                                        break;
                                }
                            } else {
                                resultado = numero;
                                response = BaseController.verifyResponse(resultado);
                                JOptionPane.showMessageDialog(
                                        null, "Binary = " + numero + " Decimal = " + response, " | ", JOptionPane.INFORMATION_MESSAGE
                                );
                            }

                        }
                        break;
                    } else {
                        JOptionPane.showMessageDialog(
                                null, "INVALID OPTION", "", JOptionPane.INFORMATION_MESSAGE
                        );
                    }
            }
        } while (op != 0);
    }

    private static double converterBinarioToDecimal(int numero) throws Exception {
        return BaseService.convertBinarioToDecimal(numero);
    }

    private static String converterDecimalToBinario(int numero) throws Exception {
        return BaseService.converterDecimalToBinario(numero);
    }

    private static String verifyResponse(double resultado) {
        String response = String.valueOf(resultado);
        response = response.contains(".") ? response.replace(".0", "") : response;
        return response;
    }

    private static String converterDecimalToOctal(int numero) {
        return BaseService.converterDecimalToOctal(numero);
    }

    private static String converterDecimalToHexacimal(int numero) {
        return BaseService.converterDecimalToHexacimal(numero);
    }
}
