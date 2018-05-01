package by.powerline.repzone.exception.auth;

public class UserAlreadyExistException extends RuntimeException {
    public UserAlreadyExistException() {
        super("User with such email already exist.");
    }
}
