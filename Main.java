import java.util.Scanner;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        double[][] cornerPoints = new double[3][2];
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the corner points as x1 y1 x2 y2 x3 y3: ");
        for (int i = 0; i < cornerPoints.length; i++)
            for (int j = 0; j < cornerPoints[i].length; j++)
                cornerPoints[i][j] = input.nextDouble();
        input.close();
         for (int i = 1; i <= cornerPoints.length; i++) {
            double[] point = cornerPoints[i - 1];
            System.out.print("x and y coordinates for corner point " + i + ": ");
            System.out.println(Arrays.toString(point));
        }
        double[] sides = computeSideLengths(cornerPoints);
        System.out.println("Computed side lenghts: " + Arrays.toString(sides));
        double area = computeArea(sides);
        System.out.println("The area of the triangle is " + area + ".");
    }

    public static double distance(double[] point1, double[] point2) {
        double xDistance=(point1[0]-point2[0]);
        double yDistance=(point1[1]-point2[1]);
        return (Math.sqrt(xDistance*xDistance)+(yDistance*yDistance));
    }

    public static double[] computeSideLengths(double[][] cornerPoints) {
        double distance1=Math.sqrt((cornerPoints[0][0]-cornerPoints[1][0])*(cornerPoints[0][0]-cornerPoints[1][0])+(cornerPoints[0][1]-cornerPoints[1][1])*(cornerPoints[0][1]-cornerPoints[1][1]));
        double distance2=Math.sqrt((cornerPoints[1][0]-cornerPoints[2][0])*(cornerPoints[1][0]-cornerPoints[2][0])+(cornerPoints[1][1]-cornerPoints[2][1])*(cornerPoints[1][1]-cornerPoints[2][1]));
        double distance3=Math.sqrt((cornerPoints[0][0]-cornerPoints[2][0])*(cornerPoints[0][0]-cornerPoints[2][0])+(cornerPoints[0][1]-cornerPoints[2][1])*(cornerPoints[0][1]-cornerPoints[2][1]));
        double[] returnArray=new double[3];
        returnArray[0]=distance1;
        returnArray[1]=distance2;
        returnArray[2]=distance3;
        return returnArray;
    }

    public static double computeArea(double[] sideLengths) {
        double var=((sideLengths[0]+sideLengths[1]+sideLengths[2])/2.0);
        return Math.sqrt(var*(var-sideLengths[0])*(var-sideLengths[1])*(var-sideLengths[2]));
    }
}