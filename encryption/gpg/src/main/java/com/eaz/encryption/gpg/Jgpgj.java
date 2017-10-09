package com.eaz.encryption.gpg;

import java.io.File;
import java.io.IOException;
import org.bouncycastle.openpgp.PGPException;
import org.c02e.jpgpj.Decryptor;
import org.c02e.jpgpj.EncryptionAlgorithm;
import org.c02e.jpgpj.Encryptor;
import org.c02e.jpgpj.HashingAlgorithm;
import org.c02e.jpgpj.Key;

/**
 *
 * @author javier
 */
public class Jgpgj {

    public static void main(String args[]) throws IOException, PGPException {
        Jgpgj jgpgj = new Jgpgj();
        jgpgj.encrypt();
        //jgpgj.encryptWithAsciiArmoured();
        jgpgj.decrypt();
    }

    public void encrypt() throws IOException, PGPException {
        Encryptor encryptor = new Encryptor(
            new Key(new File("/home/javier/temp/20170925/keys/Profile-Test-public-key.gpg"), "profile")
        );
        encryptor.setSigningAlgorithm(HashingAlgorithm.Unsigned);
        encryptor.setEncryptionAlgorithm(EncryptionAlgorithm.AES128); //Default encryption algorithm
        encryptor.encrypt(
                new File("/home/javier/temp/20170925/files/file-to-be-encrypted.txt"),
                new File("/home/javier/temp/20170925/files/file-encrypted.txt.gpg")
        );
    }

//    public void encryptWithAsciiArmoured() throws IOException, PGPException {
//        Encryptor encryptor = new Encryptor(
//                new Key(new File("/home/javier/temp/20170925/keys/Profile-Test-public-key-ascii-armoured.asc"))
//        );
//        encryptor.setAsciiArmored(Boolean.TRUE);
//        encryptor.setSigningAlgorithm(HashingAlgorithm.Unsigned);
//        encryptor.setEncryptionAlgorithm(EncryptionAlgorithm.AES128); //Default encryption algorithm
//        encryptor.encrypt(
//                new File("/home/javier/temp/20170925/files/file-to-be-encrypted.txt"),
//                new File("/home/javier/temp/20170925/files/file-encrypted.txt.gpg")
//        );
//    }

    public void decrypt() throws IOException, PGPException {
        Decryptor decryptor = new Decryptor(
                new Key(new File("/home/javier/temp/20170925/keys/Profile-Test-private-key.gpg"), "profile")
        );
//        decryptor.getRing().getKeys().forEach( key -> {
//            key.getSubkeys().forEach(subkey -> {
//                subkey.setForDecryption(Boolean.TRUE);
//            });
//        }); //This is not required!!
        decryptor.setVerificationRequired(Boolean.FALSE); //Important: otherwise => Exception in thread "main" org.c02e.jpgpj.VerificationException: content not signed with a required key
        decryptor.decrypt(
                new File("/home/javier/temp/20170925/files/file-encrypted.txt.gpg"),
                new File("/home/javier/temp/20170925/files/file-decrypted.txt")
        );
    }
}
