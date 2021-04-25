package com.qiumingjie;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Path;

/**
 * @author QiuMingJie
 * @date 2021/4/22 15:18
 * @description
 */
public class QRCodeGenerator {


    private static final String QR_CODE_IMAGE_PATH = "C:\\Users\\Qiu\\Desktop\\MyQRCode.png";
    private static final String IMP_PATH = "C:\\Users\\Qiu\\Desktop\\123.txt";

    private static void generateQRCodeImage(String text, int width, int height, String filePath) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();

        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

        Path path = FileSystems.getDefault().getPath(filePath);

        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);

    }

    public static void main(String[] args) {
        try {
            File file = new File(IMP_PATH);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
            StringBuilder stringBuilder = new StringBuilder();
            while (bufferedReader.readLine() != null) {
                stringBuilder.append(bufferedReader.read());
            }

            generateQRCodeImage(stringBuilder.toString(), 350, 350, QR_CODE_IMAGE_PATH);
        } catch (WriterException e) {
            System.out.println("Could not generate QR Code, WriterException :: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Could not generate QR Code, IOException :: " + e.getMessage());
        }

    }

}
