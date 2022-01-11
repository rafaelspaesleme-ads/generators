package br.com.rafaelspaesleme.generators;

public class LinksGenerator {

    private LinksGenerator() {

    }

    public static String whatsapp(final String phone, final String text) {
        if (phone == null) {
            return null;
        }

        if (text == null) {
            return "https://api.whatsapp.com/send?phone=" + phone;
        }

        return "https://api.whatsapp.com/send?phone=" + phone + "&text=" + text;
    }

    public static String telegram(final String username) {
        if (username == null) {
            return null;
        }
        return "https://t.me/" + username;
    }

    public static String instagram(final String nickname) {
        if (nickname == null) {
            return null;
        }
        return "https://www.instagram.com/" + nickname;
    }

    public static String facebook(final String urlShared) {
        if (urlShared == null) {
            return null;
        }
        return "https://www.facebook.com/sharer/sharer.php?u=" + urlShared;
    }

    public static String twitter(final String urlShared, final String text) {
        if (urlShared == null && text == null) {
            return null;
        }

        if (text == null) {
            return "https://twitter.com/intent/tweet?url=" + urlShared;
        }

        if (urlShared == null) {
            return "https://twitter.com/intent/tweet?text=" + text;
        }

        return "https://twitter.com/intent/tweet?url=" + urlShared + "&text=" + text;
    }

    public static String pinterest(final String urlShared, final String text, final String urlImage) {
        if (urlShared == null && text == null && urlImage == null) {
            return null;
        }

        if (urlShared == null && text == null) {
            return "https://pinterest.com/pin/create/button/?media=" + urlImage;
        }

        if (urlShared == null && urlImage == null) {
            return "https://pinterest.com/pin/create/button/?description=" + text;
        }

        if (text == null && urlImage == null) {
            return "https://pinterest.com/pin/create/button/?url=" + urlShared;
        }

        if (urlShared == null) {
            return "https://pinterest.com/pin/create/button/?media=" + urlImage + "&description=" + text;
        }

        if (urlImage == null) {
            return "https://pinterest.com/pin/create/button/?url=" + urlShared + "&description=" + text;
        }

        if (text == null) {
            return "https://pinterest.com/pin/create/button/?url=" + urlShared + "&media=" + urlImage;
        }

        return "https://pinterest.com/pin/create/button/?url=" + urlShared + "&media=" + urlImage + "&description=" + text;
    }

    public static String linkedin(final String urlShared, final Boolean sizeMiniShared) {
        if (urlShared == null) {
            return null;
        }

        if (sizeMiniShared == null) {
            return "https://www.linkedin.com/shareArticle?mini=" + true + "&url=" + urlShared;
        }

        return "https://www.linkedin.com/shareArticle?mini=" + sizeMiniShared + "&url=" + urlShared;
    }

    public static String email(final String email, final String subject,
                               final String cc, final String bcc, final String body) {

        if (email == null) {
            return null;
        }

        if (subject == null) {
            return "mailto:" + email;
        }

        if (cc == null && bcc == null) {
            return "mailto:" + email + "?&subject=" + subject + "&body=" + body;
        }

        if (cc != null && bcc == null) {
            return "mailto:" + email + "?&subject=" + subject + "&cc=" + cc + "&body=" + body;
        }

        if (cc == null) {
            return "mailto:" + email + "?&subject=" + subject + "&bcc=" + bcc + "&body=" + body;
        }

        return "mailto:" + email + "?&subject=" + subject + "&cc=" + cc + "&bcc=" + bcc + "&body=" + body;
    }

    public static String phone(final String phone) {
        if (phone == null) {
            return null;
        }

        return "tel:" + phone;
    }
}
