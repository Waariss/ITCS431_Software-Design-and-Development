package th.ac.mahidol.ict.heroesbackend.model;

import jakarta.persistence.*;

import java.util.List;
@Entity
public class Villain extends Superhuman {

    private String origin;

    public Villain() {
    }

    public Villain(int id, String name, String type, String superpower, String origin, String imageURL, List<Human> humanFriends) {
        super(id, name, type, superpower, imageURL, humanFriends);
        this.origin = origin;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @Override
    public String toString() {
        return "Villain{ " +
                super.toString() +
                ", origin='" + origin + '\'' +
                '}';
    }
}
