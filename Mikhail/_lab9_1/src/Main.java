import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String pathToEncryptedFile = args[0];
        String pathToDecryptedFile = args[1];
        String pathResult = args[2];
        byte key = Byte.parseByte(args[3]);

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(pathToDecryptedFile))) {
            try (DataInputStream dis = new DataInputStream(new FileInputStream(pathToEncryptedFile))) {
                while (dis.available() > 0)
                    dos.writeByte(dis.readByte() ^ key);
            }
        }

        try (DataOutputStream output = new DataOutputStream(new FileOutputStream(pathResult))) {
            try (DataInputStream input = new DataInputStream(new FileInputStream(pathToDecryptedFile))) {
                output.writeByte(input.readByte() * 113);
                output.writeInt(input.readInt() + 113);
                output.writeLong(input.readLong() - 113);
            }
        }
    }
}