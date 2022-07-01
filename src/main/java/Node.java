import java.util.ArrayList;
import java.util.Objects;

public class Node {
    public boolean isBorder;
    public boolean visited;
    public double localGoal;
    public double globalGoal;
    public int x;
    public int y;
    public ArrayList<Node> neighbours;
    public Node parent;

    public Node(int y, int x, boolean isBorder) {
        this.isBorder = isBorder;
        this.visited = false;
        this.localGoal = Double.POSITIVE_INFINITY;
        this.globalGoal = Double.POSITIVE_INFINITY;
        this.neighbours = new ArrayList<>();
        this.parent = null;
        this.x = x;
        this.y = y;
    }
    public Node(int x, int y) {
        this(x, y, false);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return isBorder == node.isBorder &&
                visited == node.visited &&
                Double.compare(node.localGoal, localGoal) == 0 &&
                Double.compare(node.globalGoal, globalGoal) == 0 &&
                x == node.x &&
                y == node.y &&
                Objects.equals(neighbours, node.neighbours) &&
                Objects.equals(parent, node.parent);
    }
    @Override
    public int hashCode() {
        return Objects.hash(isBorder, visited, localGoal, globalGoal, x, y, neighbours, parent);
    }

    @Override
    public String toString() {
        return "X:" + x + " Y:" + y;
    }

    public int compareTo(Node n) {
        if (this.globalGoal > n.globalGoal) {return 1;}
        if (this.globalGoal < n.globalGoal) {return - 1;}
        return 0;
    }
}


