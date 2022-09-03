public class Submarine {
    private int depth = 0;
    private int position = 0;
    public Submarine(Integer depth, Integer position) {
        this.depth = depth;
        this.position = position;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
