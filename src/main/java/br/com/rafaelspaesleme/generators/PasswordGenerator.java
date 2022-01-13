package br.com.rafaelspaesleme.generators;

import com.github.javafaker.Faker;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PasswordGenerator {
    private static final String SEPARATOR = "7c2db27bec4a947cd3248efd8ea10485";
    private static final String SEPARATOR_2 = "36915484de5814d5549a044a69e06bfe";
    private static final String SETE = "f9kb";
    private static final String ARROBA = "120tr";
    private static final String XADREZ = "27b3ez";
    private static final String EXCLAMACAO = "aasq21x";
    private static final String SIFRAO = "sifrao";
    private static final String PORCENTAGEM = "72cdw";
    private static final String E_COMERCIAL = "f9kbsl";
    private static final String ESTRELA = "lkaj675traf";
    private static final String ABRE_PARENTESES = "lmnba";
    private static final String FECHA_PARENTESES = "789iu7yc";
    private static final String UNDERLINE = "365az";
    private static final String MENOS = "x";
    private static final String IGUAL = "zxop0";
    private static final String MAIS = "plm24";
    private static final String PONTO = "xyz";
    private static final String TREMA = "qw12";
    private static final String TRACO = "zxcvbnm1";
    private static final String BARRA_ = "2345678iuh";
    private static final String _BARRA = "2345678xzs";
    private static final String INTERROGACAO = "lp0";
    private static final String ABRE_CHAVE = "0a0a";
    private static final String FECHA_CHAVE = "78";
    private static final String ABRE_CONCHETE = "rr789";
    private static final String FECHA_CONCHETE = "rrty65";
    private static final String DOIS_PONTOS = "999";
    private static final String PONTO_VIRGULA = "qw3ezll";
    private static final String MAIOR_QUE = "q12390xcm5";
    private static final String MENOR_QUE = "3x";
    private static final String VIRGULA = "1q";

    public static String crypt(final String pass) {
        StringBuilder stringBuilder = new StringBuilder();

        Faker faker = new Faker();

        stringBuilder.append(faker.crypto().md5().concat(faker.crypto().md5()), 0, 10);

        for (String s : pass.split("")) {
            stringBuilder.append(SEPARATOR + replaceSimbol(s) + SEPARATOR_2);
        }

        return stringBuilder.toString();
    }

    public static String decrypt(final String crypto) {
        final String s = replaceString(crypto);
        return s.substring(10);
    }

    public static Boolean matches(final String pass, final String crypto) {
        final String s = replaceString(crypto).substring(10);
        return pass.equals(s);
    }

    private static String replaceSimbol(final String simbol) {
        switch (simbol) {
            case "!":
                return EXCLAMACAO;
            case "@":
                return ARROBA;
            case "#":
                return XADREZ;
            case "$":
                return SIFRAO;
            case "%":
                return PORCENTAGEM;
            case "¨":
                return TREMA;
            case "&":
                return E_COMERCIAL;
            case "*":
                return ESTRELA;
            case "(":
                return ABRE_PARENTESES;
            case ")":
                return FECHA_PARENTESES;
            case "-":
                return MENOS;
            case "_":
                return UNDERLINE;
            case "+":
                return MAIS;
            case "=":
                return IGUAL;
            case "|":
                return TRACO;
            case "\\":
                return _BARRA;
            case "/":
                return BARRA_;
            case "<":
                return MAIOR_QUE;
            case ">":
                return MENOR_QUE;
            case ",":
                return VIRGULA;
            case ".":
                return PONTO;
            case ":":
                return DOIS_PONTOS;
            case ";":
                return PONTO_VIRGULA;
            case "?":
                return INTERROGACAO;
            case "{":
                return ABRE_CHAVE;
            case "}":
                return FECHA_CHAVE;
            case "[":
                return ABRE_CONCHETE;
            case "]":
                return FECHA_CONCHETE;
            case "7":
                return SETE;
            default:
                return simbol;
        }
    }

    private static String replaceString(final String s) {
        return s.replaceAll(SEPARATOR, "")
                .replaceAll(SEPARATOR_2, "")
                .replaceAll(EXCLAMACAO, "!")
                .replaceAll(ARROBA, "@")
                .replaceAll(XADREZ, "#")
                .replaceAll(SIFRAO, "$")
                .replaceAll(PORCENTAGEM, "%")
                .replaceAll(TREMA, "¨")
                .replaceAll(E_COMERCIAL, "&")
                .replaceAll(ESTRELA, "*")
                .replaceAll(ABRE_PARENTESES, "(")
                .replaceAll(FECHA_PARENTESES, ")")
                .replaceAll(MENOS, "-")
                .replaceAll(UNDERLINE, "_")
                .replaceAll(MAIS, "+")
                .replaceAll(IGUAL, "=")
                .replaceAll(TRACO, "|")
                .replaceAll(_BARRA, "\\")
                .replaceAll(BARRA_, "/")
                .replaceAll(MAIOR_QUE, "<")
                .replaceAll(MENOR_QUE, ">")
                .replaceAll(VIRGULA, ",")
                .replaceAll(PONTO, ".")
                .replaceAll(DOIS_PONTOS, ":")
                .replaceAll(PONTO_VIRGULA, ";")
                .replaceAll(INTERROGACAO, "?")
                .replaceAll(ABRE_CHAVE, "{")
                .replaceAll(FECHA_CHAVE, "}")
                .replaceAll(ABRE_CONCHETE, "[")
                .replaceAll(FECHA_CONCHETE, "]")
                .replaceAll(SETE, "7");
    }
}
