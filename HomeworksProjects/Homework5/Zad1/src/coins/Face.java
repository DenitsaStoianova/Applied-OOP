package coins;

public enum Face {

    HEAD("HEAD"), TAIL("TAIL");

    private final String faceValue;

    private Face(String faceValue){
        this.faceValue = (faceValue == null) ? "HEAD" : faceValue; // validate value
    }

    @Override
    public String toString() { // print value of face
        return String.format("Face: %s", this.faceValue);
    }
}
