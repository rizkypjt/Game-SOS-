/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cobacoba;

/**
 *
 * @author ole
 */
import java.util.Scanner;
public class TestGame {
       public static void main(String[] args) {
           Scanner input = new Scanner(System.in);
    System.out.println("Silahkan pilih papan");
    System.out.println("1. 3x3");
    System.out.println("2. 5x5");
    System.out.println("3. 7x7");
    System.out.println("Silahkan pilih");
    int pil=input.nextInt();
    if(pil==1){
  CobaCoba coba = new CobaCoba();
  coba.start();
    }else if(pil==2){
       CobaCoba2 coba2 = new CobaCoba2();
  coba2.start();
       }else if(pil==3){
           Haha3 Hah=new Haha3();
           Hah.start();
       }
 }
}
