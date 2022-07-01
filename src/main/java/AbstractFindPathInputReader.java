import java.util.Collections;
import java.util.LinkedList;

public abstract class AbstractFindPathInputReader {
    private final Node[][] bludisko;
    protected Node startNode;
    protected Node endNode;
    String cesta="";
    public AbstractFindPathInputReader(char[][] bludisko) {
        this.bludisko = new Node[bludisko.length][bludisko[0].length];
        prevedNaNode(bludisko);
        connectNeighbourNodes();
        najdiTrasu();
    }
    private void prevedNaNode(char[][] bludisko) {
        for (int i=0;i<bludisko.length;i++) {
            for (int j=0;j<bludisko[0].length;j++) {
                if (bludisko[i][j] == '.') {
                    this.bludisko[i][j] = new Node(i, j);
                } else if (bludisko[i][j] == '#') {
                    this.bludisko[i][j] = new Node(i, j, true);
                } else if (bludisko[i][j] == 'S') {
                    startNode = new Node(i, j);
                    this.bludisko[i][j] = startNode;
                } else if (bludisko[i][j] == 'X') {
                    endNode = new Node(i, j);
                    this.bludisko[i][j] = endNode;
                }
            }
        }
    }
    private void connectNeighbourNodes() {
        for (int i=0;i<bludisko.length;i++) {
            for (int j=0;j<bludisko[0].length;j++) {
                if (i < bludisko.length - 1) {
                    bludisko[i][j].neighbours.add(bludisko[i + 1][j]);
                }
                if (i > 0) {
                    bludisko[i][j].neighbours.add(bludisko[i - 1][j]);
                }
                if (j < bludisko[0].length - 1) {
                    bludisko[i][j].neighbours.add(bludisko[i][j+1]);
                }
                if (j > 0) {
                    bludisko[i][j].neighbours.add(bludisko[i][j-1]);
                }
            }
        }
    }
    private double distance(Node a, Node b) {
        return Math.sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y));
    }

    public void najdiTrasu() {
        for (Node[] nodes : bludisko) {
            for (int j = 0; j < bludisko[0].length; j++) {
                nodes[j].visited = false;
                nodes[j].parent = null;
                nodes[j].localGoal = Double.POSITIVE_INFINITY;
                nodes[j].globalGoal = Double.POSITIVE_INFINITY;
            }
        }
        Node currentNode = startNode;
        startNode.localGoal = 0.0d;
        startNode.globalGoal = distance(startNode, endNode);
        LinkedList<Node> notVisited = new LinkedList<>();
        notVisited.add(startNode);
        while (!notVisited.isEmpty() && currentNode != endNode) {
            Collections.sort(notVisited, Node::compareTo);

            while (!notVisited.isEmpty() && notVisited.getFirst().visited) {
                notVisited.removeFirst();
            }
            if (notVisited.isEmpty()) {
                break;
            }
            currentNode = notVisited.getFirst();
            currentNode.visited = true;
            for (Node neighbourNode:currentNode.neighbours) {

                if (!neighbourNode.visited && neighbourNode.isBorder == false) {
                    notVisited.addLast(neighbourNode);
                }
                double possiblyLowerGoal = currentNode.localGoal + distance(currentNode, neighbourNode);
                if (possiblyLowerGoal < neighbourNode.localGoal) {
                    neighbourNode.parent = currentNode;
                    neighbourNode.localGoal = possiblyLowerGoal;
                    neighbourNode.globalGoal = neighbourNode.localGoal + distance(neighbourNode, endNode);
                }
            }
        }
        vypisNaKonzolu();
    }
    public String ziskajTrasu() {
        String a = "";
        if (endNode.parent != null) {
            Node p = endNode;
            while (p != null && p != startNode) {
                a += p.toString();
                p = p.parent;
            }
            return a;
        }
        return "Cesta neexistuje";
    }
    public abstract void vypisNaKonzolu();
    public abstract String vypis();
}


