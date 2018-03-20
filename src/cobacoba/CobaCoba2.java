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

public class CobaCoba2 {

    /**
     * @param args the command line arguments
     */
    
   private char papan [][];
    
 private int jmlbaris=5;  
 private int jmlkolom=5;
 
 
 private char giliranPemain;
 
 private enum statusGame{
  WINNER,DRAW,PROCESS
 }

 private static Scanner input = new Scanner (System.in);
 
 public CobaCoba2(){
  
 /* System.out.print("Masukan Lebar papan");
  int lebar=input.nextInt();*/
    
  papan = new char [jmlbaris] [jmlkolom];
  System.out.println("Welcome To SOS");
  System.out.println("***************************");
  
  do{
  System.out.print("Silakan masukkan 1 untuk memilih karakter s\n"
    + "atau 2 untuk memilih karakter o\n"
    + "kemudian tekan Enter: ");
  int pilihKarakter = input.nextInt();
  if(pilihKarakter == 1){
   giliranPemain = 's';
   System.out.println("Papan telah diinisilisasi\n"
     + "**************************");
   }else if(pilihKarakter == 2){
   giliranPemain = 'o';
   System.out.println("Papan telah diinisilisasi\n"
     + "**************************");
    }else{System.out.println("Pilihan anda tidak valid!\n"
      + "*************************");
     }
  } while (cekPilihKarakter(giliranPemain) == false);
  inisialisasiPapan();
  tampilkanPapan();
  
 }
 //**********************************INISIALISASI*************************
 //Method untuk inisialisasi
  private void inisialisasiPapan(){
   for (int i = 0; i < jmlbaris; i ++){
    for (int j = 0; j < jmlkolom; j++){
     papan [i][j] = '?';
    }
   }
   
   char playerSatu;
   char playerDua;
   if(giliranPemain == 's'){
    playerSatu = 's';
    playerDua = 'o';
    System.out.println("PLAYER SATU: " + playerSatu);
    System.out.println("PLAYER DUA: " + playerDua);
   }else if(giliranPemain == 'o'){
    playerSatu = 'o';
    playerDua = 's';
    System.out.println("PLAYER SATU: " + playerSatu);
    System.out.println("PLAYER DUA: " + playerDua);
   }
     
  }//Akhir method inisilaisasiPapan()
  
  //*************************CEK PILIH KARAKTER*****************************//
  //Method untuk mengecek pemain memilih karakter
  //untuk dimainkan dengan valid
  private boolean cekPilihKarakter (char giliranPemain){
   boolean pilihKarakter = false;
   if(giliranPemain == 's' || giliranPemain =='o'){
    pilihKarakter = true;
    }else{
     pilihKarakter = false;
     }
   return pilihKarakter;
  }//Akhir method cekPilihKarakter
  
  //************************************TAMPILKAN PAPAN***********************//
  //Method untuk menampilkan papan tic tac toe
  private void tampilkanPapan(){
   System.out.println("======================");
   for (int i = 0; i < jmlbaris; i ++){
    System.out.print("| ");
    for (int j = 0; j < jmlkolom; j++){
     System.out.print(papan[i][j] + " | ");
    }
    System.out.println();
    System.out.println("=====================");
   }
  }//Akhir method tampilkan papan
  
  //*************************GANTI PEMAIN*************************************//
  //Method untuk mengecek giliran pemain
  private void gantiPemain(){
   if(giliranPemain == 's'){
    giliranPemain = 'o';
   }else{
    giliranPemain = 's';
   }
   
  }//Akhir method gantiPemain
  
  //**************************CEK PEMENANG*************************************//
  //Method untuk mengecek jika ada pemenang
  private boolean cekPemenang(){
   return(cekBarisPemenang() || cekKolomPemenang() 
     || cekDiagonalPemenang());
   
  }//Akhir method cekPemenang
  
  //Method untuk mengecek baris pemenang
  /*private boolean cekBarisPemenang(){
   for(int i = 0; i < jmlbaris; i++){
    if(cekBarisKolom(papan[i][0], papan[i][1], 
      papan[i][2]) == true){
     return true;
    }
   }
   return false;
  }//Akhir method cekBarisPemenang*/
  private boolean cekBarisPemenang(){
   for(int i = 0; i < jmlbaris; i++){
     
    if(cekBarisKolom(papan[i][0],papan[i][2],papan[i][2],papan[i][3],papan[i][4]) == true){
     return true;
    
    }
   }
   return false;
  }//Akhir method cekKolomPemenang
    
  //Method untuk mengecek kolom pemenang
  private boolean cekKolomPemenang(){
   for(int i = 0; i < jmlkolom; i++){
     
    if(cekBarisKolom(papan[1][i], papan[1][i], 
      papan[2][i],papan[3][i],papan[4][i]) == true){
     return true;
    
    }
   }
   return false;
  }//Akhir method cekKolomPemenang
  
  
  //Method untuk mengecek diagonal pemenang
  private boolean cekDiagonalPemenang(){
   return((cekBarisKolom(papan[0][0], papan[1][1], 
     papan[2][2],papan[3][3],papan[4][4]) == true)
     || (cekBarisKolom(papan[0][2], papan[1][1], 
       papan[2][0], papan[3][3], papan[4][4]) == true) );
  }//Akhir method cekDiagonalPemenang
  
  
  //Method untuk mengecek tiga nilai adalah sama
  //dan tidak kosong pada baris atau kolom
  private boolean cekBarisKolom(char a1, char a2, char a3, char par3, char par4){
   return ((a1 != '?') && (a1 == a2) && (a2 == a3));
  }//Akhir method cekBarisKolom
  
  //************************AKHIR CEK PEMENANG***********************************//
  
  
  //******************************CEK DRAW***************************************//
  //Method untuk mengecek kondisi papan game
  //sudah penuh atau belum
  private boolean cekDraw(){
   boolean draw = true;
   for(int i = 0; i < jmlbaris; i++){
    for (int j = 0; j < jmlkolom; j++){
     if(papan[i][j] == '?'){
      draw = false;
     }
    }
   }
   return draw;
  }//Akhir method cekPapanPenuh
  //******************************AKHIR CEK DRAW**********************************//
  
  //************************CEk STATUS GAME************************************//
  private statusGame statusSekarang(){
   if(cekPemenang() == true)
    return statusGame.WINNER;
   else if(cekDraw() == true)
    return statusGame.DRAW;
   else
    return statusGame.PROCESS;
  }
  
  private void tampilkanStatus(){
         statusGame status = statusSekarang();
         if (status == statusGame.WINNER)
             System.out.println("PEMAIN " + giliranPemain +" MENANG!!");
         else if (status == statusGame.DRAW)
             System.out.println("PERMAINAN BERAKHIR DRAW!!");
  }
  //******************************AKHIR CEK STATUS GAME*****************************//
  
  //***********************************INPUT KARAKTER******************************//
  //Method untuk menginput karakter
  private void inputKarakter(){
   
     cekPemenang();
        cekDraw();
        statusSekarang();
   
    System.out.print("Pemain " + giliranPemain +
      " silakan pilih baris : ");
    int row = input.nextInt();
    System.out.print("Pemain " + giliranPemain +
      " silakan pilih kolom : ");
    int col = input.nextInt();
   
             if ((row < 0) || (row > 4))
                 System.out.println("Baris tidak valid, coba lagi");
             else if ((col < 0) || (col > 4))
                 System.out.println("Kolom tidak valid, coba lagi!");

             
             else if (papan[row][col] != '?')
                 System.out.println("Area ini sudah terisi, coba lagi!");
             
             else {
                 tandaiPapan(row, col, giliranPemain);
                 tampilkanPapan();
                 if(statusSekarang() == statusGame.PROCESS){
                  gantiPemain();
                 }
            
             }
  }//Akhir method input karakter
  
     //***********************************MENANDAI PAPAN********************************//
     // Pemain menandai papan
     private void tandaiPapan(int baris, int kolom, char c) {
         papan[baris][kolom] = c;
     }//Akhir method tandaiPapan
  
     //************************************START GAME***********************************//
     public void start(){
      do{
       inputKarakter();
      }while(statusSekarang() == statusGame.PROCESS);
      tampilkanStatus();
     }//Akhir method start()
}

