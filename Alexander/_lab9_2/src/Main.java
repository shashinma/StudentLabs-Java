import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String pathEncrypt = args[0];
        String pathDecrypt = args[1];
        String pathResult = args[2];
        String pathEncryptedResult = args[4];

        byte decryptionKey = Byte.parseByte(args[3]);
        byte encryptionKey = Byte.parseByte(args[5]);

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(pathDecrypt))) {
            try (DataInputStream dis = new DataInputStream(new FileInputStream(pathEncrypt))) {
                while (dis.available() > 0)
                    dos.writeByte(dis.readByte() ^ decryptionKey);
            }
        }

        try (DataOutputStream output = new DataOutputStream(new FileOutputStream(pathResult))) {
            try (DataInputStream input = new DataInputStream(new FileInputStream(pathDecrypt))) {
                output.writeByte(input.readByte() * 143);
                output.writeLong(input.readLong() + 143);
                output.writeInt(input.readInt() - 143);
            }
        }

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(pathEncryptedResult))) {
            try (DataInputStream dis = new DataInputStream(new FileInputStream(pathResult))) {
                while (dis.available() > 0)
                    dos.writeByte(dis.readByte() ^ encryptionKey);
            }
        }
    }
}

