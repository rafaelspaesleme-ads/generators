package br.com.rafaelspaesleme.generators;

import br.com.logamigo.logamigo.enums.LangEnum;
import br.com.logamigo.logamigo.utils.ConsoleLogUtils;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Random;

import static java.lang.Boolean.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DocumentsGenerator {

    private static final Random randomNumber = new Random();
    private static final int n1 = randomNumber.nextInt(10);
    private static final int n2 = randomNumber.nextInt(10);
    private static final int n3 = randomNumber.nextInt(10);
    private static final int n4 = randomNumber.nextInt(10);
    private static final int n5 = randomNumber.nextInt(10);
    private static final int n6 = randomNumber.nextInt(10);
    private static final int n7 = randomNumber.nextInt(10);
    private static final int n8 = randomNumber.nextInt(10);
    private static final int n9 = randomNumber.nextInt(10);
    private static final int n10 = randomNumber.nextInt(10);
    private static final int n11 = randomNumber.nextInt(10);
    private static final int n12 = randomNumber.nextInt(10);

    private static int digit1 = 0;
    private static int digit2 = 0;
    private static int rest = 0;

    private static String  nDigResult;
    private static String concatNumbers;
    private static String cpf;
    private static String cnpj;
    private static String rg;

    //23092173051
    private static final String cnh = String.valueOf(n1) + n2 + n3 + n4 + n5 + n6 + n7 + n8 + n9 + n10 + n11;

    public static String toCPF(final Boolean unpointed) {
        final String cpf = ofCPF(unpointed);
        ConsoleLogUtils.ofSuccess("CPF Gerado " + cpf, LangEnum.PT_BR);
        return cpf;
    }
    public static String toCPF() {
        final String cpf = ofCPF(FALSE);
        ConsoleLogUtils.ofSuccess("CPF Gerado " + cpf, LangEnum.PT_BR);
        return cpf;
    }

    public static String toCNPJ(final Boolean unpointed) {
        final String cnpj = ofCNPJ(unpointed);
        ConsoleLogUtils.ofSuccess("CNPJ Gerado " + cnpj, LangEnum.PT_BR);
        return cnpj;
    }
    public static String toCNPJ() {
        final String cnpj = ofCNPJ(FALSE);
        ConsoleLogUtils.ofSuccess("CNPJ Gerado " + cnpj, LangEnum.PT_BR);
        return cnpj;
    }

    public static String toRG(final Boolean unpointed) {
        final String rg = ofRG(unpointed);
        ConsoleLogUtils.ofSuccess("RG Gerado " + rg, LangEnum.PT_BR);
        return rg;
    }

    public static String toRG() {
        final String rg = ofRG(FALSE);
        ConsoleLogUtils.ofSuccess("RG Gerado " + rg, LangEnum.PT_BR);
        return rg;
    }

    public static String toCNH() {
        final String cnh = ofCNH();
        ConsoleLogUtils.ofSuccess("CNH Gerado " + cnh, LangEnum.PT_BR);
        return cnh;
    }

    private static String ofCPF(final Boolean unpointed){

        int soma = n9*2 + n8*3 + n7*4 + n6*5 + n5*6 + n4*7 + n3*8 + n2*9 + n1*10;

        int valor = (soma / 11)*11;

        digit1 = soma-valor;

        //Primeiro rest da divisão por 11.
        rest = (digit1 % 11);

        if(digit1 < 2){
            digit1 = 0;
        }
        else {
            digit1 = 11-rest;
        }

        int soma2 = digit1 * 2 + n9*3 + n8*4 + n7*5 + n6*6 + n5*7 + n4*8 + n3*9 + n2*10 + n1*11;

        int valor2 = (soma2 / 11)*11;

        digit2 = soma2-valor2;

        //Primeiro rest da divisão por 11.
        rest = (digit2 % 11);

        if(digit2 < 2){
            digit2 = 0;
        }
        else {
            digit2 = 11-rest;
        }

        //Conctenando os numeros
        concatNumbers = String.valueOf(n1) + n2 + n3 +"." + n4 +
                n5 + n6 +"."+ n7 + n8 +
                n9 +"-";

        //Concatenando o primeiro rest com o segundo.
        nDigResult = String.valueOf(digit1) + digit2;

        cpf = concatNumbers+nDigResult;

        if (TRUE.equals(unpointed)) {
            return cpf.replaceAll("-", "")
                    .replaceAll("\\.", "");
        }
        return cpf;
    }

    private static String ofCNPJ(final Boolean unpointed) {

        int soma = n12*2 + n11*3 + n10*4 + n9*5 + n8*6 + n7*7 + n6*8 + n5*9 + n4*2 + n3*3 + n2*4 + n1*5;

        int valor = (soma / 11)*11;

        digit1 = soma-valor;

        //Primeiro rest da divisão por 11.
        rest = (digit1 % 11);

        if(digit1 < 2){
            digit1 = 0;
        }
        else {
            digit1 = 11-rest;
        }

        int soma2 =  digit1*2 + n12*3 + n11*4 + n10*5 + n9*6 + n8*7 + n7*8 + n6*9 + n5*2 + n4*3 + n3*4 + n2*5 + n1*6 ;

        int valor2 = (soma2 / 11)*11;

        digit2 = soma2-valor2;

        //Primeiro rest da divisão por 11.
        rest = (digit2 % 11);

        if(digit2 < 2){
            digit2 = 0;
        }
        else {
            digit2 = 11-rest;
        }

        //Conctenando os numeros
        concatNumbers = String.valueOf(n1) + n2 +"."+ n3 + n4 +
                n5 +"."+ n6 + n7 + n8 +"/"+
                n9 + n10 + n11 +
                n12 +"-";

        //Concatenando o primeiro rest com o segundo.
        nDigResult = String.valueOf(digit1) + digit2;

        cnpj = concatNumbers+nDigResult;


        if (TRUE.equals(unpointed)) {
            return cnpj.replaceAll("-", "")
                    .replaceAll("\\.", "")
                    .replaceAll("/", "");
        }
        return cnpj;
    }

    private static String ofRG(final Boolean unpointed) {

        //Conctenando os numeros
        rg = String.valueOf(n1) + n2 + "." + n3 + n4 +
                n5 + "." + n6 + n7 + n8 + "-" +
                (n9 == 0 ? "" : n9) + n10;


        if (TRUE.equals(unpointed)) {
            return rg.replaceAll("-", "")
                    .replaceAll("\\.", "");
        }
        return rg;
    }

    private static String ofCNH() {
        return cnh;
    }
}
