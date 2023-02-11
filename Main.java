//import classes.Problem;
import classes.Node;
import classes.Graph;

import java.util.*;

class Main {
    public static Comparator<Node> utilityComparator = new Comparator<Node>() {
        @Override
        public int compare(Node node, Node other) {
            return node.utility - other.utility;
        }
    };

    public static void main(String args[]) {
        //int p[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}}; // 1
        //int p[][] = {{1, 2, 3}, {4, 5, 6}, {7, 0, 8}}; // Very Easy
        //int p[][] = {{1, 2, 0}, {4, 5, 3}, {7, 8, 6}}; // Easy
        int p[][] = {{0, 1, 2}, {4, 5, 3}, {7, 8, 6}}; // Doable

        Graph graph = new Graph(new Node(p));
        
        Node solution = uniformCostSearch(graph);

        if (solution != null) {
            traceBack(solution);
        }
    }

    public static Node uniformCostSearch(Graph graph) {
        System.out.println("Uniform Cost Search");

        Node node =  null;
        PriorityQueue<Node> frontier = new PriorityQueue<>(utilityComparator);
        ArrayList<Node> explored = new ArrayList<Node>();
        frontier.add(graph.root);
  
        do {
            if (frontier.size() == 0) {
                System.out.println("NO SOLUTION TO THIS PROBLEM");
                return null;
            }
            else {
                node = frontier.poll();
            }

            if (node.state.checkGoal()) {
                System.out.println("SOLUTION FOUND!!");
                return node;
            }
            else {
                explored.add(node);
            }
            
            for (int i = 0; i < node.actions.length; i++) {
                if (node.expandNode(1, node.actions[i])) {

                Node child = node.children.get(node.children.size() - 1);

                int child_index_frontier = indexOfNode(child, new ArrayList<Node>(frontier));
                int child_index_explored = indexOfNode(child, explored);
                    
                if ((child_index_explored == -1) || (child_index_frontier == -1)) {
                    frontier.add(child);
                }
                else if (child_index_frontier != -1){
                    Node node_at_index_frontier= getNodeFromList(child_index_frontier, new ArrayList<Node>(frontier));

                    if (node_at_index_frontier.utility > child.utility) {
                        frontier = replaceNodeInList(child_index_frontier, child, frontier);
                    }
                }
            }
            }
        } while(true);
    }

    // HELPER FUNCTIONS
    public static int indexOfNode(Node node, ArrayList<Node> list) {
        int count = 0;

        for (Node n : list) {
            if (node.state.puzzleEquals(n.state.puzzle)) {
                return count;
            }
            count++;
        }

        return -1;
    }

    public static Node getNodeFromList(int index, ArrayList<Node> list) {
        return list.get(index);
    }

    public static PriorityQueue<Node> replaceNodeInList(int index, Node node, PriorityQueue<Node> frontier) {
        PriorityQueue<Node> new_frontier = new PriorityQueue<Node>();

        for (int i = 0; i < frontier.size(); i++) {
            if (i == index) {
                new_frontier.add(node);
            }
            else {
                new_frontier.add(frontier.poll());
            }
        }

        return new_frontier;
    }

    public static void traceBack(Node node) {
        System.out.println(node.action);
        node.state.displayPuzzle();

        if (node.parent != null) {
            traceBack(node.parent);
        }
    }
}