package coins;

import java.util.Random;

public class Coin {

    private Random rand;
    private Face face;

    public Coin(Face face){
        this.face = face;
        this.rand = new Random();
    }

    public final Face getFace(){
        return this.face;
    }

    public final  void setFace(Face face){
        if(face == null){ // validate face
            this.face = Face.TAIL;
        }
        else {
            this.face = face;
        }
    }

    public void flip(){
        this.face = (rand.nextInt(2) == 1) ? Face.HEAD : Face.TAIL;
    }

    public boolean isHeads(){
        return this.face == Face.HEAD;
    }

    @Override
    public String toString() {
        return face.toString();
    }
}
