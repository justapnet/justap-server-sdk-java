package justap;

import java.io.IOException;
import java.security.spec.InvalidKeySpecException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.*;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class RsaUtils {
    private static final String PKCS_8_PEM_HEADER = "-----BEGIN PRIVATE KEY-----";
    private static final String PKCS_8_PEM_FOOTER = "-----END PRIVATE KEY-----";

    public static PrivateKey loadPrivateKeyByPath(String keyFilePath) throws GeneralSecurityException, IOException {
        Path path = Paths.get(keyFilePath);
        byte[] keyDataBytes = Files.readAllBytes(path);
        String keyDataString = new String(keyDataBytes, StandardCharsets.UTF_8);

        return loadPrivateKey(keyDataString);
    }

    public static PrivateKey loadPrivateKey(String keyDataString) throws GeneralSecurityException, IOException {
        // PKCS#8 Base64 PEM encoded file
        keyDataString = keyDataString.replace(PKCS_8_PEM_HEADER, "");
        keyDataString = keyDataString.replace(PKCS_8_PEM_FOOTER, "");
        keyDataString = keyDataString.replace("\n", "");
        keyDataString = keyDataString.replace("\r\n", "");

        return readPkcs8PrivateKey(base64Decode(keyDataString));
    }

    /**
     * Create a PrivateKey instance from raw PKCS#8 bytes.
     */
    private static PrivateKey readPkcs8PrivateKey(byte[] pkcs8Bytes) throws GeneralSecurityException {
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(pkcs8Bytes);

        try {
            return keyFactory.generatePrivate(keySpec);
        } catch (InvalidKeySpecException e) {
            throw new IllegalArgumentException("Unexpected key format!", e);
        }
    }

    public static RSAPublicKey loadPublicKeyByPath(String keyFilePath) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        Path path = Paths.get(keyFilePath);
        byte[] keyDataBytes = Files.readAllBytes(path);
        String keyDataString = new String(keyDataBytes, StandardCharsets.UTF_8);

        return loadPublicKey(keyDataString);
    }

    public static RSAPublicKey loadPublicKey(String keyDataString) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        keyDataString = keyDataString.replaceAll("\\n", "").replace("-----BEGIN PUBLIC KEY-----", "").replace("-----END PUBLIC KEY-----", "");

        KeyFactory kf = KeyFactory.getInstance("RSA");

        X509EncodedKeySpec keySpecX509 = new X509EncodedKeySpec(base64Decode(keyDataString));
        RSAPublicKey pubKey = (RSAPublicKey) kf.generatePublic(keySpecX509);

        return pubKey;
    }

    public static byte[] base64Decode(String content) {
        return Base64.getDecoder().decode(content);
    }
}
