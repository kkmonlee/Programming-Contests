package com.company;
import java.util.Scanner;

/**
 * Created by aa on 27/02/17.
 */
public class Tax {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int B = scanner.nextInt();
        float siArray[] = new float[20];
        float piArray[] = new float[20];

        for (int i = 0; i < B; i++) {
            float si = scanner.nextFloat();
            siArray[i] = si;
            float pi = scanner.nextFloat();
            piArray[i] = pi;
        }

        float P = scanner.nextFloat();
        int F = scanner.nextInt();

        for (int i = 1; i <= F; i++) {
            float ej = scanner.nextFloat();
            float mj = scanner.nextFloat();
            float money = 0;
            for (int j = 0; j < B; j++) {
                if(ej > 0) {
                    if ((siArray[j] - ej) < 0) {
                        ej = ej - siArray[j];
                    } else {
                        float temp = siArray[j] - ej;
                        float temp2 = mj/((100-piArray[j])/100);
                        ej = 0;
                        if(piArray[j] != 100) {
                            if (temp >= temp2) {
                                money += mj / ((100 - piArray[j]) / 100);
                                mj = 0;
                            } else {
                                money += temp;
                                mj = mj - ((100 - piArray[j]) / 100) * temp;
                            }
                        } else {
                            if(temp >= mj){
                                money += mj;
                                mj = 0;
                            } else {
                                money += temp;
                            }
                        }
                    }
                } else{
                    if (mj > 0) {
                        float bandWidth = siArray[j];
                        float temp2 = mj/((100-piArray[j])/100);
                        if(piArray[j] != 100) {
                            if (bandWidth >= temp2) {
                                money += mj / ((100 - piArray[j]) / 100);
                                mj = 0;
                            } else {
                                money += bandWidth;
                                mj = mj - bandWidth * ((100 - piArray[j]) / 100);
                            }
                        } else {
                            if(bandWidth >= mj){
                                money += mj;
                                mj = 0;
                            } else {
                                money += bandWidth;
                            }
                        }

                    }
                }

            }
            if(mj > 0){
                money += mj/((100-P)/100);
                mj = 0;
            }
            System.out.printf("%.6f\n", money);
        }
    }

}
