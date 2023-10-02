/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.barcodegenerationprototype;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.Code128Writer;
import java.awt.image.BufferedImage;
import java.nio.file.Paths;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
/**
 *
 * @author vince-kong
 */
public class BarcodeGenerationPrototype {
    
    public static void main(String[] args) {
        BarcodeGenerationPrototype generator = new BarcodeGenerationPrototype();
        
        try{
            String randCode = generator.randomCode();
            String path = "/Users/vince-kong/Documents/Barcodes/barcode.jpg";
            
            Code128Writer cWriter = new Code128Writer();
            BitMatrix matrix = cWriter.encode(randCode, BarcodeFormat.CODE_128, 500, 200);
            
            MatrixToImageWriter.writeToPath(matrix, "jpg", Paths.get(path));

            System.out.println("Barcode has made");
            
        }catch(Exception e){
            System.out.println("There was an error while generating!");
        }  
    }
    
    public String randomCode(){
        final int length = 10;
        var characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random rand = new Random();
        StringBuilder sb = new StringBuilder(length);
        
        for (int i = 0; i < length; i++){
            int index = rand.nextInt(characters.length());
            char randomChar = characters.charAt(index);
            sb.append(randomChar);
        }
        
        return sb.toString();
    }
    
    public Icon convertBarcode(BitMatrix matrix){
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, matrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
            }
        }

        return new ImageIcon(image);
    }
}