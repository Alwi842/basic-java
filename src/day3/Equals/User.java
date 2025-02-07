package day3.Equals;

public class User {
    private String username;
    private String email;

    public User(String username, String email){
        this.username=username;
        this.email=email;
    }
    //method equals juga bisa di override untuk bandingkan 1 field atau beberapa field aja dalam objek

    public boolean equals(Object obj){
        if (this == obj) return true; //return jika sama
        if (obj==null || getClass() != obj.getClass()) return false;
        User user = (User) obj;
        return username.equals(user.username) && email.equals(user.email);
    }
    public String getData(){return "Username "+ username+", email"+email;};
    public String getUsername(){return username;};
}
