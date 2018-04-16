package by.powerline.repzone.model.dto;

public class ErrorInfoDTO {
    public final String exceptionMessage;

    public ErrorInfoDTO(Exception exception) {
        this.exceptionMessage = exception.getLocalizedMessage();
    }
}
