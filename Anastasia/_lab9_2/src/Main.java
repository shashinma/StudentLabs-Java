import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String pathToEncryptedFile = args[0];
        String pathToDecryptedFile = args[1];
        String pathToResult = args[2];
        String pathToEncryptedResult = args[4];

        byte decryptionKey = Byte.parseByte(args[3]);
        byte encryptionKey = Byte.parseByte(args[5]);

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(pathToDecryptedFile))) {
            try (DataInputStream dis = new DataInputStream(new FileInputStream(pathToEncryptedFile))) {
                while (dis.available() > 0)
                    dos.writeByte(dis.readByte() ^ decryptionKey);
            }
        }

        try (DataOutputStream output = new DataOutputStream(new FileOutputStream(pathToResult))) {
            try (DataInputStream input = new DataInputStream(new FileInputStream(pathToDecryptedFile))) {
                output.writeByte(input.readByte() + 87);
                output.writeInt(input.readInt() * 87);
                output.writeLong(input.readLong() - 87);
            }
        }

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(pathToEncryptedResult))) {
            try (DataInputStream dis = new DataInputStream(new FileInputStream(pathToResult))) {
                while (dis.available() > 0)
                    dos.writeByte(dis.readByte() ^ encryptionKey);
            }
        }

    }
}