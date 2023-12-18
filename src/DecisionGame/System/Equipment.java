/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DecisionGame.System;

/**
 *
 * @author HP
 */
public class Equipment extends GameObject{
    
    public Equipment(char o, int value) {
        super(o, value);
    }
    
}

//Kode di atas adalah bagian dari sebuah kelas Java yang disebut Equipment yang merupakan turunan dari kelas GameObject. Mari kita bahas potongan kode tersebut:

//public class Equipment extends GameObject: Ini adalah deklarasi kelas Equipment yang merupakan turunan dari kelas GameObject. 
//Artinya, Equipment mewarisi semua sifat dan perilaku yang didefinisikan dalam kelas GameObject.

//public Equipment(char o, int value) { super(o, value); }: Ini adalah konstruktor kelas Equipment. Konstruktor ini membutuhkan 
//dua parameter: sebuah karakter (char) dan sebuah bilangan bulat (int). Ketika objek Equipment dibuat, 
//konstruktor ini akan dipanggil. Konstruktor ini juga memanggil konstruktor dari kelas GameObject menggunakan super(o, value), 
//yang menginisialisasi objek Equipment dengan nilai karakter (o) dan nilai (value) yang diteruskan ke konstruktor kelas GameObject.