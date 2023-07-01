package validationcommands;

public class checkEmptySpaces implements Command{
    private Validate validate;

    public checkEmptySpaces(Validate validate){ setValidate(validate); }

    @Override
    public String execute() {
       return validate.checkSpace();
    }

    public Validate getValidate() {
        return validate;
    }

    public void setValidate(Validate validate) {
        this.validate = validate;
    }
}
