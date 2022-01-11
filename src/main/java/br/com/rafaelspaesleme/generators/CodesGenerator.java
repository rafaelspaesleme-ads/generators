package br.com.rafaelspaesleme.generators;

import br.com.rafaelspaesleme.generators.exceptions.GenericException;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.CodaBarWriter;
import com.google.zxing.qrcode.QRCodeWriter;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Arrays;

import static br.com.rafaelspaesleme.generators.FileGenerator.image;
import static br.com.rafaelspaesleme.generators.utils.StringUtils.datetimeMillisecound;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CodesGenerator {

    public static <T> Long longCode(final T value) {
        exceptionNull(value);

        final int hashCode = Arrays.hashCode(value.toString().getBytes(StandardCharsets.UTF_8));

        final String datetimeMillisecound = datetimeMillisecound();

        final int hash = Arrays.hashCode((datetimeMillisecound + hashCode).getBytes(StandardCharsets.UTF_8));

        return Long.parseLong(String.valueOf(hash - (-hash*2)).replace("-", ""));

    }

    public static String tokenSleep(final Long timeOutMillisecound) {
        try {
            exceptionNull(timeOutMillisecound);

            Thread.sleep(timeOutMillisecound);
            final LocalDateTime now = LocalDateTime.now();
            return now.getNano() + " " + now.getNano() + " " + now.getNano();
        } catch (final InterruptedException ex) {
            throw new GenericException(ex.getMessage());
        }
    }

    public static <T> String stringCode(final T value) {
        exceptionNull(value);

        final int hashCode = Arrays.hashCode(value.toString().getBytes(StandardCharsets.UTF_8));
        return String.valueOf(Arrays.hashCode((datetimeMillisecound() + (hashCode)).getBytes(StandardCharsets.UTF_8)))
                .replace("-", "");
    }

    @SneakyThrows
    public static File qrCode(final Long id) {
        exceptionNull(id);

        final QRCodeWriter qrCodeWriter = new QRCodeWriter();
        final BitMatrix bitMatrix = qrCodeWriter.encode(String.valueOf(id), BarcodeFormat.QR_CODE, 300, 300);
        final BufferedImage image = bitMatrixToBufferedImage(bitMatrix);

        return image(String.valueOf(id), image, "qrcode", "png");

    }

    @SneakyThrows
    public static File barCode(final Long id) {
        exceptionNull(id);

        final CodaBarWriter codaBarWriter = new CodaBarWriter();
        final BitMatrix bitMatrix = codaBarWriter.encode(String.valueOf(id), BarcodeFormat.CODE_39, 500, 150);
        final BufferedImage image = bitMatrixToBufferedImage(bitMatrix);

        return image(String.valueOf(id), image, "barcode", "png");

    }

    protected static BufferedImage bitMatrixToBufferedImage(final BitMatrix bitMatrix) {
        return MatrixToImageWriter.toBufferedImage(bitMatrix);
    }

    protected static <T> void exceptionNull(final T value) {
        if (value == null) {
            throw new GenericException("Valor nulo!");
        }
    }
}
