package exceptions;

public class ProgramCardNotFoundException extends RuntimeException {
  public ProgramCardNotFoundException() {
    super("No programs found on the page");
  }

  public ProgramCardNotFoundException(String programName) {
    super("Program with name %s not found".formatted(programName));
  }

  public ProgramCardNotFoundException(Throwable cause) {
    super("No programs found on the page", cause);
  }
}
