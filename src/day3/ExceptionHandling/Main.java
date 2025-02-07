package day3.ExceptionHandling;

import java.util.Objects;

/*Exception handling : error handling ketika ada operasi yang gagal
* macam macamerror handling:
* -IllegalArgumentException : error handlingu untuk argumen/parameter yang dikiriim/terima
* ArrayIndexOutOfBoundsException : error handling data array ketika indeks tidak sesuai
* ArithmeticException : error handling untuk operasi matematik
* IOException : error handling untuk operasi file
* ResourceNotFoundException : error handling resource(tidak ditemukan)
* BadRequestException : eror handling untuk (404 bad request)
* UnauthorizedException : error handling unauthorized (401 unauthorized)
* ForbiddenException : error handling akses otorisasi (403 forbidden)
* InternalServerException : error internal server (500 internal server error)
* Error : error handling universal
* */
public class Main {
    static void checkRole(String role){
        //equals ngecek data yang dikirim dari parameter
        if(Objects.equals(role, "user")){
            //respon error manual
            throw new IllegalArgumentException("Access denid, only admin bro");
        } else{
            System.out.println("welcome admin");
        }
    }

    public static void main(String[] args) {
        try{
            //panggil metod
            checkRole("user");
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
