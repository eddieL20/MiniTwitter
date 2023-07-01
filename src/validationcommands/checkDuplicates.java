package validationcommands;

public class checkDuplicates implements Command{
    private Validate validate;

    public checkDuplicates(Validate validate){
        setValidate(validate);
    }

    @Override
    public String execute() {
        return validate.checkDuplicate();
    }

    public Validate getValidate() {
        return validate;
    }

    public void setValidate(Validate validate) {
        this.validate = validate;
    }
}
