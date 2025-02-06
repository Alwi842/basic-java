package day2.OOP.Blogs;

import java.util.ArrayList;
import java.util.List;
/*ENCAPSULATION : cara untuk membatasi dan melindungi data/method dari akses secara langsung
* untuk meningkatkan keamanan data dari perubahan data yang tidak disengaja*/
public class Blog {
    //enkapsulasi, variables private dan hanya bisa diambil atau diubah dengan setter atau getter
    private String title;
    private String content;
    //List : interface yang nandan bahwa variabel ini adalah sebuah list/daftar/array
    //kenpa pake list?biar bisamake arraylist
    private List<Comment> comments;

    public Blog(String blogTitle, String blogContent){
        title = blogTitle;
        content = blogContent;
        //array buat nyimpendata dalam bentuk array ke comment
        comments=new ArrayList<>();
    }

    //Getter blog
    public String getTitle(){return title;}
    public void setTitle(String newTitle){title=newTitle;}
    public String getComment(){return content;}
    public void setContent(String newContent){content=newContent;}

    //method blog
    public void displayInfo(){
        System.out.println("Title : "+title);
        System.out.println("Content : "+content);
    }

    //inner class
    public class Comment {
        private String author;
        private String text;

        public Comment(String name, String comment){
            author=name;
            text=comment;
        }
        public String getAuthor(){return author;}
        public String getText(){return text;}
    }

    //metod buat nambahin comment ke blog
    public void addComment(String author, String text){
        Comment newComment = new Comment(author,text);
        comments.add(newComment);
    }
    public void displayComments(){
        System.out.println("Comment : ");
        for(Comment comment : comments){
            System.out.println("author : "+comment.getAuthor());
            System.out.println("comment : "+comment.getText());
        }
    }
}
