package br.com.rafaelspaesleme.generators;

import br.com.logamigo.logamigo.exceptions.FileException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.json.JSONObject;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileFilter;

import static br.com.rafaelspaesleme.generators.CodesGenerator.exceptionNull;
import static br.com.rafaelspaesleme.generators.utils.StringUtils.datetimeMillisecound;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FileGenerator {

    private static final String BAR = "/";
    private static final String DIR = "files";

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

    public static File createJson(final JSONObject json, final String filename) {
        exceptionNull(json);
        exceptionNull(filename);
        return create(json, filename, "json");
    }

    public static File createText(final String text, final String filename) {
        exceptionNull(text);
        exceptionNull(filename);
        return create(text, filename, "txt");
    }

    public static File createJava(final String scriptJava, final String filename) {
        exceptionNull(scriptJava);
        exceptionNull(filename);
        return create(scriptJava, filename, "java");
    }

    public static File createBash(final String bash, final String filename) {
        exceptionNull(bash);
        exceptionNull(filename);
        return create(bash, filename, "java");
    }

    @SneakyThrows
    private static <T> File create(final T data, final String filename, final String extensionFile) {
        File file = new File(DIR + BAR + filename.concat(".".concat(extensionFile)));

        FileUtils.write(file, data.toString());

        return file;
    }

    public static File findByFilename(final String filename, final String folder, final String extensionFile) {
        final File[] files = findAllByFilenameContains(filename.concat("_*"), folder, extensionFile);
        if (files == null) {
            return null;
        }

        return files[0];
    }

    public static File[] findAllByFilenameContains(final String filename, final String folder, final String extensionFile) {

        final File dir = new File(folder.concat("/"));
        final FileFilter fileFilter = new WildcardFileFilter(filename == null
                ? "*".concat(extensionFile)
                : filename.concat(extensionFile));

        return dir.listFiles(fileFilter);

    }

}
