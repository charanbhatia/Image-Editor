import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.lang.*;
import javax.imageio.ImageIO;
public class Main{
    public static void printPixelValues(BufferedImage inputImg){
        int height = inputImg.getHeight();
        int width = inputImg.getWidth();
        for(int row=0;row<height;row++){
            for(int col=0;col<width;col++){
                // System.out.print(inputImg.getRGB(col, row));
                Color pixel = new Color(inputImg.getRGB(col,row));
                System.out.print(pixel.getRed()+" "+ pixel.getBlue()+" "+pixel.getGreen()+" ");
            }
            // System.out.println();
        }
    }
    // GrayScale
    public static BufferedImage convertToGrayscale(BufferedImage inputImg){
        int height = inputImg.getHeight();
        int width = inputImg.getWidth();
        BufferedImage outputImg = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
        for(int row=0;row<height;row++){
            for(int col=0;col<width;col++){
                outputImg.setRGB(col, row, inputImg.getRGB(col, row));
            }
        }
        return outputImg;
    }
    // increase Brightness
    public static BufferedImage IncreaseBrightness(BufferedImage inputImg ,int increase){
        int height = inputImg.getHeight();
        int width = inputImg.getWidth();
        BufferedImage outputImg = new BufferedImage(width, height,BufferedImage.TYPE_3BYTE_BGR);
           for(int row=0;row<height;row++){
            for(int col=0;col<width;col++){
                Color pixel = new Color(inputImg.getRGB(col,row));
                int red =pixel.getRed();
                int blue=pixel.getBlue();
                int green = pixel.getGreen();
                red = red+(increase*red/100);
                blue = blue+(increase*blue/100);
                green = green+(increase*green/100);
                if(red>255) red = 255;
                if(blue>255) blue = 255;
                if(green>255) green = 255;
                Color  newPixel = new Color(red, green, blue);
                outputImg.setRGB(col, row, newPixel.getRGB());
             }
        }
        return outputImg;
    }
    // decrease Brightness
      public static BufferedImage DecreaseBrightness(BufferedImage inputImg ,int decrease){
        int height = inputImg.getHeight();
        int width = inputImg.getWidth();
        BufferedImage outputImg = new BufferedImage(width, height,BufferedImage.TYPE_3BYTE_BGR);
           for(int row=0;row<height;row++){
            for(int col=0;col<width;col++){
                Color pixel = new Color(inputImg.getRGB(col,row));
                int red =pixel.getRed();
                int blue=pixel.getBlue();
                int green = pixel.getGreen();
                red = red-(decrease*red/100);
                blue = blue-(decrease*blue/100);
                green = green-(decrease*green/100);
                if(red<0) red = 0;
                if(blue<0) blue = 0;
                if(green<0) green = 0;
                Color  newPixel = new Color(red, green, blue);
                outputImg.setRGB(col, row, newPixel.getRGB());
             }
        }
        return outputImg;
    }
    // rotate the image
    public static BufferedImage RotatetheImage(BufferedImage inputImg){
        int height = inputImg.getHeight();
        int width = inputImg.getWidth();
        BufferedImage outputImg = new BufferedImage(height, width, BufferedImage.TYPE_3BYTE_BGR);
        for(int row=0;row<height;row++){
            for(int col=0;col<width;col++){
                outputImg.setRGB(row, col, inputImg.getRGB(col, row));
            }
        }
        return outputImg;
    }
    public static BufferedImage MirrortheImage(BufferedImage inputImg){
        int height = inputImg.getHeight();
        int width = inputImg.getWidth();
        BufferedImage outputImg = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
        for(int row=0;row<height;row++){
            for(int col=0;col<width;col++){
                outputImg.setRGB(col, row, inputImg.getRGB(width-col-1, row));
            }
        }
        return outputImg;
    }
    public static BufferedImage MirrortheImageVertically(BufferedImage inputImg){
        int height = inputImg.getHeight();
        int width = inputImg.getWidth();
        BufferedImage outputImg = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
        for(int row=0;row<height;row++){
            for(int col=0;col<width;col++){
                outputImg.setRGB(col, row, inputImg.getRGB(col, height-row-1));
            }
        }
        return outputImg;
    }
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        System.out.println("1-Grayscale");
        System.out.println("2-Increase Brightness");
        System.out.println("3-Decrease Brightness");
        System.out.println("4-Rotate Image");
        System.out.println("5-Mirror Image");
        System.out.println("6-Vertical Flip Image");
        int input=sc.nextInt();

        File inputImg = new File ("image.jpg");
        try {
            BufferedImage inputImage = ImageIO.read(inputImg);// to read the input
            //printPixelValues(inputImage);
            if(input==1){
            BufferedImage grayScale = convertToGrayscale(inputImage);
            // to write the output
            File GrayScaleImage = new File("GrayScaleImage.jpg");
            ImageIO.write(grayScale, "jpg", GrayScaleImage);
        }
        if(input==2){
            System.out.print("Enter the Amount to be Increased -");
            int increase=sc.nextInt();
            BufferedImage IncreaseBright = IncreaseBrightness(inputImage,increase);
            // to write the output
            File IncreasedBrightness = new File("IncreasedBrightness.jpg");
            ImageIO.write(IncreaseBright, "jpg", IncreasedBrightness);
        }
        if(input==3){
            System.out.print("Enter the Amount to be Decreased -");
            int decrease=sc.nextInt();
            BufferedImage DecreaseBright = DecreaseBrightness(inputImage , decrease);
            // to write the output
            File DecreasedBrightness = new File("DecreasedBrightness.jpg");
            ImageIO.write(DecreaseBright, "jpg", DecreasedBrightness);
        }
        if(input==4){
            BufferedImage RotatetheImage= RotatetheImage(inputImage);
            // to write the output
            File RotatedImage = new File("RotatedImage.jpg");
            ImageIO.write(RotatetheImage, "jpg", RotatedImage);
        }
        if(input==5){
            BufferedImage MirrortheImage= MirrortheImage(inputImage);
            // to write the output
            File MirroredImage = new File("MirroredImage.jpg");
            ImageIO.write(MirrortheImage, "jpg", MirroredImage);
        }
        if(input==6){
           BufferedImage VerticallymirrortheImage= MirrortheImageVertically(inputImage);
           // to write the output
           File VerticallymirroredImage = new File("VerticalmirroredImage.jpg");
           ImageIO.write(VerticallymirrortheImage, "jpg", VerticallymirroredImage);
       }
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    }
}