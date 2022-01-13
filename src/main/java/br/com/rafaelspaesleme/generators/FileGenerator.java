package br.com.rafaelspaesleme.generators;

import br.com.logamigo.logamigo.exceptions.FileException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.apache.commons.io.filefilter.WildcardFileFilter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileFilter;

import static br.com.rafaelspaesleme.generators.CodesGenerator.exceptionNull;
import static br.com.rafaelspaesleme.generators.utils.StringUtils.datetimeMillisecound;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FileGenerator {

    private static final String BAR = "/";

    @SneakyThrows
    public static File image(final String filenameBase, final BufferedImage image, final String folder, final String extension) {
        exceptionNull(filenameBase);
        exceptionNull(image);
        exceptionNull(folder);
        exceptionNull(extension);

        if (!new File(folder).exists()) {
            new File(folder).mkdirs();
        }

        final File file = new File(folder + BAR + filenameBase + "_" + datetimeMillisecound() + "." + extension);

        final boolean imageOk = ImageIO.write(image, extension, file);

        if (imageOk) {
            return file;
        }
        throw new FileException("Não foi possivel gerar código de barras.");
    }

    protected static File findByFilenameContains(final String search, final String folder, final String extensionFile) {
        final File[] files = getFiles(search.concat("_*"), folder, extensionFile);
        if (files == null) {
            return null;
        }

        return files[0];
    }

    protected static File[] getFiles(final String search, final String folder, final String extensionFile) {

        final File dir = new File(folder.concat("/"));
        final FileFilter fileFilter = new WildcardFileFilter(search == null
                ? "*".concat(extensionFile)
                : search.concat(extensionFile));

        return dir.listFiles(fileFilter);

    }

}
