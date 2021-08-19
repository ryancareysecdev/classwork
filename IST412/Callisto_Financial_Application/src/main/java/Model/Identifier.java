package Model;

/**
 * A class the creates a unique ID for anything that requires it.
 */
public class Identifier {

    String id;

    /**
     * A constructor for generating a new ID.
     */
    public Identifier() {
        this.generate();
    }

    /**
     * Generates a new UUID to represent an object.
     */
    private void generate() {
        this.id = java.util.UUID.randomUUID().toString();
    }

    /**
     * Returns a string representing the generated UUID.
     *
     * @return A new ID as a string.
     */
    public String getID() {
        return id;
    }

    /**
     * Sets a new ID for an object.
     *
     * @param id The string representing the ID.
     */
    public void setID(String id) {
        this.id = id;
    }

    /**
     * Returns a string representing the ID.
     *
     * @return A string for the UUID.
     */
    @Override
    public String toString() {
        return this.id;
    }
}
